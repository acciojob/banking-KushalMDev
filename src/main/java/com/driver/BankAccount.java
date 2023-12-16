package com.driver;

import java.util.ArrayList;

import javax.naming.InsufficientResourcesException;

public class BankAccount {

    private String name;
    private double balance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    private double minBalance;
    String AccountNumber = "";

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception {
        // Each digit of an account number can lie between 0 and 9 (both inclusive)
        // Generate account number having given number of 'digits' such that the sum of
        // digits is equal to 'sum'
        // If it is not possible, throw "Account Number can not be generated" exception
        if (digits == 0) {
            throw new AccountNumberException("Account Number can not be generated");
        }
        if (digits > 0 && 9 * digits < sum) {
            throw new AccountNumberException("Account Number can not be generated");
        } else {
            findNDigitNums(digits,sum);
            if(result.size()>0){
                AccountNumber=result.get(0);
            }
            return AccountNumber;
        }
        // return null;
    }
    ArrayList<String> result=new ArrayList<>();

    public void findNDigitNumsUtil(int n, int sum, char out[],
    int index)
{
// Base case
if (index > n || sum < 0)
return;

// If number becomes N-digit
if (index == n)
{
// if sum of its digits is equal to given sum,
// print it
if(sum == 0)
{
out[index] = '\0'   ;
String temp="";
for(char c:out){
temp+=c;
}
result.add(temp);
}
return;
}

// Traverse through every digit. Note that
// here we're considering leading 0's as digits
for (int i = 0; i <= 9; i++)
{
// append current digit to number
out[index] = (char)(i + '0');

// recurse for next digit with reduced sum
findNDigitNumsUtil(n, sum - i, out, index + 1);
}
}
public void findNDigitNums(int n, int sum)
{
    // output array to store N-digit numbers
    char[] out = new char[n + 1];

    // fill 1st position by every digit from 1 to 9 and
    // calls findNDigitNumsUtil() for remaining positions
    for (int i = 1; i <= 9; i++)
    {
        out[0] = (char)(i + '0');
        findNDigitNumsUtil(n, sum - i, out, 1);
    }
}
 

    // public void helper(int digits, int sum, String result, int curSum, int cnt) {
    // if (cnt == digits) {
    // if (curSum == sum) {
    // AccountNumber = result;
    // }
    // return;
    // }
    // if (curSum == sum) {
    // if (cnt == digits) {
    // AccountNumber = result;
    // }
    // return;
    // }
    // if (cnt > digits || curSum > sum) {
    // return;
    // }
    // for (int i = 0; i <= 9; i++) {
    // int remaining = digits - cnt - 1;

    // int product = remaining * 9;
    // int remainder = sum - curSum - product;
    // if (i < remainder) {
    // continue;
    // }
    // helper(digits, sum, result + i, curSum + i, cnt + 1);
    // }
    // }

    public void deposit(double amount) {
        // add amount to balance
        if (amount > 0)
            balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount
        // would be less than minimum balance
        double remaining_balance = balance - amount;
        if (remaining_balance < 0 || remaining_balance < minBalance) {
            throw new InsufficientBalanceException("Insufficient Balance");
        } else {
            balance -= amount;
        }
    }

}