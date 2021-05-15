/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.CartCon;
import controller.MovieCon;
import java.util.ArrayList;

/**
 *
 * @author Andressa Gomes
 */
public class Cart {

    MovieCon mCon;
    CartCon cCon;

    private double dayCharge = 2.99;
    private double totalCharge;
    private String promoCode = "FREE123";
    public boolean boolVP;
    public ArrayList<Movie> movies;

    public Cart(MovieCon mCon) {                          // Constructor to create a cart instance from Movie Controller instance
        this.mCon = mCon;
        movies = new ArrayList<Movie>();                // Instantiate the movies array to store movies added to cart
    }

    public double calcTotal() {                                     // Method to calculate total based on initial day charge of 2.99 for each movie in cart
        totalCharge = dayCharge * movies.size();
        return totalCharge;
    }

    public double applyPromo() {                                // Method to apply promotional discount (equivalent to one initial day charge
        totalCharge -= dayCharge;
        return totalCharge;
    }

    public boolean validatePromo(String userPromo) {        // Method to validate promo entered by user matches promotional code for free movie for first user
        if (userPromo.equals(promoCode)) {
            boolVP = true;
            applyPromo();                                                       // Method above which updates total charge to reflect movie discount
        } else {
            System.out.println("Promo entered is invalid.");
        }
        return boolVP;
    }

    public void removeItem(String userRemovalChoice) {          // Method to remove item from cart
        movies.remove(userRemovalChoice);
    }

    public double getTotal() {                          // Method to get the total charge
        return totalCharge;
    }

    public void removePromo() {                     // Method to remove promo if user is not a new customer
        totalCharge += dayCharge;
    }

    public ArrayList<Movie> getMovies() {       // Method to get movies from cart
        return movies;
    }

}
