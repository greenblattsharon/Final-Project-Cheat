package player;

import card.Card;
import card.IllegalCardException;
import card.Suit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OpponentTester {
    Opponent opponent;

    @Before
    public void setup(){opponent = new Opponent(0);}

    /**
     * Constructing Opponent using Factory
     */
    @Test
    public void correctInstanceFromFactory(){
        OpponentFactory of = new OpponentFactory();
        Opponent fromFactory = of.createPlayer(.1);
        Assert.assertTrue(fromFactory instanceof Opponent);
    }

    /**
     * Constructing Opponent with a double intelligence
     */
    @Test
    public void initialIntelligence(){
        opponent = new Opponent(.1);
        assertTrue("Constructing opponent with double intelligence", .1 == opponent.getIntelligence());
    }

    /**
     * Pass 0 cards played to calculateOdds will throw IllegalMoveException
     */
    @Test(expected = IllegalMoveException.class)
    public void zeroCardsThrowsException() throws IllegalMoveException{
        opponent = new Opponent(.1);
        double odds = opponent.calculateOdds(1, 0);
    }

    /**
     * Having one ace card in hand and 4 ace cards played will return odds of 1
     */
    @Test
    public void oneCardHandAndFourPlayedReturnsOddsOfOne() throws IllegalMoveException, IllegalCardException {
        opponent.getHand().addCard(new Card(1, Suit.Club));
        Assert.assertTrue("Having one card in hand and four of the same number card will return odds of one", 1.0 == opponent.calculateOdds(1,4));
    }

    /**
     * Having one ace card in hand and 3 ace cards played will return odds of .75
     */
    @Test
    public void oneCardHandAndThreePlayedReturnsOddsOfPointSevenFive() throws IllegalMoveException, IllegalCardException {
        opponent.getHand().addCard(new Card(1, Suit.Club));
        Assert.assertTrue("Having one card in hand three of the same number card will return odds of .75", .75 == opponent.calculateOdds(1,3));
    }
    /**
     * Having one ace card in hand and 2 ace cards played will return odds of .5
     */
    @Test
    public void oneCardHandAndTwoPlayedReturnsOddsOfPointFive() throws IllegalMoveException, IllegalCardException {
        opponent.getHand().addCard(new Card(1, Suit.Club));
        Assert.assertTrue("Having one card in hand three of the same number card will return odds of .5", .5 == opponent.calculateOdds(1,2));
    }
    /**
     * Having one ace card in hand and 1 ace cards played will return odds of .25
     */
    @Test
    public void oneCardHandAndOnePlayedReturnsOddsOfPointTwoFive() throws IllegalMoveException, IllegalCardException {
        opponent.getHand().addCard(new Card(1, Suit.Club));
        Assert.assertTrue("Having one card in hand three of the same number card will return odds of .25", .25 == opponent.calculateOdds(1,1));
    }



}
