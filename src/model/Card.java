/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andressa Gomes
 */
public class Card {
    protected int cardNum;
    protected int cardPin;
    public boolean boolV = false;
    public boolean boolNC = false;
    public boolean boolVP = false;
    private String hashCardNum;
    private String hashCardPin;

    public Card() {
    }

    @Override
    public String toString() {
        return "Card{" + "cardNum=" + cardNum + '}';
    }
    

    public int getCardNum() {
        return cardNum;
    }
    
    public int getCardPin() {
        return cardPin;
    }
    
    public String hashCardNum() {
        
        try{
        String cardNum = getCardNum() + "hashthisshit";
        
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
    
    public boolean validateCard() {
        return boolV;
    }
    
    public boolean isNewCustomer() {
        return boolNC;
    }
    
    public boolean validatePIn() {
        return boolVP;
    }
    
    public String hashPin() {
        
        try{
        String cardPin = getCardNum() + "hashthisshit";
        
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(cardPin.getBytes());
        byte[] digest = md.digest();
        
        // Convert byte array into signum representation
        BigInteger no = new BigInteger(1, digest);
        
        // Convert message digest into hex value
        hashCardPin = no.toString(16);
        
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Card.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return hashCardPin;        
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
