package com.techelevator.utility;

import java.math.BigDecimal;

public class Gum extends Product{

    public Gum(String productCode, String productName, String  productPrice, String productCategory) {
        super(productCode, productName, productPrice, "Gum");
    }

    @Override   // Override method to display message after purchase
    public void displayMessage() {
        System.out.println("\"Chew Chew, Yum!");
    }

}
