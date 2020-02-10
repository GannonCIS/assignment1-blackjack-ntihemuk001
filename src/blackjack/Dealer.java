/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Scanner;

/**
 *
 * @author gubotdev
 */
public class Dealer {
  private Player[] myPlayers;
  private Deck myDeck = new Deck();
  private Hand dealerHand = new Hand();
  private Scanner scan = new Scanner(System.in);
  
  public Dealer(int numOfPlayers){
      
      initMyPlayers(numOfPlayers);
      
  }
  
  public void playGame(){
      dealOutOpeningHand();
      takePlayerTurns();
      playOutDealerHand();
      declareWinners();
  
  }
  
  public void dealOutOpeningHand(){
      for(int i = 0; i < 2; i++){
          for(Player currPlayer : myPlayers){
              currPlayer.getMyHand().addCard(myDeck.dealCard());
          }
          dealerHand.addCard(myDeck.dealCard());
      }
  }
  
  public void takePlayerTurns(){
      for(Player currPlayer : myPlayers){
          while(currPlayer.getMyHand().getNumofCards() < 5 &&
                  currPlayer.getMyHand().getScore() < 21){
              System.out.println(currPlayer.getName() + "'s Hand");
              currPlayer.getMyHand().printHand();
              System.out.println("Do you want a hit? (y/n)");
              char opt = scan.next().charAt(0);
              if(opt=='y'){
                  currPlayer.getMyHand().addCard(myDeck.dealCard());
              }else{
                  break;
              }
          }
          currPlayer.getMyHand().printHand();
      }
  }
  
  public void playOutDealerHand(){
      while(dealerHand.getScore() < 16){
          dealerHand.addCard(myDeck.dealCard());
      }
      dealerHand.printHand();
      
      
  }
  
  public void declareWinners(){
      System.out.println("Dealer's Hand: ");
      dealerHand.printHand();
      for(int i = 0; i < myPlayers.length; i++){
          Player currPlayer = myPlayers[i];
          System.out.println(currPlayer.getName() + "'s hand: ");
          currPlayer.getMyHand().printHand();
          
          if(dealerHand.getScore() > 21 || currPlayer.getMyHand().getScore() > 21){
            
              if(currPlayer.getMyHand().getScore() > 21){
                  System.out.println(currPlayer.getName() + " you busted man!!"
                          + "you just lost!...what a loser!! "); 
              }else{
                  System.out.println(currPlayer.getName() + " The dealer busted"
                          + " you win!! Congrats!!"); //First condition is done
              }
          }else if(dealerHand.getScore() == 21 ||
                  dealerHand.getNumofCards() > 4){
              System.out.println(currPlayer.getName() + 
                      " The dealer is hot tonight! You LOSE!!"); //Second diamond condition 
              
          }else if(currPlayer.getMyHand().getNumofCards() > 4){
              System.out.println(currPlayer.getName() + "Five Cards under.."
                      + "must be luck lol.. YOU WIN!!"); //Third diamond condition
              
          }else if(currPlayer.getMyHand().getScore() > dealerHand.getScore()){ //fourth diamond condition
              System.out.println(currPlayer.getName() + "you win this time..."
                      + "but there will be another... GOOD JOB");
          }else{
              System.out.println(currPlayer.getName() + " quit while you got "
                      + "enough for a cab ride home LOSER!!");
          }
      }
      
  }
  
  
  
  
    private void initMyPlayers(int num) {
       myPlayers = new Player[num];
      for(int i = 0; i < myPlayers.length; i++){
          System.out.println("Player " + (i+1) + " what's your name: ");
          String name = scan.next();
          if(name.equals("")){
              myPlayers[i] = new Player(i+1);
          }else{
              myPlayers[i] = new Player(name);
          }
      }  
    }
    
    
}
