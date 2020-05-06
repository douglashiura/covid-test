package br.ufsc.covid.doctor;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import net.douglashiura.us.Fixture;

@Fixture("Subscribe")
public class FixtureSubscribe {
	private String path;
	private String user;
	private static int STATUS_HTTP;

	public void setPath(String value) {
		path = value;
	}

	public void setUser(String value) {
		user = value;
	}

	public void toEmailCode(String action) throws Exception {
		JSONObject json = new JSONObject();
		json.put("user", user);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost request = new HttpPost(FixtureSetupDoctor.getBASE_URL() + path);
		request.addHeader("content-type", "application/json");
		request.setEntity(new StringEntity(json.toString()));
		CloseableHttpResponse response = httpClient.execute(request);
		STATUS_HTTP = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String result = EntityUtils.toString(entity);
		if (!result.isBlank()) {
			throw new Exception(result);
		}
		response.close();
		httpClient.close();
	}

	public void toSMSCode(String action) throws Exception {
		JSONObject json = new JSONObject();
		json.put("user", user);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost request = new HttpPost(FixtureSetupDoctor.getBASE_URL() + path);
		request.addHeader("content-type", "application/json");
		request.setEntity(new StringEntity(json.toString()));
		CloseableHttpResponse response = httpClient.execute(request);
		STATUS_HTTP = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String result = EntityUtils.toString(entity);
		if (!result.isBlank()) {
			throw new Exception(result);
		}
		response.close();
		httpClient.close();
	}

	public static int getSTATUS_HTTP() {
		return STATUS_HTTP;
	}
}