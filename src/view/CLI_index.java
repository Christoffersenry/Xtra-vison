/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.IndexCon;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author rcvb8
 */
public class CLI_index {

    Scanner sc = new Scanner(System.in);
    public int userWelcomeOption;

    IndexCon iCon;

    public CLI_index(IndexCon iCon) {               // Constructor to create instance of CLI_Index from Index Controller instance
        this.iCon = iCon;

        welcomePage();
    }

    public void welcomePage() {                                                 // Method to display welcome page prompt to guide user to rent or return section
        System.out.println("********************************");
        System.out.println("WELCOME TO XTRA-VISON!");
        System.out.println("Press 1 to RENT or 2 to RETURN");
        System.out.println("********************************");
        boolean boolWP = false;

        do {
            try {                                                           // Try catch to verify user input is an integer and no other
                userWelcomeOption = sc.nextInt();
                boolWP = true;
            } catch (InputMismatchException ime) {
                sc.next();
                System.out.println("Sorry, the input isn't recognised. Only numbers allowed. Please try again.");
            }
        } while (!boolWP);

        iCon.directWelcomePage(userWelcomeOption);              // Pass user input into Index Controller method to direct user to next location

    }

}
