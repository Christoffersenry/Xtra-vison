/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CartCon;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author rcvb8
 */
public class CLI_cart {
    Scanner sc = new Scanner(System.in);
    CartCon cCon;
    
    public int userCartOption;
    public String userRemovalChoice;
    
    public CLI_cart(CartCon cCon) {
        this.cCon = cCon;
        
        viewCart();
    }
    
    public void viewCart() {
        System.out.println("\nYour Cart:");
        System.out.println("_____________________________________________");
        cCon.showCart();
        selectCartOptions();
    }
    
    public void selectCartOptions() {
        System.out.println("\nCart Options:"
                + "\nPress 1 - Remove Item   2 - Add Promo   3 - Continue to Payment");
        
        boolean boolSCO = false;
        
        do {
        try {
        userCartOption = sc.nextInt();
        boolSCO = true;
        } catch (InputMismatchException ime) {
            sc.next();
            System.out.println("Sorry, the input isn't recognised. Only numbers allowed. Please try again.");
        }
        } while (!boolSCO);
        
        cCon.directCartChoice(userCartOption);
        
    }
    
    public void removeItemPrompt() {
        System.out.println("Which item would you like to remove?\n");
        cCon.showCart();
        System.out.println("Type in the title or disc code of the movie you want to remove:");
        do {
        userRemovalChoice = sc.next();
        } while (!cCon.validateUserRC(userRemovalChoice));
    }
    
    
}
