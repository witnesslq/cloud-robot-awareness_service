package com.efrobot.robotstore.awareness.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class StringFilter {
	
	
	public final static String StringFilter(String str) throws PatternSyntaxException {
		String regEx = "[市县区]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim();
	}
	
	
	static public void main(String[] args) {
		
		System.out.println("...."+StringFilter.StringFilter("丰台区"));
	}
	
	
	
}
