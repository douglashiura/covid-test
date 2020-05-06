package br.ufsc.covid.ok;

import br.ufsc.covid.Database;
import br.ufsc.covid.Notification;
import br.ufsc.covid.Person;
import br.ufsc.covid.RiskFactor;
import br.ufsc.covid.Rule;
import br.ufsc.covid.Symptom;
import br.ufsc.covid.User;
import net.douglashiura.us.Fixture;

@Fixture("Setup")
public class FixtureSetup {

	private User drauzio;
	private RiskFactor asthma;
	private RiskFactor cardiovascular;
	private RiskFactor bronchitis;
	private Symptom fever;
	private Symptom shortnessOfBreath;
	private Rule rule1;
	private Rule rule2;
	private Person douglas;
	private Person pedro;
	private Notification douglasNotification1;
	private Notification douglasNotification2;
	public static String BASE_URL;

	public void setUrlBase(String value) {
		BASE_URL = value;
	}


	public void toPathGet(String action) {
		Database.getInstance().clear();
		Database.getInstance().insert(drauzio);
		Database.getInstance().insert(asthma);
		Database.getInstance().insert(cardiovascular);
		Database.getInstance().insert(bronchitis);
		Database.getInstance().insert(fever);
		Database.getInstance().insert(shortnessOfBreath);
		Database.getInstance().insert(douglas);
		Database.getInstance().insert(pedro);
		Database.getInstance().rule(rule1);
		Database.getInstance().rule(rule2);
		Database.getInstance().insert(douglasNotification1);
		Database.getInstance().insert(douglasNotification2);
	}

	public void toSubscribe(String action) {
		Database.getInstance().clear();
		Database.getInstance().rule(rule1);
		Database.getInstance().rule(rule2);
	}

}