package de.illilli.opendata.service.wahlgebiet.wahllokal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WahllokalCSV {

	/**
	 * OBJECTID
	 */
	@JsonProperty("OBJECTID")
	public String objectid;
	/**
	 * NR_STIMMBEZIRK800
	 */
	@JsonProperty("NR_STIMMBEZIRK800")
	public String nr_stimmbezirk800;
	/**
	 * WLK_NAME
	 */
	@JsonProperty("WLK_NAME")
	public String wlk_name;
	/**
	 * WLK_ADRESSE
	 */
	@JsonProperty("WLK_ADRESSE")
	public String wlk_adresse;
	/**
	 * ROLLSTUHLGERECHT
	 */
	@JsonProperty("ROLLSTUHLGERECHT")
	public String rollstuhlgerecht;
	/**
	 * WLK_BEMERKUNG
	 */
	@JsonProperty("WLK_BEMERKUNG")
	public String wlk_bemerkung;
	/**
	 * ABSTIMMBEZIRK
	 */
	@JsonProperty("ABSTIMMBEZIRK")
	public String abstimmbezirk;
	/**
	 * WLK_STADTTEIL
	 */
	@JsonProperty("WLK_STADTTEIL")
	public String wlk_stadtteil;
	/**
	 * POSTZUSTELLBEZIRK
	 */
	@JsonProperty("POSTZUSTELLBEZIRK")
	public String postzustellbezirk;
	/**
	 * AD_NUMMER
	 */
	@JsonProperty("AD_NUMMER")
	public String ad_nummer;
	/**
	 * KOORX
	 */
	@JsonProperty("KOORX")
	public String koorx;
	/**
	 * KOORY
	 */
	@JsonProperty("KOORY")
	public String koory;
	/**
	 * STIMMBEZIRK_STADTTEIL
	 */
	@JsonProperty("STIMMBEZIRK_STADTTEIL")
	public String stimmbezirk_stadtteil;
	/**
	 * KOMMUNALWAHLBEZIRK
	 */
	@JsonProperty("KOMMUNALWAHLBEZIRK")
	public String kommunalwahlbezirk;
	/**
	 * LANDTAGSWAHLKREIS
	 */
	@JsonProperty("LANDTAGSWAHLKREIS")
	public String landtagswahlkreis;
	/**
	 * BUNDESTAGSWAHLKREIS
	 */
	@JsonProperty("BUNDESTAGSWAHLKREIS")
	public String bundestagswahlkreis;

	@Override
	public String toString() {
		return "WahllokalCSV [objectid=" + objectid + ", nr_stimmbezirk800=" + nr_stimmbezirk800 + ", wlk_name="
				+ wlk_name + ", wlk_adresse=" + wlk_adresse + ", rollstuhlgerecht=" + rollstuhlgerecht
				+ ", wlk_bemerkung=" + wlk_bemerkung + ", abstimmbezirk=" + abstimmbezirk + ", wlk_stadtteil="
				+ wlk_stadtteil + ", postzustellbezirk=" + postzustellbezirk + ", ad_nummer=" + ad_nummer + ", koorx="
				+ koorx + ", koory=" + koory + ", stimmbezirk_stadtteil=" + stimmbezirk_stadtteil
				+ ", kommunalwahlbezirk=" + kommunalwahlbezirk + ", landtagswahlkreis=" + landtagswahlkreis
				+ ", bundestagswahlkreis=" + bundestagswahlkreis + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abstimmbezirk == null) ? 0 : abstimmbezirk.hashCode());
		result = prime * result + ((ad_nummer == null) ? 0 : ad_nummer.hashCode());
		result = prime * result + ((bundestagswahlkreis == null) ? 0 : bundestagswahlkreis.hashCode());
		result = prime * result + ((kommunalwahlbezirk == null) ? 0 : kommunalwahlbezirk.hashCode());
		result = prime * result + ((koorx == null) ? 0 : koorx.hashCode());
		result = prime * result + ((koory == null) ? 0 : koory.hashCode());
		result = prime * result + ((landtagswahlkreis == null) ? 0 : landtagswahlkreis.hashCode());
		result = prime * result + ((nr_stimmbezirk800 == null) ? 0 : nr_stimmbezirk800.hashCode());
		result = prime * result + ((objectid == null) ? 0 : objectid.hashCode());
		result = prime * result + ((postzustellbezirk == null) ? 0 : postzustellbezirk.hashCode());
		result = prime * result + ((rollstuhlgerecht == null) ? 0 : rollstuhlgerecht.hashCode());
		result = prime * result + ((stimmbezirk_stadtteil == null) ? 0 : stimmbezirk_stadtteil.hashCode());
		result = prime * result + ((wlk_adresse == null) ? 0 : wlk_adresse.hashCode());
		result = prime * result + ((wlk_bemerkung == null) ? 0 : wlk_bemerkung.hashCode());
		result = prime * result + ((wlk_name == null) ? 0 : wlk_name.hashCode());
		result = prime * result + ((wlk_stadtteil == null) ? 0 : wlk_stadtteil.hashCode());
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
		WahllokalCSV other = (WahllokalCSV) obj;
		if (abstimmbezirk == null) {
			if (other.abstimmbezirk != null)
				return false;
		} else if (!abstimmbezirk.equals(other.abstimmbezirk))
			return false;
		if (ad_nummer == null) {
			if (other.ad_nummer != null)
				return false;
		} else if (!ad_nummer.equals(other.ad_nummer))
			return false;
		if (bundestagswahlkreis == null) {
			if (other.bundestagswahlkreis != null)
				return false;
		} else if (!bundestagswahlkreis.equals(other.bundestagswahlkreis))
			return false;
		if (kommunalwahlbezirk == null) {
			if (other.kommunalwahlbezirk != null)
				return false;
		} else if (!kommunalwahlbezirk.equals(other.kommunalwahlbezirk))
			return false;
		if (koorx == null) {
			if (other.koorx != null)
				return false;
		} else if (!koorx.equals(other.koorx))
			return false;
		if (koory == null) {
			if (other.koory != null)
				return false;
		} else if (!koory.equals(other.koory))
			return false;
		if (landtagswahlkreis == null) {
			if (other.landtagswahlkreis != null)
				return false;
		} else if (!landtagswahlkreis.equals(other.landtagswahlkreis))
			return false;
		if (nr_stimmbezirk800 == null) {
			if (other.nr_stimmbezirk800 != null)
				return false;
		} else if (!nr_stimmbezirk800.equals(other.nr_stimmbezirk800))
			return false;
		if (objectid == null) {
			if (other.objectid != null)
				return false;
		} else if (!objectid.equals(other.objectid))
			return false;
		if (postzustellbezirk == null) {
			if (other.postzustellbezirk != null)
				return false;
		} else if (!postzustellbezirk.equals(other.postzustellbezirk))
			return false;
		if (rollstuhlgerecht == null) {
			if (other.rollstuhlgerecht != null)
				return false;
		} else if (!rollstuhlgerecht.equals(other.rollstuhlgerecht))
			return false;
		if (stimmbezirk_stadtteil == null) {
			if (other.stimmbezirk_stadtteil != null)
				return false;
		} else if (!stimmbezirk_stadtteil.equals(other.stimmbezirk_stadtteil))
			return false;
		if (wlk_adresse == null) {
			if (other.wlk_adresse != null)
				return false;
		} else if (!wlk_adresse.equals(other.wlk_adresse))
			return false;
		if (wlk_bemerkung == null) {
			if (other.wlk_bemerkung != null)
				return false;
		} else if (!wlk_bemerkung.equals(other.wlk_bemerkung))
			return false;
		if (wlk_name == null) {
			if (other.wlk_name != null)
				return false;
		} else if (!wlk_name.equals(other.wlk_name))
			return false;
		if (wlk_stadtteil == null) {
			if (other.wlk_stadtteil != null)
				return false;
		} else if (!wlk_stadtteil.equals(other.wlk_stadtteil))
			return false;
		return true;
	}

}
