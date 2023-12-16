package com.driver;

import java.util.ArrayList;

public class CurrentAccount extends BankAccount {
    String tradeLicenseId; // consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw
        // "Insufficient Balance" exception
        super(name, balance, 5000);
        this.tradeLicenseId = tradeLicenseId;
        if (balance < 5000) {
            throw new InsufficientBalanceException("Insufficient Balance");
        }
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are
        // same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid
        // license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        String temp = "";
        boolean flag = isValid(tradeLicenseId);
        if (!flag) {
            ArrayList<String> result = new ArrayList<>();
            int[] dp = new int[tradeLicenseId.length()];
            generatePermutations(tradeLicenseId, result, dp, 0, "");
            for (String str : result) {
                if (!str.equals(tradeLicenseId)) {
                    if (isValid(str)) {
                        tradeLicenseId = str;
                        return;
                    }
                }
            }
            throw new InvalidLicenseException("Valid License can not be generated");
        }

    }

    public void generatePermutations(String s, ArrayList<String> result, int[] dp, int size, String str) {
        if (size >= s.length()) {
            result.add(str);
            return;
        }
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == 0) {
                dp[i] = 1;
                generatePermutations(s, result, dp, size + 1, str + s.charAt(i));
                dp[i] = 0;
            }
        }
    }

    public boolean isValid(String s) {
        if (s.length() == 0)

            return true;
        char prev = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (prev == curr)
                return false;
            prev = curr;
        }
        return true;
    }

}
