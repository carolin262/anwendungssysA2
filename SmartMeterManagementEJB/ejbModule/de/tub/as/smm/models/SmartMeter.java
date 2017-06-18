package de.tub.as.smm.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SmartMeter implements Serializable {

	private static final long serialVersionUID = 1L;

	// Persistent Fields:
	@Id
	@GeneratedValue
	public Long id;
	public String geraetekennung;
	public double maxBelastung;
	public double spannung;
	public double strom;

	// Constructors:
	public SmartMeter() {
	}

	public SmartMeter(String name, String maxbel) {
		this.geraetekennung = name;
		this.maxBelastung = Math.round(Double.parseDouble(maxbel) * 10.0) / 10.0;
	}

	public void randomSpannung() {
		this.spannung = Math.round((Math.random() * 20 + 220) * 10.0) / 10.0;
	}

	public void randomStrom() {
		this.strom = Math.round((Math.random() * (maxBelastung + 5)) * 10.0) / 10.0;
	}

	// String Representation:
	public String currentStatus() {
		if (strom > maxBelastung)
			return "<div class=\"warning\"><h3 class=\"warningHead\">WARNUNG:</h3>Die Stromstärke liegt oberhalb der zulässigen Maximalbelastung!</div>";
		else
			return "<div class=\"info\"><h3 class=\"infoHead\">Aktueller Status:</h3>Alles läuft nach Plan: Keine weiteren Informationen vorhanden.</div>";
	}
	
	@Override
	public String toString() {
		return geraetekennung + " (max Belastung: " + maxBelastung + ")";
	}

}
