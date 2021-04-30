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
            custCard = sc.nextLine();
                if (c.isNewCustomer(custCard)) {
                   custCard = c.newCustCardGen();
                   validCard = c.validateCard(custCard);
                } else {
                validCard = c.validateCard(custCard);
                }
                
            } catch (Exception e) {
                System.out.println(e);   
            }
       } while (!validCard);
        return custCard;
    }
    
    
}
