package com.example.loditech.bitloanmanager.Models;

public class Wallet {
    public int ID;
    public int AccountID;
    public double Amount;
    public static Wallet wallet;

    public Wallet(int ID, int accountID, double amount) {
        this.ID = ID;
        AccountID = accountID;
        Amount = amount;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int accountID) {
        AccountID = accountID;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }


}
