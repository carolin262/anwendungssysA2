package de.tub.as.smm.models;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 5488382585787964091L;
	// persistent fields
	private Long id;
	private String name;
	private boolean status;
	private Date lastLogin;
	// non persistent field:
	private Long smartmeterId;

	// constructors
	public User() {
	}

	public User(String name) {
		this.name = name;
		this.status = true;
		this.lastLogin = new Date(System.currentTimeMillis());
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(unique = true)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// status = true if user is logged in
	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	// helper field to create a record
	@Transient
	public Long getSmartmeterId() {
		return smartmeterId;
	}

	public void setSmartmerterId(Long id) {
		this.smartmeterId = id;
	}
	
	@Transient
	public String getFormattedLastLogin() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy, HH:mm:ss");
		return "Zuletzt eingeloggt am: " + simpleDateFormat.format(this.lastLogin);
	}
	
	// forms
	public static String loginForm() {
		return "<br />" +
				"<h2>Login</h2>" +
				"<hr />" +
				"Um neue Geräte hinzufügen und Ablesungen vornehmen zu können, müssen Sie sich anmelden." +
				"<br />" +
				"<br />" +
				"<form method=\"POST\" action=\"verwalten\">" +
				"<b>Nutzerkennung:</b>" +
				"<input pattern=\".{3,}\" required title=\"Mindestens 3 Zeichen\" type=\"text\" name=\"user\" /> " +
				"<input class=\"inButton\" type=\"submit\" value=\"Anmelden\" />" +
				"</form>";
	}

	@Transient
	public String addDevices() {
		return "<br />" +
				"<h2>Geräte hinzufügen</h2>" +
				"<hr />" +
				"<form method=\"POST\" action=\"verwalten\">" +
				"<b>Gerätekennung:</b>" +
				"<input pattern=\"[A-Z]{2}[0-9]{8}\" required type=\"text\" name=\"geraetekennung\"/> " +
				"<b>Maximale Belastung</b> (in Ampere): " +
				"<input required type=\"number\" min=\"50\" max=\"100\" name=\"maxBelastung\"/> " +
				"<input class=\"inButton\" type=\"submit\" value=\"Hinzufügen\" />" +
				"</form>";
	}

	@Transient
	public String logout() {
		return "<br />" +
				"<h2>Logout</h2>" +
				"<hr />" +
				"Sie sind eingeloggt als: " + this.getName() +
				"<br />" +
				this.getFormattedLastLogin() +
				"<form method=\"POST\" action=\"verwalten\">" +
				"<input type=\"hidden\" name=\"logout\" value=\"" + this.getId() + "\" />" +
				"<br />" +
				"<input class=\"inButton\" type=\"submit\" value=\"Abmelden\" />" +
				"</form>";
	}

	@Transient
	public String ablesenForm() {
		return "<br />" +
				"<h2>Ablesen</h2>" +
				"<hr />" +
				"<b>Nutzerkennung:</b>" +
				"<br />" +
				"Sie sind eingeloggt als: " + this.getName() +
				"<br />" +
				"<br />" +
				"<form method=\"POST\" action=\"detail\">" +
				"<input type=\"hidden\" name=\"user\" value=\"" + this.getName() + "\">" +
				"<input type=\"hidden\" name=\"id\" value=\"" + this.getSmartmeterId() + "\">" +
				"<b>Verbrauchswert:</b>" +
				"<input required type=\"number\" name=\"verbrauchswert\" /> " +
				"<input class=\"inButton\" type=\"submit\" value=\"Ablesen\" />" +
				"</form>";
	}

}