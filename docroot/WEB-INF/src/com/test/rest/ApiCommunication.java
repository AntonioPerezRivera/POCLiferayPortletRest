package com.test.rest;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.test.constants.ConstantsCommon;
import com.test.model.Empleado;
import com.test.utils.KelvinConverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class ApiCommunication {

	public ArrayList<Empleado> doCommunication() {

		ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
		
		try {

			String url = ConstantsCommon.URL_GET;

			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet getRequest = new HttpGet(url);

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

			JsonArray jArray = gson.fromJson(sb.toString(), JsonArray.class);

			Iterator it = jArray.iterator();

			while (it.hasNext()) {
				JsonObject jObject = (JsonObject) it.next();
				String id = jObject.get("id").getAsString();
				String name = jObject.get("name").getAsString();
				String email = jObject.get("email").getAsString();

				Empleado eObject = new Empleado(id, name, email);
				listaEmpleados.add(eObject);
			}

			httpClient.getConnectionManager().shutdown();

		} catch (ClientProtocolException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}

		return listaEmpleados;
	}
}