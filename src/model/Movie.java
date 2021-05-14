/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.MovieCon;
import database.DBConnection;
import java.util.ArrayList;
import view.CLI_movie;

/**
 *
 * @author Andressa Gomes
 */
public class Movie {
    private String discCode;
    private int movieNum;
    private String title;
    
//    protected int quantities;
//    protected boolean availability;    
    
    MovieCon mCon;
    
    public Movie(MovieCon mCon){
        this.mCon = mCon;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\n"
                + "Disc Code: " +discCode + "\n";
    }

    public void setMovieNum(int movieNum) {
        this.movieNum = movieNum;
    }

    public void setDiscCode(String discCode) {
        this.discCode = discCode;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
    
    
    
    
    

    
    
    
    
}