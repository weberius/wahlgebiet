package de.illilli.opendata.service.wahlgebiet.landtagswahlkreis;

import com.fasterxml.jackson.annotation.JsonProperty;

import de.illilli.opendata.koeln.arcgis.Geometry;

public class Feature {

	@JsonProperty("attributes")
	public FieldAliases attributes;

	@JsonProperty("geometry")
	public Geometry geometry;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attributes == null) ? 0 : attributes.hashCode());
		result = prime * result + ((geometry == null) ? 0 : geometry.hashCode());
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
		Feature other = (Feature) obj;
		if (attributes == null) {
			if (other.attributes != null)
				return false;
		} else if (!attributes.equals(other.attributes))
			return false;
		if (geometry == null) {
			if (other.geometry != null)
				return false;
		} else if (!geometry.equals(other.geometry))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Feature [attributes=" + attributes + ", geometry=" + geometry + "]";
	}

}
