package de.illilli.opendata.koeln.arcgis;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Geometry {

	@JsonProperty("rings")
	double[][][] rings;

	public double[][][] getRings() {
		return rings;
	}

	public void setRings(double[][][] rings) {
		this.rings = rings;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(rings);
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
		Geometry other = (Geometry) obj;
		if (!Arrays.deepEquals(rings, other.rings))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Geometry [rings=" + Arrays.toString(rings) + "]";
	}

}
