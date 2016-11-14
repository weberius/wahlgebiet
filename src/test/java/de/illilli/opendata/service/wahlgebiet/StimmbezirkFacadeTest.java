package de.illilli.opendata.service.wahlgebiet;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

import de.illilli.opendata.service.wahlgebiet.stimmbezirk.jdbc.StimmbezirkDTO;

public class StimmbezirkFacadeTest {

	@Before
	public void setUp() throws Exception {
	}

	public static List<StimmbezirkDTO> getDefaultStimmbezirk() {
		List<StimmbezirkDTO> stimmbezirkList = new ArrayList<>();
		StimmbezirkDTO stimmbezirk = new StimmbezirkDTO();
		stimmbezirk.setId("id");
		stimmbezirk.setNummer(0);
		stimmbezirk.setbWahl(0);
		stimmbezirk.setkWahl(0);
		stimmbezirk.setlWahl(0);
		stimmbezirk.setNrStb(0);
		stimmbezirk.setNrStt(0);
		stimmbezirk.setStb("stadtbezirk");
		stimmbezirk.setStt("stadtteil");
		stimmbezirkList.add(stimmbezirk);
		return stimmbezirkList;
	}

}
