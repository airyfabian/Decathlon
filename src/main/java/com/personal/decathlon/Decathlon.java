package com.personal.decathlon;

import java.util.List;

import com.personal.decathlon.business.file.ProcessOnCsvAndXml;
import com.personal.decathlon.business.process.ProcessCompetitionResult;
import com.personal.decathlon.model.data.Athlete;

/**
 * @author Airy Fabian Rosales 
 * @date September/21/2019
 */
public class Decathlon {

	public static void main(String[] args) {
		if (args == null || args.length <= 0) {
			System.out.println("Please, To execute this programm you must send two parameter");
			return;
		}
		if (args.length != 2) {
			System.out.println("Sorry, the parameter's number is not correct. Try Again.");
			return;
		}
		try {
			ProcessOnCsvAndXml processFile = new ProcessOnCsvAndXml();
			List<String> rows = processFile.readFile(args[0]);
			List<Athlete> athletes = (new ProcessCompetitionResult()).resultEvent(rows);
			processFile.createdXmlWithJaxb(athletes, args[1]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}