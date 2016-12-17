package com.bridgelabz.results;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.bridgelabz.constants.ConstantData;
import com.bridgelabz.model.SummaryReportModel;
import com.csvreader.CsvWriter;

public class SummaryReportCsv {
	public void createReport(List<SummaryReportModel> summaryReportModels) {
		String appOpenFile = ConstantData.resultsFilepath + "SummaryReport.csv";
		File file = new File(appOpenFile);
		try {
			if (file.exists()) {
				// System.out.println("inside delete");
				file.delete();
			}
			CsvWriter csvOutput = new CsvWriter(new FileWriter(appOpenFile, true), ConstantData.csvDelimiter);
			// adding headings to csv file
			csvOutput.write("Android ID");
			csvOutput.write("Event_Name");
			csvOutput.write("Inserted_Date");
			csvOutput.endRecord();

			// adding data for app open in csv
			for (int i = 0; i < summaryReportModels.size(); i++) {
				csvOutput.write(summaryReportModels.get(i).getmAndroidId());
				csvOutput.write(summaryReportModels.get(i).getmGaDiscription());
				csvOutput.write(summaryReportModels.get(i).getmDate());
				csvOutput.endRecord();
			}

			csvOutput.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
