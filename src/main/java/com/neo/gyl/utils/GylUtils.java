package com.neo.gyl.utils;

import java.util.Calendar;

public class GylUtils {
	
	public static String getDDH(String type){
		return type+getCurrentDateString();
	}
	
	public static String getCurrentDateString(){
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		String monthString = (month < 10 ? "0"+month : "" + month);
		String dayString = (day < 10 ? "0"+day : "" + day);
		return year + monthString + dayString;
	}
	
	public static void main(String[] args) {
		System.out.println(getCurrentDateString());
		//System.out.println(getDDH(GylContstantKey.XSYDD_DDH));
	}
}
