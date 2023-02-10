package com.techelevator.utility;

import java.math.BigDecimal;
import java.util.Objects;

public class Product implements Inventory{
    //list of items will go
    //message for each item group
    private String productCode;
    private String productName;
    private String productPrice;
    private String productCategory;
    private int productCount;
//    private String productMessage;    //Christy: removed the variable and created a displayMessage method below.


    public Product(String productCode, String productName, String productPrice, String productCategory) {
        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
        this.productCount = 5;
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

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }


    public void displayMessage(){       //To display message after purchase

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productCode.equals(product.productCode) && productName.equals(product.productName) && productPrice.equals(product.productPrice) && productCategory.equals(product.productCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productCode, productName, productPrice, productCategory);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productCategory='" + productCategory + '\'' +
                '}';
    }


}
