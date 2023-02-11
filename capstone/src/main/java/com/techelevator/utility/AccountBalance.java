package com.techelevator.utility;

import java.math.BigDecimal;

public class AccountBalance {
    private BigDecimal accountBalance;
    private BigDecimal change;

    public AccountBalance() {
        this.accountBalance = new BigDecimal(0.00);
    }

    public BigDecimal getChange() {
        return change;
    }

    public void setChange(BigDecimal change) {
        this.change = change;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void addBalance(BigDecimal amount){
        accountBalance = accountBalance.add(amount);
    }


}
