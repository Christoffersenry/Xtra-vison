/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CartCon;
import controller.MovieCon;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author rcvb8
 */
public class CLI_cart {

    Scanner sc = new Scanner(System.in);
    MovieCon mCon;
    CartCon cCon;

    public int userCartOption;
    public String userRemovalChoice;

    public CLI_cart(MovieCon mCon) {                        // Constructor to create instance of CLI_cart from Movie Controller instance
        this.mCon = mCon;
        this.cCon = new CartCon(this, mCon);                // Set up Cart Controller instance from Movie Controller instance and this CLI instance to control user input here

        viewCart();                                                     // Initialise cart for user to view
    }

    public void viewCart() {                                            // Method to show cart information
        System.out.println("\nYour Cart:");
        System.out.println("_____________________________________________");
        cCon.showCart();
        selectCartOptions();
    }

    public void selectCartOptions() {                                           // Method to display cart options which allow the user to remove items, add promotions or continue to payment CLI
        System.out.println("\nCart Options:"
                + "\nPress 1 - Remove Item   2 - Add Promo   3 - Continue to Payment");

        boolean boolSCO = false;

        do {
            try {                                                                                           // Try catch to validate user input is an integer and no other
                userCartOption = sc.nextInt();
                boolSCO = true;
            } catch (InputMismatchException ime) {
                sc.next();
                System.out.println("Sorry, the input isn't recognised. Only numbers allowed. Please try again.");
            }
        } while (!boolSCO);

        cCon.directCartChoice(userCartOption);                              // Pass user input into Cart Controller instance method to direct user to appropriate option

    }

    public void removeItemPrompt() {                                                    // Method to display prompt for removing items based on movies in cart
        System.out.println("Which item would you like to remove?\n");
        cCon.showMovies();
        System.out.println("Type in the title or disc code of the movie you want to remove:");
        do {
            userRemovalChoice = sc.next();
        } while (!cCon.validateUserRC(userRemovalChoice));                       // Pass user input into validation method in Cart Controller
        viewCart();                                                                                 // Display cart after item is removed
    }

}
