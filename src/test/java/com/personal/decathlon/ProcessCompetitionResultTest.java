package com.personal.decathlon;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.personal.decathlon.business.process.ProcessCompetitionResult;
import com.personal.decathlon.model.data.Athlete;

public class ProcessCompetitionResultTest {

	ProcessCompetitionResult processCompetitionResult;

	@BeforeEach
	void init() {
		this.processCompetitionResult = new ProcessCompetitionResult();
	}

	@DisplayName("Verify the method result event")
	@Test
	public void verifyMethodResultEvent() {
		List<String> rows = new ArrayList<String>();
		rows.add("John Smith;12.61;5.00;9.22;1.50;60.39;16.43;21.60;2.60;35.81;5.25.72");
		rows.add("Jane Doe;13.04;4.53;7.79;1.55;64.72;18.74;24.20;2.40;28.20;6.50.76");
		List<Athlete> athletes = this.processCompetitionResult.resultEvent(rows);
		assertNotNull(athletes);
		assertTrue(rows.size() == 2);
	}

	@DisplayName("Verify the method result event")
	@Test
	public void verifyOneObjecEvent() {
		List<String> rows = new ArrayList<String>();
		rows.add("Airy Fabian Rosales;10.55;7.80;16.00;2.05;48.42;13.75;50.54;5.45;71.90;4.36.11");
		List<Athlete> athletes = this.processCompetitionResult.resultEvent(rows);
		assertNotNull(athletes);
		assertTrue(rows.size() == 1);
		assertTrue(athletes.get(0).getName().compareToIgnoreCase("Airy Fabian Rosales") == 0);
		assertTrue(athletes.get(0).getTotalScore().compareTo(new BigDecimal("9126")) == 0);
		assertTrue(athletes.get(0).getEvent().get(0).getScore().compareTo(new BigDecimal("963")) == 0);
	}
}
