package com.techelevator.utility;

import java.math.BigDecimal;

public class AccountBalance {
    private BigDecimal accountBalance;
    //private BigDecimal change;

    public AccountBalance() {
        this.accountBalance = new BigDecimal(0.00);
    }

//    public BigDecimal getChange() {
//        return change;
//    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void addBalance(BigDecimal amount){
        accountBalance = accountBalance.add(amount);
    }

    public void calculateChange(BigDecimal costOfItem) {
        accountBalance = accountBalance.subtract(costOfItem);
    }

    public BigDecimal getChangeMethod(BigDecimal totalCost){
        int quarterCount = 0;
        int dimeCount = 0;
        int nickleCount = 0;

        BigDecimal change = accountBalance.subtract(totalCost);
        BigDecimal remainingChange = change;


        while (remainingChange.compareTo(BigDecimal.valueOf(0.25)) >= 0) {
            remainingChange = remainingChange.subtract(BigDecimal.valueOf(0.25));
            quarterCount++;
        }

        while (remainingChange.compareTo(BigDecimal.valueOf(0.1)) >= 0) {
            remainingChange = remainingChange.subtract(BigDecimal.valueOf(0.1));
            dimeCount++;
        }

        while (remainingChange.compareTo(BigDecimal.valueOf(0.05)) >= 0) {
            remainingChange = remainingChange.subtract(BigDecimal.valueOf(0.05));
            nickleCount++;
        }

        System.out.println("dispensing number of quarters: " + quarterCount + " number of dimes: "
                + dimeCount + " number of nickles: " + nickleCount + " totaling $" + change);

        return change;
    }


}
