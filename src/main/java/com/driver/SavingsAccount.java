package com.driver;

public class SavingsAccount extends BankAccount {
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name, balance, 0);
        this.rate = rate;
        this.maxWithdrawalLimit = maxWithdrawalLimit;

    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal
        // limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if (amount > maxWithdrawalLimit) {
            throw new MaxWithdrawLimitException("Maximum Withdraw Limit Exceed");
        } else {
            super.withdraw(amount);
        }

    }

    public double getSimpleInterest(int years) {
        // Return the final amount considering that bank gives simple interest on
        // current amount
        double bal = super.getBalance();
        double interest = (bal * years * rate) / 100;
        return interest + bal;

    }

    public double getCompoundInterest(int times, int years) {
        // Return the final amount considering that bank gives compound interest on
        // current amount given times per year
        double bal = super.getBalance();
        double val = 1 + (rate / times);
        val = bal * (Math.pow(val, times * years));
        return val;
    }

}
