/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.DBConnection;
import java.util.Scanner;
import model.Cart;
import model.Movie;
import view.CLI_cart;
import view.CLI_movie;

/**
 *
 * @author rcvb8
 */
public class MovieCon {

    Movie m;
    DBConnection db;
    Cart c;
    CLI_movie cli;
    Scanner sc = new Scanner(System.in);

    boolean boolWP;

    public MovieCon(CLI_movie cli) {                    // Movie Controller Constructer to create instances from CLI_movie class
        this.cli = cli;
        this.db = new DBConnection(this);               // Create a new Database Connection instance
        this.m = new Movie(this);                           // Create a new instance of the Movie class
        this.c = new Cart(this);                               // Create a new instance of the Cart class
    }

    public void getAvailableMovies() {                 // Method to get available movies from database through database method
        db.getMovieSelection();
    }

    public void getMovieInfo(int movieNum) {             // Method to get the specific movie information, given the movieNum
        if (movieNum < 1 || movieNum > 10) {            // If statement to determine if input given is within range of options
            System.out.println("Input is outside of range. Please choose a number between 1-10.");
            cli.selectMovie();                                        // If not, return to CLI to show user movies available
        } else if (db.checkAvailability(movieNum) == false) {             // Else if statement to check that the movie selected from number input, which is within the range of options, is available
            System.out.println("Sorry, this is out of stock. Please choose another:");
            cli.selectMovie();                                                          // If not, return user to CLI to show user movies available
        } else {
            db.getMovieInfo(movieNum);                                      // Else show user the movie info gathered from successful database query and
            cli.promptAddToCart();                                               // offer whether they want to add to cart or not throug CLI
        }
    }

    public void addToCart(int movieNum) {                       // Method to add movie selected to cart
        Movie m = new Movie(this);
        m.setMovieNum(movieNum);
        m.setTitle(db.getTitle(movieNum));
        m.setDiscCode(db.getDiscCode(movieNum));            // Set disc code value by requesting it from the database by querying with the movie number

        c.movies.add(m);
    }

    public void decideCart(String cartAns) {                        // Method to determine if user input would like to add to cart or not
        if (cartAns.equalsIgnoreCase("y")) {
            addToCart(cli.getUserMovieNum());
            cli.promptConShopOrCheckout();
        } else if (cartAns.equalsIgnoreCase("n")) {
            cli.showMovieSelection();
        } else {
            System.out.println("Input not recognised.");            // Return to prompt if input doesn't match options
            cli.promptAddToCart();
        }
    }

    public void decideShopping(String promptConShopAns) {              // Method to determine if user would like to continue shopping or checkout
        if (promptConShopAns.equalsIgnoreCase("1")) {
            cli.showMovieSelection();
        } else if (promptConShopAns.equalsIgnoreCase("2")) {
            new CLI_cart(this);
        } else {
            System.out.println("Sorry, the options are only 1 or 2.");          // Return to prompt if input doesn't match options
            cli.promptConShopOrCheckout();
        }
    }

    public int getMovieNum() {                             // Method to get the movie number entered by the user
        return cli.getUserMovieNum();
    }

}
