package com.techelevator.utility;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Product {
    private String productCode;
    private String productName;
    private BigDecimal productPrice;
    private String productCategory;
    private int productCount;

    public Product(String productCode, String productName, BigDecimal productPrice, String productCategory) {
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

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productCount == product.productCount && productCode.equals(product.productCode) && productName.equals(product.productName) && productPrice.equals(product.productPrice) && productCategory.equals(product.productCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productCode, productName, productPrice, productCategory, productCount);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productCategory='" + productCategory + '\'' +
                ", productCount=" + productCount +
                '}';
    }

    public void displayMessage() {
    }
}


