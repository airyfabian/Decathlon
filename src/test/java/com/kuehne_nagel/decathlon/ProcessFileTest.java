package com.kuehne_nagel.decathlon;

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

import com.kuehne_nagel.decathlon.business.file.ProcessFile;
import com.kuehne_nagel.decathlon.business.process.BusinessProcess;
import com.kuehne_nagel.decathlon.model.data.Athlete;
import com.kuehne_nagel.decathlon.model.data.XmlContent;
/**
 * @author Airy Fabian Rosales
 * @date Sep-2019
 */
public class ProcessFileTest {

	ProcessFile processFile;
	BusinessProcess businessProcess;

	@BeforeEach
	void init() {
		this.processFile = new ProcessFile();
		this.businessProcess = new BusinessProcess();
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
		athletes.add(this.businessProcess
				.registerOneAthlete("John Smith;12.61;5.00;9.22;1.50;60.39;16.43;21.60;2.60;35.81;5.25.72"));
		String outFile = "C:\\eclipse\\personales\\decathlon\\";
		try {
			this.processFile.createdXmlWithJaxb(athletes, outFile);
			XmlContent xc = this.readXmlWithJaxb(outFile + "DecathlonResult.xml");
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

	public XmlContent readXmlWithJaxb(String pathFile) throws Exception {
		File xmlFile = new File(pathFile);
		XmlContent xc = new XmlContent();
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(XmlContent.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			xc = (XmlContent) jaxbUnmarshaller.unmarshal(xmlFile);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return xc;
	}
}
