package br.ufsc.covid.doctor;

import br.ufsc.covid.Database;
import net.douglashiura.us.Fixture;

@Fixture("SetupDoctor")
public class FixtureSetupDoctor {
	private static String BASE_URL;

	public void setUrlBase(String value) {
		BASE_URL = value;
	}

	public void toDoctorApp(String action) {
		Database.getInstance().clear();
	}

	public static String getBASE_URL() {
		return BASE_URL;
	}
}