package fr.formation.countries.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country extends AbstractId {

    @Column(length = 255, nullable = false)
    private String nativeName;

    @Column(length = 2, nullable = false, unique = true)
    private String alpha2Code;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Region region;

    @Column(nullable = false)
    private String flag;

    public Country() {
    }

    public Country(String nativeName, String alpha2Code, Region region,
	    String flag) {
	this.nativeName = nativeName;
	this.alpha2Code = alpha2Code;
	this.region = region;
	this.flag = flag;
    }

    public String getNativeName() {
	return nativeName;
    }

    public void setNativeName(String nativeName) {
	this.nativeName = nativeName;
    }

    public String getAlpha2Code() {
	return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
	this.alpha2Code = alpha2Code;
    }

    public Region getRegion() {
	return region;
    }

    public void setRegion(Region region) {
	this.region = region;
    }

    public String getFlag() {
	return flag;
    }

    public void setFlag(String flag) {
	this.flag = flag;
    }

    @Override
    public String toString() {
	return "Country: [nativeName: " + nativeName + ", alpha2Code: "
		+ alpha2Code + " region: " + region + " flag: " + flag + "]";
    }
}
