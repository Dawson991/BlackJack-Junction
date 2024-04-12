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
    
    public BlackJackPlayerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getHand method, of class BlackJackPlayer.
     */
    @Test
    public void testGetHand() {
        System.out.println("getHand");
        BlackJackPlayer instance = null;
        Hand expResult = null;
        Hand result = instance.getHand();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasBlackjack method, of class BlackJackPlayer.
     */
    @Test
    public void testHasBlackjack() {
        System.out.println("hasBlackjack");
        BlackJackPlayer instance = null;
        boolean expResult = false;
        boolean result = instance.hasBlackjack();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHasBlackjack method, of class BlackJackPlayer.
     */
    @Test
    public void testSetHasBlackjack() {
        System.out.println("setHasBlackjack");
        boolean hasBlackjack = false;
        BlackJackPlayer instance = null;
        instance.setHasBlackjack(hasBlackjack);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getChips method, of class BlackJackPlayer.
     */
    @Test
    public void testGetChips() {
        System.out.println("getChips");
        BlackJackPlayer instance = null;
        int expResult = 0;
        int result = instance.getChips();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setChips method, of class BlackJackPlayer.
     */
    @Test
    public void testSetChips() {
        System.out.println("setChips");
        int chips = 0;
        BlackJackPlayer instance = null;
        instance.setChips(chips);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateChips method, of class BlackJackPlayer.
     */
    @Test
    public void testUpdateChips() {
        System.out.println("updateChips");
        int bet = 0;
        boolean win = false;
        BlackJackPlayer instance = null;
        instance.updateChips(bet, win);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBetAmount method, of class BlackJackPlayer.
     */
    @Test
    public void testGetBetAmount() {
        System.out.println("getBetAmount");
        BlackJackPlayer instance = null;
        int expResult = 0;
        int result = instance.getBetAmount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBetAmount method, of class BlackJackPlayer.
     */
    @Test
    public void testSetBetAmount() {
        System.out.println("setBetAmount");
        int betAmount = 0;
        BlackJackPlayer instance = null;
        instance.setBetAmount(betAmount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of askHitOrStand method, of class BlackJackPlayer.
     */
    @Test
    public void testAskHitOrStand() {
        System.out.println("askHitOrStand");
        BlackJackPlayer instance = null;
        boolean expResult = false;
        boolean result = instance.askHitOrStand();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of play method, of class BlackJackPlayer.
     */
    @Test
    public void testPlay() {
        System.out.println("play");
        BlackJackPlayer instance = null;
        instance.play();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
