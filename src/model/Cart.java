/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.MovieCon;
import java.util.ArrayList;

/**
 *
 * @author Andressa Gomes
 */
public class Cart {
    MovieCon mCon;
    
    public double dayCharge;
    public double totalCharge;
    public ArrayList<Movie> movies;
    
    public Cart(MovieCon mCon){
        this.mCon = mCon;
        movies = new ArrayList<Movie>();
    }
    
    public double calcTotal() {
        return totalCharge;
    }
    
    public void showCartItems() {
        System.out.println(movies);
    }
    
    public void removeItem() {
        
    }
    
}
