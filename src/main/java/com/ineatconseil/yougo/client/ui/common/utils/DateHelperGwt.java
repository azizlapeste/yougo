package com.ineatconseil.yougo.client.ui.common.utils;

import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;
import com.google.gwt.user.datepicker.client.DateBox.Format;

public class DateHelperGwt {

	/**
	 * Milliseconds in a day.
	 */
	private static final Long MILLISECONDS_IN_A_DAY = 86400000L;
	private static final DateTimeFormat DATE_FORMAT = DateTimeFormat.getFormat("dd-MM-yyyy");
	private static final DateTimeFormat HOUR_FORMAT = DateTimeFormat.getFormat("HH:mm");
	private static final DefaultFormat DEFAULT_FORMAT = new DefaultFormat(DATE_FORMAT);

	/**
	 * Method for checking the format of the date is dd/MM/yy or dd/MM/YYYY.
	 * @param date
	 * @return
	 */
	public static boolean isFormatDateValidSlash(final String date) {
		return date.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(([0-9]{2})|([0-9]{4}))$");
	}

	/**
	 * Method for checking the format of the date is ddMMyy or ddMMYYYY, .
	 * @param date
	 * @return boolean.
	 */
	public static boolean isFormatDateValid(final String date) {

		Boolean check = isFormatDateValidSlash(date);

		if (check) {
			return true;
		} else {

			check = isFormatDateValidWithoutSlash(date);
			if (check) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Method for checking the format of the date is ddMMyy or ddMMYYYY.
	 * @param date
	 * @return
	 */
	public static boolean isFormatDateValidWithoutSlash(final String date) {

		Boolean check = isFormatDateValidWithoutSlashShortFormat(date);

		if (check) {
			return true;
		} else {

			check = isFormatDateValidWithoutSlashLongFormat(date);
			if (check) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Method for checking the format of the date is ddMMyy.
	 * @param date
	 * @return
	 */
	public static boolean isFormatDateValidWithoutSlashShortFormat(final String date) {

		return date.matches("^(0[1-9]|[12][0-9]|3[01])(0[1-9]|1[012])([0-9]{2})$");
	}

	/**
	 * Method for checking the format of the date is ddMMyyyy.
	 * @param date
	 * @return
	 */
	public static boolean isFormatDateValidWithoutSlashLongFormat(final String date) {
		return date.matches("^(0[1-9]|[12][0-9]|3[01])(0[1-9]|1[012])([0-9]{4})$");

	}

	/**
	 * Function who return false is problem, true if date is in short format yy.
	 * @param date
	 * @return
	 */
	public static Boolean isYearShortFormat(final String date) {

		Boolean check = isYearShortFormatSlash(date);

		if (check) {
			return true;
		} else {

			check = isYearShortFormatWithoutSlash(date);
			if (check) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Function who return false is problem, true if date is in short format yy.
	 * @param date
	 * @return
	 */
	public static Boolean isYearShortFormatWithoutSlash(final String date) {
		return date.matches("^(0[1-9]|[12][0-9]|3[01])(0[1-9]|1[012])([0-9]{2})$");

	}

	/**
	 * Function who return false is problem, true if date is in short format yy.
	 * @param date
	 * @return
	 */
	public static Boolean isYearShortFormatSlash(final String date) {

		return date.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/([0-9]{2})$");
	}

	/**
	 * Function who return true if date is in short format yyyy.
	 * @param date
	 * @return
	 */
	public static Boolean isYearLongFormat(final String date) {
		Boolean check = isYearLongFormatSlash(date);

		if (check) {
			return true;
		} else {

			check = isYearLongFormatWithoutSlash(date);
			if (check) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Function who return true if date is in short format yyyy.
	 * @param date
	 * @return
	 */
	public static Boolean isYearLongFormatSlash(final String date) {

		return date.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/([0-9]{4})$");

	}

	/**
	 * Function who return true if date is in short format yyyy.
	 * @param date
	 * @return
	 */
	public static Boolean isYearLongFormatWithoutSlash(final String date) {
		return date.matches("^(0[1-9]|[12][0-9]|3[01])(0[1-9]|1[012])([0-9]{4})$");

	}

	/**
	 * Method who return true if the date is in well format see from calendar. Useful for testing the 31/02/yyyy.
	 * @param dateDebStr
	 * @param dateBegin
	 * @return
	 */
	public static Boolean checkDate(final String dateDebStr) {

		if (dateDebStr == null || dateDebStr.length() != 10) {
			return null;
		}

		DateTimeFormat dateFormat = DateTimeFormat.getFormat("dd/MM/yyyy");

		String jour = dateDebStr.substring(0, 2);
		String mois = dateDebStr.substring(3, 5);
		String annee = dateDebStr.substring(6, 10);

		Integer jourInt = Integer.valueOf(jour);
		Integer moisInt = Integer.valueOf(mois);
		moisInt--;
		Integer anneeInt = Integer.valueOf(annee);

		Date date = new Date(anneeInt.intValue() - 1900, moisInt.intValue(), jourInt.intValue());

		Date dateConv = date;
		String dateConvStr = dateFormat.format(dateConv);

		if (!dateConvStr.equals(dateDebStr)) {
			return false;
		}
		return true;
	}

	/**
	 * Method for convert date format ddmmaa in ddmmaaaa.
	 * @param date
	 * @return
	 */
	public static String convertShortDateFormatInLong(final String date) {
		Integer dateLengthStr = date.length();

		String dateTemp = date.substring(0, dateLengthStr - 2);
		String yearStr = date.substring(dateLengthStr - 2, dateLengthStr);

		Integer year = Integer.valueOf(yearStr);

		if (year.toString().length() < 3) {
			dateTemp = dateTemp + "20" + yearStr;
		}

		return dateTemp;

	}

	/**
	 * Method for convert date format ddmmaaaa in dd/mm/aaaa.
	 * @param date
	 * @return
	 */
	public static String convertDateWithoutSlashWithSlash(final String date) {
		if (date.length() != 8) {
			return null;
		}
		String jour = date.substring(0, 2);
		String mois = date.substring(2, 4);
		String annee = date.substring(4, 8);

		String result = jour + "/" + mois + "/" + annee;

		return result;
	}

	/**
	 * test if the date Begin jj/mm/aaaa is inf of dateEnd jj/mm/aaaa
	 * @param dateDeb
	 * @param dateFin
	 * @param dateFormat
	 * @return
	 */
	public static Boolean isDateDebInfDateFin(final String dateDeb, final String dateFin, final String dateFormat) {
		Date dDeb = null;
		Date dFin = null;

		DateTimeFormat dateFormatSDF = DateTimeFormat.getFormat(dateFormat);

		dDeb = dateFormatSDF.parse(dateDeb);
		dFin = dateFormatSDF.parse(dateFin);

		if (dDeb.after(dFin)) {
			return false;
		} else {
			return true;
		}
	}

	public static final Date getDateOfTomorrow() {
		Long dateOfTommorrow = new Date().getTime() + MILLISECONDS_IN_A_DAY;
		return new Date(dateOfTommorrow);
	}

	/**
	 * @return
	 */
	public static Format getDefaultFormat() {
		return DEFAULT_FORMAT;
	}

	/**
	 * @return
	 */
	public static DateTimeFormat getDateFormat() {
		return DATE_FORMAT;
	}

	/**
	 * @return
	 */
	public static DateTimeFormat getHourFormat() {
		return HOUR_FORMAT;
	}
}
