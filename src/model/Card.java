/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.CardCon;
import database.DBConnection;

/**
 *
 * @author Andressa Gomes
 */
public class Card { 
    
    public CardCon cardC;
    private DBConnection db;
    protected String cardNum;
    public boolean boolDBNCC;
    
    

    public Card(CardCon cardC) {                                // Constructor to create instance of the card class from the CLI
        this.cardC = cardC;                                                     
        this.db = new DBConnection(this);                 // a new connection to the database is created from this constructor

    }
    
    public boolean getDBNewCustCheck(String custCardNum) {      // get the result from database checking for if card entered by customer is new or not
        db.newCustCheck(custCardNum);
        return boolDBNCC;
    }

    public void setNewCust(String newCustCardNum) {                 // transfer (generated) customer card into database
        db.insertNewCustCard(newCustCardNum);
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
