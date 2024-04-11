/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Dawso
 */
public class BlackJackDealer {

    private Hand hand;
    private Boolean hasBlackjack;

    public Hand getHand() {
            return hand;
    }

    public BlackJackDealer() {
            hand = new Hand();
    }

    // Deal a card to the dealer's hand
    public void dealCard(PlayingCard card) {
            hand.addCard(card);
    }
    
        public boolean hasBlackjack() {
        return hasBlackjack;
    }

    public void setHasBlackjack(boolean hasBlackjack) {
        this.hasBlackjack = hasBlackjack;
    }


    // Calculate and return the value of the dealer's hand
    public int calculateHandValue() {
            return hand.calculateHandValue();
    }

    // Dealer should hit if hand value is less than 17 otherwise stop.
    public boolean shouldHit() {
            return calculateHandValue() < 17;
    }

    // Reset the dealer's hand
    public void resetHand() {
            hand.clearHand();
    }
}
