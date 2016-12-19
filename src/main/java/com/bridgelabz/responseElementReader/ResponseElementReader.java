package com.bridgelabz.responseElementReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.bridgelabz.constants.ConstantData;
import com.bridgelabz.model.GaReportInputModel;
import com.bridgelabz.model.ResponseModel;
import com.bridgelabz.model.SummaryReportModel;
import com.bridgelabz.results.SummaryReportCsv;

public class ResponseElementReader {
	SummaryReportCsv summaryReportCsv = new SummaryReportCsv();
	List<SummaryReportModel> summaryReportModels = new ArrayList<SummaryReportModel>();
	int sum = 0;

	public void responseElementReader(ResponseModel responseModelObject, GaReportInputModel gaReportInputModel,
			int size) {
		sum++;

		List<HashMap<String, String>> dimensionHashMapArrayList = new ArrayList<HashMap<String, String>>();
		dimensionHashMapArrayList = responseModelObject.getDimensionHashMapArrayList();
		System.out.println(dimensionHashMapArrayList.size());
		for(int i=0;i<dimensionHashMapArrayList.size();i++){
			
			//adding data for app open
			/*if(gaReportInputModel.getmGaID().equals(ConstantData.one)){
				SummaryReportModel summaryReportModel = new SummaryReportModel();
				summaryReportModel.setmGaDiscription(gaReportInputModel.getmGaDiscription());
				summaryReportModel.setmAndroidId(dimensionHashMapArrayList.get(i).get(ConstantData.dimension1));
				summaryReportModel.setmDate(dimensionHashMapArrayList.get(i).get(ConstantData.date));
			
				summaryReportModels.add(summaryReportModel);
			}*/
			
			//adding data for app reopen 
			/*if(gaReportInputModel.getmGaID().equals(ConstantData.two)){
				SummaryReportModel summaryReportModel = new SummaryReportModel();
				summaryReportModel.setmGaDiscription(gaReportInputModel.getmGaDiscription());
				summaryReportModel.setmAndroidId(dimensionHashMapArrayList.get(i).get(ConstantData.dimension1));
				summaryReportModel.setmDate(dimensionHashMapArrayList.get(i).get(ConstantData.date));
			
				summaryReportModels.add(summaryReportModel);
			}*/
			
			//adding data other than app open and reopen
			if(!gaReportInputModel.getmGaID().equals(ConstantData.one)
					&& !gaReportInputModel.getmGaID().equals(ConstantData.two)){
				SummaryReportModel summaryReportModel = new SummaryReportModel();
				summaryReportModel.setmGaDiscription(gaReportInputModel.getmGaDiscription());
				summaryReportModel.setmAndroidId(dimensionHashMapArrayList.get(i).get(ConstantData.dimension1));
				summaryReportModel.setmDate(dimensionHashMapArrayList.get(i).get(ConstantData.date));
			
				//adding model into the list of models
				summaryReportModels.add(summaryReportModel);
			}
		}
	
		if(sum==size){
			System.out.println(summaryReportModels.size());
			//creating summary report 
			summaryReportCsv.createReport(summaryReportModels);
		}
	}		
}
