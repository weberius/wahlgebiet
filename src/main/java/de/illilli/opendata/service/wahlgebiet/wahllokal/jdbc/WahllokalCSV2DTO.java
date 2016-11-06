package de.illilli.opendata.service.wahlgebiet.wahllokal.jdbc;

import org.apache.commons.lang.math.NumberUtils;
import org.opengis.geometry.MismatchedDimensionException;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.NoSuchAuthorityCodeException;
import org.opengis.referencing.operation.TransformException;
import org.postgis.PGgeometry;

import de.illilli.opendata.service.wahlgebiet.wahllokal.WahllokalCSV;

/**
 * Diese Klasse konvertiert ein csv-Object in ein DTO. Hierbei werden bereits
 * alle Konversionen vorgenommen. Für die Konversion von String nach int wird
 * die Bibliothek
 * <a href="https://commons.apache.org/proper/commons-lang/">Apache Commons
 * Lang</a> verwendket. Die Konversion von KOORX, KOORY nach {@link PGgeometry}
 * wird an die Klasse {@link ConvertCoordinate2PGgeometry} deligiert.
 * 
 * @see ConvertCoordinate2PGgeometry
 */

public class WahllokalCSV2DTO {

	private WahllokalDTO dto;

	public WahllokalCSV2DTO(WahllokalCSV csv)
			throws MismatchedDimensionException, NoSuchAuthorityCodeException, FactoryException, TransformException {

		dto = new WahllokalDTO();
		dto.setAbstimmbezirk(NumberUtils.toInt(csv.abstimmbezirk));
		dto.setAdNummer(NumberUtils.toInt(csv.ad_nummer));
		dto.setAdresse(csv.wlk_adresse);
		dto.setBemerkung(csv.wlk_bemerkung);
		dto.setBundestagswahlkreis(NumberUtils.toInt(csv.bundestagswahlkreis));
		dto.setKommunalwahlbezirk(NumberUtils.toInt(csv.kommunalwahlbezirk));
		dto.setLandtagswahlkreis(NumberUtils.toInt(csv.landtagswahlkreis));
		dto.setName(csv.wlk_name);
		dto.setObjectid(NumberUtils.toInt(csv.objectid));
		dto.setPostzustellbezirk(NumberUtils.toInt(csv.postzustellbezirk));
		dto.setRollstuhlgerecht(NumberUtils.toInt(csv.rollstuhlgerecht));
		dto.setStadtteil(csv.wlk_stadtteil);
		dto.setStimmbezirk(NumberUtils.toInt(csv.nr_stimmbezirk800));
		dto.setStimmbezirkStadtteil(csv.stimmbezirk_stadtteil);

		PGgeometry geom = new ConvertCoordinate2PGgeometry(csv.koorx, csv.koory).getGeom();
		dto.setGeom(geom);

	}

	public WahllokalDTO getDto() {
		return dto;
	}

}
