package com.test.rest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.test.constants.ConstantsCommon;
import com.test.model.WeatherObject;
import com.test.utils.KelvinConverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class ApiCommunication {

	public WeatherObject doCommunication() {

		WeatherObject wObject = new WeatherObject();
		try {

			String url = ConstantsCommon.URL_GETID;
			String id = ConstantsCommon.CITY_CODE;

			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet getRequest = new HttpGet(url + id + "&appid="
					+ ConstantsCommon.API_KEY);

			getRequest.addHeader("accept", "application/json");

			HttpResponse response = httpClient.execute(getRequest);

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Code : "
						+ response.getStatusLine().getStatusCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(response.getEntity().getContent())));

			String output;
			StringBuilder sb = new StringBuilder();
			
			System.out.println("Server: \n");
			while ((output = br.readLine()) != null) {
				sb.append(output);
			}

			Gson gson = new Gson();
			
			JsonObject jObject = gson.fromJson(sb.toString(), JsonObject.class);
			
			String currentStatus = jObject.get("weather").getAsJsonArray()
					.get(0).getAsJsonObject().get("main").getAsString();
			String currentStatusInfo = jObject.get("weather").getAsJsonArray()
					.get(0).getAsJsonObject().get("description").getAsString();
			float currentTemp = KelvinConverter.convertKelvinToCelsius(jObject
					.get("main").getAsJsonObject().get("temp").getAsFloat());
			float maxTemp = KelvinConverter
					.convertKelvinToCelsius(jObject.get("main")
							.getAsJsonObject().get("temp_max").getAsFloat());
			float minTemp = KelvinConverter
					.convertKelvinToCelsius(jObject.get("main")
							.getAsJsonObject().get("temp_min").getAsFloat());

			wObject = new WeatherObject(currentStatus, currentStatusInfo,
					currentTemp, maxTemp, minTemp);

			httpClient.getConnectionManager().shutdown();

			return wObject;

		} catch (ClientProtocolException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}
		return wObject;
	}
}