package com.techelevator.utility;

import java.math.BigDecimal;

public class Drink extends Product{
    public Drink(String productCode, String productName, String productPrice, String productCategory) {
        super(productCode, productName, productPrice, "Drink");
    }

    @Override       // Override method to display message after purchase
    public void displayMessage() {
        System.out.println("Glug Glug, Yum!");
    }
}
