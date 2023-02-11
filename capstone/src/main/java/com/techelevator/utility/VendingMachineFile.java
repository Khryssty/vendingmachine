package com.techelevator.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class VendingMachineFile {

    //This method reads the input file vendingmachine.csv and returns a List to be used in VendingMachineCLI displayProductsToPurchase method.
    public List<String> readVendingMachineFile() {
        List<String> products = new ArrayList<>();

        File readVendingMachineFile = new File("C:\\Users\\Student\\workspace\\capstone-projects\\module-1\\mod-1-capstone-java-team-0\\capstone\\vendingmachine.csv");
                //vendingmachine.csv");

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



    public void writeToLogFile(String description) {      //TODO: Add fields to pass for logging in file

        SimpleDateFormat fileFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat logDate = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a");
        Date date = new Date();

        String vendingMachineLog = "log" + fileFormat.format(date) + ".txt";

        File file = new File("C:\\Users\\Student\\workspace\\capstone-projects\\module-1\\mod-1-capstone-java-team-0\\capstone", vendingMachineLog);

//        if(file.exists()) {
//            System.out.println(file + " already exists. Appening to the file...");
//        }
            try(PrintWriter writer = new PrintWriter(new FileOutputStream(file, true))) {
                writer.println(logDate.format(date) + " " + description);    //TODO: add fields to log in file
            } catch (FileNotFoundException e) {
                System.out.println(file.getAbsoluteFile() + " does not exist.");
        }

    }


}