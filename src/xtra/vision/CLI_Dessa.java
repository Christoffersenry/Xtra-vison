/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xtra.vision;

import java.util.Scanner;
import model.Movie;

/**
 *
 * @author rcvb8
 */
public class CLI_Dessa {
    Scanner sc = new Scanner(System.in);
    Movie m;
    int question1;
     int movieNum;
     
     public static void main(String[] args) {

         new CLI_Dessa();
    }
    
    public CLI_Dessa(){
        this.m = new Movie(this);
        welcomePage();
        
    }
    
    public  void welcomePage(){
        System.out.println("********************************");
        System.out.println("WELCOME TO XTRA-VISON!");
        System.out.println("Press 1 to RENT or 2 to RETURN");
        System.out.println("********************************");
        question1 = sc.nextInt();
        if(question1 == 1){
            showMovieSelection();
        } else {
            System.out.println("Return Service coming soon...");
        }
            
    }
    
    public void showMovieSelection(){
        
            System.out.println("");
            System.out.println("Movie Selection:");
            System.out.println("******************************************");
            System.out.println("");
            m.showAvailableMovies();
            System.out.println("");
            System.out.println("To view movie info, press:");
            System.out.println("1 - What The Wealth,   2 - Cowspiracy,   3 - The Game Changers,   4 - My Octopus Teacher \n"
                    + "5 - Seaspiracy,   6 - Hush,   7 - Annabelle,   8 - Cast Away,   9 - Grown Ups,   0 - Easy A");
            System.out.println("");
            selectMovie();
    }
    
    public void selectMovie() {
        movieNum = sc.nextInt();
        System.out.println("");
        m.showMovieInfo(movieNum);
        System.out.println("Would you like to add to cart?");
        System.out.println("Press y - YES or n - NO");
        String cartAns = sc.next();
        if (cartAns.equalsIgnoreCase("y")) {
            m.addToCart(movieNum);
        } else if (cartAns.equalsIgnoreCase("n")) {
            showMovieSelection();
        }
    }
      
    
    
}
