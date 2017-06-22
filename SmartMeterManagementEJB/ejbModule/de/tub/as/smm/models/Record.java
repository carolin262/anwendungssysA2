package de.tub.as.smm.models;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Record implements Serializable {

	private static final long serialVersionUID = -4497369383015167908L;
	// persistent fields
	private Long id;
	private SmartMeter smartmeter;
	private String user;
	private double record;
	private Date date;

	// constructors
	public Record() {
	}

	public Record(SmartMeter smartmeter, String user, double record) {
		this.smartmeter = smartmeter;
		this.user = user;
		this.record = record;
		this.date = new Date(System.currentTimeMillis());
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST,
			CascadeType.MERGE }, targetEntity = SmartMeter.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "SMARTMETER_ID", nullable = false)
	public SmartMeter getSmartmeter() {
		return smartmeter;
	}

	public void setSmartmeter(SmartMeter smartmeter) {
		this.smartmeter = smartmeter;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String userId) {
		this.user = userId;
	}

	public double getRecord() {
		return record;
	}

	public void setRecord(double record) {
		this.record = record;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Transient
	public String getFormattedDate() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss, dd.MM.yyyy");
		return simpleDateFormat.format(this.date);
	}

}