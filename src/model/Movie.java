/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.DBConnection;
import xtra.vision.CLI_Dessa;

/**
 *
 * @author Andressa Gomes
 */
public class Movie {
    protected int discCode;
    protected String title;
    protected String description;
    protected int runTime;
    protected int rating;
    protected String genre;
    protected int quantities;
    protected boolean availability;
    
    
    CLI_Dessa cli;
    DBConnection db;
    
    public Movie(CLI_Dessa cli){
        this.cli = cli;
        this.db = new DBConnection(this);
    }

    public int getQuantities() {
        return quantities;
    }

    public boolean isAvailability() {
        return availability;
    }
    
    public void showAvailableMovies() {
        db.getMovieSelection();
    }
    
    public void showMovieInfo(int movieNum){
        db.getMovieInfo(movieNum);
    }
    
    public void addToCart(int movieNum) {
        
    }
    
}