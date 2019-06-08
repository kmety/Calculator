package ua.bevza;

public class Validator {

	public static void checkExpression(String expression) throws IllegalArgumentException {
		String regex = "(([0-9]|(10))\\s?[\\+\\*/-]\\s?([0-9]|(10)))|"
				+ "(([IVX]|(II)|(III)|(IV)|(VI)|(VII)|(VIII)|(IX))\\s?[\\+\\*/-]\\s?"
				+ "([IVX]|(II)|(III)|(IV)|(VI)|(VII)|(VIII)|(IX)))";
		if(!expression.toUpperCase().matches(regex)) {
			throw new IllegalArgumentException("Invalid expression! Try one more time");
		}
	}

	public static void checkRange(int number) throws NumberFormatException {
		if(number < 0 || number > 10) {
			throw new NumberFormatException("Result must be in range from 0 to 10");
		}		
	}

	public static boolean containsRomanNumerals(String expression) {
		if(expression.toUpperCase().matches("^[IVX].+")) {
			return true;
		}
		return false;
	}

}
