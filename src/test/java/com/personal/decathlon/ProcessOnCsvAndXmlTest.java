package com.personal.decathlon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.personal.decathlon.business.file.ProcessOnCsvAndXml;
import com.personal.decathlon.business.process.ProcessCompetitionResult;
import com.personal.decathlon.model.data.Athlete;
import com.personal.decathlon.model.data.DataForXmlFile;
/**
 * @author Airy Fabian Rosales
 * @date Sep-2019
 */
public class ProcessOnCsvAndXmlTest {

	ProcessOnCsvAndXml processFile;
	ProcessCompetitionResult processCompetitionResult;

	@BeforeEach
	void init() {
		this.processFile = new ProcessOnCsvAndXml();
		this.processCompetitionResult = new ProcessCompetitionResult();
	}

	@DisplayName("Verify the calculate of Score to Javelin Throw Event")
	@Test
	public void verifyReadFile() {
		List<String> rows;
		try {
			rows = this.processFile.readFile("C:\\Users\\Wayssen\\Downloads\\archive\\results.csv");
			assertNotNull(rows);
			assumeTrue(rows.size() > 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@DisplayName("Fail the calculate of Score to Javelin Throw Event")
	@Test
	public void failReadFile() {
		try {
			List<String> rows = this.processFile.readFile("C:\\eclipse\\personales\\decathlon\\results.csv");
			assumeTrue(!(rows.size() > 0));
			assumeTrue(false);
		} catch (Exception e) {
			assumeTrue(true);
		}
	}

	@DisplayName("Verify if I can create the xml file")
	@Test
	public void verifyCreateXmlFile() {
		List<Athlete> athletes = new ArrayList<Athlete>();
		athletes.add(this.processCompetitionResult
				.registerOneAthlete("John Smith;12.61;5.00;9.22;1.50;60.39;16.43;21.60;2.60;35.81;5.25.72"));
		String outFile = "C:\\eclipse\\personales\\decathlon\\";
		try {
			this.processFile.createdXmlWithJaxb(athletes, outFile);
			DataForXmlFile xc = this.readXmlWithJaxb(outFile + "DecathlonResult.xml");
			assertNotNull(xc);
			assertNotNull(xc.getAthletes().get(0));
			Athlete athletesXml = xc.getAthletes().get(0);
			assertEquals(athletesXml.getName(), "John Smith");
			assumeTrue(true);
		} catch (Exception e) {
			assumeTrue(false);
			e.printStackTrace();
		}
	}

	public DataForXmlFile readXmlWithJaxb(String pathFile) throws Exception {
		File xmlFile = new File(pathFile);
		DataForXmlFile xc = new DataForXmlFile();
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(DataForXmlFile.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			xc = (DataForXmlFile) jaxbUnmarshaller.unmarshal(xmlFile);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return xc;
	}
}
