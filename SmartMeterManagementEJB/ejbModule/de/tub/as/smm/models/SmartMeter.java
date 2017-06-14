package de.tub.as.smm.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Repraesentiert ein SmartMeter, welchem verschiedene Ablesungen zugeordnet werden koennen
 * @author Robert
 *
 */
@Entity
public class SmartMeter implements Serializable {

	
	private static final long serialVersionUID = 1L;
	// Persistent Fields:
    @Id @GeneratedValue
    Long id;
    @NotNull
    @Size(min=10)
    private String geraeteKennung;
    private int maximalBelastung;
    private transient double spannung;
    private  transient double stromStaerke;
    @OneToMany
    public List<Ablesung> ablesungen;
    static String imageURL= "blubb";
 
    // Constructors:
    public SmartMeter(){
    }
    public SmartMeter(String geraeteKennung) {
    	this.geraeteKennung=geraeteKennung;
    	this.maximalBelastung=80;
    	
    	
    }

	public double getSpannung() {
		return spannung;
	}

	public void setSpannung(double spannung) {
		this.spannung = spannung;
	}

	public double getStromStaerke() {
		return stromStaerke;
	}

	public void setStromStaerke(double stromStaerke) {
		this.stromStaerke = stromStaerke;
	}

	public Long getId() {
		return id;
	}

	public String getGeraeteKennung() {
		return geraeteKennung;
	}

	public int getMaximalBelastung() {
		return maximalBelastung;
	}

	public List<Ablesung> getAblesungen() {
		return ablesungen;
	}
	public void setAblesungen(List<Ablesung> ablesungen){
		this.ablesungen=ablesungen;
	}

	public static String getImageURL() {
		return imageURL;
	}
	/**
	 * Berechnet spannung und stromstaerke, gibt boolean fuer die Warnmeldung bei zu hoher 
	 * Stromstaerke zurueck
	 * @return true wenn zu hoch
	 */
	public boolean calculateAmpere(){
		this.spannung=Math.round((220+Math.random()*20)*10)/10.0;
		this.stromStaerke=Math.round(Math.random()*(maximalBelastung+5)*10)/10.0;
		if(stromStaerke>maximalBelastung) return true;
		else return false;
	}
}
