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
		 * getPrice()
		 * Get the price of an item from the user.
		 * 
		 * getMoneyTendered()
		 * Prompt the user to enter the amount of money tendered.
		 */
		double price = getPrice(), moneyTendered = getMoneyTendered();

		/*
		 * 	Check to see whether the amount of money tendered is
		 * 	sufficient to cover the price of the item, and based on
		 * 	the result, take appropriate action.
		 */
		checkAmount(price, moneyTendered);

	}

	/*
	 * Print a header to clearly show the user which program
	 * they are using.
	 */
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
		System.out.print("Money Tendered: $");
		return scanner.nextDouble();
	}

	/*
	 * Evaluate the money tendered relative to the price of the item, and take
	 * appropriate action:
	 * -	If the customer provided too little money, present
	 * 		options to re-start the transaction or exit the program.
	 * -	If the customer provided exact change,
	 * 		notify the user and allow the program to end.
	 * -	If the customer provided more than exact change,
	 * 		output the change to be made.
	 */
	public static void checkAmount(double price, double moneyTendered) {
		if (price > moneyTendered) {
			System.err.println("Payment Insufficient");
			System.out.println();
			displayMenu();
		} else if (price == moneyTendered) {
			System.out.println("Exact Change Provided");
			System.out.println("Transaction Complete");
			System.out.println();
			displayMenu();
		} else {
			/*
			 * 	When calculating the change to be made, 
			 * 	use a combination of rounding and
			 * 	multiplication by 100.0 followed by division by 100.0
			 * 	to address precision issues.
			 */
			makeChange(Math.round(100.0 * (moneyTendered - price))/100.0);
		}
	}

	/*
	 *	Determine which denominations to give to the customer
	 *	in which quantities, and output only the necessary
	 *	denominations to the screen.
	 */
	public static void makeChange(double change) {
		/*	
		 * 	Initialize variables
		 * 
		 * 	double denominations
		 * 	Placing the values of the denominations into an array
		 * 	enables iteration.
		 * 
		 * 	int numThisDenomination
		 * 	Holds the number of the current denomination to be
		 * 	given to the customer.
		 */
		double[] denominations = {20, 10, 5, 1, .25, .10, .05, .01};
		int numThisDenomination = 0;

		System.out.println();
		System.out.println("Provide the customer with the following denominations:");
		System.out.println("------------------------------------------------------");
		for (int i = 0; i < denominations.length; i++) {
			/*	
			 * 	Rounding and multiplication/division by 100.0
			 * 	are necessary to address precision issues.
			 */
			numThisDenomination = (int) Math.round(100.0 * change / denominations[i])/100;
			if (numThisDenomination > 0) {
				/*	
				 * 	Format the output string to display each
				 * 	denomination in	a uniform manner.
				 */
				System.out.printf("%5.2f: " + numThisDenomination + "\n", denominations[i]);
				change -= Math.round(100.0 * numThisDenomination * denominations[i])/100.0;
			}
		}
		System.out.println();
		displayMenu();
	}

	/*
	 * 	Display a menu to allow the user to decide what to do next,
	 * 	either when the value entered for money tendered is insufficient or
	 * 	when a transaction has been successfully completed.
	 */
	public static void displayMenu() {
		int selection = 0;

		System.out.println("---------------------------");
		System.out.println("Please select an option from the following menu:");
		System.out.println("---------------------------");
		System.out.println("1 - New Transaction");
		System.out.println("2 - Quit");
		System.out.println("---------------------------");
		System.out.print("> ");

		selection = (int) scanner.nextInt();

		if (selection == 1) {							//	Start over
			System.out.println();
			main(null);
		} else if (selection == 2) {					//	Exit the program
			System.out.println("Exiting program...");
			System.exit(0);
		} else {										//	Handle invalid selection
			System.err.println("Invalid selection");
			displayMenu();
		}
	}
}
