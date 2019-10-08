package com.personal.decathlon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.personal.decathlon.business.enu.ScoringTable;

/**
 * Unit test for simple App.
 */
public class ScoringTableTest {

	@DisplayName("Verify the calculate of Score to Mts 100 Event")
	@Test
	public void verifyScoreMTS100() {
		BigDecimal scoreCalculate = ScoringTable.ST_MTS100.toDoCalculate("12.61");
		assertEquals(new BigDecimal("536"), scoreCalculate);

	}

	@DisplayName("Verify the calculate of Score to Long Jump Event")
	@Test
	public void verifyScoreLONGJUMP() {
		BigDecimal scoreCalculate = ScoringTable.ST_LONGJUMP.toDoCalculate("5.00");
		assertEquals(new BigDecimal("382"), scoreCalculate);
	}

	@DisplayName("Verify the calculate of Score to Shot Put Event")
	@Test
	public void verifyScoreSHOTPUT() {
		BigDecimal scoreCalculate = ScoringTable.ST_SHOTPUT.toDoCalculate("9.22");
		assertEquals(new BigDecimal("439"), scoreCalculate);
	}

	@DisplayName("Verify the calculate of Score to High Jump Event")
	@Test
	public void verifyScoreHIGHJUMP() {
		BigDecimal scoreCalculate = ScoringTable.ST_HIGHJUMP.toDoCalculate("1.50");
		assertEquals(new BigDecimal("389"), scoreCalculate);
	}

	@DisplayName("Verify the calculate of Score to Mts 400 Event")
	@Test
	public void verifyScoreMTS400() {
		BigDecimal scoreCalculate = ScoringTable.ST_MTS400.toDoCalculate("60.39");
		assertEquals(new BigDecimal("400"), scoreCalculate);
	}

	@DisplayName("Verify the calculate of Score to Hurdles Mts 110 Event")
	@Test
	public void verifyScoreHURDLESMTS110() {
		BigDecimal scoreCalculate = ScoringTable.ST_HURDLESMTS110.toDoCalculate("16.43");
		assertEquals(new BigDecimal("685"), scoreCalculate);
	}

	@DisplayName("Verify the calculate of Score to Discus Throw Event")
	@Test
	public void verifyScoreDISCUSTHROW() {
		BigDecimal scoreCalculate = ScoringTable.ST_DISCUSTHROW.toDoCalculate("21.60");
		assertEquals(new BigDecimal("302"), scoreCalculate);
	}

	@DisplayName("Verify the calculate of Score to Pole Vault Event")
	@Test
	public void verifyScorePOLEVAULT() {
		BigDecimal scoreCalculate = ScoringTable.ST_POLEVAULT.toDoCalculate("2.60");
		assertEquals(new BigDecimal("264"), scoreCalculate);
	}

	@DisplayName("Verify the calculate of Score to Javelin Throw Event")
	@Test
	public void verifyScoreJAVELINTHROW() {
		BigDecimal scoreCalculate = ScoringTable.ST_JAVELINTHROW.toDoCalculate("35.81");
		assertEquals(new BigDecimal("382"), scoreCalculate);
	}

	@DisplayName("Verify the calculate of Score to Mts 1500 Event")
	@Test
	public void verifyScoreMTS1500() {
		BigDecimal scoreCalculate = ScoringTable.ST_MTS1500.toDoCalculate("5.25.72");
		assertEquals(new BigDecimal("421"), scoreCalculate);
	}
}
