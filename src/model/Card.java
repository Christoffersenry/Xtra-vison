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
public abstract class Card {
    protected int cardNum;
    private String hashCardNum;

    public Card() {
    }

    @Override
    public String toString() {
        return "Card{" + "cardNum=" + cardNum + '}';
    }
    

    public int getCardNum() {
        return cardNum;
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
    
}
