package de.illilli.opendata.service.wahlgebiet.landtagswahkreis.jdbc;

import org.postgis.PGgeometry;

/**
 * 
 */
public class LandtagswahlkreisDTO {

	/**
	 * "OBJECTID": 5
	 */
	private int id;
	/**
	 * "NUMMER": "16"
	 */
	private int nummer;
	/**
	 * BEZEICHNUNG: "Köln IV"
	 */
	private String bezeichnung;
	/**
	 * Die MultiPolygon-Geometrie als PGgeometry
	 */
	private PGgeometry geom;
	/**
	 * Die MultiPolygon-Geometrie als geojson Struktur
	 */
	private String geojson;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
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
		result = prime * result + ((bezeichnung == null) ? 0 : bezeichnung.hashCode());
		result = prime * result + ((geojson == null) ? 0 : geojson.hashCode());
		result = prime * result + ((geom == null) ? 0 : geom.hashCode());
		result = prime * result + id;
		result = prime * result + nummer;
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
		LandtagswahlkreisDTO other = (LandtagswahlkreisDTO) obj;
		if (bezeichnung == null) {
			if (other.bezeichnung != null)
				return false;
		} else if (!bezeichnung.equals(other.bezeichnung))
			return false;
		if (geojson == null) {
			if (other.geojson != null)
				return false;
		} else if (!geojson.equals(other.geojson))
			return false;
		if (geom == null) {
			if (other.geom != null)
				return false;
		} else if (!geom.equals(other.geom))
			return false;
		if (id != other.id)
			return false;
		if (nummer != other.nummer)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LandtagswahlkreisDTO [id=" + id + ", nummer=" + nummer + ", bezeichnung=" + bezeichnung + "]";
	}

}
