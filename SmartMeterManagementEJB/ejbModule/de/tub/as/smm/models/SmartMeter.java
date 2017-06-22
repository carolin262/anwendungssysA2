package de.tub.as.smm.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class SmartMeter implements Serializable {

	private static final long serialVersionUID = -2250177305743873329L;
	// persistent fields
	private Long id;
	private String geraetekennung;
	private double maxBelastung;
	private List<Record> smartmeterRecords;
	// non persistent fields
	private double spannung;
	private double strom;

	// constructors
	public SmartMeter() {
	}

	public SmartMeter(String geraetekennung, double maxBelastung) {
		this.geraetekennung = geraetekennung;
		this.maxBelastung = maxBelastung;
		this.smartmeterRecords = new ArrayList<Record>();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGeraetekennung() {
		return geraetekennung;
	}

	public void setGeraetekennung(String geraetekennung) {
		this.geraetekennung = geraetekennung;
	}

	public double getMaxBelastung() {
		return maxBelastung;
	}

	public void setMaxBelastung(double maxBelastung) {
		this.maxBelastung = maxBelastung;
	}

	@OneToMany(cascade = { CascadeType.PERSIST,
			CascadeType.MERGE }, targetEntity = Record.class, mappedBy = "smartmeter", fetch = FetchType.EAGER)
	public List<Record> getSmartmeterRecords() {
		return smartmeterRecords;
	}

	public void setSmartmeterRecords(List<Record> smartmeterRecords) {
		this.smartmeterRecords = smartmeterRecords;
	}

	@Transient
	public double getSpannung() {
		return spannung;
	}

	public void randomSpannung() {
		this.spannung = Math.round((Math.random() * 20 + 220) * 10.0) / 10.0;
	}

	@Transient
	public double getStrom() {
		return strom;
	}

	public void randomStrom() {
		this.strom = Math.round((Math.random() * (maxBelastung + 5)) * 10.0) / 10.0;
	}

	@Transient
	public String currentStatus() {
		if (strom > maxBelastung)
			return "<div class=\"warning\"><h3 class=\"warningHead\">WARNUNG:</h3>Die Stromstärke liegt oberhalb der zulässigen Maximalbelastung!</div>";
		else
			return "<div class=\"info\"><h3 class=\"infoHead\">Aktueller Status:</h3>Alles läuft nach Plan: Keine weiteren Informationen vorhanden.</div>";
	}

}