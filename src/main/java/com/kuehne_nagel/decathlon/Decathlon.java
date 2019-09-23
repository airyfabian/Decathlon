package com.kuehne_nagel.decathlon;

import java.util.List;

import com.kuehne_nagel.decathlon.business.file.ProcessFile;
import com.kuehne_nagel.decathlon.business.process.BusinessProcess;
import com.kuehne_nagel.decathlon.model.data.Athlete;

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
			ProcessFile processFile = new ProcessFile();
			List<String> rows = processFile.readFile(args[0]);
			List<Athlete> athlete = (new BusinessProcess()).resultEvent(rows);
			processFile.createdXmlWithJaxb(athlete, args[1]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}