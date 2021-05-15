/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Andressa Gomes
 */
public class Rental {

    protected int cardNum;
    protected int discCode;
    protected int rentalDate;
    protected int returnDate;
    protected int duration;
    protected double totalCharge;
    protected String promoCode = "FREE123";
    protected double promoDiscount = 2.99;
    protected boolean boolVDC = false;
    protected boolean boolL = false;
    protected boolean boolVP = false;

    protected String userPromo;                       //Maybe not the right place, but we will see

    ArrayList<Movie> movies;                          // I don't think this is necessary in here, but we will see

    public Rental() {

    }

    public int getDiscCode() {
        return discCode;
    }

    public int getCardNum() {
        return cardNum;
    }

    public int getRentalDate() {
        return rentalDate;
    }

    public int getReturnDate() {
        return returnDate;
    }

    public double getTotalCharge() {
        return totalCharge;
    }

    public String getUserPromo() {          // Maybe not needed here, but we will see
        return userPromo;
    }

    public boolean validateDiscCode() {
        return boolVDC;
    }

    public boolean isLate() {
        return boolL;
    }

    public boolean validatePromo() {
        return boolVP;
    }

    public void calcAddCharges() {

    }

    public void chargeMax() {

    }

    public void applyPromo() {

    }

}
