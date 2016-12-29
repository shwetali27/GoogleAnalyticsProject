package com.bridgelabz.responseElementReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.bridgelabz.constants.ConstantData;
import com.bridgelabz.model.GaReportInputModel;
import com.bridgelabz.model.ResponseModel;
import com.bridgelabz.model.SummaryReportModel;
import com.bridgelabz.results.SummaryReportCsv;

public class ResponseElementReader {
	Logger logger = Logger.getLogger(ResponseElementReader.class);
	SummaryReportCsv summaryReportCsv = new SummaryReportCsv();
	List<SummaryReportModel> summaryReportModels = new ArrayList<SummaryReportModel>();
	int sum = 0;

	// method for reading the data and creating the report
	public void responseElementReader(ResponseModel responseModelObject, GaReportInputModel gaReportInputModel,
			int size) {
		sum++;
		try {
			List<HashMap<String, String>> dimensionHashMapArrayList = new ArrayList<HashMap<String, String>>();
			List<HashMap<String, String>> metricHashmapList = new ArrayList<HashMap<String, String>>();
			dimensionHashMapArrayList = responseModelObject.getDimensionHashMapArrayList();
			metricHashmapList = responseModelObject.getMetricHashMapArrayList();
			for (int i = 0; i < dimensionHashMapArrayList.size(); i++) {

				// adding data for app open
				if (gaReportInputModel.getmGaID().equals(ConstantData.one)) {
					SummaryReportModel summaryReportModel = new SummaryReportModel();
					summaryReportModel.setmGaDiscription(gaReportInputModel.getmGaDiscription());
					summaryReportModel.setmAndroidId(dimensionHashMapArrayList.get(i).get(ConstantData.dimension1));
					summaryReportModel.setmDate(dimensionHashMapArrayList.get(i).get(ConstantData.date));
					// if metricValue is not provided then taking default value
					// else taking value mentioned in json file
					if (gaReportInputModel.getmMetricValue() == null) {
						summaryReportModel
								.setValues(Integer.parseInt(metricHashmapList.get(i).get(ConstantData.totalEvents)));
					} else {
						summaryReportModel.setValues(
								Integer.parseInt(metricHashmapList.get(i).get(gaReportInputModel.getmMetricValue())));
					}
					summaryReportModels.add(summaryReportModel);
				}

				// adding data for app reopen
				if (gaReportInputModel.getmGaID().equals(ConstantData.two)) {
					SummaryReportModel summaryReportModel = new SummaryReportModel();
					summaryReportModel.setmGaDiscription(gaReportInputModel.getmGaDiscription());
					summaryReportModel.setmAndroidId(dimensionHashMapArrayList.get(i).get(ConstantData.dimension1));
					summaryReportModel.setmDate(dimensionHashMapArrayList.get(i).get(ConstantData.date));
					// if metricValue is not provided then taking default value
					// else taking value mentioned in json file
					if (gaReportInputModel.getmMetricValue() == null) {
						summaryReportModel
								.setValues(Integer.parseInt(metricHashmapList.get(i).get(ConstantData.totalEvents)));
					} else {
						summaryReportModel.setValues(
								Integer.parseInt(metricHashmapList.get(i).get(gaReportInputModel.getmMetricValue())));
					}
					summaryReportModels.add(summaryReportModel);
				}

				// adding data other than app open and reopen
				if (!gaReportInputModel.getmGaID().equals(ConstantData.one)
						&& !gaReportInputModel.getmGaID().equals(ConstantData.two)) {
					SummaryReportModel summaryReportModel = new SummaryReportModel();
					summaryReportModel.setmGaDiscription(gaReportInputModel.getmGaDiscription());
					summaryReportModel.setmAndroidId(dimensionHashMapArrayList.get(i).get(ConstantData.dimension1));
					summaryReportModel.setmDate(dimensionHashMapArrayList.get(i).get(ConstantData.date));
					// if metricValue is not provided then taking default value
					// else taking value mentioned in json file
					if (gaReportInputModel.getmMetricValue() == null) {
						// if metric list contains totalEvents the taking it as
						// default value else taking sessions as default
						if (responseModelObject.getMetricHashMapArrayList().get(i)
								.containsKey(ConstantData.totalEvents)) {
							summaryReportModel.setValues(
									Integer.parseInt(metricHashmapList.get(i).get(ConstantData.totalEvents)));
						} else {
							summaryReportModel
									.setValues(Integer.parseInt(metricHashmapList.get(i).get(ConstantData.sessions)));
						}
					} else {
						summaryReportModel.setValues(
								Integer.parseInt(metricHashmapList.get(i).get(gaReportInputModel.getmMetricValue())));
					}
					// adding model into the list of models
					summaryReportModels.add(summaryReportModel);
				}
			}

		} catch (Exception e) {
			logger.debug(e);
			// e.printStackTrace();
		} finally {
			if (sum == size) {
				// System.out.println(summaryReportModels.size());
				// creating summary report
				summaryReportCsv.createReport(summaryReportModels);
			}
		}
	}
}
