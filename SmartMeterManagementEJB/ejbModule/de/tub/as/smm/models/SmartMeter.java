package de.tub.as.smm.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SmartMeter implements Serializable {

	private static final long serialVersionUID = 1L;
	 
    // Persistent Fields:
    @Id @GeneratedValue
    public Long id;
    public String geraetekennung;
    public String maxBelastung;
 
    // Constructors:
    public SmartMeter() {
    }
 
 
    public SmartMeter(String name, String maxbel) {
    	this.geraetekennung = name;
        this.maxBelastung = maxbel;
	}

	// String Representation:
    @Override
    public String toString() {
        return geraetekennung + " (max Belastung: " + maxBelastung + ")";
    }
}
