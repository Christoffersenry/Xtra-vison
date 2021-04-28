/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.DBConnection;

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
    
    DBConnection db = new DBConnection();
    
    public Movie(){
        
    }

    public Movie(int discCode, String title, String description, int runTime, int rating, String genre) {
        this.discCode = discCode;
        this.title = title;
        this.description = description;
        this.runTime = runTime;
        this.rating = rating;
        this.genre = genre;
    }    
    
    public int getDiscCode() {
        return discCode;
    }
    
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getRunTime() {
        return runTime;
    }

    public int getRating() {
        return rating;
    }

    public String getGenre() {
        return genre;
    }

    public int getQuantities() {
        return quantities;
    }

    public boolean isAvailability() {
        return availability;
    }
    
    public void showAvailableMovies() {
        
    }
    
    public void showMovieDetails() {
        
    }
    
    public void addToCart() {
        
    }
    
}