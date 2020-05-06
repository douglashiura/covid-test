package br.ufsc.covid.ok;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;

import net.douglashiura.us.Fixture;

@Fixture("PathGet")
public class FixturePathGet {
	private String path;
	private static JSONArray JSON_ARRAY;
	private static int STATUS_HTTP;

	public void setPath(String value) {
		path = value;
	}

	public void toSymptomsList(String action) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet request = new HttpGet(FixtureSetup.BASE_URL + path);
		request.addHeader("content-type", "application/json");
		CloseableHttpResponse response = httpClient.execute(request);
		STATUS_HTTP = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String result = EntityUtils.toString(entity);
		System.out.println(result);
		JSON_ARRAY = new JSONArray(result);
		response.close();
		httpClient.close();
	}

	public void toPersonStatus(String action) {
	}

	public void toPathGet(String action) {
	}

	

	public void toRiskFactor(String action) throws ParseException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet request = new HttpGet(FixtureSetup.BASE_URL + path);
		request.addHeader("content-type", "application/json");
		CloseableHttpResponse response = httpClient.execute(request);
		STATUS_HTTP = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String result = EntityUtils.toString(entity);
		System.out.println(result);
		JSON_ARRAY = new JSONArray(result);
		response.close();
		httpClient.close();
	}

	public void toNotificationCreate(String action) {
	}

	public void toPersonNotification(String action) throws IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet request = new HttpGet(FixtureSetup.BASE_URL + path);
		request.addHeader("content-type", "application/json");
		request.addHeader("Authorization", "Token " + FixtureAuthetication.getAuthenticationToken());
		CloseableHttpResponse response = httpClient.execute(request);
		STATUS_HTTP = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String result = EntityUtils.toString(entity);
		System.out.println(result);
		JSON_ARRAY = new JSONArray(result);
		response.close();
		httpClient.close();
	}

	public void toRulesList(String action) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet request = new HttpGet(FixtureSetup.BASE_URL + path);
		request.addHeader("content-type", "application/json");
		CloseableHttpResponse response = httpClient.execute(request);
		STATUS_HTTP = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String result = EntityUtils.toString(entity);
		System.out.println(result);
		JSON_ARRAY = new JSONArray(result);
		response.close();
		httpClient.close();
	}

	public void toEncounterCount(String action) {
	}

	public static JSONArray getArray() {
		return JSON_ARRAY;
	}

	public static String getHttpStatus() {
		return Integer.toString(STATUS_HTTP);
	}
}