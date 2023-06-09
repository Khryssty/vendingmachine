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

    private Scanner userInput;
    private String filePath;

    public VendingMachineCLI() {
        userInput = new Scanner(System.in);
    }

    AccountBalance accountBalance = new AccountBalance();   // new object for Account Balances, this will be handling the current amount, entered amount and change
    VendingMachine vendingMachine = new VendingMachineScreen();


    /**
     * This is the main execution loop for the VendingMachineCLI Orchestrator Class
     */

    public static void main(String[] args) {
        VendingMachineCLI cli = new VendingMachineCLI();
        cli.run();
    }

    public void run() {

        boolean runMenu = true;

//        System.out.print("Please enter the filepath to read the file from: ");
//        String filePath = userInput.nextLine();


        vendingMachine.displayMainMenu();


        while (runMenu) {
            try {

                //System.out.println("*****************************************************************************");
                System.out.print("Please make a selection: ");
                String selection = userInput.nextLine();
                int option = Integer.parseInt(selection);
                System.out.println("*****************************************************************************");

                if (option == 1) {
                    vendingMachine.displayVendingMachineItems();
                    //vendingMachine.displayMainMenu();
                } else if (option == 2) {
                    vendingMachine.displayPurchaseMenu();
                    boolean runSubMenu = true;

                    while (runSubMenu) {
                        try {
                            System.out.print("Please make a selection: ");
                            String subSelection = userInput.nextLine();
                            int subOption = Integer.parseInt(subSelection);

                            if (subOption == 1) {       //TODO: Code for feed money logic
                                System.out.print("Please enter amount: ");
                                String enteredAmountFromScreen = userInput.nextLine();
                                BigDecimal enteredAmount = new BigDecimal(enteredAmountFromScreen);
                                vendingMachine.feedMoney(enteredAmount);

                            } else if (subOption == 2) {
                                //display items to buy
                                vendingMachine.displayProductsForPurchase();
                                System.out.println("*****************************************************************************\n");
                                System.out.print("Enter the product code you wish to purchase: ");

                                boolean runPurchase = true;
                                while (runPurchase) {
                                    try {
                                        String productEntry = userInput.nextLine();
                                        vendingMachine.selectOptionFromPurchaseMenu(productEntry);
                                        runPurchase = false;
                                    } catch (Exception e) {
                                        System.out.println("Not a valid product code. Please try again");
                                        continue;
                                    }
                                }

                            } else if (subOption == 3) {
                                vendingMachine.finishPurchaseTransaction();
                                runSubMenu = false;

                            } else {
                                System.out.println("Not a valid selection. Please try again");
                                continue;
                            }
                        } catch (Exception e) {
                            System.out.println("Not a valid selection. Please try again");
                            continue;
                        }
                    }

                } else if (option == 3) {

                    System.out.println("Thank you for visiting our Vending Machine.");
                    runMenu = false;
                } else {
                    System.out.println("Not a valid selection. Please try again");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Not a valid selection. Please try again");
                continue;
            } catch (Exception e) {
                System.out.println("Not a valid selection. Please try again");
                continue;
            }
        }


    }

}