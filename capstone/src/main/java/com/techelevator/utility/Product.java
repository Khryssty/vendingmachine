package com.techelevator.utility;

import java.math.BigDecimal;

public class Product implements Inventory{
    //list of items will go
    //message for each item group
    private String productCode;
    private String productName;
    private BigDecimal productPrice;
    private String productCategory;
    private String productMessage;

    public Product(String productCode, String productName, BigDecimal productPrice, String productCategory, String productMessage) {
        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
        this.productMessage = productMessage;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductMessage() {
        return productMessage;
    }

    public void setProductMessage(String productMessage) {
        this.productMessage = productMessage;
    }
}
