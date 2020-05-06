package br.ufsc.covid.ok.without.authentication;
import br.ufsc.covid.ok.FixturePathGet;
import net.douglashiura.us.Fixture;
@Fixture("RiskFactor")
public class FixtureRiskFactor {
	public String getId(){
		return "{id}";
	}
	public String getId1(){
		return "{id1}";
	}
	public String getId2(){
		return "{id2}";
	}
	public String getName(){
		return FixturePathGet.getArray().getJSONObject(0).getString("name");
	}
	public String getName1(){
		return FixturePathGet.getArray().getJSONObject(1).getString("name");
	}
	public String getName2(){
		return FixturePathGet.getArray().getJSONObject(2).getString("name");
	}
	public String getStatusHttp(){
		return FixturePathGet.getHttpStatus();
	}
}