package br.ufsc.covid.ok.person;
import br.ufsc.covid.ok.FixturePathGet;
import net.douglashiura.us.Fixture;
@Fixture("PersonNotification")
public class FixturePersonNotification {
	
	
	public String getCreated(){
		return FixturePathGet.getArray().getJSONObject(0).getString("created");
	}
	public String getCreated1(){
		return FixturePathGet.getArray().getJSONObject(1).getString("created");
	}
	public String getDelivered(){
		return FixturePathGet.getArray().getJSONObject(0).getString("delivered");
	}
	public String getDelivered1(){
		return FixturePathGet.getArray().getJSONObject(1).getString("delivered");
	}
	public String getId(){
		return "{id}";
	}
	public String getId1(){
		return "{id}";
	}
	public String getMessage(){
		return FixturePathGet.getArray().getJSONObject(0).getString("message");
	}
	public String getMessage1(){
		return FixturePathGet.getArray().getJSONObject(1).getString("message");
	}
	public String getRead(){
		return FixturePathGet.getArray().getJSONObject(0).getString("read");
	}
	public String getRead1(){
		return FixturePathGet.getArray().getJSONObject(1).getString("read");
	}
	public String getStatusHttp(){
		return FixturePathGet.getHttpStatus();
	}
	public String getTitle(){
		return FixturePathGet.getArray().getJSONObject(0).getString("title");
	}
	public String getTitle1(){
		return FixturePathGet.getArray().getJSONObject(1).getString("title");
	}
	public void toPersonSymtomsReport(String action){
	}
}