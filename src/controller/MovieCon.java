/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Movie;
import xtra.vision.CLI_Dessa;

/**
 *
 * @author rcvb8
 */
public class MovieCon {
    
    Movie m;
    CLI_Dessa cli;
    
    public MovieCon(CLI_Dessa cli) {
        this.cli = cli;
        this.m = new Movie(this);
               
    }
    
     public void getAvailableMovies() {
        m.getAvailableMovies();
    }
    
    public void getMovieInfo(int movieNum){
        if (m.isAvailable(movieNum) == false) {
            System.out.println("Sorry, this is out of stock. Please choose another:");
            cli.selectMovie();
        } else {
            m.getMovieInfo(movieNum);           
        }
    }
    
    public void addToCart(int movieNum) {
        m.addToCart(movieNum);
    }
    
}
