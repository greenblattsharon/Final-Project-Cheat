package card;

import org.junit.Assert;
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
}
