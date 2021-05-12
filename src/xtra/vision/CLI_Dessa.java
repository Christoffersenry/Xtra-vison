/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xtra.vision;

import controller.MovieCon;
import database.DBConnection;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.Movie;

/**
 *
 * @author rcvb8
 */
public class CLI_Dessa {
    Scanner sc = new Scanner(System.in);
    MovieCon mCon;
    int question1;
     int movieNum;
     String cartAns;
     String promptConShopAns;
     
     public static void main(String[] args) {

         new CLI_Dessa();
    }
    
    public CLI_Dessa(){
        this.mCon = new MovieCon(this);
        welcomePage();
        
    }
    
    public  void welcomePage(){
        System.out.println("********************************");
        System.out.println("WELCOME TO XTRA-VISON!");
        System.out.println("Press 1 to RENT or 2 to RETURN");
        System.out.println("********************************");
        boolean boolWP = false;
        
        do {
        try {
        question1 = sc.nextInt();
        boolWP = true;
        } catch (InputMismatchException ime) {
            sc.next();
            System.out.println("Sorry, the input isn't recognised. Only numbers allowed. Please try again.");
        }
        } while (!boolWP);
        
        mCon.directWelcomePage(question1);  
          
    }
    
    public void showMovieSelection(){
        
            System.out.println("");
            System.out.println("Movie Selection:");
            System.out.println("******************************************");
            System.out.println("");
            mCon.getAvailableMovies();
            System.out.println("");
            System.out.println("To view movie info, press:");
            System.out.println("1 - What The Wealth,   2 - Cowspiracy,   3 - The Game Changers,   4 - My Octopus Teacher \n"
                    + "5 - Seaspiracy,   6 - Hush,   7 - Annabelle,   8 - Cast Away,   9 - Grown Ups,   0 - Easy A");
            System.out.println("");
            selectMovie();
    }
    
    public void selectMovie() {
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
        
        mCon.getMovieInfo(movieNum);
        System.out.println("");
    }
        
    public void promptAddToCart() {
        System.out.println("Would you like to add to cart?");
        System.out.println("Press y - YES or n - NO");
        cartAns = sc.next();
        mCon.decideCart(cartAns);
    }
      
    public void promptConShopOrCheckout() {
        System.out.println("");
        System.out.println("Would you like to continue shopping OR continue to checkout?");
        System.out.println("Press   1 - Continue Shopping   OR   2 - Checkout");
              
        promptConShopAns = sc.next();
        mCon.decideShopping(promptConShopAns);
       
    }
    
    
    public int getUserMovieNum() {
    return movieNum;
    }
    
}
