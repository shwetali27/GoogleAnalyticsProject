package com.bridgelabz.InputFileReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.bridgelabz.constants.ConstantData;
import com.bridgelabz.model.GaReportInputModel;
import com.bridgelabz.model.SecretFileModel;

public class InputJsonReader {
	
	ArrayList<GaReportInputModel> GaReportInputModelArrayList = new ArrayList<GaReportInputModel>();

	public ArrayList<GaReportInputModel> readInputJsonFile(String jsonFilePath){
		try{

			JSONParser parser = new JSONParser();//json parser is used to read json files
			// parsing and casting to Object
			Object obj = parser.parse(new FileReader(jsonFilePath));
			// casting object into JSONObject
			JSONObject jsonObject = (JSONObject) obj;//creating json object

			// setting common values in secretFileModelObject
			SecretFileModel.setStartDate((String) jsonObject.get(ConstantData.startDate));

			SecretFileModel.setEndDate((String) jsonObject.get(ConstantData.endDate));

			SecretFileModel.setAPPLICATION_NAME((String) jsonObject.get(ConstantData.APPLICATION_NAME));

			SecretFileModel.setKEY_FILE_LOCATION((String) jsonObject.get(ConstantData.KEY_FILE_LOCATION));

			SecretFileModel.setSERVICE_ACCOUNT_EMAIL((String) jsonObject.get(ConstantData.SERVICE_ACCOUNT_EMAIL));

			SecretFileModel.setVIEW_ID((String) jsonObject.get(ConstantData.VIEW_ID));

			SecretFileModel.setCsvFilePath((String) jsonObject.get(ConstantData.CSVFilePath));

			//System.out.println(SecretFileModel.getCsvFilePath());
			
			JSONArray gaReportInfoArray = (JSONArray) jsonObject.get(ConstantData.GAReportInfo);

			// reading one by one object
			for (int i = 0; i < gaReportInfoArray.size(); i++) {
				GaReportInputModel gaReportInputModelObject = new GaReportInputModel();

				// initializing all value

				List<String> metricArrayList = new ArrayList<String>();
				List<String> dimensionArrayList = new ArrayList<String>();
				List<String> dimensionFilterArrayList = new ArrayList<String>();

				JSONObject gaReportInfoObject = (JSONObject) gaReportInfoArray.get(i);

				// setting gaid into model class
				gaReportInputModelObject.setmGaID((String) gaReportInfoObject.get(ConstantData.GAID));

				// setting GAdiscription in model class
				gaReportInputModelObject.setmGaDiscription((String) gaReportInfoObject.get(ConstantData.GAdiscription));

				// making metric array
				JSONArray metricJSONArray = (JSONArray) gaReportInfoObject.get(ConstantData.metric);
				// reading the metric array
				for (int k = 0; k < metricJSONArray.size(); k++) {
					// adding into metric ArrayList
					metricArrayList.add((String) metricJSONArray.get(k));
				}
				// setting metric in model class
				gaReportInputModelObject.setmMetricArrayList(metricArrayList);

				// making dimension JSONArray
				JSONArray dimensionsJSONArray = (JSONArray) gaReportInfoObject.get(ConstantData.dimension);
				// reading the dimension array
				for (int j = 0; j < dimensionsJSONArray.size(); j++) {
					dimensionArrayList.add((String) dimensionsJSONArray.get(j));
				}
				// setting dimension in model class
				gaReportInputModelObject.setmDimensionArrayList(dimensionArrayList);

				// Casting DimensionFilter into JSONArray
				JSONArray dimensionFilterJSONArray = (JSONArray) gaReportInfoObject.get(ConstantData.dimensionfilter);

				for (int l = 0; l < dimensionFilterJSONArray.size(); l++) {
					// adding into DimensionFilter ArrayList
					dimensionFilterArrayList.add((String) dimensionFilterJSONArray.get(l));
				}
				// setting dimension filter in model class
				gaReportInputModelObject.setmDimensionFilterArrayList(dimensionFilterArrayList);

				GaReportInputModelArrayList.add(gaReportInputModelObject);
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		return GaReportInputModelArrayList;
	}
}