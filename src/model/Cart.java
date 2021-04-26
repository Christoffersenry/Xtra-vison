/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Andressa Gomes
 */
public class Cart {
    
    protected double dayCharge;
    protected double totalCharge;
    protected ArrayList<Movie> movies;
    
    public Cart(){
        
    }
    
    public double calcTotal() {
        return totalCharge;
    }
    
    public void showCartItems() {
        
    }
    
    public void removeItem() {
        
    }
    
}
