package de.illilli.opendata.service.wahlgebiet.wahllokal.jdbc;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;

import de.illilli.jdbc.ConnectionEnvironment;
import de.illilli.jdbc.Select;

public class SelectWahllokaleTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	public static void main(String[] args) throws SQLException, NamingException, IOException, ClassNotFoundException {
		ConnectionEnvironment.setUpConnectionForJndi();
		Select<WahllokalDTO> select = new SelectWahllokale();
		List<WahllokalDTO> list = select.getDbObjectList();
		for (WahllokalDTO dto : list) {
			System.out.println(dto);
		}
	}

}
