package de.illilli.opendata.koeln.arcgis;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Feature {

	@JsonProperty("attributes")
	FieldAliases attributes;

	@JsonProperty("geometry")
	Geometry geometry;

	public FieldAliases getAttributes() {
		return attributes;
	}

	public void setAttributes(FieldAliases attributes) {
		this.attributes = attributes;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

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
