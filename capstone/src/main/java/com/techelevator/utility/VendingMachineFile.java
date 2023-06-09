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
        Scanner userInput = new Scanner(System.in);


        System.out.println("*****************************************************************************\n");
        System.out.print("Please enter ONLY the filepath of vendingmachine.csv file: ");
        String filePath = userInput.nextLine();

        File readVendingMachineFile = new File(filePath + "\\vendingmachine.csv");


        if (!readVendingMachineFile.exists()) {
            System.out.println("Unable to find the file in " + filePath);
            System.exit(0);
        }


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

        File file = new File("C:\\Users\\Student\\workspace\\mod-1-capstone-java-team-0\\log", vendingMachineLog);

        if(file.exists()) {
//            if(!file.mkdirs()) {
//                //TODO: Create a code to handle
//            }
        }

        try(PrintWriter writer = new PrintWriter(new FileOutputStream(file, true))) {
            writer.println(logDate.format(date) + " " + description);    //TODO: add fields to log in file
        } catch (FileNotFoundException e) {
            System.out.println(file.getAbsoluteFile() + " does not exist.");
        }

    }


}