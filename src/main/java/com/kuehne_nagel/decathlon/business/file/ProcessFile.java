package com.kuehne_nagel.decathlon.business.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.kuehne_nagel.decathlon.model.data.Athlete;
import com.kuehne_nagel.decathlon.model.data.XmlContent;

/**
 * @author Airy Fabian Rosales
 * @date Sep-2019
 */
public class ProcessFile {

	public ProcessFile() {
		super();
	}

	/**
	 * @description with this method, you can read a file.
	 * @param path is a string with path where you can find the file.
	 * @return a list of the String, each row is a register.
	 * @throws Exception
	 */
	public List<String> readFile(String path) throws Exception {
		List<String> rows = new ArrayList<String>();
		Stream<String> lines = null;
		try {
			lines = Files.lines(Paths.get(path));
			lines.forEach(rowFile -> {
				if (rowFile != null && rowFile.trim().length() > 1) {
					rows.add(rowFile);
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception("We have a problem when we was reading the file");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("We have a problem unkown");
		} finally {
			if (lines != null) {
				lines.close();
			}
		}
		return rows;
	}

	/** 
	 * @description with this method, I will create the xml file
	 * @param athletes is the list of athletes
	 * @param outFile is the path where you want to create the xml file
	 * */
	public void createdXmlWithJaxb(List<Athlete> athletes, String outFile) throws Exception {
		XmlContent xc = new XmlContent();
		xc.setAthletes(athletes);
		File file = new File(outFile + "DecathlonResult.xml");
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(XmlContent.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(xc, file);
		} catch (JAXBException e) {
			e.printStackTrace();
			throw new Exception("We have a problem when we going to created the xml file.");
		}

	}
}
