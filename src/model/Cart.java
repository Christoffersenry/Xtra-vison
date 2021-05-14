/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.MovieCon;
import java.util.ArrayList;

/**
 *
 * @author Andressa Gomes
 */
public class Cart {
    MovieCon mCon;
    
    private double dayCharge = 2.99;
    private double totalCharge;
    private String promoCode = "FREE123";
    public boolean boolVP;
    public ArrayList<Movie> movies;
    
    public Cart(MovieCon mCon){
        this.mCon = mCon;
        movies = new ArrayList<Movie>();
    }
    
    public double calcTotal() {
        totalCharge = dayCharge * movies.size();
        return totalCharge;
    }
    
    public double applyPromo() {
        totalCharge -= dayCharge;
        return totalCharge;
    }
    
    public boolean validatePromo(String userPromo) {
        if (userPromo.equals(promoCode)) {
            boolVP = true;
            applyPromo();
        } else {
            System.out.println("Promo entered is invalid.");
        }
        return boolVP;
    }
    
    public void removeItem(String userRemovalChoice) {
        movies.remove(userRemovalChoice);
    }
    
    public double getTotal() {
        return totalCharge;
    }
    
//    public double getDiscount() {
//        double promoDiscount = 0.00;
//        return promoDiscount;
//    }
    
    public void removePromo() {
        totalCharge += dayCharge;
    }
    
    public ArrayList<Movie> getMovies() {
        return movies;
    }
    
}
