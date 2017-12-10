package player;

import card.Card;
import card.IllegalCardException;
import card.Suit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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

}
