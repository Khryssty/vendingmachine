package com.techelevator;

import com.techelevator.utility.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class VendingMachineCLI {

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";

    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";

    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

    private Scanner userInput;

    public VendingMachineCLI() {
        userInput = new Scanner(System.in);
    }

    AccountBalance accountBalance = new AccountBalance();   // new object for Account Balances, this will be handling the current amount, entered amount and change
    VendingMachineFile file = new VendingMachineFile();     //new object for processing files, reading and writing
    List<String> products = file.readVendingMachineFile();  // list of products after reading the vendingmachine.csv file. The products variable is used in the displayProductItems method below as input to parse thru the list of products.

    /**
     * This is the main execution loop for the VendingMachineCLI Orchestrator Class
     */
    public void run() {

        boolean runMenu = true;

        String[] currentMenu = MAIN_MENU_OPTIONS;
        String[] purchaseMenu = PURCHASE_MENU_OPTIONS;      // Added to hold the PURCHASE MENU OPTION

        while (runMenu) {

            displayMenu(currentMenu);

            System.out.print("\nPlease make a selection: ");
            String selection = userInput.nextLine();

            try {
                int selectionIndex = Integer.parseInt(selection) - 1;

                String menuOption = currentMenu[selectionIndex];

                if (menuOption.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                    // display vending machine items
                    System.out.println("**************************************************************************\n");
                    System.out.printf("\t\tVENDING MACHINE ITEMS\n");
                    displayProductItems(products);  // method to display the list of items


                } else if (menuOption.equals(MAIN_MENU_OPTION_PURCHASE)) {
                    //TODO: more logic into this
                    //String[] purchaseMenu = PURCHASE_MENU_OPTIONS;

                    while (purchaseMenu == PURCHASE_MENU_OPTIONS) {

                        System.out.printf("\t\tPURCHASE SCREEN\n");

                        displayMenu(purchaseMenu);          // displays the PURCHASE MENU OPTIONS >> Feed Money, Select Product & Finish Transaction
                        System.out.println("\n\t\t\tCurrent Money Provided: " + accountBalance.getAccountBalance());

                        System.out.print("Please enter a selection: ");
                        String purchaseMenuSelection = userInput.nextLine();

                        int purchaseIndex = Integer.parseInt(purchaseMenuSelection) - 1;
                        String purchaseOption = purchaseMenu[purchaseIndex];


                        if (purchaseOption.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {   //TODO: Code to feed money. Need additional logic to process this portion

                            System.out.print("Enter amount: ");
                            String stringEnteredAmount = userInput.nextLine();

                            BigDecimal enteredAmount = new BigDecimal(stringEnteredAmount);
                            accountBalance.addToCurrentBalance(enteredAmount);

                            System.out.print("Do you want to enter another amount? (y/n) ");
                            String anotherEntry = userInput.nextLine();

                            if (anotherEntry.equalsIgnoreCase("y")) {
                                displayMenu(new String[]{PURCHASE_MENU_OPTION_FEED_MONEY});
                            } else if (anotherEntry.equalsIgnoreCase("n")) {
                                displayMenu(purchaseMenu);
                            } else {
                                System.out.println("Invalid entry.");
                                displayMenu(currentMenu);
                            }
                            //purchaseMenu = PURCHASE_MENU_OPTIONS;
                            //TODO: Add a code here to log the current balances and feed money to log.txt
                            //TODO: currentbalance not updating


                        } else if (purchaseOption.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {  //TODO: Code to display product selection
                            displayProductsToPurchase(products);
                        } else if(purchaseOption.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION))  {
                            currentMenu = MAIN_MENU_OPTIONS;    //TODO : Correct this code, not returning to main menu.
                            //TODO: Code to finish purchase processing
                        } else {
                            System.out.println("Not a valid selection.");
                        }


                    }



                } else if (menuOption.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
                    currentMenu = MAIN_MENU_OPTIONS; //Return to Main Menu execution loop
                    //TODO: Code to finish purchase

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


    //This method populates the DISPLAY VENDING MACHINE ITEMS AND add the items to each class.
    //TODO: Needs to be adjusted so the objects created can be accessed above.

    public String[] displayProductItems(List<String> products) {
        String[] detailedProducts = {};
        String productCode = "";
        String productName = "";
        String productPrice = "";
        String productCategory = "";

        System.out.println("**************************************************************************\n");
        System.out.println("	GROUP		NAME			PRODUCT CODE	PRICE		QUANTITY	");

        for (String item : products) {
            detailedProducts = item.trim().split("\\|");
             productCode = detailedProducts[0];
             productName = detailedProducts[1];
             productPrice = detailedProducts[2];
             productCategory = detailedProducts[3];

            System.out.printf("\t%-7s\t%-20s\t%-2s\t\t\t%-4s\t\t\t5\n", productCategory, productName, productCode, productPrice);

            if (productCategory.equalsIgnoreCase("Candy")) {
                Inventory candy = new Candy(detailedProducts[0], detailedProducts[1], detailedProducts[2], detailedProducts[3]);
                List<Inventory> candyList = new ArrayList<>();
                candyList.add(candy);
            } else if (productCategory.equalsIgnoreCase("Gum")) {
                Inventory gum = new Candy(detailedProducts[0], detailedProducts[1], detailedProducts[2], detailedProducts[3]);
                List<Inventory> gumList = new ArrayList<>();
                gumList.add(gum);
            } else if (productCategory.equalsIgnoreCase("Drink")) {
                Inventory drink = new Drink(detailedProducts[0], detailedProducts[1], detailedProducts[2], detailedProducts[3]);
                List<Inventory> drinkList = new ArrayList<>();
                drinkList.add(drink);
            } else if (productCategory.equalsIgnoreCase("Chip")) {
                Inventory chips = new Chips(detailedProducts[0], detailedProducts[1], detailedProducts[2], detailedProducts[3]);
                List<Inventory> chipsList = new ArrayList<Inventory>();
                chipsList.add(chips);
            }

        }

        return detailedProducts;
    }


    //TODO: method to display in PURCHASE_MENU_OPTION_SELECT_PRODUCT screen but i think this needs to be updated or deleted if we find a way to make the objects public
    public void displayProductsToPurchase(List<String> products) {

        System.out.println("**************************************************************************\n");
        System.out.printf("\t\t\tSELECT PRODUCT TO PURCHASE\n");

        for (String item : products) {
            String[] detailedProducts = item.trim().split("\\|");
            String productCode = detailedProducts[0];
            String productName = detailedProducts[1];
            String productPrice = detailedProducts[2];
            String productCategory = detailedProducts[3];

            if (productCategory.equals("Chip")) {
                System.out.printf("%-20s\n", productName);
                System.out.printf("%-2s %-4s\n", productCode, productPrice);
            }

            }

    }



    private void displayMenu(String[] menu) {

        System.out.println("\n********************************");
        for (int i = 0; i < menu.length; i++) {
            if (!menu[i].startsWith("*")) {
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

