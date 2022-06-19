package com.skilldistillery.makechange;

import java.util.Scanner;

public class MakeChange {
	// Declare fields
	static Scanner scanner = new Scanner(System.in); // Scanner to retrieve user input

	public static void main(String[] args) {
		/*
		 * Print the header before anything else to clearly show the user which program
		 * they are using.
		 */
		printHeader();

		/*
		 * Initialize variables using the relevant methods:
		 * 
		 * getPrice() Get the price of an item from the user.
		 * 
		 * getMoneyTendered() Prompt the user to enter the amount of money tendered.
		 */
		double price = getPrice(), moneyTendered = getMoneyTendered();

		checkAmount(price, moneyTendered);

	}

	public static void printHeader() {
		System.out.println("*************************");
		System.out.println("*     Cash Register     *");
		System.out.println("*************************");
		System.out.println();
	}

	/*
	 * Prompt the user for the price of an item.
	 * 
	 * @return a double containing the user-provided price of the item.
	 */
	public static double getPrice() {
		System.out.print("Item price:     $");
		return scanner.nextDouble();
	}

	/*
	 * Prompt the user for the amount of money tendered by the customer.
	 * 
	 * @return moneyTendered a double containing the user-provided amount of money
	 * tendered.
	 */
	public static double getMoneyTendered() {
		/*
		 * Initialize local variable to store the amount of money tendered. This will be
		 * the return variable
		 */
		System.out.print("Money Tendered: $");
		return scanner.nextDouble();
	}

	/*
	 * Evaluate the money tendered relative to the price of the item, and take
	 * appropriate action: - If the customer provided too little money, present
	 * options to re-start the transaction or exit the program. - If the customer
	 * provided exact change, notify the user and allow the program to end. - If the
	 * customer provided more than exact change, output the change to be made.
	 */
	public static void checkAmount(double price, double moneyTendered) {
		if (price > moneyTendered) {
			System.err.println("Payment Insufficient");
			displayMenu();
		} else if (price == moneyTendered) {
			System.out.println("Exact Change Provided");
			System.out.println("Transaction Complete");
		} else {
			makeChange(Math.round(100 * (moneyTendered - price))/100.0);
		}
	}

	public static void makeChange(double change) {
		double[] denominations = {20, 10, 5, 1, .25, .10, .05, .01};
		int numThisDenomination = 0;

		System.out.println();
		System.out.println("Provide the customer with the following denominations:");
		System.out.println("------------------------------------------------------");
		for (int i = 0; i < denominations.length; i++) {
			numThisDenomination = (int) Math.ceil(100.0 * change / denominations[i])/100;
			System.out.printf("%5.2f: " + numThisDenomination + "\n", denominations[i]);
			change -= Math.ceil(100.0 * numThisDenomination * denominations[i])/100.0;
		}
	}

	public static void displayMenu() {
		int selection = 0;

		System.out.println("---------------------------");
		System.out.println("Please select an option from the following menu:");
		System.out.println("---------------------------");
		System.out.println("1 - Re-start Transaction");
		System.out.println("2 - Quit");
		System.out.println("---------------------------");
		System.out.print("> ");

		selection = scanner.nextInt();

		if (selection == 1) {
			System.out.println();
			main(null);
		} else if (selection == 2) {
			System.out.println("Exiting program...");
			System.exit(0);
		} else {
			System.err.println("Invalid selection");
			displayMenu();
		}
	}
}
