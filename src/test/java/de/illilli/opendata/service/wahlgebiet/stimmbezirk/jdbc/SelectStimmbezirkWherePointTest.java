package de.illilli.opendata.service.wahlgebiet.stimmbezirk.jdbc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;

import de.illilli.jdbc.ConnectionEnvironment;
import de.illilli.jdbc.Select;

public class SelectStimmbezirkWherePointTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	public static void main(String[] args) throws SQLException, NamingException, IOException {

		ConnectionEnvironment.setUpConnectionForJndi();

		double lng = 6.958307;
		double lat = 50.941357;

		Select<StimmbezirkDTO> select = new SelectStimmbezirkWherePoint(lng, lat);
		List<StimmbezirkDTO> dtoList = select.getDbObjectList();

		for (StimmbezirkDTO dto : dtoList) {
			System.out.println(dto.toString());
		}
	}
}
