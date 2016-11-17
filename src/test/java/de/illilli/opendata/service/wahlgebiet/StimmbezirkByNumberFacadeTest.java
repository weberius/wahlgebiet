package de.illilli.opendata.service.wahlgebiet;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.junit.Before;

import de.illilli.jdbc.ConnectionEnvironment;
import de.illilli.opendata.service.Facade;

public class StimmbezirkByNumberFacadeTest {

	@Before
	public void setUp() throws Exception {
	}

	public static void main(String[] args) throws SQLException, NamingException, IOException {
		ConnectionEnvironment.setUpConnectionForJndi();

		int number = 10101;
		Facade facade = new StimmbezirkByNumberFacade(number);
		System.out.println(facade.getJson());
	}

}
