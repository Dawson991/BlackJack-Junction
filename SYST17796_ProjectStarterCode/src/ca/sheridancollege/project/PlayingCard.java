/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Dawso
 */
public class PlayingCard extends Card{
    

    
    public enum Suit
   {
       HEARTS, CLUBS, SPADES, DIAMONDS
   }
   
   public enum Rank
   {
       ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
   }
    private Rank rank;
    private Suit suit;
    
    public PlayingCard(Rank rank, Suit suit)
    {
        this.rank = rank;
        this.suit = suit;

        
        
        
    }

    public Rank getRank() {
        return rank;
        
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

 
    public Suit getSuit() {
        return suit;
    }


    public void setSuit(Suit suit) {
        this.suit = suit;
    }
    

        public int getValue() {
        switch (rank) {
            case ACE:
                return 11;
            case TWO:
                return 2;
            case THREE:
                return 3;
            case FOUR:
                return 4;
            case FIVE:
                return 5;
            case SIX:
                return 6;
            case SEVEN:
                return 7;
            case EIGHT:
                return 8;
            case NINE:
                return 9;
            default:
                return 10;
        }
    }
        
    
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
    
}