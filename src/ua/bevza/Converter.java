package ua.bevza;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Converter {

	private static final Map<String, Integer> romanArabicNumeralsMap = new HashMap<>();
	static{
		romanArabicNumeralsMap.put("I", 1);
		romanArabicNumeralsMap.put("II", 2);
		romanArabicNumeralsMap.put("III", 3);
		romanArabicNumeralsMap.put("IV", 4);
		romanArabicNumeralsMap.put("V", 5);
		romanArabicNumeralsMap.put("VI", 6);
		romanArabicNumeralsMap.put("VII", 7);
		romanArabicNumeralsMap.put("VIII", 8);
		romanArabicNumeralsMap.put("IX", 9);
		romanArabicNumeralsMap.put("X", 10);
	}
	
	public static String convertExpressionToArabic(String expression){
		String num1 = expression.split("\\b")[0].toUpperCase();
		String num2 = expression.split("\\b")[2].toUpperCase();		
		String operator = expression.split("\\b")[1];
		
		return romanArabicNumeralsMap.get(num1) + operator + romanArabicNumeralsMap.get(num2);
	}
	
	public static String convertArabicToRoman(int intNumeral) {
		Set<Entry<String, Integer>> entrySet=romanArabicNumeralsMap.entrySet();
		for (Map.Entry<String,Integer> pair : entrySet) {
		    if (intNumeral == pair.getValue()) {
		    	return pair.getKey();
		    }
		}
		return "Invalid numeral";		
	}
}
