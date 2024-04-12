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
public class BlackJackPlayerTest {
    

    /**
     * Test of setBetAmount method, of class BlackJackPlayer.
     */
    @Test
    public void testSetBetAmount_Bad() {
        BlackJackPlayer player = new BlackJackPlayer("TestPlayer");
        int betAmount = -100;
        player.setBetAmount(betAmount);
        
        //Test is supposed to fail but the bet amount was actually set to -100 which is not a possible bet but it worked anyways.
        //So the test failed
        assertEquals(false, player.getBetAmount());
    }
    
    @Test
    public void testSetBetAmount_Good() {
        BlackJackPlayer player = new BlackJackPlayer("TestPlayer");
        int betAmount = 100;
        player.setBetAmount(betAmount);
        assertEquals(betAmount, player.getBetAmount());
    }
    
    @Test
    public void testSetBetAmount_Boundary() {
        BlackJackPlayer player = new BlackJackPlayer("TestPlayer");
        
        
        int betAmount = 10000000;
        player.setBetAmount(betAmount);
        assertEquals(betAmount, player.getBetAmount());
    }
}