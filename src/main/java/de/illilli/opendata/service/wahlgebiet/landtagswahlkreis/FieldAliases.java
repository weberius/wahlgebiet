package de.illilli.opendata.service.wahlgebiet.landtagswahlkreis;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <pre>
 "fieldAliases": {
  "OBJECTID": "OBJECTID",
  "NUMMER": "Landtagswahlkreis (Nr.)",
  "BEZEICHNUNG": "Landtagswahlkreis"
 } *
 * </pre>
 */

public class FieldAliases {

	@JsonProperty("OBJECTID")
	public String objectid;

	@JsonProperty("NUMMER")
	public String nummer;

	@JsonProperty("BEZEICHNUNG")
	public String bezeichnung;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bezeichnung == null) ? 0 : bezeichnung.hashCode());
		result = prime * result + ((nummer == null) ? 0 : nummer.hashCode());
		result = prime * result + ((objectid == null) ? 0 : objectid.hashCode());
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
		if (bezeichnung == null) {
			if (other.bezeichnung != null)
				return false;
		} else if (!bezeichnung.equals(other.bezeichnung))
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
		return true;
	}

	@Override
	public String toString() {
		return "FieldAliases [objectid=" + objectid + ", nummer=" + nummer + ", bezeichnung=" + bezeichnung + "]";
	}

}
