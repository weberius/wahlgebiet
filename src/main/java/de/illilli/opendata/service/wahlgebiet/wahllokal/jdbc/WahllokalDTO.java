package de.illilli.opendata.service.wahlgebiet.wahllokal.jdbc;

import org.postgis.PGgeometry;

/**
 * Das WahllokalDTO ist ein Object, dass sich ohne weitere Konversion verwenden
 * läßt, um Daten in die Datebank zu schreiben oder herauszulesen. Es
 * berücksichtigt bereits alle in der Datenbank festgelegten Typen, wie z.B. die
 * PGgeometry.
 */
public class WahllokalDTO {

	private int objectid;
	private int stimmbezirk;
	private String name;
	private String adresse;
	private int rollstuhlgerecht;
	private String bemerkung;
	private int abstimmbezirk;
	private String stadtteil;
	private int postzustellbezirk;
	private String adNummer;
	private String stimmbezirkStadtteil;
	private int kommunalwahlbezirk;
	private int landtagswahlkreis;
	private int bundestagswahlkreis;
	private PGgeometry geom;
	private String geojson;

	public int getObjectid() {
		return objectid;
	}

	public void setObjectid(int objectid) {
		this.objectid = objectid;
	}

	public int getStimmbezirk() {
		return stimmbezirk;
	}

	public void setStimmbezirk(int stimmbezirk) {
		this.stimmbezirk = stimmbezirk;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getRollstuhlgerecht() {
		return rollstuhlgerecht;
	}

	public void setRollstuhlgerecht(int rollstuhlgerecht) {
		this.rollstuhlgerecht = rollstuhlgerecht;
	}

	public String getBemerkung() {
		return bemerkung;
	}

	public void setBemerkung(String bemerkung) {
		this.bemerkung = bemerkung;
	}

	public int getAbstimmbezirk() {
		return abstimmbezirk;
	}

	public void setAbstimmbezirk(int abstimmbezirk) {
		this.abstimmbezirk = abstimmbezirk;
	}

	public String getStadtteil() {
		return stadtteil;
	}

	public void setStadtteil(String stadtteil) {
		this.stadtteil = stadtteil;
	}

	public int getPostzustellbezirk() {
		return postzustellbezirk;
	}

	public void setPostzustellbezirk(int postzustellbezirk) {
		this.postzustellbezirk = postzustellbezirk;
	}

	public String getAdNummer() {
		return adNummer;
	}

	public void setAdNummer(String adNummer) {
		this.adNummer = adNummer;
	}

	public String getStimmbezirkStadtteil() {
		return stimmbezirkStadtteil;
	}

	public void setStimmbezirkStadtteil(String stimmbezirkStadtteil) {
		this.stimmbezirkStadtteil = stimmbezirkStadtteil;
	}

	public int getKommunalwahlbezirk() {
		return kommunalwahlbezirk;
	}

	public void setKommunalwahlbezirk(int kommunalwahlbezirk) {
		this.kommunalwahlbezirk = kommunalwahlbezirk;
	}

	public int getLandtagswahlkreis() {
		return landtagswahlkreis;
	}

	public void setLandtagswahlkreis(int landtagswahlkreis) {
		this.landtagswahlkreis = landtagswahlkreis;
	}

	public int getBundestagswahlkreis() {
		return bundestagswahlkreis;
	}

	public void setBundestagswahlkreis(int bundestagswahlkreis) {
		this.bundestagswahlkreis = bundestagswahlkreis;
	}

	public PGgeometry getGeom() {
		return geom;
	}

	public void setGeom(PGgeometry geom) {
		this.geom = geom;
	}

	public String getGeojson() {
		return geojson;
	}

	public void setGeojson(String geojson) {
		this.geojson = geojson;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + abstimmbezirk;
		result = prime * result + ((adNummer == null) ? 0 : adNummer.hashCode());
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((bemerkung == null) ? 0 : bemerkung.hashCode());
		result = prime * result + bundestagswahlkreis;
		result = prime * result + kommunalwahlbezirk;
		result = prime * result + landtagswahlkreis;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + objectid;
		result = prime * result + postzustellbezirk;
		result = prime * result + rollstuhlgerecht;
		result = prime * result + ((stadtteil == null) ? 0 : stadtteil.hashCode());
		result = prime * result + stimmbezirk;
		result = prime * result + ((stimmbezirkStadtteil == null) ? 0 : stimmbezirkStadtteil.hashCode());
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
		WahllokalDTO other = (WahllokalDTO) obj;
		if (abstimmbezirk != other.abstimmbezirk)
			return false;
		if (adNummer == null) {
			if (other.adNummer != null)
				return false;
		} else if (!adNummer.equals(other.adNummer))
			return false;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (bemerkung == null) {
			if (other.bemerkung != null)
				return false;
		} else if (!bemerkung.equals(other.bemerkung))
			return false;
		if (bundestagswahlkreis != other.bundestagswahlkreis)
			return false;
		if (kommunalwahlbezirk != other.kommunalwahlbezirk)
			return false;
		if (landtagswahlkreis != other.landtagswahlkreis)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (objectid != other.objectid)
			return false;
		if (postzustellbezirk != other.postzustellbezirk)
			return false;
		if (rollstuhlgerecht != other.rollstuhlgerecht)
			return false;
		if (stadtteil == null) {
			if (other.stadtteil != null)
				return false;
		} else if (!stadtteil.equals(other.stadtteil))
			return false;
		if (stimmbezirk != other.stimmbezirk)
			return false;
		if (stimmbezirkStadtteil == null) {
			if (other.stimmbezirkStadtteil != null)
				return false;
		} else if (!stimmbezirkStadtteil.equals(other.stimmbezirkStadtteil))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WahllokalDTO [objectid=" + objectid + ", stimmbezirk=" + stimmbezirk + ", name=" + name + ", adresse="
				+ adresse + ", rollstuhlgerecht=" + rollstuhlgerecht + ", bemerkung=" + bemerkung + ", abstimmbezirk="
				+ abstimmbezirk + ", stadtteil=" + stadtteil + ", postzustellbezirk=" + postzustellbezirk
				+ ", adNummer=" + adNummer + ", stimmbezirkStadtteil=" + stimmbezirkStadtteil + ", kommunalwahlbezirk="
				+ kommunalwahlbezirk + ", landtagswahlkreis=" + landtagswahlkreis + ", bundestagswahlkreis="
				+ bundestagswahlkreis + "]";
	}

}
