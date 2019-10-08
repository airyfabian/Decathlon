package com.personal.decathlon.business.enu;

import java.math.BigDecimal;

import com.personal.decathlon.business.process.ProcessCompetitionResult;
import com.personal.decathlon.utils.ConvertVariable;
/**
 * @author Airy Fabian Rosales
 * @date Sep-2019
 */
public enum ScoringTable {
	ST_MTS100("100 Mts", new BigDecimal("25.4347"), new BigDecimal("18"), new BigDecimal("1.81")) {
		@Override
		public BigDecimal toDoCalculate(String scoreEvent) {
			ProcessCompetitionResult bp = new ProcessCompetitionResult();
			return bp.trackEvents(ConvertVariable.getSecond(scoreEvent), this);
		}
	},
	ST_LONGJUMP("Long Jump", new BigDecimal("0.14354"), new BigDecimal("220"), new BigDecimal("1.4")) {
		@Override
		public BigDecimal toDoCalculate(String scoreEvent) {
			ProcessCompetitionResult bp = new ProcessCompetitionResult();
			return bp.fieldEvents(ConvertVariable.getCentimeters(scoreEvent), this);
		}
	},
	ST_SHOTPUT("Shot Put", new BigDecimal("51.39"), new BigDecimal("1.5"), new BigDecimal("1.05")) {
		@Override
		public BigDecimal toDoCalculate(String scoreEvent) {
			ProcessCompetitionResult bp = new ProcessCompetitionResult();
			return bp.fieldEvents(ConvertVariable.getMeters(scoreEvent), this);
		}
	},
	ST_HIGHJUMP("High Jump", new BigDecimal("0.8465"), new BigDecimal("75"), new BigDecimal("1.42")) {
		@Override
		public BigDecimal toDoCalculate(String scoreEvent) {
			ProcessCompetitionResult bp = new ProcessCompetitionResult();
			return bp.fieldEvents(ConvertVariable.getCentimeters(scoreEvent), this);
		}
	},
	ST_MTS400("400 mts", new BigDecimal("1.53775"), new BigDecimal("82"), new BigDecimal("1.81")) {
		@Override
		public BigDecimal toDoCalculate(String scoreEvent) {
			ProcessCompetitionResult bp = new ProcessCompetitionResult();
			return bp.trackEvents(ConvertVariable.getSecond(scoreEvent), this);
		}
	},
	ST_HURDLESMTS110("Hurdles 110 mts", new BigDecimal("5.74352"), new BigDecimal("28.5"), new BigDecimal("1.92")) {
		@Override
		public BigDecimal toDoCalculate(String scoreEvent) {
			ProcessCompetitionResult bp = new ProcessCompetitionResult();
			return bp.trackEvents(ConvertVariable.getSecond(scoreEvent), this);
		}
	},
	ST_DISCUSTHROW("Discus Throw", new BigDecimal("12.91"), new BigDecimal("4"), new BigDecimal("1.1")) {
		@Override
		public BigDecimal toDoCalculate(String scoreEvent) {
			ProcessCompetitionResult bp = new ProcessCompetitionResult();
			return bp.fieldEvents(new BigDecimal(scoreEvent), this);
		}
	},
	ST_POLEVAULT("Pole Vault", new BigDecimal("0.2797"), new BigDecimal("100"), new BigDecimal("1.35")) {
		@Override
		public BigDecimal toDoCalculate(String scoreEvent) {
			ProcessCompetitionResult bp = new ProcessCompetitionResult();
			return bp.fieldEvents(ConvertVariable.getCentimeters(scoreEvent), this);
		}
	},
	ST_JAVELINTHROW("Javalin Throw", new BigDecimal("10.14"), new BigDecimal("7"), new BigDecimal("1.08")) {
		@Override
		public BigDecimal toDoCalculate(String scoreEvent) {
			ProcessCompetitionResult bp = new ProcessCompetitionResult();
			return bp.fieldEvents(ConvertVariable.getMeters(scoreEvent), this);
		}
	},
	ST_MTS1500("1500 mts", new BigDecimal("0.03768"), new BigDecimal("480"), new BigDecimal("1.85")) {
		@Override
		public BigDecimal toDoCalculate(String scoreEvent) {
			ProcessCompetitionResult bp = new ProcessCompetitionResult();
			return bp.trackEvents(ConvertVariable.getMinuteToSecond(scoreEvent), this);
		}
	};

	private String name;
	private BigDecimal valueA;
	private BigDecimal valueB;
	private BigDecimal valueC;

	public abstract BigDecimal toDoCalculate(String scoreEvent);

	/**
	 * @param name
	 * @param valueA
	 * @param valueB
	 * @param valueC
	 */
	private ScoringTable(String name, BigDecimal valueA, BigDecimal valueB, BigDecimal valueC) {
		this.name = name;
		this.valueA = valueA;
		this.valueB = valueB;
		this.valueC = valueC;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getValueA() {
		return valueA;
	}

	public void setValueA(BigDecimal valueA) {
		this.valueA = valueA;
	}

	public BigDecimal getValueB() {
		return valueB;
	}

	public void setValueB(BigDecimal valueB) {
		this.valueB = valueB;
	}

	public BigDecimal getValueC() {
		return valueC;
	}

	public void setValueC(BigDecimal valueC) {
		this.valueC = valueC;
	}

}
