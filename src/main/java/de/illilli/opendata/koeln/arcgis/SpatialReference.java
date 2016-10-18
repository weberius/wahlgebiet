package de.illilli.opendata.koeln.arcgis;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SpatialReference {

	@JsonProperty("wkid")
	String wkid;

	@JsonProperty("latestWkid")
	String latestWkid;

	public String getWkid() {
		return wkid;
	}

	public void setWkid(String wkid) {
		this.wkid = wkid;
	}

	public String getLatestWkid() {
		return latestWkid;
	}

	public void setLatestWkid(String latestWkid) {
		this.latestWkid = latestWkid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((latestWkid == null) ? 0 : latestWkid.hashCode());
		result = prime * result + ((wkid == null) ? 0 : wkid.hashCode());
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
		SpatialReference other = (SpatialReference) obj;
		if (latestWkid == null) {
			if (other.latestWkid != null)
				return false;
		} else if (!latestWkid.equals(other.latestWkid))
			return false;
		if (wkid == null) {
			if (other.wkid != null)
				return false;
		} else if (!wkid.equals(other.wkid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SpatialReference [wkid=" + wkid + ", latestWkid=" + latestWkid + "]";
	}

}
