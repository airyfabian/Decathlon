package com.personal.decathlon.business.process;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.personal.decathlon.business.enu.OrderByFile;
import com.personal.decathlon.business.enu.ScoringTable;
import com.personal.decathlon.model.data.Athlete;
import com.personal.decathlon.model.data.Event;
import com.personal.decathlon.utils.ConstantUtils;

/**
 * @author Airy Fabian Rosales
 * @date Sep-2019
 */
public class ProcessCompetitionResult {
	/**
	 * @description to know witch position on the file
	 */
	private Integer positionFile;
	/**
	 * @description to controller total score
	 */
	private BigDecimal totalScore;
	/**
	 * @description to controller the position on recursive method
	 */
	private Integer position;
	/**
	 * @description With this list, I can controller position
	 */
	private List<Athlete> athletesWithPositions;

	/**
	 * @description with method, you can move inside of arrays to send one row.
	 * @return list of Athlete Object
	 */
	public List<Athlete> resultEvent(List<String> rows) {
		List<Athlete> athletes = new ArrayList<Athlete>();
		rows.forEach(row -> {
			athletes.add(this.registerOneAthlete(row));
		});
		athletes.sort((a1, a2) -> a2.getTotalScore().compareTo(a1.getTotalScore()));
		this.position = 1;
		this.athletesWithPositions = new ArrayList<Athlete>();
		this.definePositionPerEachAthlete(athletes);
		return this.athletesWithPositions;
	}

	/**
	 * @description With this method, I will show the final position to the athlete.
	 * @note this is the best method, because I don't need to move through all arrays, it's only necessary.
	 */
	private void definePositionPerEachAthlete(List<Athlete> athleteOrigin) {
		List<Athlete> athlete = (List<Athlete>) athleteOrigin.stream().filter(athleteOne -> athleteOne.getPositionFinal().compareToIgnoreCase("0") == 0 && !this.athletesWithPositions.contains(athleteOne)).collect(Collectors.toList());
		if (athlete != null && athlete.size() > 0) {
			List<Athlete> duplicate = athleteOrigin.stream().filter(athleteOne -> athleteOne.getTotalScore().compareTo(athlete.get(0).getTotalScore()) == 0).collect(Collectors.toList());
			if (duplicate.size() > 0) {
				String position1 = this.similarPosition(this.position, new Integer(duplicate.size()));
				duplicate.forEach(a -> a.setPositionFinal(position1));
				this.position = this.position + duplicate.size();
				this.athletesWithPositions.addAll(duplicate);
			} else {
				athlete.get(0).setPositionFinal(this.position.toString());
				this.athletesWithPositions.add(athlete.get(0));
				this.position++;
			}
			this.definePositionPerEachAthlete(athleteOrigin);
		}
	}

	/**
	 * @description With method, I will group by the position and return this value
	 */
	String similarPosition(Integer begin, Integer end) {
		String response = "";
		for (Integer i = begin; i < (begin + end); i++)
			response = response + i.toString() + " - ";
		return response.substring(0, response.length() - 3);
	}

	public Athlete registerOneAthlete(String register) {
		if (register == null || register.trim().length() < 1 || register.split(ConstantUtils.SEPARATOR_FILE).length < ConstantUtils.MAX_FIELDS_FILE) {
			throw new IllegalArgumentException("The parameters [" + register + "] were incorrect, please check them and try again");
		}
		String name = register.split(ConstantUtils.SEPARATOR_FILE)[0];
		this.positionFile = 1;
		this.totalScore = new BigDecimal("0");
		String fields = register.substring(register.indexOf(ConstantUtils.SEPARATOR_FILE) + 1);
		List<Event> event = Stream.of(fields.split(ConstantUtils.SEPARATOR_FILE)).map(myEvent -> this.createEvent(myEvent)).collect(Collectors.toList());
		return new Athlete(name, event, this.totalScore, "0");
	}

