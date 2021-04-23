/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Andressa Gomes
 */
public class Movies {
    protected String title;
    protected String description;
    protected int runTime;
    protected int rating;
    protected String genre;
    protected int quantities;
    protected boolean availability;
    
    public Movies(){
        
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
    
    
    
}