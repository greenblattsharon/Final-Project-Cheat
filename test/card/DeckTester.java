package card;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import player.Player;
import player.User;

public class DeckTester {
    Deck deck;

    @Before
    public void setup(){deck = new Deck();}

    /**
     * Initializing Deck will create deck with 52 cards
     */
    @Test
    public void newDeckWillHave52Cards() throws IllegalCardException {
        deck.initializeDeck();
        assertTrue("New deck will have 52 cards", 52 == deck.getSize());
    }

    /**
     * Dealing cards to one player will result in the one player having a hand of 52 cards
     */
    @Test
    public void dealToOnePlayer() throws IllegalCardException{
        deck.initializeDeck();
        Player player = new User();
        Player[] players = new Player[1];

        players[0] = player;

        deck.dealCards(players);

        assertTrue("Player will have hand of 52 cards", 52 == player.getHand().getSize());

    }

    /**
     * Dealing cards to four players will result in the each player having a hand of 13 cards
     */
    @Test
    public void dealToFourPlayers() throws IllegalCardException{
        deck.initializeDeck();

        Player player1 = new User();
        Player player2 = new User();
        Player player3 = new User();
        Player player4 = new User();
        
        Player[] players = new Player[4];

        players[0] = player1;
        players[1] = player2;
        players[2] = player3;
        players[3] = player4;

        deck.dealCards(players);

        assertTrue("Player 1 will have hand of 13 cards", 13 == players[0].getHand().getSize());
        assertTrue("Player 2 will have hand of 13 cards", 13 == players[1].getHand().getSize());
        assertTrue("Player 3 will have hand of 13 cards", 13 == players[2].getHand().getSize());
        assertTrue("Player 4 will have hand of 13 cards", 13 == players[3].getHand().getSize());

    }



}
