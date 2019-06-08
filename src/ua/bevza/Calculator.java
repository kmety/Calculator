package ua.bevza;

public class Calculator {

	public static int calculate(String expression) {
		int num1 = Integer.parseInt(expression.split("\\b")[0]);
		int num2 = Integer.parseInt(expression.split("\\b")[2]);
		String operator = expression.split("\\b")[1].trim();
		switch (operator) {
		case "+":
			return num1 + num2;

		case "-":
			return num1 - num2;

		case "*":
			return num1 * num2;

		case "/":
			return num1 / num2;

		default:
			throw new ArithmeticException("Unknown operator!");
		}
	}
}
