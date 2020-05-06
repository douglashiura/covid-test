package br.ufsc.covid.ok.person;

import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import br.ufsc.covid.Database;
import br.ufsc.covid.ok.FixtureAuthetication;
import br.ufsc.covid.ok.FixtureSetup;
import net.douglashiura.us.Fixture;

@Fixture("PersonUpdateStatus")
public class FixturePersonUpdateStatus {

	private String sex;
	private String riskfactors;
	private String path;
	private String beaconId;
	private Integer age;
	private String status;
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

	public void setStatus(String value) {
		status = value;
	}

	public String getAge() {
		return Integer.toString(person.getInt("age"));
	}

	public String getBeaconId() {
		return "{beacon_id}";
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

	public String getStatusHttp() {
		return Integer.toString(STATUS_HTTP);
	}

	public String getRiskFactorsIds() {
		return "Asthma, Cardiovascular, Bronchitis";

	}

	public void toPersonUpdateStatus(String action) throws Exception {
		JSONObject json = new JSONObject();
		json.put("age", age);
		json.put("beacon_id", beaconId);
		json.put("sex", sex);
		json.put("status", status);
		List<Integer> riskFactorsIds = Database.getInstance().idsOf(riskfactors);
		json.put("risk_factors_ids", riskFactorsIds);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		path = path.replace("{beacon_id}", FixturePersonCreate.getPerson().getString("beacon_id"));
		HttpPost request = new HttpPost(FixtureSetup.BASE_URL + path);
		request.addHeader("content-type", "application/json");
		
//		request.addHeader("Authorization", "Token " + FixturePersonCreate.getPerson().getString("token"));
		request.addHeader("Authorization", "Token " + FixtureAuthetication.getAuthenticationToken());
		request.setEntity(new StringEntity(json.toString()));
		CloseableHttpResponse response = httpClient.execute(request);
		STATUS_HTTP = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String result = EntityUtils.toString(entity);
		System.out.println(result);
		person = new JSONObject(result);
		response.close();
		httpClient.close();

	}
}