/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Dawso
 */

import java.util.Scanner;

public class BlackJackPlayer extends Player {
    private Hand hand;
    private int chips;
    private String name;
    private int betAmount;
    private Boolean hasBlackjack;

    public Hand getHand() {
        return hand;
    }

    public BlackJackPlayer(String name) {
        super(name);
        hand = new Hand();
    }

    public boolean hasBlackjack() {
        return hasBlackjack;
    }

    public void setHasBlackjack(boolean hasBlackjack) {
        this.hasBlackjack = hasBlackjack;
    }

    public int getChips() {
        return chips;
    }

    public void setChips(int chips) {
        this.chips = chips;
    }

    public void updateChips(int bet, boolean win) {
        if (win) {
            chips += bet * 2;
        } else {
            chips -= bet;
        }
    }

    public int getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(int betAmount) {
        this.betAmount = betAmount;
    }

    public boolean askHitOrStand() {
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean validInput = false;

        do {
            System.out.println("Do you want to hit (y/n)?");
            input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("y") || input.equals("yes")) {
                validInput = true;
            } else if (input.equals("n") || input.equals("no")) {
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter 'y' (yes) or 'n' (no).");
            }
        } while (!validInput);

        return input.equals("y") || input.equals("yes");
    }

    @Override
    public void play() {
        // Implement the play logic for a Blackjack player
        System.out.println(getName() + " is playing Blackjack!");
    }
}
