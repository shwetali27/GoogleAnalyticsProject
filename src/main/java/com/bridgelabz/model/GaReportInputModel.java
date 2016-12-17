package com.bridgelabz.model;

import java.util.List;

public class GaReportInputModel {
	private String mGaID;
	private String mGaDiscription;
	private List<String> mMetricArraList;
	private List<String> mDimensionArraList;
	private List<String> mDimensionFilterArraList;
	public String getmGaID() {
		return mGaID;
	}
	public void setmGaID(String mGaID) {
		this.mGaID = mGaID;
	}
	public String getmGaDiscription() {
		return mGaDiscription;
	}
	public void setmGaDiscription(String mGaDiscription) {
		this.mGaDiscription = mGaDiscription;
	}
	public List<String> getmMetricArraList() {
		return mMetricArraList;
	}
	public void setmMetricArraList(List<String> mMetricArraList) {
		this.mMetricArraList = mMetricArraList;
	}
	public List<String> getmDimensionArraList() {
		return mDimensionArraList;
	}
	public void setmDimensionArraList(List<String> mDimensionArraList) {
		this.mDimensionArraList = mDimensionArraList;
	}
	public List<String> getmDimensionFilterArraList() {
		return mDimensionFilterArraList;
	}
	public void setmDimensionFilterArraList(List<String> mDimensionFilterArraList) {
		this.mDimensionFilterArraList = mDimensionFilterArraList;
	}
	
}
