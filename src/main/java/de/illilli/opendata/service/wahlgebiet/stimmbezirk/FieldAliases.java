package de.illilli.opendata.service.wahlgebiet.stimmbezirk;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <pre>
 * "attributes": {
    "OBJECTID": 3449,
    "NUMMER": "90806",
    "KOMMUNALWAHLBEZIRK": "37",
    "LANDTAGSWAHLKREIS": "19",
    "BUNDESTAGSWAHLKREIS": "101",
    "NR_STADTBEZIRK": "9",
    "STADTBEZIRK": "Mülheim",
    "NR_STADTTEIL": "908",
    "STADTTEIL": "Stammheim",
    "GLOBALID": "{01E4261A-6BFD-498E-BACF-E1815BF27B70}"
 * </pre>
 */

public class FieldAliases {

	@JsonProperty("OBJECTID")
	String objectid;

	@JsonProperty("NUMMER")
	String nummer;

	@JsonProperty("KOMMUNALWAHLBEZIRK")
	String kommunalwahlbezirk;

	@JsonProperty("LANDTAGSWAHLKREIS")
	String landtagswahlkreis;

	@JsonProperty("BUNDESTAGSWAHLKREIS")
	String bundestagswahlkreis;

	@JsonProperty("NR_STADTBEZIRK")
	String nrStadtbezirk;

	@JsonProperty("STADTBEZIRK")
	String stadtbezirk;

	@JsonProperty("NR_STADTTEIL")
	String nrStadtteil;

	@JsonProperty("STADTTEIL")
	String stadtteil;

	@JsonProperty("GLOBALID")
	String globalid;

	public String getObjectid() {
		return objectid;
	}

	public void setObjectid(String objectid) {
		this.objectid = objectid;
	}

	public String getNummer() {
		return nummer;
	}

	public void setNummer(String nummer) {
		this.nummer = nummer;
	}

	public String getKommunalwahlbezirk() {
		return kommunalwahlbezirk;
	}

	public void setKommunalwahlbezirk(String kommunalwahlbezirk) {
		this.kommunalwahlbezirk = kommunalwahlbezirk;
	}

	public String getLandtagswahlkreis() {
		return landtagswahlkreis;
	}

	public void setLandtagswahlkreis(String landtagswahlkreis) {
		this.landtagswahlkreis = landtagswahlkreis;
	}

	public String getBundestagswahlkreis() {
		return bundestagswahlkreis;
	}

	public void setBundestagswahlkreis(String bundestagswahlkreis) {
		this.bundestagswahlkreis = bundestagswahlkreis;
	}

	public String getNrStadtbezirk() {
		return nrStadtbezirk;
	}

	public void setNrStadtbezirk(String nrStadtbezirk) {
		this.nrStadtbezirk = nrStadtbezirk;
	}

	public String getStadtbezirk() {
		return stadtbezirk;
	}

	public void setStadtbezirk(String stadtbezirk) {
		this.stadtbezirk = stadtbezirk;
	}

	public String getNrStadtteil() {
		return nrStadtteil;
	}

	public void setNrStadtteil(String nrStadtteil) {
		this.nrStadtteil = nrStadtteil;
	}

	public String getStadtteil() {
		return stadtteil;
	}

	public void setStadtteil(String stadtteil) {
		this.stadtteil = stadtteil;
	}

	public String getGlobalid() {
		return globalid;
	}

	public void setGlobalid(String globalid) {
		this.globalid = globalid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bundestagswahlkreis == null) ? 0 : bundestagswahlkreis.hashCode());
		result = prime * result + ((globalid == null) ? 0 : globalid.hashCode());
		result = prime * result + ((kommunalwahlbezirk == null) ? 0 : kommunalwahlbezirk.hashCode());
		result = prime * result + ((landtagswahlkreis == null) ? 0 : landtagswahlkreis.hashCode());
		result = prime * result + ((nrStadtbezirk == null) ? 0 : nrStadtbezirk.hashCode());
		result = prime * result + ((nrStadtteil == null) ? 0 : nrStadtteil.hashCode());
		result = prime * result + ((nummer == null) ? 0 : nummer.hashCode());
		result = prime * result + ((objectid == null) ? 0 : objectid.hashCode());
		result = prime * result + ((stadtbezirk == null) ? 0 : stadtbezirk.hashCode());
		result = prime * result + ((stadtteil == null) ? 0 : stadtteil.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FieldAliases other = (FieldAliases) obj;
		if (bundestagswahlkreis == null) {
			if (other.bundestagswahlkreis != null)
				return false;
		} else if (!bundestagswahlkreis.equals(other.bundestagswahlkreis))
			return false;
		if (globalid == null) {
			if (other.globalid != null)
				return false;
		} else if (!globalid.equals(other.globalid))
			return false;
		if (kommunalwahlbezirk == null) {
			if (other.kommunalwahlbezirk != null)
				return false;
		} else if (!kommunalwahlbezirk.equals(other.kommunalwahlbezirk))
			return false;
		if (landtagswahlkreis == null) {
			if (other.landtagswahlkreis != null)
				return false;
		} else if (!landtagswahlkreis.equals(other.landtagswahlkreis))
			return false;
		if (nrStadtbezirk == null) {
			if (other.nrStadtbezirk != null)
				return false;
		} else if (!nrStadtbezirk.equals(other.nrStadtbezirk))
			return false;
		if (nrStadtteil == null) {
			if (other.nrStadtteil != null)
				return false;
		} else if (!nrStadtteil.equals(other.nrStadtteil))
			return false;
		if (nummer == null) {
			if (other.nummer != null)
				return false;
		} else if (!nummer.equals(other.nummer))
			return false;
		if (objectid == null) {
			if (other.objectid != null)
				return false;
		} else if (!objectid.equals(other.objectid))
			return false;
		if (stadtbezirk == null) {
			if (other.stadtbezirk != null)
				return false;
		} else if (!stadtbezirk.equals(other.stadtbezirk))
			return false;
		if (stadtteil == null) {
			if (other.stadtteil != null)
				return false;
		} else if (!stadtteil.equals(other.stadtteil))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FieldAliases [objectid=" + objectid + ", nummer=" + nummer + ", kommunalwahlbezirk="
				+ kommunalwahlbezirk + ", landtagswahlkreis=" + landtagswahlkreis + ", bundestagswahlkreis="
				+ bundestagswahlkreis + ", nrStadtbezirk=" + nrStadtbezirk + ", stadtbezirk=" + stadtbezirk
				+ ", nrStadtteil=" + nrStadtteil + ", stadtteil=" + stadtteil + ", globalid=" + globalid + "]";
	}

}
