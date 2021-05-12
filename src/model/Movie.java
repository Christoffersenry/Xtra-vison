/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.MovieCon;
import database.DBConnection;
import java.util.ArrayList;
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
    
    MovieCon mCon;
    DBConnection db;
    
    public Movie(MovieCon mCon){
        this.mCon = mCon;
        this.db = new DBConnection(this);
    }

    public int getQuantities() {
        return quantities;
    }

    public boolean isAvailable(int movieNum) {
        availability = db.checkAvailability(movieNum);
        return availability;
    }
    
    public void getAvailableMovies() {
        db.getMovieSelection();
    }
    
    public void getMovieInfo(int movieNum){
        db.getMovieInfo(movieNum);
    }
    
    public void getDiscCode(int movieNum) {
        String discCode = db.getDiscCode(movieNum);
        System.out.println(discCode);
    }
    
}