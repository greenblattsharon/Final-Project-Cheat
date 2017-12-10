package player;

import card.Card;
import card.IllegalCardException;
import card.Suit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class UserTester {
    User user;

    @Before
    public void setup(){user = new User();}

    /**
     * Constructing User using Factory
     */
    @Test
    public void correctInstanceFromFactory(){
        UserFactory uf = new UserFactory();
        User fromFactory = uf.createPlayer(.1);
        Assert.assertTrue(fromFactory instanceof User);
    }

    /**
     * Sorting the cards
     */
    @Test
    public void sortingTheHand() throws IllegalCardException {
        user.getHand().addCard(new Card(2, Suit.Club));
        user.getHand().addCard(new Card(3, Suit.Club));
        user.getHand().addCard(new Card(1, Suit.Diamond));
        user.getHand().addCard(new Card(12, Suit.Club));
        user.getHand().addCard(new Card(10, Suit.Club));
        user.getHand().addCard(new Card(5, Suit.Diamond));
        user.sort();

        user.getHand().printCards();

        Assert.assertTrue("First card should be 1", 1 == user.getHand().getCards().get(0).getNumber());
        Assert.assertTrue("Last card should be 12", 12 == user.getHand().getCards().get(5).getNumber());
    }

    /**
     * Calling getCardsToPlay returns int[] of card indices to play
     */
    @Test
    public void getCardsToPlayWorksCorrectly() throws IllegalCardException{
        user.getHand().addCard(new Card(2, Suit.Club));
        user.getHand().addCard(new Card(3, Suit.Club));
        user.getHand().addCard(new Card(1, Suit.Diamond));
        user.getHand().addCard(new Card(12, Suit.Club));
        user.getHand().addCard(new Card(10, Suit.Club));
        user.getHand().addCard(new Card(5, Suit.Diamond));

        String stimulatedInput = "3 0 1 2 ";
        InputStream in = new ByteArrayInputStream(stimulatedInput.getBytes());
        System.setIn(in);

        int[] cards = user.getCardsToPlay(-1);

        Assert.assertArrayEquals("An array of the first 3 cards should be returned", new int[]{0, 1, 2}, cards);
    }

    /**
     * Calling getCardsToPlay returns int[] of card indices to play
     * Putting in a too small size and then the correct size
     */
    @Test
    public void getCardsToPlayWorksCorrectlyTooSmallSize() throws IllegalCardException{
        user.getHand().addCard(new Card(2, Suit.Club));
        user.getHand().addCard(new Card(3, Suit.Club));
        user.getHand().addCard(new Card(1, Suit.Diamond));
        user.getHand().addCard(new Card(12, Suit.Club));
        user.getHand().addCard(new Card(10, Suit.Club));
        user.getHand().addCard(new Card(5, Suit.Diamond));

        String stimulatedInput = "-1 3 0 1 2 ";
        InputStream in = new ByteArrayInputStream(stimulatedInput.getBytes());
        System.setIn(in);

        int[] cards = user.getCardsToPlay(-1);

        Assert.assertArrayEquals("After putting in the a too small array size, an array of the first 3 cards should be returned", new int[]{0, 1, 2}, cards);
    }

    /**
     * Calling getCardsToPlay returns int[] of card indices to play
     * Putting in too large array size and then correct size
     */
    @Test
    public void getCardsToPlayWorksCorrectlyTooLargeSize() throws IllegalCardException{
        user.getHand().addCard(new Card(2, Suit.Club));
        user.getHand().addCard(new Card(3, Suit.Club));
        user.getHand().addCard(new Card(1, Suit.Diamond));
        user.getHand().addCard(new Card(12, Suit.Club));
        user.getHand().addCard(new Card(10, Suit.Club));
        user.getHand().addCard(new Card(5, Suit.Diamond));

        String stimulatedInput = "7 3 0 1 2 ";
        InputStream in = new ByteArrayInputStream(stimulatedInput.getBytes());
        System.setIn(in);

        int[] cards = user.getCardsToPlay(-1);

        Assert.assertArrayEquals("After putting in a too large array size, an array of the first 3 cards should be returned", new int[]{0, 1, 2}, cards);
    }

    /**
     * Calling getCardsToPlay returns int[] of card indices to play
     * Putting in an invalid index twice and then the correct index
     */
    @Test
    public void getCardsToPlayWorksCorrectlyInvalidIndex() throws IllegalCardException{
        user.getHand().addCard(new Card(2, Suit.Club));
        user.getHand().addCard(new Card(3, Suit.Club));
        user.getHand().addCard(new Card(1, Suit.Diamond));
        user.getHand().addCard(new Card(12, Suit.Club));
        user.getHand().addCard(new Card(10, Suit.Club));
        user.getHand().addCard(new Card(5, Suit.Diamond));

        String stimulatedInput = "3 100 -1 0 1 2 ";
        InputStream in = new ByteArrayInputStream(stimulatedInput.getBytes());
        System.setIn(in);

        int[] cards = user.getCardsToPlay(1);

        Assert.assertArrayEquals("After putting in an incorrect card index, an array of the first 3 cards should be returned", new int[]{0, 1, 2}, cards);
    }



}
