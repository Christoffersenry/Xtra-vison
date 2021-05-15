/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CardCon;
import java.util.Scanner;

/**
 *
 * @author rcvb8
 */
public class CLI_card {

    Scanner sc = new Scanner(System.in);
    CardCon cardC;
    public String custCard;

    public CLI_card() {                                     // Constructor to create instance of CLI_Card class as well as new instance of a Card Controller
        this.cardC = new CardCon(this);

        getCustomerCard();

    }

    public String getCustomerCard() {                                       // Method to get customers card either from input or generator and validate it
        System.out.println("Please insert your card.");
        System.out.println("*For Test Purpose - Press ENTER for new customer to generate a new card or type in existing card.");
        boolean validCard = false;
        do {
            try {
                custCard = sc.nextLine();                                   // Capture user input
                if (cardC.isNewCustomer(custCard)) {                    // Check to see if is a new customer
                    custCard = cardC.newCustCardGen();                 // If it is, generate a new card to be used (pretend they already had this) and insert into DB for record
                    validCard = true;                                        // newly generated card is automatically valid
                } else {
                    validCard = cardC.validateCard(custCard);               // validate user's input to make sure it was a proper card number and that it matches with existing one in DB.
                }

            } catch (Exception e) {                                         // Catch any errors that might occur and print message
                System.out.println(e);
            }
        } while (!validCard);                                                // Loop to get user input until card input is valid
        System.out.println("Approved!");
        return custCard;
    }

}
