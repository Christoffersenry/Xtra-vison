/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.MovieCon;

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

    public Movie(MovieCon mCon) {
        this.mCon = mCon;
    }

    @Override
    public String toString() {                                      // Method to print out movies in cart
        return "Title: " + title + "\n"
                + "Disc Code: " + discCode + "\n";
    }

    public void setMovieNum(int movieNum) {         // Method to set the movie number of movie object before adding to cart
        this.movieNum = movieNum;
    }

    public void setDiscCode(String discCode) {          // Method to set the disc code of movie object before adding to cart
        this.discCode = discCode;
    }

    public void setTitle(String title) {                        // Method to set the title of movie object before adding to cart
        this.title = title;
    }

}
