package de.illilli.opendata.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public abstract class AskForCsv<T> {

	// used by inherited classes
	protected Class<T> clazz;
	// used in this class
	private List<T> dataList = new ArrayList<>();

	public AskForCsv() {
	}

	/**
	 * Map read data from remote Stream to List<T>. This has to be called by
	 * inherited classes.
	 * 
	 * @param url
	 *            use gutURL(int) for retrieving valid URL.
	 * @param objectReader
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	protected void mapData(URL url, ObjectReader objectReader) throws MalformedURLException, IOException {
		mapData(url.openStream(), objectReader);
	}

	/**
	 * Map read data from remote Stream to List<T>. This has to be called by
	 * inherited classes.
	 * 
	 * @param inputStream
	 *            e.g. from file for local tests.
	 * @param objectReader
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	protected void mapData(InputStream inputStream, ObjectReader objectReader)
			throws MalformedURLException, IOException {
		MappingIterator<T> mappingIterator = objectReader.readValues(inputStream);
		while (mappingIterator.hasNext()) {
			dataList.add(mappingIterator.next());
		}
	}

	/**
	 * Assemble different fragments to a valid URL. This must be done in
	 * inherited Class.
	 * 
	 * @return
	 * @throws MalformedURLException
	 */
	protected abstract URL getUrl() throws MalformedURLException;

	/**
	 * Needs a CsvSchema and the Class where to put the data. This has to be
	 * defined in inherited Class.
	 * 
	 * @param schema
	 * @param clazz
	 * @return
	 */
	protected ObjectReader getObjectReader(CsvSchema schema, Class<T> clazz) {
		return new CsvMapper().reader(schema).withType(clazz);
	}

	/**
	 * return data.
	 * 
	 * @return
	 * @see AskFor
	 */
	public List<T> getData() {
		return dataList;
	}

}
