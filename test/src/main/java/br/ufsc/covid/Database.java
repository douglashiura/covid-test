package br.ufsc.covid;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.hibernate.service.ServiceRegistry;

public class Database {

	private static final String RISK_BY_NAMES = "SELECT factor FROM RiskFactor factor WHERE factor.name IN :names";
	private SessionFactory sessionFactory;
	private static Database INSTANCE = null;

	private Database() {
		Configuration configuration = new Configuration();
		Properties settings = new Properties();
		settings.put(AvailableSettings.DRIVER, "org.postgresql.Driver");
		settings.put(AvailableSettings.URL, "jdbc:postgresql://localhost:5432/app");
		settings.put(AvailableSettings.USER, "postgres");
		settings.put(AvailableSettings.PASS, "postgres");
		settings.put(AvailableSettings.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
		settings.put(AvailableSettings.SHOW_SQL, "false");
		settings.put(AvailableSettings.HBM2DDL_AUTO, "validate");
		configuration.setProperties(settings);
		configuration.addAnnotatedClass(User.class);
		configuration.addAnnotatedClass(RiskFactor.class);
		configuration.addAnnotatedClass(Symptom.class);
		configuration.addAnnotatedClass(Rule.class);
		configuration.addAnnotatedClass(Condition.class);
		configuration.addAnnotatedClass(LogicalCondition.class);
		configuration.addAnnotatedClass(Person.class);
		configuration.addAnnotatedClass(Notification.class);

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	public static Database getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Database();
		}
		return INSTANCE;
	}

	public void clear() {
		Session session = sessionFactory.openSession();
		session.doWork(new Work() {
			@Override
			public void execute(Connection connection) throws SQLException {
				StringBuffer sql = new StringBuffer();

				sql.append("DELETE FROM subscribe_subscribe;");
				sql.append("DELETE FROM subscribe_subscribe;");
				sql.append("DELETE FROM subscribe_subscribe;");
				sql.append("DELETE FROM subscribe_subscribe;");
				sql.append("DELETE FROM notification_notification;");
				sql.append("DELETE FROM tracking_person;");
				sql.append("DELETE FROM rules_logicalcondition;");
				sql.append("DELETE FROM rules_rulecondition;");
				sql.append("DELETE FROM rules_rule;");
				sql.append("DELETE FROM tracking_personstatuschange;");
				sql.append("DELETE FROM tracking_personriskfactor;");
				sql.append("DELETE FROM tracking_symptom;");
				sql.append("DELETE FROM authentication_persontoken;");
				sql.append("DELETE FROM tracking_person;");
				sql.append("DELETE FROM tracking_riskfactor;");
				sql.append("DELETE FROM authtoken_token;");
				sql.append("DELETE FROM Users_user;");
				connection.prepareStatement(sql.toString()).execute();
			}
		});
		session.close();

	}

	public void rule(Rule rule) {
		rule.getConditions().forEach(condition -> {
			condition.getLogicals().forEach(logical -> {
				logical.setCondition(condition);
			});
			condition.setRule(rule);
		});

		insert(rule);
	}

	public void insert(Object persitible) {
		Session session = sessionFactory.openSession();
		try {
			session.getTransaction().begin();
			session.persist(persitible);
			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}

	public List<Integer> idsOf(String riskfactors) {
		String[] names = riskfactors.trim().split(", ");
		Session session = sessionFactory.openSession();
		try {
			return session.createQuery(RISK_BY_NAMES, RiskFactor.class).setParameter("names", Arrays.asList(names))
					.getResultStream().map(a -> a.getId()).collect(Collectors.toList());
		} finally {
			session.close();
		}
	}

}