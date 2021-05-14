/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.InputMismatchException;
import model.Cart;
import view.CLI_cart;

/**
 *
 * @author rcvb8
 */
public class CartCon {
    Cart c;
    MovieCon mCon;
    CLI_cart cli;
    
    public CartCon(MovieCon mCon) {
        this.mCon = mCon;
        this.c = mCon.c;
        this.cli = new CLI_cart(this);
    }
    
    public void showCart() {
        System.out.println(c.getMovies());
        c.calcTotal();
        System.out.println("Total: € " + c.getTotal());
    }
    
    public void directCartChoice(int userCartOption) {
        if (userCartOption == 1) {
            cli.removeItemPrompt();
        } else if (userCartOption == 2) {
            System.out.println("We are working on promo option..");
        } else if (userCartOption == 3) {
            System.out.println("We are working on payment option..");
        } else {
            System.out.println("Input value is out of range.");
        }
    }
    
    public boolean validateUserRC(String userRemovalChoice) {
        boolean boolVURC = false;
        try {
            c.removeItem(userRemovalChoice);
            boolVURC = true;
        } catch (InputMismatchException ime) {
            System.out.println("Sorry this doesn't match any of the information in your cart. Please check spelling and try again.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
    }
        return boolVURC;
    }
    
    
    
    
    
}
