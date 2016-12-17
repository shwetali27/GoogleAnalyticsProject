package com.bridgelabz.model;

import java.util.HashMap;
import java.util.List;

public class ResponseModel {
	private List<String> mColumnHeaderArrayList;
	private List<String> mMetricHeaderArrayList;
	private List<HashMap<String, String>> dimensionHashMapArrayList;
	private List<HashMap<String, String>> metricHashMapArrayList;
	
	//getters and setters
	public List<String> getmColumnHeaderArrayList() {
		return mColumnHeaderArrayList;
	}
	public void setmColumnHeaderArrayList(List<String> mColumnHeaderArrayList) {
		this.mColumnHeaderArrayList = mColumnHeaderArrayList;
	}
	public List<String> getmMetricHeaderArrayList() {
		return mMetricHeaderArrayList;
	}
	public void setmMetricHeaderArrayList(List<String> mMetricHeaderArrayList) {
		this.mMetricHeaderArrayList = mMetricHeaderArrayList;
	}
	public List<HashMap<String, String>> getDimensionHashMapArrayList() {
		return dimensionHashMapArrayList;
	}
	public void setDimensionHashMapArrayList(List<HashMap<String, String>> dimensionHashMapArrayList) {
		this.dimensionHashMapArrayList = dimensionHashMapArrayList;
	}
	public List<HashMap<String, String>> getMetricHashMapArrayList() {
		return metricHashMapArrayList;
	}
	public void setMetricHashMapArrayList(List<HashMap<String, String>> metricHashMapArrayList) {
		this.metricHashMapArrayList = metricHashMapArrayList;
	}

}
