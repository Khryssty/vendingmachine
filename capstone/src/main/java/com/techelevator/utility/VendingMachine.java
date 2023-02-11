package com.techelevator.utility;

import java.math.BigDecimal;

public interface VendingMachine {
    //void readFile();
    void displayMainMenu();
    void selectOptionFromMainMenu(int selection);
    void displayVendingMachineItems();

    void displayPurchaseMenu();
    void selectOptionFromPurchaseMenu(String productCode);

    void exitFromMainMenu();

    void feedMoney(BigDecimal enteredAmount);
    void logEnteredMoney();
    void updateBalance();

    void displayProductsForPurchase();
    void selectProductCode();
    void purchaseProduct();
    void logPurchase();

    void finishPurchaseTransaction();
    void dispenseChange();
    void logChange();

}
