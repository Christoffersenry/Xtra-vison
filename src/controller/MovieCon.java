/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Scanner;
import model.Cart;
import model.Movie;
import xtra.vision.CLI_Dessa;

/**
 *
 * @author rcvb8
 */
public class MovieCon {
    
    Movie m;
    Cart c;
    CLI_Dessa cli;
    Scanner sc = new Scanner(System.in);
    
    boolean boolWP;
    
    public MovieCon(CLI_Dessa cli) {
        this.cli = cli;
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
        m.getAvailableMovies();
    }
    
    public void getMovieInfo(int movieNum){
        if (movieNum < 1 || movieNum > 10) {
            System.out.println("Input is outside of range. Please choose a number between 1-10.");
            cli.selectMovie();
        }
        else if (m.isAvailable(movieNum) == false) {
            System.out.println("Sorry, this is out of stock. Please choose another:");
            cli.selectMovie();
        } else {
            m.getMovieInfo(movieNum);
            cli.promptAddToCart();
        }
    }
    
    public void addToCart(int movieNum) {
        m.getMovieNum();
        m.getDiscCode(movieNum);
        c.movies.add(m);
        c.showCartItems();
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
        c.showCartItems();
        } else {
            System.out.println("Sorry, the options are only 1 or 2.");
            cli.promptConShopOrCheckout();
        }
     }
     
     public int getMovieNum() {
         return cli.getUserMovieNum();          
     }
    
    
}
