package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJackGame extends Game {
    private Deck deck;
    private BlackJackDealer dealer;
    private BlackJackPlayer player;
    private ArrayList<Player> players = new ArrayList<>();
    private String playerName;

    public BlackJackGame(String name) {
        super(name);
        deck = new Deck();
        dealer = new BlackJackDealer();
    }

    // Add player to the local list
    public void addPlayer(Player player) {
        players.add(player);
    }

    public Deck getDeck() {
        return deck;
    }

    public BlackJackDealer getDealer() {
        return dealer;
    }

    public void dealCardsToDealer(int numCards) {
        // Get a reference to the dealer
        BlackJackDealer dealer = getDealer();

        // Deal the specified number of cards to the dealer
        for (int i = 0; i < numCards; i++) {
            PlayingCard card = deck.dealCard();
            dealer.dealCard(card);

            // Print the first card face up and second card facedown.
            if (i == 0) {
                System.out.println();
                System.out.println("********DEALERS HAND: ************************************");
                System.out.println("Dealer gets: " + card + ", [Card FaceDown]");
                System.out.println("Dealers known score: " + card.getValue());
                System.out.println("**********************************************************");
            }
        }
    }

    public void dealCardsToPlayer(BlackJackPlayer player, int numCards) {
        Hand playerHand = player.getHand();// Get player's hand

        for (int i = 0; i < numCards; i++) {
            PlayingCard card = getDeck().dealCard();
            playerHand.addCard(card); // add the card to the players hand
            System.out.println("Dealt card to " + player.getName() + ": " + card);
        }
    }

    @Override
    public void play() {
        System.out.println("Let's play Blackjack!");
        Scanner scanner = new Scanner(System.in);
        String input;
        Boolean playAgain = true;

        System.out.println("Enter your name: ");
        playerName = scanner.nextLine();

        player = new BlackJackPlayer(playerName);
        player.setChips(2500);
        
        
        //Loop to play another round of blackjack
        while (playAgain) {
            player.setHasBlackjack(false);
            dealer.setHasBlackjack(false);
            // Randomize the cards in the array
            deck.shuffle();

            
            
            int betAmount;
            do {
                System.out.println("You have " + player.getChips() + " chips. Enter your bet amount (between 1 and " + player.getChips() + "): ");
                
                
                //https://www.tutorialspoint.com/java/util/scanner_hasnextint.htm
                //Checks for valid user input values
                if (scanner.hasNextInt()) {
                    betAmount = scanner.nextInt();
                    scanner.nextLine();
                    if (betAmount < 1 || betAmount > player.getChips()) {
                        System.out.println("Invalid bet amount. Please enter a number between 1 and " + player.getChips() + ".");
                    } else {
                        player.setBetAmount(betAmount);
                        break;
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.nextLine();
                }
            } while (true);
            Hand playerHand = player.getHand();
            for (int i = 0; i < 2; i++) {
                PlayingCard dealtCard = deck.dealCard();
                playerHand.addCard(dealtCard);
            }
            dealCardsToDealer(2);

            boolean wantsHit = true;
            while (wantsHit && player.getHand().calculateHandValue() <= 21) {
                System.out.println();
                System.out.println("*******" + player.getName().toUpperCase() + "S HAND: " + "***************************************");
                System.out.println("Your hand: " + player.getHand());
                System.out.println("Your Current score: " + player.getHand().calculateHandValue());
                System.out.println("***********************************************************");

                // Check for Blackjack (When the players card are 21)
                if (player.getHand().calculateHandValue() == 21) {
                    player.setHasBlackjack(true);
                    break;
                } else {
                    wantsHit = player.askHitOrStand();
                    if (wantsHit) {
                        PlayingCard dealtCard = deck.dealCard();
                        player.getHand().addCard(dealtCard);
                        System.out.println();
                        System.out.println("********DEALERS HAND: ************************************");
                        System.out.println("Dealer's hand: " + dealer.getHand()); // Reveal both cards here
                        System.out.println("Dealers Score: " + dealer.getHand().calculateHandValue());
                        System.out.println("**********************************************************");
                    }
                }
            }

            // Dealer's turn (hit logic)
            if (dealer.getHand().calculateHandValue() == 21) {
            dealer.setHasBlackjack(true);
            break;}
            else{
            while (dealer.shouldHit()) {
                PlayingCard dealtCard = deck.dealCard();
                dealer.getHand().addCard(dealtCard);
                System.out.println();
                System.out.println("********DEALERS HAND: ************************************");
                System.out.println("Dealers Hand: " + dealer.getHand());
                System.out.println("Dealers Total Value: " + dealer.calculateHandValue());
                System.out.println("**********************************************************");
            }
            }
            
            //Display dealers hand and players hand for a clear understanding of why either player or dealer won
            System.out.println("-----FINAL HANDS: -----");
            System.out.println("********DEALERS HAND Final Hand: ************************************");
            System.out.println("Dealers Hand: " + dealer.getHand());
            System.out.println("Dealers Total Value: " + dealer.calculateHandValue());
            System.out.println("**********************************************************");

            System.out.println("*******" + player.getName().toUpperCase() + "S Final HAND: " + "***************************************");
            System.out.println("Your hand: " + player.getHand());
            System.out.println("Your Current score: " + player.getHand().calculateHandValue());
            System.out.println("***********************************************************");

            // Declare the winner
            declareWinner();


            // Ask player if they want to play again
            System.out.println("Do you want to play again(y/n)?");
            input = scanner.nextLine();
            if (input.equals("y") || input.equals("yes")) {
                playAgain = true;
            } else if (input.equals("n") || input.equals("no")) {
                System.out.println("You cashed out with: " + player.getChips());
                break;
            }
            
            
        // if the play reaches 0 or less chips they lose
        if (player.getChips() <= 0) {
            System.out.println("You have run out of chips.. Better luck next time");
            playAgain = false;
        }


            // Reset player's hand, dealer's hand, and deck for a new game
            //Otherwise hand will fill will null values
            player.getHand().clearHand();
            dealer.resetHand();
            deck = new Deck();
        }
        scanner.close();

    }

    @Override
    public void declareWinner() {

        // Calculate dealer's score directly
        int dealerScore;
        dealerScore = dealer.getHand().calculateHandValue();
        // Check each player's hand against the dealer's score
        player.getHand().clearHand();
        System.out.println("player chips is: " + player.getChips());
        int playerScore = player.getHand().calculateHandValue();
        
        if(playerScore == dealerScore){
            System.out.println(player.getName() + " ties with the dealer.");
        } else if (playerScore  >21 && dealerScore >21 ) {
        System.out.println(player.getName() + " ties with the dealer.");
        } else if (player.hasBlackjack()) {
            System.out.println("Blackjack! Congratulations, " + player.getName() + " wins!");
            player.updateChips((int) (player.getBetAmount() * 1.5), true);
        } else if (dealer.hasBlackjack()) {
              System.out.println("Dealer has 21" + player.getName() + " loses.");
        } else if (playerScore > 21) {
            System.out.println(player.getName() + " busts! You lose.");
            player.updateChips(player.getBetAmount(), false);
        } else if (dealerScore > 21 && playerScore < 21) {
            System.out.println("Dealer busts! " + player.getName() + " wins!");
            player.updateChips(player.getBetAmount(), true);
        } else if (playerScore > dealerScore) {
            System.out.println(player.getName() + " wins!");
            player.updateChips(player.getBetAmount(), true);
        } else if (playerScore < dealerScore) {
            System.out.println(player.getName() + " loses to the dealer.");
            player.updateChips(player.getBetAmount(), false);
        } else {
            System.out.println(player.getName() + " ties with the dealer.");
        }
        

        //Reset the dealers hand at the end of the round
        dealer.resetHand();

        //Used to reset the deck so it doesn't empty
        deck = new Deck();

    }
}
