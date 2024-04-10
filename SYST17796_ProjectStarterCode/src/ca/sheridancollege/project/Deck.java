/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Collections;

/**
 *
 * @author Dawso
 */
public class Deck extends GroupOfCards {

    public Deck() {
        super(52); 
        initializeDeck(); 
    }

    private void initializeDeck() {
        
        for (PlayingCard.Suit suit : PlayingCard.Suit.values()) {
            for (PlayingCard.Rank rank : PlayingCard.Rank.values()) {
                addCard(new PlayingCard(rank, suit));
            }
        }
    }

    public void addCard(Card card) {
        if (getCards() != null) { // Check if the ArrayList is initialized
            getCards().add(card);
        }
    }

    @Override
    public void shuffle() {
        Collections.shuffle(getCards());
    }

    public PlayingCard dealCard() {
            return (PlayingCard) getCards().remove(0);
    }
}