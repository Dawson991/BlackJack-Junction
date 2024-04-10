/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Dawso
 */
import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    // Add a card to the hand
    public void addCard(Card card) {
        cards.add(card);
    }

    //Used to display the hand of the card of the players hand
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cards: ");
        for (Card card : cards) {
            sb.append(card).append(", ");
        }
        if (!cards.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }

        return sb.toString();
    }

    public int calculateHandValue() {
        int value = 0;
        int numberOfAces = 0;

        for (Card card : cards) {
            if (card != null) {
                PlayingCard playingCard = (PlayingCard) card;
                value += playingCard.getValue();
                if (playingCard.getRank() == PlayingCard.Rank.ACE) {
                    numberOfAces++;
                }
            }
        }

        // Adjust for aces being worth 1 or 11
        while (numberOfAces > 0 && value > 21) {
            value -= 10;
            numberOfAces--;
        }

        return value;
    }

    public void clearHand() {
        cards.clear();
    }

    public int handSize() {
        return cards.size();
    }

    public void removeCard(PlayingCard card) {
        cards.remove(card);
    }
}
