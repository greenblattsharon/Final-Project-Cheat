package card;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;

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
        System.out.println(deck.getSize());
        assertTrue("New deck will have 52 cards", 52 == deck.getSize());
    }

}
