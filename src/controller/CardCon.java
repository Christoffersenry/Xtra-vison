/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import model.Card;
import xtra.vision.CLI_Rylee;

/**
 *
 * @author rcvb8
 */
public class CardCon {
    CLI_Rylee cli;
    Card c;
    
    private Random rand = new Random();
    public boolean boolV = false;
    public boolean boolNC = false;
    private String hashCardNum;
    
    public CardCon(CLI_Rylee cli) {
        this.cli = cli;
        this.c = new Card(this);
    }
    
    //  THIS CODE WAS GIVEN BY AMILCAR APONTE IN YEAR 2 - GUI PROGRAMMING HASHING CLASS 
    public String hashCardNum(String custCard) {                            // Hashes and Salts card numbers for security and privacy
        // ctr + shift + f
        try {
            String cardNum = custCard + "hashthisshit";                     // Card number is converted to include salting

            MessageDigest md = MessageDigest.getInstance("MD5");        // MD5 hashing
            md.update(cardNum.getBytes());
            byte[] digest = md.digest();
            
            BigInteger no = new BigInteger(1, digest);                              // Convert byte array into signum representation                        

            hashCardNum = no.toString(16);                                          // Convert message digest into readable hex value

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Card.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hashCardNum;
    }

    public boolean validateCard(String custCard) {                       // Validate input matches prefixed card length and only contains numbers and is already in DB. 
        if (isNum(custCard) && custCard.length() == 16 && !c.getDBNewCustCheck(hashCardNum(custCard))) {                                 
//            System.out.println("Card validated.");   
            boolV = true;
        } else {
            System.out.println("Card entered is not valid. Please re-enter:");
        }
        return boolV;
    }

    //     VALIDATE STRING ONLY CONTAINS NUMBERS
    public boolean isNum(String num) {                                  // Checks user input for card number only contains numbers
        return Pattern.matches("[0-9]+", num);
    }


    public boolean isNewCustomer(String custCard) {                 // For test purposes - if no card details are entered = new customer
        if (custCard.isEmpty() || custCard.equals("")) {
            boolNC = true;
        }
        return boolNC;
    }

 
// THIS CODE WAS ADAPTED FROM JOSEF GALEA ON GITHUB.COM -- HREF: https://gist.github.com/josefeg/5781824
// RESEARCH WAS ALSO GATHERED FROM HREF: Href = https://gizmodo.com/how-credit-card-numbers-work-1493331190#:~:text=In%20a%20typical%20sixteen%20digit,last%20digit%2C%20it%20is%20deterministic
    public String newCustCardGen() {

        String bankFormat = "70";             // Fake Bank Identification Number to begin all issued CC's
        int length = 16;                            // Pre-set length of credit cards

        int randNumLength = length - (bankFormat.length() + 1); // represents how many digits in the credit card need to be randomly generated besides the initial bankFormat & ending check digit

        
        
        StringBuilder builder = new StringBuilder(bankFormat);
        
        for (int i = 0; i < randNumLength; i++) {                                    // Loop to create a random digit between 0-9 for all needed random digits in our card number
            int digit = this.rand.nextInt(10);
            builder.append(digit);                                                           // Adds each random digit generated onto the end of the bankFormat
        }

        int checkDigit = this.getCheckDigit(builder.toString());                // Get check digit from card number so far
        builder.append(checkDigit);                                                     // Add the check digit to the end of the card number to get the full valid card number
        String newCustCardNum = builder.toString();
        newCustCardNum = hashCardNum(newCustCardNum);
        c.setNewCust(newCustCardNum);
//        System.out.println(newCustCardNum);
        return newCustCardNum;                                                          // Returns a randomly generated 15 digit card number (2 digit from BankFormat + 13 random digits)
    }

    // THIS CODE WAS ADAPTED FROM JOSEF GALEA ON GITHUB.COM -- HREF: https://gist.github.com/josefeg/5781824
    private int getCheckDigit(String number) {                                  // Method to create the check digit at the end of card number
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {                                 // Loop through given card number to perform Luhn algorithm
            int digit = Integer.parseInt(number.substring(i, (i + 1)));

            if ((i % 2 == 0)) {                                                             // Multiple the first digit and every other digit by two
                digit = digit * 2;
                if (digit > 9) {                                                                // Create a single digit number from the double digit
                    digit -= 9;                                                                 // Same as taking a double digit (between 10-19) and adding the two individual digits together like (18 -> 1+8 = 9) or (18-9 = 9).
                }
            }
            sum += digit;                                                                   // Add all individual digits (created and carried down)
        }

        int mod = sum % 10;                                                             // Get remainder
        int diff = 10 - mod;                                                                // Get the difference it would take to make this number a value of 10 or the sum a multiplier of 10
        
        return diff;                                                                            // The diff is your check digit
        }
    
}
