package com.bridgelabz.googleAnalyticProject;

import java.util.ArrayList;

import com.bridgelabz.InputFileReader.InputJsonReader;
import com.bridgelabz.model.GaReportInputModel;
import com.bridgelabz.model.ResponseModel;
import com.bridgelabz.responseElementReader.ResponseElementReader;
import com.bridgelabz.responseFetcher.GaReportResponseFetcher;

public class GoogleAnalytic {

	public static void main(String[] args) {
		//reading the json filepath from command line argument
		String jsonfilepath = args[0];
		
		//creating instants for classes
		InputJsonReader inputJsonReader = new InputJsonReader();
		ResponseModel responseModelObject = new ResponseModel();
		GaReportResponseFetcher gaReportResponseFetcherObject = new GaReportResponseFetcher(); 
		ResponseElementReader elementReader = new ResponseElementReader();
		
		
		//reading the json file 
		ArrayList<GaReportInputModel> gaReportInputInfoArrayList = inputJsonReader.readInputJsonFile(jsonfilepath);
	
		//performing the operations on each task
		for (int i = 0; i < gaReportInputInfoArrayList.size(); i++) {

			// getting ArrayList of responseModel for each gaReportInputInfoArrayList
			responseModelObject = gaReportResponseFetcherObject
					.getResponse(gaReportInputInfoArrayList.get(i));

			//reading the response and finding the result
			elementReader.responseElementReader(responseModelObject,
					gaReportInputInfoArrayList.get(i),gaReportInputInfoArrayList.size());

		}
		
		System.out.println("Finished");
	}
}