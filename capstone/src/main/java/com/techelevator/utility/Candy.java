package com.techelevator.utility;

import java.math.BigDecimal;

public class Candy extends Product{

    public Candy(String productCode, String productName, String  productPrice, String productCategory) {
        super(productCode, productName, productPrice, "Candy");


    }



    @Override   // Override method to display message after purchase
    public void displayMessage() {
        System.out.println("Munch Munch, Yum!");
    }
}
