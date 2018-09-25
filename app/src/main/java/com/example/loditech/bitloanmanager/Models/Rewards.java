package com.example.loditech.bitloanmanager.Models;

public class Rewards {
    public int ID;
    public int AccountID;
    public double Points;
    public static Rewards rewards;

    public Rewards(int ID, int accountID, double points) {
        this.ID = ID;
        AccountID = accountID;
        Points = points;
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

    public double getPoints() {
        return Points;
    }

    public void setPoints(double points) {
        Points = points;
    }

}
