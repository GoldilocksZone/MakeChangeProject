package com.skilldistillery.makechange;

import java.util.Scanner;

public class MakeChange {
	// Declare fields
	static Scanner scanner = new Scanner(System.in); // Scanner to retrieve user input
	
	
	public static void main(String[] args) {
		/*	Print the header before anything else
		 *	to clearly show the user
		 *	which program they are using.
		 */
		printHeader();
		
		/*	Step 1.	getPrice()
		 * 			Get the price of an item from the user.
		 * 
		 *	Step 2.	getMoneyTendered()
		 * 			Prompt the user to enter the amount of
		 * 			money tendered.
		 * 
		 *	Step 3.	checkAmount()
		 * 			Evaluate the money tendered relative to the
		 * 			price of the item, and present a message
		 * 			if the customer provided too little money or
		 * 			exact change.
		 * 			-	If the customer provided too little money,
		 * 				present options to re-enter money tendered
		 * 				or cancel the transaction.
		 * 			-	If the customer provided more than exact
		 * 				change, output the change to be made.
		 */
		checkAmount(getPrice(), getMoneyTendered());
		
	}

	public static void printHeader() {
		System.out.println("*************************");
		System.out.println("*     Cash Register     *");
		System.out.println("*************************");
		System.out.println();
	}
	
	/* Prompt the user for the price of an item.
	 * @return	a double containing the user-provided
	 * 			price of the item.
	 */
	public static double getPrice() {
		System.out.print("Item price:     $");
		return scanner.nextDouble();
	}
	
	/* Prompt the user for the amount of money
	 * tendered by the customer.
	 * @return	moneyTendered
	 * 			a double containing the user-provided
	 * 			amount of money tendered.
	 */
	public static double getMoneyTendered() {
		/* Initialize local variable to store the
		 * amount of money tendered.
		 * This will be the return variable
		 */
		double moneyTendered = 0.0;
		
		System.out.print("Money Tendered: $");
		return scanner.nextDouble();
	}
	
	/* Check to see whether the money tendered
	 * was sufficient to pay for the priced item.
	 * Send one message if it is insufficient and
	 * another if it exact change.
	 */
	public static void checkAmount(double price, double moneyTendered) {
		if (price > moneyTendered) {
			System.out.println("Payment Insufficient");
			
		} else if (price == moneyTendered){
			System.out.println("Exact Change Provided");
		} else {
			displayChange();
		}
	}
	
	public static void displayChange() {
		
	}
	
}

