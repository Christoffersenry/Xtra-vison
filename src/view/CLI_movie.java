/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MovieCon;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author rcvb8
 */
public class CLI_movie {

    Scanner sc = new Scanner(System.in);
    MovieCon mCon;
    int question1;
    int movieNum;
    String cartAns;
    String promptConShopAns;

    public CLI_movie() {                                     // Constructor for CLI_movie instance as well as instantion of Movie Controller
        this.mCon = new MovieCon(this);

        showMovieSelection();
    }

    public void showMovieSelection() {                   // Method to display movies available to the user and prompt user to select one to view more info

        System.out.println("\nMovie Selection:");
        System.out.println("******************************************\n");
        mCon.getAvailableMovies();
        System.out.println("");
        System.out.println("To view movie info, press:");
        System.out.println("1 - What The Wealth,   2 - Cowspiracy,   3 - The Game Changers,   4 - My Octopus Teacher \n"
                + "5 - Seaspiracy,   6 - Hush,   7 - Annabelle,   8 - Cast Away,   9 - Grown Ups,   10 - Easy A\n");
        selectMovie();
    }

    public void selectMovie() {                     // Method to gather user's movie selection and verify user's input is an integer
        boolean boolSM = false;

        do {
            try {
                movieNum = sc.nextInt();
                boolSM = true;
            } catch (InputMismatchException ime) {
                sc.next();
                System.out.println("Sorry, the input isn't recognised. Only numbers allowed. Please try again.");
            }
        } while (!boolSM);

        mCon.getMovieInfo(movieNum);                // Pass the user's movie number into Movie Controller's method to get the movie's information
        System.out.println("");
    }

    public void promptAddToCart() {                                     // Method to prompt the user to add item to cart or continue shopping
        System.out.println("Would you like to add to cart?");
        System.out.println("Press y - YES or n - NO");
        cartAns = sc.next();
        mCon.decideCart(cartAns);                                       // Pass user's choise into Movie Controller's method to decide next direction
    }

    public void promptConShopOrCheckout() {                     // Method to prompt cusotmer to choose to continue shopping or proceed to checkout
        System.out.println("\nWould you like to continue shopping OR continue to checkout?");
        System.out.println("Press   1 - Continue Shopping   OR   2 - Checkout");

        promptConShopAns = sc.next();
        mCon.decideShopping(promptConShopAns);              // Pass the user's choice into Movie Controller to decide next action

    }

    public int getUserMovieNum() {
        return movieNum;
    }

}
