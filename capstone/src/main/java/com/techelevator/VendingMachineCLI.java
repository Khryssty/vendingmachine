package com.techelevator;

import com.techelevator.utility.Console;

import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";

	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";

	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

	private Scanner userInput;

	public VendingMachineCLI() { userInput = new Scanner(System.in);}

	/**
	 * This is the main execution loop for the VendingMachineCLI Orchestrator Class
	 */
	public void run() {

		boolean runMenu = true;
		String[] currentMenu = MAIN_MENU_OPTIONS;

		while (runMenu) {

			displayMenu(currentMenu);

			System.out.print("\nPlease make a selection: ");
			String selection = userInput.nextLine();

			try {
				int selectionIndex = Integer.parseInt(selection) - 1;

				String menuOption = currentMenu[selectionIndex];

				if (menuOption.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
					// display vending machine items
					System.out.println("Display Items Placeholder"); // TODO: REMOVE THIS TEMPORARY DISPLAY ITEMS ROUTINE PLACEHOLDER STATEMENT

				} else if (menuOption.equals(MAIN_MENU_OPTION_PURCHASE)) {
					// do purchase
					currentMenu = PURCHASE_MENU_OPTIONS; //Switch to Purchase Menu execution loop
					System.out.println("Set current menu to purchase menu"); // TODO: REMOVE THIS TEMPORARY PURCHASE MENU PLACEHOLDER STATEMENT

				} else if (menuOption.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
					currentMenu = MAIN_MENU_OPTIONS; //Return to Main Menu execution loop

				} else if (menuOption.equals(MAIN_MENU_OPTION_EXIT)) {
					runMenu = false; //Terminate While Loop
					System.out.println("Good Bye!"); // TODO: REMOVE THIS TEMPORARY EXIT ROUTINE PLACEHOLDER STATEMENT

				}

			} catch (Exception ex) {

				System.out.println(Console.ANSI_RED);

				System.out.println(Console.fillText("-", 24 + selection.length()));
				System.out.printf("'%s' Is Not a Valid Option%n", selection);
				System.out.println(Console.fillText("-", 24 + selection.length()));

				System.out.println(Console.ANSI_RESET);
			}

		}
	}

	private void displayMenu(String[] menu){

		System.out.println("\n********************************");
		for(int i = 0; i < menu.length; i++){
			if( ! menu[i].startsWith("*")) {
				System.out.printf("%1$s) %2$s\n", i + 1, menu[i]);
			}
		}
		System.out.println("********************************");
	}

	/**
	 * the public static void main is the core method of the program
	 * allowing it to be executable and calls all other methods. In VendingMachineCLI
	 * it is used to create an instance of the class so that the public void run()
	 * method can be called and CLI instance variables can be used in a natural
	 * OOP way.
	 *
	 * @param args unused
	 */
	public static void main(String[] args) {
		VendingMachineCLI cli = new VendingMachineCLI();
		cli.run();
	}
}
