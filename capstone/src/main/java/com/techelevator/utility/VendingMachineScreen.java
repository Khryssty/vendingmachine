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
    private BigDecimal change;



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

       for(Product item : productList) {
            if(account.getAccountBalance().compareTo(item.getProductPrice()) == 1) {
                if (item.getProductCode().equalsIgnoreCase(productCode)) {
                    account.calculateChange(item.getProductPrice());
                    System.out.println("Dispensing " + item.getProductName() + " costs $" + item.getProductPrice() + " and your balance is $" + account.getChange());
                    displayMessageAfterItemPurchase(item.getProductCode());
                    //BigDecimal changeToReturn = calculateChange(item.getProductPrice());
                    file.writeToLogFile(item.getProductName() + " " + item.getProductCode() + " $" + item.getProductPrice() + " $" + account.getChange());
                    //TODO: Add the logic to deduct balance
                    try {
                        wait(3000);
                    } catch (InterruptedException e) {
                        System.out.println("Unable to process..");
                    }
                    displayPurchaseMenu();
                }

//        }   else {
//                System.out.println("Account balance is not enough for purchase. Please add money.");
//            }
        }
     else {
            System.out.println("Invalid product entry. Please try again.");
            displayPurchaseMenu();
    } } }



    @Override
    public void exitFromMainMenu() {

    }

    @Override
    public void feedMoney(BigDecimal enteredAmount) {           //TODO: Logic to add money and display the balance

        account.addBalance(enteredAmount);
        file.writeToLogFile("FEED MONEY: " + " $" + enteredAmount + "  $" + account.getAccountBalance());

        displayPurchaseMenu();
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
    public BigDecimal dispenseChange(BigDecimal totalCost) {

        account.getChangeMethod(totalCost);

        return change;
    }

    @Override
    public void logChange() {

    }


    @Override
    public void displayMessageAfterItemPurchase(String productCode) {

        for (Product item : productList) {
            if (item.getProductCode().equalsIgnoreCase(productCode) && item.getProductCategory().equalsIgnoreCase("Chip")){
                System.out.println("Crunch Crunch, Yum!");
            } else if (item.getProductCode().equalsIgnoreCase(productCode) && item.getProductCategory().equalsIgnoreCase("Candy")){
                System.out.println("Munch Munch, Yum!");
            } else if (item.getProductCode().equalsIgnoreCase(productCode) && item.getProductCategory().equalsIgnoreCase("Drink")) {
                System.out.println("Glug Glug, Yum!");
            } else if (item.getProductCode().equalsIgnoreCase(productCode) && item.getProductCategory().equalsIgnoreCase("Gum")){
                System.out.println("Chew Chew, Yum!");
            }
        }
    }

    private void displayMenu(String[] menu) {

        System.out.println("*****************************************************************************\n");
        for (int i = 0; i < menu.length; i++) {
            if (!menu[i].startsWith("*")) {
                System.out.printf("%1$s) %2$s\n", i + 1, menu[i]);
            }
        }
        System.out.println("*****************************************************************************\n");
    }

    public void wait(String[] args) {
        System.out.println("Returning to previous screen...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println("The message has now disappeared.");
    }

}



