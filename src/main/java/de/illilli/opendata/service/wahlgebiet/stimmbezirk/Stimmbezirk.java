package de.illilli.opendata.service.wahlgebiet.stimmbezirk;

public class Stimmbezirk {

	public Stimmbezirk() {

	}

	/**
	 * id des Stimmbezirks: "id":"Stimmbezirk.2"
	 */
	private String id;
	/**
	 * Nummer des Stimmbezirks
	 */
	private int nummer;
	/**
	 * Stimmbezirksnummer zu Kommunalwahl: "K_WAHL":"31"
	 */
	private int nummerKommunalwahl;
	/**
	 * Stimmbezirksnummer zur Landtagswahl: "L_Wahl":"15"
	 */
	private int nummerLandtagswahl;
	/**
	 * Stimmbezirksnummer zur Bundestagswahl: "B_Wahl":"95"
	 */
	private int nummerBundestagswahl;
	/**
	 * Nummer des Stadtbezirks: "NR_STB":"5"
	 */
	private int nummerStadtbezirk;
	/**
	 * Name des Stadtbezirks: "STB":"Nippes"
	 */
	private String stadtbezirk;
	/**
	 * Nummer des Stadtteils: "NR_STT":"507"
	 */
	private int nummerStadtteil;
	/**
	 * Name des Stadtteils: "STT":"Bilderstöckchen"
	 */
	private String stadtteil;
	/**
	 * Fläche in qm: "SHAPE_AREA":1604161.85491
	 */
	private double flaeche;
	/**
	 * Länge des Polygon: "SHAPE_LEN":6399.97354317}
	 */
	private double umfang;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

	public int getNummerKommunalwahl() {
		return nummerKommunalwahl;
	}

	public void setNummerKommunalwahl(int nummerKommunalwahl) {
		this.nummerKommunalwahl = nummerKommunalwahl;
	}

	public int getNummerLandtagswahl() {
		return nummerLandtagswahl;
	}

	public void setNummerLandtagswahl(int nummerLandtagswahl) {
		this.nummerLandtagswahl = nummerLandtagswahl;
	}

	public int getNummerBundestagswahl() {
		return nummerBundestagswahl;
	}

	public void setNummerBundestagswahl(int nummerBundestagswahl) {
		this.nummerBundestagswahl = nummerBundestagswahl;
	}

	public int getNummerStadtbezirk() {
		return nummerStadtbezirk;
	}

	public void setNummerStadtbezirk(int nummerStadtbezirk) {
		this.nummerStadtbezirk = nummerStadtbezirk;
	}

	public String getStadtbezirk() {
		return stadtbezirk;
	}

	public void setStadtbezirk(String stadtbezirk) {
		this.stadtbezirk = stadtbezirk;
	}

	public int getNummerStadtteil() {
		return nummerStadtteil;
	}

	public void setNummerStadtteil(int nummerStadtteil) {
		this.nummerStadtteil = nummerStadtteil;
	}

	public String getStadtteil() {
		return stadtteil;
	}

	public void setStadtteil(String stadtteil) {
		this.stadtteil = stadtteil;
	}

	public double getFlaeche() {
		return flaeche;
	}

	public void setFlaeche(double flaeche) {
		this.flaeche = flaeche;
	}

	public double getUmfang() {
		return umfang;
	}

	public void setUmfang(double umfang) {
		this.umfang = umfang;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(flaeche);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + nummer;
		result = prime * result + nummerBundestagswahl;
		result = prime * result + nummerKommunalwahl;
		result = prime * result + nummerLandtagswahl;
		result = prime * result + nummerStadtbezirk;
		result = prime * result + nummerStadtteil;
		result = prime * result + ((stadtbezirk == null) ? 0 : stadtbezirk.hashCode());
		result = prime * result + ((stadtteil == null) ? 0 : stadtteil.hashCode());
		temp = Double.doubleToLongBits(umfang);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Stimmbezirk other = (Stimmbezirk) obj;
		if (Double.doubleToLongBits(flaeche) != Double.doubleToLongBits(other.flaeche))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nummer != other.nummer)
			return false;
		if (nummerBundestagswahl != other.nummerBundestagswahl)
			return false;
		if (nummerKommunalwahl != other.nummerKommunalwahl)
			return false;
		if (nummerLandtagswahl != other.nummerLandtagswahl)
			return false;
		if (nummerStadtbezirk != other.nummerStadtbezirk)
			return false;
		if (nummerStadtteil != other.nummerStadtteil)
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
		if (Double.doubleToLongBits(umfang) != Double.doubleToLongBits(other.umfang))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Stimmbezirk [id=" + id + ", nummer=" + nummer + ", nummerKommunalwahl=" + nummerKommunalwahl
				+ ", nummerLandtagswahl=" + nummerLandtagswahl + ", nummerBundestagswahl=" + nummerBundestagswahl
				+ ", nummerStadtbezirk=" + nummerStadtbezirk + ", stadtbezirk=" + stadtbezirk + ", nummerStadtteil="
				+ nummerStadtteil + ", stadtteil=" + stadtteil + ", flaeche=" + flaeche + ", umfang=" + umfang + "]";
	}

}
