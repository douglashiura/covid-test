package br.ufsc.covid.ok;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import net.douglashiura.us.Fixture;

@Fixture("Authetication")
public class FixtureAuthetication {
	private String path;
	private String password;
	private String email;
	private static int STATUS_HTTP;
	private static JSONObject authentication;

	public void setEmail(String value) {
		email = value;
	}

	public void setPasword(String value) {
		password = value;
	}

	public void setPath(String value) {
		path = value;
	}

	public String getEmail() {
		return authentication.getJSONObject("user").getString("email");
	}

	public String getLastName() {
		return authentication.getJSONObject("user").getString("last_name");
	}

	public String getName() {
		return authentication.getJSONObject("user").getString("first_name");

	}

	public String getStatusHttp() {
		return Integer.toString(STATUS_HTTP);
	}

	public String getToken() {
		return "{access_token}";
	}

	public void toEncounteredPeople(String action) {

	}

	public void toPathGet(String action) {

	}

	public void toAuthetication(String action) throws ParseException, IOException {
		JSONObject json = new JSONObject();
		json.put("email", email);
		json.put("password", password);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost request = new HttpPost(FixtureSetup.BASE_URL + path);
		request.addHeader("content-type", "application/json");
		request.setEntity(new StringEntity(json.toString()));
		CloseableHttpResponse response = httpClient.execute(request);
		STATUS_HTTP = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String result = EntityUtils.toString(entity);
		authentication = new JSONObject(result);
		response.close();
		httpClient.close();

	}

	public void toPersonCreate(String action) {
	}

	public void toEncounterCreate(String action) {
	}

	public static String getAuthenticationToken() {
		return authentication.getString("access_token");
	}
}