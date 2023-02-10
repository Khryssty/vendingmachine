package com.techelevator.utility;

import java.math.BigDecimal;

public class Chips extends Product{

    public Chips(String productCode, String productName, String productPrice, String productCategory) {
        super(productCode, productName, productPrice, "Chips");
    }

    @Override   // Override method to display message after purchase
    public void displayMessage() {
        System.out.println("Crunch Crunch, Yum!");
    }

}
