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
    public String discCode;
    public int movieNum;
    public String title;
    
//    protected String description;             // DON'T THINK THEY ARE NEEDED FOR MOVIE OBJECT
//    protected int runTime;
//    protected int rating;
//    protected String genre;
//    protected int quantities;
    protected boolean availability;    
    
    MovieCon mCon;
    DBConnection db;
    
    public Movie(MovieCon mCon){
        this.mCon = mCon;
        this.db = new DBConnection(this);
        
    }

//    public int getQuantities() {
//        return quantities;
//    }

    @Override
    public String toString() {
        return "Title: " + title +
                "\nDisc Code: " +discCode;
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
    
    public String getDiscCode(int movieNum) {
        db.getDiscCode(movieNum);
        return discCode;
    }

    

    
    
    
    
}