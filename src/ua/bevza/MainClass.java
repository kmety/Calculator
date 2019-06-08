package ua.bevza;

import java.util.Scanner;

public class MainClass {
	/*
	 * Калькулятор command line application. Користувач запускає його з консолі і
	 * вводить дані через консоль. Калькулятор вміє виконувати операції додавання,
	 * віднімання, множення та ділення з двома числами: a + b, a - b, a * b, a / b
	 * Калькулятор вміє працювати з арабськими і римськими числами. Вираз містить
	 * числа одного типу: II + 2 - не валідний вираз. Калькулятор працює з цілими
	 * числами. Калькулятор вміє працювати з арабськими числами від 0 до 10. З
	 * римськими числами від І до X. Зверни увагу на правила ООП. Обдумай структуру
	 * класів. Завдання в яких весь код в одному класі будуть оцінені низько. НЕ
	 * обов’язкові вимоги Обробка виразів з декількома операціями - НЕ обов’язкова.
	 * Обробка чисел більше 10 - НЕ обов’язкова.
	 */

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
