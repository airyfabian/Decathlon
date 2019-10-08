package com.personal.decathlon.model.data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Airy Fabian Rosales
 * @date Sep-2019
 */
public class Event implements Serializable {

	private String nameEvent;
	private String result;
	private BigDecimal score;

	public Event() {
		super();
	}

	/**
	 * @param nameEvent
	 * @param result
	 * @param score
	 * @param position
	 */
	public Event(String nameEvent, String result, BigDecimal score) {
		super();
		this.nameEvent = nameEvent;
		this.result = result;
		this.score = score;
	}

	public String getNameEvent() {
		return nameEvent;
	}

	public void setNameEvent(String nameEvent) {
		this.nameEvent = nameEvent;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Event [nameEvent=" + nameEvent + ", result=" + result + ", score=" + score + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6588854356100823193L;

}
