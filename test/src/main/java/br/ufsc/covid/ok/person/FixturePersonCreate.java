package br.ufsc.covid.ok.person;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import br.ufsc.covid.Database;
import br.ufsc.covid.ok.FixtureSetup;
import net.douglashiura.us.Fixture;

@Fixture("PersonCreate")
public class FixturePersonCreate {
	private String path;
	private String beaconId;
	private Integer age;
	private String riskfactors;
	private String sex;
	private static int STATUS_HTTP;
	private static JSONObject person;

	public void setAge(String value) {
		age = Integer.valueOf(value);
	}

	public void setBeaconId(String value) {
		beaconId = value;
	}

	public void setPath(String value) {
		path = value;
	}

	public void setRiskFactorsIds(String value) {
		riskfactors = value;
	}

	public void setSex(String value) {
		sex = value;
	}

	public String getAge() {
		return Integer.toString(person.getInt("age"));
	}

	public String getBeaconId() {
		return "{beacon_id}";
	}

	public String getHttpStatus() {
		return Integer.toString(STATUS_HTTP);
	}

	public String getId() {
		return "{id}";
	}

	public String getSex() {
		return person.getString("sex");
	}

	public String getStatus() {
		return person.getString("status");
	}

	public String getToken() {
		return "{token}";
	}

	public void setStatus(String value) {
	}

	public void toPersonUpdateStatus(String action) throws Exception {

	}

	public void toPersonCreate(String action) throws ClientProtocolException, IOException {
		JSONObject json = new JSONObject();
		json.put("age", age);
		json.put("beacon_id", beaconId);
		json.put("sex", sex);
//		json.put("status", status);
		List<Integer> riskFactorsIds = Database.getInstance().idsOf(riskfactors);
		json.put("risk_factors_ids", riskFactorsIds);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost request = new HttpPost(FixtureSetup.BASE_URL + path);
		request.addHeader("content-type", "application/json");
		request.setEntity(new StringEntity(json.toString()));
		CloseableHttpResponse response = httpClient.execute(request);
		STATUS_HTTP = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String result = EntityUtils.toString(entity);
		person = new JSONObject(result);
		response.close();
		httpClient.close();
	}

	public static JSONObject getPerson() {
		return person;
	}
}