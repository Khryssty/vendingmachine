package com.techelevator.utility;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VendingMachineScreen<products> implements VendingMachine{

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";

    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";

    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

    String[] currentMenu = MAIN_MENU_OPTIONS;
    String[] purchaseMenu = PURCHASE_MENU_OPTIONS;

    AccountBalance account = new AccountBalance();
    VendingMachineFile file = new VendingMachineFile();
    private List<String> productsFromFile;
    private List<Product> productList = new ArrayList<>();
    private String[] detailedProducts = {};
    private String productCode;
    private String productName;
    private BigDecimal productPrice;
    private String productCategory;



    @Override
    public void displayMainMenu() {

        //loads values from the vendingmachine.csv file and assign it to productList


        VendingMachineFile file = new VendingMachineFile();
        productsFromFile = file.readVendingMachineFile();

        for (String item : productsFromFile) {
            detailedProducts = item.trim().split("\\|");
            productCode = detailedProducts[0];
            productName = detailedProducts[1];
            productPrice = new BigDecimal(detailedProducts[2]);
            productCategory = detailedProducts[3];

            Product product = new Product(productCode, productName, productPrice, productCategory);
            productList.add(product);
        }

            displayMenu(currentMenu);
    }

    @Override
    public void selectOptionFromMainMenu(int selection) {       // TODO: should this be deleted

}

    @Override
    public void displayVendingMachineItems() {

        System.out.println("*****************************************************************************\n");
        System.out.println("");
        System.out.print("\tGROUP\t\tNAME\t\t\t\tPRODUCT CODE\t\tPRICE\t\tQUANTITY\n");

         for(Product i : productList) {
            System.out.printf("\t%-7s\t\t" , i.getProductCategory());
            System.out.printf("%-20s\t", i.getProductName());
            System.out.printf("%-10s\t\t", i.getProductCode());
            System.out.printf("%-4s\t\t\t", i.getProductPrice());
            System.out.printf(i.getProductCount() + "\n");
         }

    }

    @Override
    public void displayPurchaseMenu() {

        System.out.println("Current money: " + account.getAccountBalance());
        displayMenu(purchaseMenu);

        }




    @Override
    public void selectOptionFromPurchaseMenu(String productCode) {
//        System.out.print("Please enter product code you wish to buy: ");
//        String productCode = userin

    }

    @Override
    public void exitFromMainMenu() {

    }

    @Override
    public void feedMoney(BigDecimal enteredAmount) {           //TODO: Logic to add money and display the balance
        //BigDecimal currentBalance = account.getAccountBalance();
        account.addBalance(enteredAmount);
        file.writeToLogFile("FEED MONEY" + enteredAmount + account.getAccountBalance());
        //"FEED MONEY " + enteredAmount + account.getAccountBalance()

        displayPurchaseMenu();



    }

    @Override
    public void logEnteredMoney() {


    }

    @Override
    public void updateBalance() {

    }

    @Override
    public void displayProductsForPurchase() {

        System.out.println("*****************************************************************************\n");
        System.out.println("\t\t\t\t\t\t\tPURCHASE ITEMS");
        System.out.println("*****************************************************************************\n");
        System.out.println("\t\tNAME\t\t\t\t\tCODE\tPRICE");

        for(Product i : productList) {
            System.out.printf("\t\t%-18s\t\t%-8s%-4s\n", i.getProductName(),i.getProductCode(), i.getProductPrice());
        }

    }

    @Override
    public void selectProductCode() {

    }

    @Override
    public void purchaseProduct() {

    }

    @Override
    public void logPurchase() {

    }

    @Override
    public void finishPurchaseTransaction() {

    }

    @Override
    public void dispenseChange() {

    }

    @Override
    public void logChange() {

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

}



