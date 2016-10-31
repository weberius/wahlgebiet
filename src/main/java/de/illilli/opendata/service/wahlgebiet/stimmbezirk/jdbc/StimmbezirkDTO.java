package de.illilli.opendata.service.wahlgebiet.stimmbezirk.jdbc;

import org.postgis.PGgeometry;

public class StimmbezirkDTO {

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
	private int kWahl;
	/**
	 * Stimmbezirksnummer zur Landtagswahl: "L_Wahl":"15"
	 */
	private int lWahl;
	/**
	 * Stimmbezirksnummer zur Bundestagswahl: "B_Wahl":"95"
	 */
	private int bWahl;
	/**
	 * Nummer des Stadtbezirks: "NR_STB":"5"
	 */
	private int nrStb;
	/**
	 * Name des Stadtbezirks: "STB":"Nippes"
	 */
	private String stb;
	/**
	 * Nummer des Stadtteils: "NR_STT":"507"
	 */
	private int nrStt;
	/**
	 * Name des Stadtteils: "STT":"Bilderstöckchen"
	 */
	private String stt;
	/**
	 * Fläche in qm: "SHAPE_AREA":1604161.85491
	 */
	private double shapeArea;
	/**
	 * Länge des Polygon: "SHAPE_LEN":6399.97354317}
	 */
	private double shapeLen;
	/**
	 * Die MultiPolygon-Geometrie als geojson Struktur
	 */
	private PGgeometry geom;

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

	public int getkWahl() {
		return kWahl;
	}

	public void setkWahl(int kWahl) {
		this.kWahl = kWahl;
	}

	public int getlWahl() {
		return lWahl;
	}

	public void setlWahl(int lWahl) {
		this.lWahl = lWahl;
	}

	public int getbWahl() {
		return bWahl;
	}

	public void setbWahl(int bWahl) {
		this.bWahl = bWahl;
	}

	public int getNrStb() {
		return nrStb;
	}

	public void setNrStb(int nrStb) {
		this.nrStb = nrStb;
	}

	public String getStb() {
		return stb;
	}

	public void setStb(String stb) {
		this.stb = stb;
	}

	public int getNrStt() {
		return nrStt;
	}

	public void setNrStt(int nrStt) {
		this.nrStt = nrStt;
	}

	public String getStt() {
		return stt;
	}

	public void setStt(String stt) {
		this.stt = stt;
	}

	public double getShapeArea() {
		return shapeArea;
	}

	public void setShapeArea(double shapeArea) {
		this.shapeArea = shapeArea;
	}

	public double getShapeLen() {
		return shapeLen;
	}

	public void setShapeLen(double shapeLen) {
		this.shapeLen = shapeLen;
	}

	public PGgeometry getGeom() {
		return geom;
	}

	public void setGeom(PGgeometry geom) {
		this.geom = geom;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bWahl;
		result = prime * result + ((geom == null) ? 0 : geom.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + kWahl;
		result = prime * result + lWahl;
		result = prime * result + nrStb;
		result = prime * result + nrStt;
		result = prime * result + nummer;
		long temp;
		temp = Double.doubleToLongBits(shapeArea);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(shapeLen);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((stb == null) ? 0 : stb.hashCode());
		result = prime * result + ((stt == null) ? 0 : stt.hashCode());
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
		StimmbezirkDTO other = (StimmbezirkDTO) obj;
		if (bWahl != other.bWahl)
			return false;
		if (geom == null) {
			if (other.geom != null)
				return false;
		} else if (!geom.equals(other.geom))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (kWahl != other.kWahl)
			return false;
		if (lWahl != other.lWahl)
			return false;
		if (nrStb != other.nrStb)
			return false;
		if (nrStt != other.nrStt)
			return false;
		if (nummer != other.nummer)
			return false;
		if (Double.doubleToLongBits(shapeArea) != Double.doubleToLongBits(other.shapeArea))
			return false;
		if (Double.doubleToLongBits(shapeLen) != Double.doubleToLongBits(other.shapeLen))
			return false;
		if (stb == null) {
			if (other.stb != null)
				return false;
		} else if (!stb.equals(other.stb))
			return false;
		if (stt == null) {
			if (other.stt != null)
				return false;
		} else if (!stt.equals(other.stt))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StimmbezirkDTO [id=" + id + ", nummer=" + nummer + ", kWahl=" + kWahl + ", lWahl=" + lWahl + ", bWahl="
				+ bWahl + ", nrStb=" + nrStb + ", stb=" + stb + ", nrStt=" + nrStt + ", stt=" + stt + ", shapeArea="
				+ shapeArea + ", shapeLen=" + shapeLen + "]";
	}

}
