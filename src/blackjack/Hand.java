/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author gubotdev
 */
public class Hand {
    Card[] myCards = new Card[5];
    private int numOfCards = 0;
    private int score = 0;
    
    public Hand(){
        
    }
    
    public int getNumofCards(){
        return numOfCards; //gets the number of cards
    }
    
    public int getScore(){
        return score;
    }
    
    public void addCard(Card newCard){
        
    }
    
    public void printHand(){
        
    }
    
    
}
