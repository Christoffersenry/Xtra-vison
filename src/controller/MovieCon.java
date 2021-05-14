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
    
    public MovieCon(CLI_movie cli) {
        this.cli = cli;
        this.db = new DBConnection(this);
        this.m = new Movie(this);
        this.c = new Cart(this);
               
    }
    
    
    public void directWelcomePage(int welcomeChoice) {
        do {
        if (welcomeChoice == 1) {
            cli.showMovieSelection();
            boolWP = true;
        } else if (welcomeChoice == 2) {
            System.out.println("Return Service coming soon...");
            boolWP = true;
        } else {
            System.out.println("Number entered exceeds options. Press   1 - Rent   2 - Return");
            boolWP = false;
            welcomeChoice = sc.nextInt();
        }
        }while (!boolWP);
    }
    
     public void getAvailableMovies() {
        db.getMovieSelection();
    }
    
    public void getMovieInfo(int movieNum){
        if (movieNum < 1 || movieNum > 10) {
            System.out.println("Input is outside of range. Please choose a number between 1-10.");
            cli.selectMovie();
        }
        else if (db.checkAvailability(movieNum) == false) {
            System.out.println("Sorry, this is out of stock. Please choose another:");
            cli.selectMovie();
        } else {
            db.getMovieInfo(movieNum);
            cli.promptAddToCart();
        }
    }
    
    public void addToCart(int movieNum) {
        Movie m = new Movie(this);
        m.setMovieNum(movieNum);
        m.setTitle(db.getTitle(movieNum));
        m.setDiscCode(db.getDiscCode(movieNum));
        
        c.movies.add(m);
    }
    
    public void decideCart(String cartAns) {
        if (cartAns.equalsIgnoreCase("y")) {
            addToCart(cli.getUserMovieNum()); 
            cli.promptConShopOrCheckout();
        } else if (cartAns.equalsIgnoreCase("n")) {
            cli.showMovieSelection();
        } else {
            System.out.println("Input not recognised.");
            cli.promptAddToCart();
        }
    }
        
     public void decideShopping(String promptConShopAns) {
         if(promptConShopAns.equalsIgnoreCase( "1")) {
            cli.showMovieSelection();
        } else if (promptConShopAns.equalsIgnoreCase("2")) {
        new CartCon(this);
        } else {
            System.out.println("Sorry, the options are only 1 or 2.");
            cli.promptConShopOrCheckout();
        }
     }
     
     public int getMovieNum() {
         return cli.getUserMovieNum();          
     }
    
    
}
