package com.skilldistillery.makechange;

import java.util.Scanner;

public class MakeChange {
	// Declare fields
	static Scanner scanner = new Scanner(System.in); // Scanner to retrieve user input
	
	
	public static void main(String[] args) {
		// Declare variables and
		// initialize with relevant method calls
		double price = getPrice(),
				moneyTendered = getMoneyTendered();
		
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
		System.out.print("Item price:     ");
		return scanner.nextDouble();
	}
	
	/* Prompt the user for the amount of money
	 * tendered by the customer.
	 * @return	a double containing the user-provided
	 * 			amount of money tendered.
	 */
	public static double getMoneyTendered() {
		System.out.print("Money Tendered: ");
		return scanner.nextDouble();
	}
	
}

