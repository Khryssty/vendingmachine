package com.techelevator.utility;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineFileTest {

    @Test
    void readVendingMachineFileShouldReadFromFile() {       //TODO: Needs more update
        VendingMachineFile vendingMachineFile = new VendingMachineFile();

        //File readVendingMachineFile = new File("C:\\Users\\Student\\workspace\\mod-1-capstone-java-team-0\\capstone\\vendingmachine-Copy.csv");
        List<String> products = new ArrayList<>();
        products.add("A1|Potato Crisps|3.05|Chip");
        products.add("B1|Moonpie|1.80|Candy");
        products.add("C1|Cola|1.25|Drink");

        assertEquals(products,vendingMachineFile.readVendingMachineFile());



    }

}