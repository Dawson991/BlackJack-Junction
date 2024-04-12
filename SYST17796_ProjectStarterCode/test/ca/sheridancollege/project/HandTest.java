/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ca.sheridancollege.project;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Dawso
 */
public class HandTest {
    
    public HandTest() {
    }
    

    @Test
    public void testCalculateHandValue_Boundary() {
        Hand hand = new Hand();

        hand.addCard(new PlayingCard(PlayingCard.Rank.ACE, PlayingCard.Suit.HEARTS));
        hand.addCard(new PlayingCard(PlayingCard.Rank.ACE, PlayingCard.Suit.SPADES));
        hand.addCard(new PlayingCard(PlayingCard.Rank.ACE, PlayingCard.Suit.DIAMONDS));

        
        int handValue = hand.calculateHandValue();
        
        
        //This test should expect 13 because ACE is 1 or 11. So one ace should be 11 and the other two should be 1.
        assertEquals(13, handValue);


    }
    
    @Test
    public void testCalculateHandValue_Good() {
        Hand hand = new Hand();

   
        hand.addCard(new PlayingCard(PlayingCard.Rank.ACE, PlayingCard.Suit.HEARTS));
        hand.addCard(new PlayingCard(PlayingCard.Rank.KING, PlayingCard.Suit.SPADES));


        int handValue = hand.calculateHandValue();

        assertEquals(21, handValue);


    }
    
    @Test
    public void testCalculateHandValue_Bad() {
        Hand hand = new Hand();

        hand.addCard(new PlayingCard(PlayingCard.Rank.TEN, null));
        // Calculate the hand value
        int handValue = hand.calculateHandValue();

        
        //Should be false but the value is actually 10 so the test failed
        assertEquals(false, handValue);
    }
    
    

    
}
