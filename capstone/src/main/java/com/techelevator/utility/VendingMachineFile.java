package com.techelevator.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class VendingMachineFile {

    public VendingMachineFile() {

    }

    //This method reads the input file vendingmachine.csv and returns a List to be used in VendingMachineCLI displayProductsToPurchase method.
    public List<String> readVendingMachineFile() {
        List<String> products = new ArrayList<>();

        File readVendingMachineFile = new File("vendingmachine.csv");

        File listOfProducts = new File(String.valueOf(readVendingMachineFile));

        try (Scanner scanner = new Scanner(listOfProducts)) {
            while (scanner.hasNextLine()) {
                products.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println(listOfProducts.getAbsoluteFile() + " does not exist.");
        }
        return products;
    }



    public void writeToLogFile() {      //TODO: Add fields to pass for logging in file

        SimpleDateFormat fileFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat logFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a");
        Date date = new Date();

        String vendingMachineLog = "log" + fileFormat.format(date) + ".txt";

        File file = new File(vendingMachineLog);

        try(PrintWriter writer = new PrintWriter(file)) {
            writer.println(logFormat);    //TODO: add fields to log in file
        } catch (FileNotFoundException e) {
            System.out.println(file.getAbsoluteFile() + " does not exist.");
        }

    }

}