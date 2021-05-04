/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xtra.vision;

import database.DBConnection;
import java.util.Scanner;

/**
 *
 * @author rcvb8
 */
public class CLI_Dessa {
    Scanner sc = new Scanner(System.in);
//    DBConnection db = new DBConnection();
    
    int question1;
     int movieNum;
    
    public CLI_Dessa(){
        welcomePage();
        movieSelection();
        
    }
    
    public  void welcomePage(){
        System.out.println("********************************");
        System.out.println("WELCOME TO XTRA-VISON!");
        System.out.println("Press 1 to RENT or 2 to RETURN");
        question1 = sc.nextInt();
        System.out.println("********************************");
    }
    
    public void movieSelection(){
        if(question1 == 1){
//            db.openConnection();
            System.out.println("");
            System.out.println("Movie Selection:");
            System.out.println("********************************");
            System.out.println("");
//            db.getMovieSelection();
            
            System.out.println("");
            System.out.println("Press 1 for What The Wealth \n"
                    + "Press 2 for Cowspiracy \n"
                    + "Press 3 for The Game Changers \n"
                    + "Press 4 for My Octopus Teacher \n"
                    + "Press 5 for Seaspiracy \n"
                    + "Press 6 for Hush \n"
                    + "Press 7 for Annabelle \n"
                    + "Press 8 for Cast Away \n"
                    + "Press 9 for Grown Ups \n"
                    + "Press 10 for Easy A");}
        System.out.println("");
        movieNum = sc.nextInt();
        System.out.println("");
    }
    
    public void showMovieInfo(){
        if(movieNum == 1){
            
        }else if (movieNum == 2){
            
        }else if (movieNum == 3){
            
        }else if (movieNum == 4){
            
        }else if (movieNum == 5){
            
        }else if (movieNum == 6){
            
        }else if (movieNum == 7){
            
        }else if (movieNum == 8){
            
        }else if (movieNum == 9){
            
        }else if (movieNum == 10){
            
        }else{
            System.out.println("Please try again");
        }
    }
}
