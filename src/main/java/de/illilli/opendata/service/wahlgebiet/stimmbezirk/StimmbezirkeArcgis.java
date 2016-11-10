package de.illilli.opendata.service.wahlgebiet.stimmbezirk;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import de.illilli.opendata.koeln.arcgis.Fields;
import de.illilli.opendata.koeln.arcgis.SpatialReference;

public class StimmbezirkeArcgis {

	@JsonProperty("objectIdFieldName")
	String objectIdFieldName;

	@JsonProperty("globalIdFieldName")
	String globalIdFieldName;

	@JsonProperty("geometryType")
	String geometryType;

	@JsonProperty("spatialReference")
	SpatialReference spatialReference;

	@JsonProperty("fields")
	List<Fields> fields;

	@JsonProperty("features")
	List<Feature> features;

	public String getObjectIdFieldName() {
		return objectIdFieldName;
	}

	public void setObjectIdFieldName(String objectIdFieldName) {
		this.objectIdFieldName = objectIdFieldName;
	}

	public String getGlobalIdFieldName() {
		return globalIdFieldName;
	}

	public void setGlobalIdFieldName(String globalIdFieldName) {
		this.globalIdFieldName = globalIdFieldName;
	}

	public String getGeometryType() {
		return geometryType;
	}

	public void setGeometryType(String geometryType) {
		this.geometryType = geometryType;
	}

	public SpatialReference getSpatialReference() {
		return spatialReference;
	}

	public void setSpatialReference(SpatialReference spatialReference) {
		this.spatialReference = spatialReference;
	}

	public List<Fields> getFields() {
		return fields;
	}

	public void setFields(List<Fields> fields) {
		this.fields = fields;
	}

	public List<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(List<Feature> features) {
		this.features = features;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((features == null) ? 0 : features.hashCode());
		result = prime * result + ((fields == null) ? 0 : fields.hashCode());
		result = prime * result + ((geometryType == null) ? 0 : geometryType.hashCode());
		result = prime * result + ((globalIdFieldName == null) ? 0 : globalIdFieldName.hashCode());
		result = prime * result + ((objectIdFieldName == null) ? 0 : objectIdFieldName.hashCode());
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
		StimmbezirkeArcgis other = (StimmbezirkeArcgis) obj;
		if (features == null) {
			if (other.features != null)
				return false;
		} else if (!features.equals(other.features))
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
		if (globalIdFieldName == null) {
			if (other.globalIdFieldName != null)
				return false;
		} else if (!globalIdFieldName.equals(other.globalIdFieldName))
			return false;
		if (objectIdFieldName == null) {
			if (other.objectIdFieldName != null)
				return false;
		} else if (!objectIdFieldName.equals(other.objectIdFieldName))
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
		return "StimmbezirkeArcgis [objectIdFieldName=" + objectIdFieldName + ", globalIdFieldName=" + globalIdFieldName
				+ ", geometryType=" + geometryType + ", spatialReference=" + spatialReference + ", fields=" + fields
				+ ", features=" + features + "]";
	}

}
