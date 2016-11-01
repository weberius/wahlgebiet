package de.illilli.opendata.service.wahlgebiet;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

import de.illilli.opendata.service.wahlgebiet.stimmbezirk.Stimmbezirk;

public class StimmbezirkFacadeTest {

	@Before
	public void setUp() throws Exception {
	}

	public static List<Stimmbezirk> getDefaultStimmbezirk() {
		List<Stimmbezirk> stimmbezirkList = new ArrayList<>();
		Stimmbezirk stimmbezirk = new Stimmbezirk();
		stimmbezirk.setFlaeche(0.0);
		stimmbezirk.setId("id");
		stimmbezirk.setNummer(0);
		stimmbezirk.setNummerBundestagswahl(0);
		stimmbezirk.setNummerKommunalwahl(0);
		stimmbezirk.setNummerLandtagswahl(0);
		stimmbezirk.setNummerStadtbezirk(0);
		stimmbezirk.setNummerStadtteil(0);
		stimmbezirk.setStadtbezirk("stadtbezirk");
		stimmbezirk.setStadtteil("stadtteil");
		stimmbezirk.setUmfang(0.0);
		stimmbezirkList.add(stimmbezirk);
		return stimmbezirkList;
	}

}
