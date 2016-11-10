package de.illilli.opendata.service.wahlgebiet.landtagswahlkreis;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import de.illilli.opendata.koeln.arcgis.Fields;
import de.illilli.opendata.koeln.arcgis.SpatialReference;

public class LandtagswahlkreiseArcgis {

	@JsonProperty("displayFieldName")
	public String displayFieldName;

	@JsonProperty("fieldAliases")
	public FieldAliases fieldAliases;

	@JsonProperty("geometryType")
	public String geometryType;

	@JsonProperty("spatialReference")
	public SpatialReference spatialReference;

	@JsonProperty("fields")
	public List<Fields> fields;

	@JsonProperty("features")
	public List<Feature> features;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((displayFieldName == null) ? 0 : displayFieldName.hashCode());
		result = prime * result + ((features == null) ? 0 : features.hashCode());
		result = prime * result + ((fieldAliases == null) ? 0 : fieldAliases.hashCode());
		result = prime * result + ((fields == null) ? 0 : fields.hashCode());
		result = prime * result + ((geometryType == null) ? 0 : geometryType.hashCode());
		result = prime * result + ((spatialReference == null) ? 0 : spatialReference.hashCode());
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
		LandtagswahlkreiseArcgis other = (LandtagswahlkreiseArcgis) obj;
		if (displayFieldName == null) {
			if (other.displayFieldName != null)
				return false;
		} else if (!displayFieldName.equals(other.displayFieldName))
			return false;
		if (features == null) {
			if (other.features != null)
				return false;
		} else if (!features.equals(other.features))
			return false;
		if (fieldAliases == null) {
			if (other.fieldAliases != null)
				return false;
		} else if (!fieldAliases.equals(other.fieldAliases))
			return false;
		if (fields == null) {
			if (other.fields != null)
				return false;
		} else if (!fields.equals(other.fields))
			return false;
		if (geometryType == null) {
			if (other.geometryType != null)
				return false;
		} else if (!geometryType.equals(other.geometryType))
			return false;
		if (spatialReference == null) {
			if (other.spatialReference != null)
				return false;
		} else if (!spatialReference.equals(other.spatialReference))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LandtagswahlkreiseArcgis [displayFieldName=" + displayFieldName + ", fieldAliases=" + fieldAliases
				+ ", geometryType=" + geometryType + ", spatialReference=" + spatialReference + ", fields=" + fields
				+ ", features=" + features + "]";
	}

}
