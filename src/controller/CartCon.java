/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.InputMismatchException;
import model.Cart;
import model.Movie;
import view.CLI_cart;

/**
 *
 * @author rcvb8
 */
public class CartCon {

    Cart c;
    MovieCon mCon;
    CLI_cart cli;

    public CartCon(CLI_cart cli, MovieCon mCon) {           // Constructor to  create Cart Controller instance from CLI_Cart & MovieCon classes
        this.cli = cli;
        this.mCon = mCon;
        this.c = mCon.c;                                            // Set the cart controlled by this controller equal to the Movie Controller cart instance

    }

    public void addToCart(Movie m) {                // Method to add movie(s) to cart
        c.movies.add(m);
    }

    public void showCart() {                                            // Method to show what is currently in the cart
        System.out.println(c.getMovies());
        c.calcTotal();                                                          // Calculate the cart total based on total movies and print total
        System.out.println("Total: € " + c.getTotal());
    }

    public void directCartChoice(int userCartOption) {                                  // Method to determine if customer would like to edit the cart, add a promotional code or continue to payment
        if (userCartOption == 1) {
            cli.removeItemPrompt();                                                             // Prompt customer in CLI to begin item removal process
        } else if (userCartOption == 2) {
            System.out.println("We are working on promo option..");             // Where add promo method would go
        } else if (userCartOption == 3) {
            System.out.println("We are working on payment option..");           // Where payment option would go
        } else {
            System.out.println("Input value is out of range.");                         // Else statement to return user to cart option prompt if input doesn't match options
            cli.selectCartOptions();
        }
    }

    public boolean validateUserRC(String userRemovalChoice) {               // Method to validate if users input of what item they want removed actually matches an item in their cart
        boolean boolVURC = false;
        try {
            c.removeItem(userRemovalChoice);                                        // Try to remove item and catch errors if they occur
            boolVURC = true;
        } catch (InputMismatchException ime) {
            System.out.println("Sorry this doesn't match any of the information in your cart. Please check spelling and try again.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return boolVURC;
    }

    public void showMovies() {                                              // Method to show movies in cart without generating the total as well
        System.out.println(c.getMovies());
    }

}
