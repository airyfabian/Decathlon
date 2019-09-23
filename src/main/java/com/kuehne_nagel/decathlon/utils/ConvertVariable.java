package com.kuehne_nagel.decathlon.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Airy Fabian Rosales
 * @Description with class help to change/convert the variable to project.
 */
public class ConvertVariable {

	private static final int SECONDS_IN_MINUTE = 60;
	private static final int MIILISECONDS_IN_SECOND = 100;

	public static BigDecimal getMeters(String value) {
		return new BigDecimal(value);
	}

	/**
	 * @description On this method, we can to change the parameter value to
	 *              centimeters
	 * @param String value it's the value that you wish change
	 * @return BigDecimal with final value after convert.
	 */
	public static BigDecimal getCentimeters(String value) {
		return new BigDecimal(value).multiply(new BigDecimal("100")).setScale(6, RoundingMode.DOWN);
	}

	/**
	 * @description On this method, we can to change the parameter value to Second
	 * @param String vlaud it's the value that you wish change return BigDecimal
	 *               with final value after convert
	 */
	public static BigDecimal getMinuteToSecond(String value) {

		BigDecimal response = null;

		DateFormat formatter = new SimpleDateFormat("mm.ss.SS");
		try {
			Date dt = formatter.parse(value);
			Calendar cal = Calendar.getInstance();
			cal.setTime(dt);
			response = getSeconds(cal);
		} catch (ParseException e) {
			response = BigDecimal.ZERO;
		}
		return response;
	}
	
	public static BigDecimal getSecond(String value) {

		BigDecimal response = null;

		DateFormat formatter = new SimpleDateFormat("ss.SS");
		try {
			Date dt = formatter.parse(value);
			Calendar cal = Calendar.getInstance();
			cal.setTime(dt);
			response = getSeconds(cal);
		} catch (ParseException e) {
			response = BigDecimal.ZERO;
		}
		return response;
	}

	public static BigDecimal getSeconds(Calendar cal) {
		return BigDecimal.valueOf(cal.get(Calendar.MINUTE) * SECONDS_IN_MINUTE + cal.get(Calendar.SECOND)
				+ ((float) cal.get(Calendar.MILLISECOND)) / MIILISECONDS_IN_SECOND);
	}

}
