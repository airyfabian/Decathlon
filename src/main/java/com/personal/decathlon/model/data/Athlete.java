package com.personal.decathlon.model.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
/**
 * @author Airy Fabian Rosales
 * @date Sep-2019
 */
@XmlRootElement
@XmlType(propOrder = {"name", "positionFinal", "totalScore", "event"})
public class Athlete implements Serializable {

	private String name;
	private BigDecimal totalScore;
	private String positionFinal;
	private List<Event> event;

	public Athlete() {
		super();
	}

	/**
	 * @param name
	 * @param event
	 * @param totalScore
	 * @param positionFinal
	 */
	public Athlete(String name, List<Event> event, BigDecimal totalScore, String positionFinal) {
		super();
		this.name = name;
		this.event = event;
		this.totalScore = totalScore;
		this.positionFinal = positionFinal;
	}

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getTotalScore() {
		return totalScore;
	}

	@XmlElement
	public void setTotalScore(BigDecimal totalScore) {
		this.totalScore = totalScore;
	}

	public String getPositionFinal() {
		return positionFinal;
	}

	@XmlElement
	public void setPositionFinal(String positionFinal) {
		this.positionFinal = positionFinal;
	}

	public List<Event> getEvent() {
		return event;
	}

	@XmlElement
	public void setEvent(List<Event> event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "Athlete [name=" + name + ", event=" + event.toString() + ", totalScore=" + totalScore
				+ ", positionFinal=" + positionFinal + "]";
	}

	/**
	* 
	*/
	private static final long serialVersionUID = -2384700268103627911L;

}
