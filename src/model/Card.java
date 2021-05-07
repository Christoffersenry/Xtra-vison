/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.DBConnection;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import xtra.vision.CLI_Rylee;

/**
 *
 * @author Andressa Gomes
 */
public class Card {

//    protected long newCustCardNum;                  //Don't think we need, but just in case
    CLI_Rylee cli;
    DBConnection db;
    protected String cardNum;
    private Random rand = new Random();
    public boolean boolV = false;
    public boolean boolNC = false;
    private String hashCardNum;

    public Card(CLI_Rylee cli) {
        this.cli = cli;
        this.db = new DBConnection(this);

    }

    @Override
    public String toString() {
        return "Card{" + "cardNum=" + cardNum + '}';
    }

    public String getCardNum() {
        cardNum = cli.getCustomerCard();
        return cardNum;
    }

    public String hashCardNum(String custCard) {
        // ctr + shift + f
        try {
            String cardNum = custCard + "hashthisshit";

            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(cardNum.getBytes());
            byte[] digest = md.digest();

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, digest);

            // Convert message digest into hex value
            hashCardNum = no.toString(16);

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Card.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hashCardNum;
    }

    public boolean validateCard(String custCard) {
        if (isNum(custCard) && custCard.length() == 16 && !db.newCustCheck(hashCardNum(custCard))) {                    // Validate input matches prefixed card length and only contains numbers.               
//            System.out.println("Card validated.");   
            boolV = true;
        } else {
            System.out.println("Card entered is not valid. Please re-enter:");
        }
        return boolV;
    }

    //     VALIDATE STRING ONLY CONTAINS NUMBERS
    public boolean isNum(String num) {
        return Pattern.matches("[0-9]+", num);
    }


    public boolean isNewCustomer(String custCard) {
        if (custCard.isEmpty() || custCard.equals("")) {
            boolNC = true;
        }
        return boolNC;
    }

 

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
//        System.out.println(newCustCardNum);
        return newCustCardNum;                                                          // Returns a randomly generated 15 digit card number (2 digit from BankFormat + 13 random digits)
    }

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

   
    public class InnerEmail {

        protected String custEmail;
        protected boolean boolVE;
        protected boolean boolE;

        public InnerEmail() {

        }

        public String getCustEmail() {
            return custEmail;
        }

        public boolean validateEmail() {
            return boolVE;
        }

        public boolean isEmpty() {
            return boolE;
        }

        public void sendDigReceipt() {

        }

    }

}
