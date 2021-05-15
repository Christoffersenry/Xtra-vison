/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Scanner;
import view.CLI_index;
import view.CLI_movie;

/**
 *
 * @author rcvb8
 */
public class IndexCon {

    CLI_index cli;
    Scanner sc = new Scanner(System.in);

    boolean boolWP;

    public IndexCon() {                             // Constructor to create Index Controller instance as well as CLI_Index instance
        this.cli = new CLI_index(this);
    }

    public void directWelcomePage(int welcomeChoice) {              // Method to direct user to appropriate page based on user input
        do {
            if (welcomeChoice == 1) {                                           // Take user to CLI_Movie view if rental option is chosen
                new CLI_movie();
                boolWP = true;
            } else if (welcomeChoice == 2) {                                        // Take user to Return Service if return option is chosen
                System.out.println("Return Service coming soon...");
                boolWP = true;
            } else {                                                                            // Else input given by user exceeds options available and user is reprompted
                System.out.println("Number entered exceeds options. Press   1 - Rent   2 - Return");
                boolWP = false;
                welcomeChoice = sc.nextInt();
            }
        } while (!boolWP);
    }

}
