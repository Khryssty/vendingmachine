package com.techelevator.utility;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineScreenTest {

    @Test
    void displayMainMenuShouldReturnParsedProductItems() {
        VendingMachine vendingMachine = new VendingMachineScreen<>();

        //Input
        List<String> productsFromFile = new ArrayList<>();
            productsFromFile.add("A1|Potato Crisps|3.05|Chip");
            productsFromFile.add("B1|Moonpie|1.80|Candy");
        //Expected
        List<Product> products = new ArrayList<>();
            products.add(new Product("A1", "Potato Crisps", new BigDecimal("3.05"), "Chip"));
            products.add(new Product("B1", "Moonpie", new BigDecimal("1.80"), "Candy"));

        List<Product> productList = new ArrayList<>();
        for (String item : productsFromFile) {
            String[] detailedProducts = item.trim().split("\\|");
            String productCode = detailedProducts[0];
            String productName = detailedProducts[1];
            BigDecimal productPrice = new BigDecimal(detailedProducts[2]);
            String productCategory = detailedProducts[3];

            Product product = new Product(productCode, productName, productPrice, productCategory);
            productList.add(product);
        }

        //Assert
        Assert.assertEquals(products.size(), productsFromFile.size());
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            Product actualProduct = productList.get(i);
            assertEquals(product.getProductCode(), actualProduct.getProductCode());
            assertEquals(product.getProductPrice(),actualProduct.getProductPrice());
            assertEquals(product.getProductCategory(),actualProduct.getProductCategory());
            assertEquals(product.getProductName(),actualProduct.getProductName());
        }

    }






}