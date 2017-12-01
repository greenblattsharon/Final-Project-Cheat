package card;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;

public class GroupOfCardsTester {
    GroupOfCards goc;

    @Before
    public void setup(){
        goc = new GroupOfCards();
    }

    /**
     * Adding one card to the deck should make the size increase by 1
     */
    @Test
    public void shouldAddOneToSize()throws IllegalCardException{
        goc.addCard(new Card(5, Suit.Diamond));
        assertTrue("Should display one card in size", 1 == goc.getSize());
    }

    /**
     * Remove one card from the deck should make the size decrease by 1
     */
    @Test
    public void shouldRemoveOneFromSize() throws IllegalCardException{
        goc.addCard(new Card(5, Suit.Diamond));
        goc.removeCard(new Card(5, Suit.Diamond));
        assertTrue("Should display one card in size", 0 == goc.getSize());
    }

    /**
     * Verify cannot add same cards
     */
    @Test(expected = IllegalCardException.class)
    public void shouldRejectAddingSameCards() throws IllegalCardException{
        goc.addCard(new Card(5, Suit.Diamond));
        goc.addCard(new Card(5, Suit.Diamond));
    }

    /**
     * Verify cannot remove cards from empty deck
     */
    @Test(expected = IllegalCardException.class)
    public void shouldRejectRemovingFromEmpty() throws IllegalCardException{
        goc.removeCard(new Card(5, Suit.Diamond));

    }

    /**
     * Returns correct size of deck
     */
    @Test
    public void shouldReturnCorrectDeckSize() throws IllegalCardException{
        goc.addCard(new Card(5, Suit.Diamond));
        goc.addCard(new Card(6, Suit.Diamond));
        assertTrue("There should be two cards in the deck", 2 == goc.getSize());
    }

    /**
     * Verify that empty deck returns true
     */
    @Test
    public void shouldReturnTrueForEmpty(){
        assertTrue("Method returns true for empty", goc.isItEmpty());
    }

    /**
     * Verify that not empty deck returns false
     */
    @Test
    public void shouldNotReturnTrueForEmpty() throws IllegalCardException{
        goc.addCard(new Card(5, Suit.Diamond));
        assertFalse("Method returns false for empty", goc.isItEmpty());
    }

}
