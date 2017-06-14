package de.tub.as.smm.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Repraesentiert eine Ablesung
 * @author Robert
 *
 */
@Entity
public class Ablesung implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	Long id;
	private double verbrauchsWert;
	private Date ableseDatum;
	
	//Constructors
	public Ablesung(){}
	public Ablesung(double verbrauchsWert){
		this.verbrauchsWert=verbrauchsWert;
		this.ableseDatum= new Date(System.currentTimeMillis());
	}

	public double getVerbrauchsWert() {
		return verbrauchsWert;
	}

	public Date getAbleseDatum() {
		return ableseDatum;
	}
	
}
