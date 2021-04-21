/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Andressa Gomes
 */
public abstract class Card {
    protected int cardNum;

    public Card() {
    }

    @Override
    public String toString() {
        return "Card{" + "cardNum=" + cardNum + '}';
    }

}
