package com.xtrainning.hop.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	public static Date yyyyMMddToDate(String str){
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		try{
			Date date = f.parse(str);
			return date;
		} catch(Throwable e){
			return null;
		}
	}
	
	public static String dateToyyyyMMdd(Date date){
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		try{
			String str = f.format(date);
			return str;
		} catch(Throwable e){
			return "";
		}
	}

	public static String dateToyyyyMMddHHmiss(Timestamp endDate) {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try{
			String str = f.format(new Date(endDate.getTime()));
			return str;
		} catch(Throwable e){
			return "";
		}
	}
	
	public static String dateToyyyyMMddHHmi(Timestamp endDate) {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try{
			String str = f.format(new Date(endDate.getTime()));
			return str;
		} catch(Throwable e){
			return "";
		}
	}

	public static Timestamp yyyyMMddHHmmssToTimestamp(String startDate) {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try{
			Date d = f.parse(startDate);
			return new Timestamp(d.getTime());
		} catch(Throwable e){
			return null;
		}
	}
	
	public static Timestamp yyyyMMddHHmmToTimestamp(String startDate) {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try{
			Date d = f.parse(startDate);
			return new Timestamp(d.getTime());
		} catch(Throwable e){
			return null;
		}
	}

	public static Date getEndDate() {
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.YEAR, 2020);
		return cal.getTime();
	}
}
