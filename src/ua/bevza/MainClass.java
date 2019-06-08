package ua.bevza;

import java.util.Scanner;

public class MainClass {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Enter expression:");
			String expression = scanner.nextLine();
			
			if("EXIT".equals(expression.toUpperCase())) {
				scanner.close();
				System.exit(1);
			}
			
			boolean containsRomanNumerals = false;
			int result = 0;
			
			try {
				Validator.checkExpression(expression);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				continue;
			}
			if (Validator.containsRomanNumerals(expression)) {
				containsRomanNumerals = true;
				expression = Converter.convertExpressionToArabic(expression);
			}
			try {
				result = Calculator.calculate(expression);
			} catch (ArithmeticException e) {
				System.out.println(e.getMessage());
				continue;
			}
			try {
				Validator.checkRange(result);
			} catch (NumberFormatException e) {
				System.out.println(e.getMessage());
				continue;
			}
			if (containsRomanNumerals) {
				System.out.println(Converter.convertArabicToRoman(result));
			} else {
				System.out.println(result);
			}
		}
	}
}
