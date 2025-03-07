package com.bridgelabz.responseFetcher;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.bridgelabz.model.GaReportInputModel;
import com.bridgelabz.model.ResponseModel;
import com.bridgelabz.responseReader.ResponseReader;
import com.google.api.services.analyticsreporting.v4.AnalyticsReporting;
import com.google.api.services.analyticsreporting.v4.model.GetReportsResponse;
import com.google.api.services.analyticsreporting.v4.model.ReportRequest;

public class GaReportResponseFetcher {

	// creating object of InitializeAnalyticsReporting
	GAreportHandler reportHandler = GAreportHandler.getInstance();
	AnalyticsReporting service;

	Logger logger = Logger.getLogger(GaReportResponseFetcher.class);
	// default constructor
	public GaReportResponseFetcher() {
		// calling initializeAnalyticsReporting method of
		// InitializeAnalyticsReporting class to initialize all credential
		try {
			this.service = reportHandler.initializeAnalyticsReporting();
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*-------------------------method to get the response model ArrayList------------------------------------*/
	public ResponseModel getResponse(GaReportInputModel gaReportInputModel) {
		// creating object of ResponseModel
		ResponseModel responseModelObject = new ResponseModel();
		GetReportsResponse response = null;
		ArrayList<ReportRequest> requests = new ArrayList<ReportRequest>();

		try {

			// calling getReport method to get response
			String nextToken = "0";
			int i = 0;
			while (nextToken != null) {

				// calling getReport method to get response
				response = reportHandler.getReport(service, gaReportInputModel, nextToken, requests);
				nextToken = response.getReports().get(i).getNextPageToken();
				// System.out.println(nextToken);
				i++;
			}

			//System.out.println(response);
			logger.debug("\n\n"+gaReportInputModel.getmGaID()+"."+gaReportInputModel.getmGaDiscription());;
			logger.debug(response);
			// reading response and placing it to responseModelArrayList
			responseModelObject = ResponseReader.responseReader(response.toString());
		} catch (Exception e) {
			e.printStackTrace();

		}

		return responseModelObject;
	}
}