	/**
	 * @description There I will create an event and calculate the score of each athlete
	 * @param athleteScore this score of the athlete
	 * @return one object type event
	 */
	public Event createEvent(String athleteScore) {
		String nameEvent = "";
		BigDecimal score = new BigDecimal("0");
		if (this.positionFile == OrderByFile.OBF_MTS100.getPositionFile()) {
			nameEvent = OrderByFile.OBF_MTS100.getScoringTable().getName();
			score = OrderByFile.OBF_MTS100.getScoringTable().toDoCalculate(athleteScore);
		} else if (this.positionFile == OrderByFile.OBF_LONGJUMP.getPositionFile()) {
			nameEvent = OrderByFile.OBF_LONGJUMP.getScoringTable().getName();
			score = OrderByFile.OBF_LONGJUMP.getScoringTable().toDoCalculate(athleteScore);
		} else if (this.positionFile == OrderByFile.OBF_SHOTPUT.getPositionFile()) {
			nameEvent = OrderByFile.OBF_SHOTPUT.getScoringTable().getName();
			score = OrderByFile.OBF_SHOTPUT.getScoringTable().toDoCalculate(athleteScore);
		} else if (this.positionFile == OrderByFile.OBF_HIGHJUMP.getPositionFile()) {
			nameEvent = OrderByFile.OBF_HIGHJUMP.getScoringTable().getName();
			score = OrderByFile.OBF_HIGHJUMP.getScoringTable().toDoCalculate(athleteScore);
		} else if (this.positionFile == OrderByFile.OBF_MTS400.getPositionFile()) {
			nameEvent = OrderByFile.OBF_MTS100.getScoringTable().getName();
			score = OrderByFile.OBF_MTS400.getScoringTable().toDoCalculate(athleteScore);
		} else if (this.positionFile == OrderByFile.OBF_HURDLESMTS110.getPositionFile()) {
			nameEvent = OrderByFile.OBF_HURDLESMTS110.getScoringTable().getName();
			score = OrderByFile.OBF_HURDLESMTS110.getScoringTable().toDoCalculate(athleteScore);
		} else if (this.positionFile == OrderByFile.OBF_DISCUSTHROW.getPositionFile()) {
			nameEvent = OrderByFile.OBF_DISCUSTHROW.getScoringTable().getName();
			score = OrderByFile.OBF_DISCUSTHROW.getScoringTable().toDoCalculate(athleteScore);
		} else if (this.positionFile == OrderByFile.OBF_POLEVAULT.getPositionFile()) {
			nameEvent = OrderByFile.OBF_POLEVAULT.getScoringTable().getName();
			score = OrderByFile.OBF_POLEVAULT.getScoringTable().toDoCalculate(athleteScore);
		} else if (this.positionFile == OrderByFile.OBF_JAVELINTHROW.getPositionFile()) {
			nameEvent = OrderByFile.OBF_JAVELINTHROW.getScoringTable().getName();
			score = OrderByFile.OBF_JAVELINTHROW.getScoringTable().toDoCalculate(athleteScore);
		} else if (this.positionFile == OrderByFile.OBF_MTS1500.getPositionFile()) {
			nameEvent = OrderByFile.OBF_MTS1500.getScoringTable().getName();
			score = OrderByFile.OBF_MTS1500.getScoringTable().toDoCalculate(athleteScore);
		}
		this.positionFile++;
		this.totalScore = this.totalScore.add(score).setScale(2, RoundingMode.DOWN);
		return new Event(nameEvent, athleteScore, score);
	}

	/**
	 * @description I created this function because I need to validated if result is major to Zero. Check this -> (P — B)
	 * @return result of the subtract
	 */
	private BigDecimal Subtract(BigDecimal a, BigDecimal b) {
		return a.subtract(b).compareTo(BigDecimal.ZERO) >= 0 ? a.subtract(b) : BigDecimal.ZERO;
	}

	/**
	 * @description I will apply the formula INT(A(B — P)^C) for track events.
	 * @param P  is the value that Athelet has in him event
	 * @param st is the Enum that I will use.
	 * @return score final has the Athelet
	 */
	public BigDecimal trackEvents(BigDecimal P, ScoringTable st) {
		return st.getValueA().multiply(new BigDecimal(Math.pow(this.Subtract(st.getValueB(), P).doubleValue(), st.getValueC().doubleValue()))).setScale(0, BigDecimal.ROUND_DOWN);
	}

	/**
	 * @description I will apply the formula INT(A(P — B)^C) for field events.
	 * @param P  is the value that Athelet has in him event
	 * @param st is the Enum that I will use.
	 * @return score final has the Athelet
	 */
	public BigDecimal fieldEvents(BigDecimal P, ScoringTable ps) {
		return ps.getValueA().multiply(new BigDecimal(Math.pow(this.Subtract(P, ps.getValueB()).doubleValue(), ps.getValueC().doubleValue()))).setScale(0, BigDecimal.ROUND_DOWN);
	}

}
