package de.illilli.opendata.service.wahlgebiet.landtagswahkreis.jdbc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.junit.Before;

import de.illilli.jdbc.ConnectionEnvironment;
import de.illilli.jdbc.Select;

public class SelectLandtagswahlkreiseGeojsonTest {

	@Before
	public void setUp() throws Exception {
	}

	public static void main(String[] args) throws SQLException, NamingException, IOException, ClassNotFoundException {
		ConnectionEnvironment.setUpConnectionForJndi();
		Select<LandtagswahlkreisDTO> select = new SelectLandtagswahlkreiseGeojson();
		List<LandtagswahlkreisDTO> list = select.getDbObjectList();
		for (LandtagswahlkreisDTO dto : list) {
			System.out.println(dto);
		}
	}

}
