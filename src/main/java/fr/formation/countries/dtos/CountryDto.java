package fr.formation.countries.dtos;

public class CountryDto {

    private String nativeName;

    private String alpha2Code;

    private String region;

    private String flag;

    public CountryDto() {
    }

    public CountryDto(String nativeName, String alpha2Code, String region,
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

    public String getRegion() {
	return region;
    }

    public void setRegion(String region) {
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
