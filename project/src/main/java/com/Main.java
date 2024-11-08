package com;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

	private static final Logger logger = Logger.getLogger(Main.class.getName());

	public int add(int a, int b) {
		try {
			if (a < 0 || b < 0) {
				throw new IllegalArgumentException("Both numbers must be non-negative.");
			}
			if (Integer.MAX_VALUE - a < b) {
				throw new ArithmeticException("Integer overflow when trying to add " + a + " + " + b);
			}
			int result = a + b;
			logger.log(Level.INFO, "Successfully added {0} and {1} to get {2}", new Object[]{a, b, result});
			return result;
		} catch (IllegalArgumentException | ArithmeticException e) {
			logger.log(Level.SEVERE, "Exception caught during addition: " + e.getMessage());
			throw e; // Re-throwing the exception to let the caller know an error occurred
		}
	}

	public static void main(String[] args) {
		Main calculator = new Main();
		
		// Test cases
		System.out.println("Test Case 1 (5 + 5): " + calculator.add(5, 5));
		System.out.println("Test Case 2 (Integer.MAX_VALUE + 1):");
		try {
			calculator.add(Integer.MAX_VALUE, 1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Test Case 3 (-1 + 5):");
		try {
			calculator.add(-1, 5);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
