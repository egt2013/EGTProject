package com.egt.core.common.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import com.egt.core.common.exception.TechnicalException;

public class DateUtil {

	/**
	 * Returns a new calendar instance with sysdate
	 * 
	 * @return
	 */
	public static Calendar getSysCalendar() {
		return Calendar.getInstance();
	}

	/**
	 * Returns a new timestamp instance with sysdate
	 * 
	 * @return
	 */
	public static Timestamp getSysTimestamp() {
		return new Timestamp(getSysCalendar().getTime().getTime());
	}

	public static Date convertTimestampByDate(Date date) {
		Date result = null;
		if (date != null) {
			result = new Timestamp(date.getTime());
		}
		return result;
	}

	public static Timestamp findCurrentTimestamp() throws Exception {
		Timestamp result = null;
		try {
			java.util.Date utilDate = new java.util.Date(
					System.currentTimeMillis());
			java.sql.Date dbDate = new java.sql.Date(utilDate.getTime());
			result = new java.sql.Timestamp(dbDate.getTime());
		} catch (Exception ex) {
			throw ex;
		}
		return result;
	}

	public static Date findMilliCurrentDate() throws Exception {
		Date result = null;
		try {
			java.util.Date utilDate = new java.util.Date(
					System.currentTimeMillis());
			result = new java.sql.Date(utilDate.getTime());
		} catch (Exception ex) {
			throw ex;
		}
		return result;
	}

	// public static Calendar getCalendar(String date, String pattern) throws
	// ParseException{
	// Calendar cal = new GregorianCalendar();
	// SimpleDateFormat format = new SimpleDateFormat(pattern, Locale.US);
	// Date dateObj = null;
	// dateObj = format.parse(date);
	// cal.setTime(dateObj);
	// return cal;
	// }

	public static java.sql.Date toDateFormat(String date, String format)
			throws TechnicalException {
		Calendar cal = null;
		java.sql.Date result = null;
		if (!StringUtil.isEmpty(date) && !StringUtil.isEmpty(format)) {
			cal = getCalendar(date, format);
			result = (java.sql.Date) cal.getTime();
		}

		return result;
	}

	/**
	 * Date Arithmetic function. Adds the specified (signed) amount of day to
	 * the given day calendar, based on the calendar's rules. For example, to
	 * subtract 5 days from the specified calendar, you can achieve it by
	 * calling:
	 * <p>
	 * addDay(Calendar calendar, -5).
	 * 
	 * @param calendar
	 *            a Calendar
	 * @param amount
	 *            the amount of date to be added to the calendar.
	 */
	public static void addDay(Calendar calendar, int amount) {
		calendar.add(Calendar.DAY_OF_MONTH, amount);
	}

	/**
	 * Date Arithmetic function. Adds the specified (signed) amount of hour to
	 * the given hour calendar, based on the calendar's rules. For example, to
	 * subtract 5 hours from the specified calendar, you can achieve it by
	 * calling:
	 * <p>
	 * addHour(Calendar calendar, -5).
	 * 
	 * @param calendar
	 *            a Calendar
	 * @param amount
	 *            the amount of hour to be added to the calendar.
	 */
	public static void addHour(Calendar calendar, int amount) {
		calendar.add(Calendar.HOUR_OF_DAY, amount);
	}

	/**
	 * Date Arithmetic function. Adds the specified (signed) amount of minute to
	 * the given minute calendar, based on the calendar's rules. For example, to
	 * subtract 5 minute from the specified calendar, you can achieve it by
	 * calling:
	 * <p>
	 * addMinute(Calendar calendar, -5).
	 * 
	 * @param calendar
	 *            a Calendar
	 * @param amount
	 *            the amount of minute to be added to the calendar.
	 */
	public static void addMinute(Calendar calendar, int amount) {
		calendar.add(Calendar.MINUTE, amount);
	}

