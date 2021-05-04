/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xtra.vision;

import java.util.Scanner;
import model.Card;

/**
 *
 * @author rcvb8
 */
public class CLI_Rylee {
    
    Scanner sc = new Scanner(System.in);
    Card c;
    public String custCard;
 
    public static void main(String[] args) {
       
        new CLI_Rylee();
        
        
        
    }
    
    public CLI_Rylee() {
        this.c = new Card(this);
        
        getCustomerCard();
        
    }
    
    
    public String getCustomerCard() {
        System.out.println("Please insert your card.");
        System.out.println("*For Test Purpose - Press ENTER for new customer to generate a new card or type in existing card.");
       boolean validCard = false;
        do {
            try {
            custCard = sc.nextLine();                                   // Capture user input
                if (c.isNewCustomer(custCard)) {                    // Check to see if is a new customer
                   custCard = c.newCustCardGen();                 // If it is, generate a new card to be used (pretend they already had this) and insert into DB for record
                   validCard = true;                                        // newly generated card is automatically valid
                } else {
                validCard = c.validateCard(custCard);               // validate user's input to make sure it was a proper card number and that it matches with existing one in DB.
                }
                
            } catch (Exception e) {                                         // Catch any errors that might occur and print message
                System.out.println(e);   
            }
       } while (!validCard);                                                // Loop to get user input until card input is valid
        return custCard;
    }
    
    
}
