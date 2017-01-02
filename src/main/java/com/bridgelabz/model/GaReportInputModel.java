package com.bridgelabz.model;

import java.util.List;

public class GaReportInputModel {
	private String mGaID;
	private String mGaDiscription;
	private List<String> mMetricArrayList;
	private List<String> mDimensionArrayList;
	private List<String> mDimensionFilterArrayList;
	
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
	public List<String> getmMetricArrayList() {
		return mMetricArrayList;
	}
	public void setmMetricArrayList(List<String> mMetricArrayList) {
		this.mMetricArrayList = mMetricArrayList;
	}
	public List<String> getmDimensionArrayList() {
		return mDimensionArrayList;
	}
	public void setmDimensionArrayList(List<String> mDimensionArrayList) {
		this.mDimensionArrayList = mDimensionArrayList;
	}
	public List<String> getmDimensionFilterArrayList() {
		return mDimensionFilterArrayList;
	}
	public void setmDimensionFilterArrayList(List<String> mDimensionFilterArrayList) {
		this.mDimensionFilterArrayList = mDimensionFilterArrayList;
	}
}