	/**
	 * Return a string representation of this calendar. This method is intended
	 * to be used only for debugging purposes, and the format of the returned
	 * string may vary between implementations. The returned string may be null.
	 * 
	 * @param calendar
	 *            a Calendar.
	 * @param pattern
	 *            a specified by date and time pattern strings.
	 * @return the day of the week represented by this date.
	 * @see Date Date and Time Patterns(java.text.SimpleDateFormat)
	 */
	public static String convertDateTime2String(Calendar calendar,
			String pattern) {
		String data = null;

		if (calendar != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.US);
			data = sdf.format(calendar.getTime());
		}

		return data;
	}

	public static String convertCurrentDate2String(String pattern) {
		return convertDateTime2String(DateUtil.getSysCalendar(), pattern);
	}

	/**
	 * Return a string representation of this date. This method is intended to
	 * be used only for debugging purposes, and the format of the returned
	 * string may vary between implementations. The returned string may be null.
	 * 
	 * @param date
	 *            a Date.
	 * @param pattern
	 *            a specified by date and time pattern strings.
	 * @return the day of the week represented by this date.
	 * @see Date Date and Time Patterns(java.text.SimpleDateFormat)
	 */
	public static String convertDateTime2String(Date date, String pattern) {
		String data = null;

		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.US);
			data = sdf.format(date);
		}

		return data;
	}

	/**
	 * Compares the specified calendar to the specified calendar.
	 * 
	 * @param calendar1
	 *            a Calendar.
	 * @param calendar2
	 *            a Calendar.
	 * @return true if the calendar are equal; false otherwise.
	 */
	public static boolean equal(Calendar calendar1, Calendar calendar2) {
		Calendar c1 = getCalendar(calendar1.get(Calendar.DAY_OF_MONTH),
				calendar1.get(Calendar.MONTH), calendar1.get(Calendar.YEAR),
				calendar1.get(Calendar.HOUR), calendar1.get(Calendar.MINUTE),
				calendar1.get(Calendar.SECOND));
		Calendar c2 = getCalendar(calendar2.get(Calendar.DAY_OF_MONTH),
				calendar2.get(Calendar.MONTH), calendar2.get(Calendar.YEAR),
				calendar2.get(Calendar.HOUR), calendar2.get(Calendar.MINUTE),
				calendar2.get(Calendar.SECOND));

		return c1.equals(c2);
	}

	/**
	 * Gets a calendar using the given date set in the default time zone with
	 * the default locale.
	 * 
	 * @param day
	 *            the value used to set the DATE time field in the calendar.
	 * @param month
	 *            the value used to set the MONTH time field in the calendar.
	 *            Month value is 0-based. e.g., 0 for January.
	 * @param year
	 *            the value used to set the YEAR time field in the calendar.
	 * @return a specified Calendar.
	 */
	public static Calendar getCalendar(int day, int month, int year) {
		return getCalendar(day, month, year, 0, 0, 0);
	}

	/**
	 * Gets a calendar using the given date set in the default time zone with
	 * the default locale.
	 * 
	 * @param day
	 *            the value used to set the DATE time field in the calendar.
	 * @param month
	 *            the value used to set the MONTH time field in the calendar.
	 *            Month value is 0-based. e.g., 0 for January.
	 * @param year
	 *            the value used to set the YEAR time field in the calendar.
	 * @param hour
	 *            the value used to set the HOUR_OF_DAY time field in the
	 *            calendar.
	 * @param minute
	 *            the value used to set the MINUTE time field in the calendar.
	 * @return a specified Calendar.
	 */
	public static Calendar getCalendar(int day, int month, int year, int hour,
			int minute) {
		return getCalendar(day, month, year, hour, minute, 0);
	}

	/**
	 * Gets a calendar using the given date set in the default time zone with
	 * the default locale.
	 * 
	 * @param day
	 *            the value used to set the DATE time field in the calendar.
	 * @param month
	 *            the value used to set the MONTH time field in the calendar.
	 *            Month value is 0-based. e.g., 0 for January.
	 * @param year
	 *            the value used to set the YEAR time field in the calendar.
	 * @param hour
	 *            the value used to set the HOUR_OF_DAY time field in the
	 *            calendar.
	 * @param minute
	 *            the value used to set the MINUTE time field in the calendar.
	 * @param second
	 *            the value used to set the SECOND time field in the calendar.
	 * @return a specified Calendar.
	 */
	public static Calendar getCalendar(int day, int month, int year, int hour,
			int minute, int second) {
		Calendar cal = null;

		if (day >= 0 && month >= 0 && year >= 0 && hour >= 0 && minute >= 0) {
			cal = new GregorianCalendar(Locale.US);
			cal.set(Calendar.DAY_OF_MONTH, day);
			cal.set(Calendar.MONTH, month);
			cal.set(Calendar.YEAR, year);
			cal.set(Calendar.HOUR_OF_DAY, hour);
			cal.set(Calendar.MINUTE, minute);
			cal.set(Calendar.SECOND, second);
			cal.set(Calendar.MILLISECOND, 0);
		}

		return cal;
	}

	/**
	 * Gets a calendar using the given time set in the default time zone with
	 * the default locale.
	 * 
	 * @param time
	 *            the value used to set the DATE time field in the calendar.
	 * @return a specified Calendar.
	 */
	public static Calendar getCalendar(long time) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(new Date(time));

		return cal;
	}

	/**
	 * Gets a calendar using the given date set in the default pattern and date
	 * format symbols for the default locale.<b>Note:</b> This method may not
	 * support all locales.
	 * 
	 * @param date
	 *            the value used to set the DATE time field in the calendar.
	 * @return a specified Calendar.
	 * @throws ParseException
	 */
	public static Calendar getCalendar(String date) throws ParseException {
		Calendar cal = new GregorianCalendar();
		SimpleDateFormat format = new SimpleDateFormat();
		Date dateObj = null;
		dateObj = format.parse(date);
		cal.setTime(dateObj);
		return cal;
	}

	/**
	 * Gets a calendar using the given date and pattern set in the date format
	 * symbols for the default locale.<b>Note:</b> This method may not support
	 * all locales.
	 * 
	 * @param date
	 *            the value used to set the DATE time field in the calendar.
	 * @param pattern
	 *            the pattern describing the date and time format.
	 * @return a specified Calendar.
	 * @throws ParseException
	 * @see Date Date and Time Patterns(java.text.SimpleDateFormat)
	 */
	public static Calendar getCalendar(String date, String pattern) throws TechnicalException {
		Calendar cal = new GregorianCalendar();
		try{
			SimpleDateFormat format = new SimpleDateFormat(pattern, Locale.US);
			Date dateObj = null;
			dateObj = format.parse(date);
			cal.setTime(dateObj);
		}catch(ParseException e){
			throw new TechnicalException(e);
		}
		return cal;

	}

	/**
	 * Gets a calendar using the given date, pattern and local set in the date
	 * format symbols.
	 * 
	 * @param date
	 *            the value used to set the DATE time field in the calendar.
	 * @param pattern
	 *            the pattern describing the date and time format.
	 * @param local
	 *            the locale whose date format symbols should be used.
	 * @return a specified Calendar.
	 * @throws ParseException
	 * @see Date Date and Time Patterns(java.text.SimpleDateFormat),
	 *      Local(java.util.Locale)
	 */
	public static Calendar getCalendar(String date, String pattern, Locale local)
			throws ParseException {
		Calendar cal = new GregorianCalendar();
		SimpleDateFormat format = new SimpleDateFormat(pattern, local);
		Date dateObj = null;
		dateObj = format.parse(date);
		cal.setTime(dateObj);
		return cal;
	}

	/**
	 * Gets a calendar using the current time in the default time zone with the
	 * default locale.
	 * 
	 * @return a Calendar.
	 */
	public static Calendar getCurrentDateTime() {
		Calendar cal = new GregorianCalendar();
		return cal;
	}

	/**
	 * Gets a calendar using the current time in the default time zone with the
	 * default locale.
	 * 
	 * @param pattern
	 *            the pattern describing the date and time format.
	 * 
	 * @return a String of represent date by pattern.
	 */
	public static String getCurrentDate(String pattern) {
		return (String) (new SimpleDateFormat(pattern, Locale.US))
				.format(new java.util.Date());
	}

	/**
	 * Gets indicating the current day of the month.
	 * 
	 * @return a current day of the month.
	 */
	public static int getCurrentDay() {
		return getCurrentDateTime().get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * Gets indicating the current day of the week.This field takes values
	 * SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, and SATURDAY.
	 * 
	 * @return a current day of the week.
	 */
	public static int getCurrentDayOfWeek() {
		return getCurrentDateTime().get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * Gets indicating the current hour of the morning or afternoon. HOUR is
	 * used for the 12-hour clock. E.g., at 10:04:15.250 PM the HOUR is 10.
	 * 
	 * @return a current hour.
	 */
	public static int getCurrentHour() {
		return getCurrentDateTime().get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * Gets indicating the current minute within the hour. E.g., at 10:04:15.250
	 * PM the MINUTE is 4.
	 * 
	 * @return a current minute.
	 */
	public static int getCurrentMinute() {
		return getCurrentDateTime().get(Calendar.MINUTE);
	}

	/**
	 * Gets indicating the current second within the minute. E.g., at
	 * 10:04:15.250 PM the SECOND is 15.
	 * 
	 * @return a current second.
	 */
	public static int getCurrentSecond() {
		return getCurrentDateTime().get(Calendar.SECOND);
	}

	/**
	 * Gets indicating the current month.The first month of the year is JANUARY
	 * which is 0; the last depends on the number of months in a year.
	 * 
	 * @return a current month.
	 */
	public static int getCurrentMonth() {
		return getCurrentDateTime().get(Calendar.MONTH);
	}

	/**
	 * Return the number of milliseconds since January 1, 1970, 00:00:00 GMT
	 * represented by this Date object.
	 * 
	 * @return the number of milliseconds since January 1, 1970, 00:00:00 GMT
	 *         represented by this date.
	 */
	public synchronized static long getCurrentTimeinLong() {
		Calendar cal = new GregorianCalendar();
		return cal.getTime().getTime();
	}

	/**
	 * Return the number of milliseconds since January 1, 1970, 00:00:00 GMT
	 * represented by this Date object.
	 * 
	 * @return the number of milliseconds since January 1, 1970, 00:00:00 GMT
	 *         represented by this date.
	 */
	public synchronized static long getCurrentTimeinLong(Calendar cal) {
		return cal.getTime().getTime();
	}

	/**
	 * Gets indicating the year.
	 * 
	 * @return a current year.
	 */
	public static int getCurrentYear() {
		return getCurrentDateTime().get(Calendar.YEAR);
	}

	/**
	 * Gets indicating the specified day of the calendar.
	 * 
	 * @return a specified day of the month.
	 */
	public static int getDay(Calendar calendar) {
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * Gets indicating the specified day of the calendar.This field takes values
	 * SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, and SATURDAY.
	 * 
	 * @return a specified day of the calendar.
	 */
	public static int getDayOfWeek(Calendar calendar) {
		return calendar.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * Gets indicating the specified hour of the morning or afternoon. HOUR is
	 * used for the 12-hour clock. E.g., at 10:04:15.250 PM the HOUR is 10.
	 * 
	 * @return a specified hour.
	 */
	public static int getHour(Calendar calendar) {
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * Gets indicating the specified minute within the hour. E.g., at
	 * 10:04:15.250 PM the MINUTE is 4.
	 * 
	 * @return a specified minute.
	 */
	public static int getMinute(Calendar calendar) {
		return calendar.get(Calendar.MINUTE);
	}

	/**
	 * Gets indicating the specified minute within the hour. E.g., at
	 * 10:04:15.250 PM the MINUTE is 4.
	 * 
	 * @return a specified minute.
	 */
	public static int getSecond(Calendar calendar) {
		return calendar.get(Calendar.SECOND);
	}

	public static int getMilliSecond(Calendar calendar) {
		return calendar.get(Calendar.MILLISECOND);
	}

	/**
	 * Gets indicating the specified month.The first month of the year is
	 * JANUARY which is 0; the last depends on the number of months in a year.
	 * 
	 * @return a specified month.
	 */
	public static int getMonth(Calendar calendar) {
		return calendar.get(Calendar.MONTH);
	}

	/**
	 * Gets indicating the specified year.
	 * 
	 * @return a specified year.
	 */
	public static int getYear(Calendar calendar) {
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * Find the day that difference between 2 calendar.The result is a integer
	 * of day that difference.
	 * 
	 * @param fist
	 *            a calendar.
	 * @param last
	 *            a calendar.
	 * @return a integer of day that difference.
	 */
	public static int minus(Calendar first, Calendar last) {
		Calendar fCal = DateUtil.getCalendar(DateUtil.getDay(first),
				DateUtil.getMonth(first), DateUtil.getYear(first));
		Calendar lCal = DateUtil.getCalendar(DateUtil.getDay(last),
				DateUtil.getMonth(last), DateUtil.getYear(last));

		long lastLong = lCal.getTime().getTime();
		long firstLong = fCal.getTime().getTime();
		System.out.println("lastLong=" + lastLong);
		System.out.println("firstLong=" + firstLong);

		long diff = lastLong - firstLong;
		System.out.println("diff=" + diff);

		return (new Long(diff / (24 * 60 * 60 * 1000))).intValue();
	}

	/**
	 * Sets the calendar with the given day.
	 * 
	 * @param calendar
	 *            a calendar.
	 * @param day
	 *            the day to be set for the given calendar.
	 */
	public static void setDay(Calendar calendar, int day) {
		calendar.set(Calendar.DAY_OF_MONTH, day);
	}

	/**
	 * Sets the calendar with the given hour.
	 * 
	 * @param calendar
	 *            a calendar.
	 * @param hour
	 *            the hour to be set for the given calendar.
	 */
	public static void setHour(Calendar calendar, int hour) {
		calendar.set(Calendar.HOUR_OF_DAY, hour);
	}

	/**
	 * Sets the calendar with the given minute.
	 * 
	 * @param calendar
	 *            a calendar.
	 * @param minute
	 *            the minute to be set for the given calendar.
	 */
	public static void setMinute(Calendar calendar, int minute) {
		calendar.set(Calendar.MINUTE, minute);
	}

	/**
	 * Sets the calendar with the given month.
	 * 
	 * @param calendar
	 *            a calendar.
	 * @param month
	 *            the month to be set for the given calendar.
	 */
	public static void setMonth(Calendar calendar, int month) {
		calendar.set(Calendar.MONTH, month);
	}

	/**
	 * Sets the calendar with the given second.
	 * 
	 * @param calendar
	 *            a calendar.
	 * @param second
	 *            the second to be set for the given calendar.
	 */
	public static void setSecond(Calendar calendar, int second) {
		calendar.set(Calendar.SECOND, second);
	}

	public static void setMilliSecond(Calendar calendar, int millisecond) {
		calendar.set(Calendar.MILLISECOND, millisecond);
	}

	/**
	 * Sets the calendar with the given year.
	 * 
	 * @param calendar
	 *            a calendar.
	 * @param year
	 *            the year to be set for the given calendar.
	 */
	public static void setYear(Calendar calendar, int year) {
		calendar.set(Calendar.YEAR, year);
	}

	public static long subtractDate(Date firstDate, Date lastDate) {
		long i = 0;
		if (firstDate == null || lastDate == null) {
			i = 0;
		} else {
			i = (lastDate.getTime() - firstDate.getTime()) / 1000;
		}
		return i;
	}

	public static String getTime(Calendar calendar) {
		int hour = getHour(calendar);
		int minute = getMinute(calendar);
		int second = getSecond(calendar);
		int millisecond = getMilliSecond(calendar);
		String time = "" + hour + ":" + minute + ":" + second + ":"
				+ millisecond;
		return time;
	}

	public static void main(String[] args) {

		System.out.println(DateUtil.convertDateTime2String(
				DateUtil.getSysCalendar(), "yyyyMMddHHmmss"));
	}
}
