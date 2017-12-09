package player;

import card.Card;
import card.IllegalCardException;
import card.Suit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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

    /**
     * Having odds of 1 and intelligence of .1 will return cheat of .1
     */
    @Test
    public void oddsOfOneAndIntelligenceOfPointOneReturnsCheatOfPointOne() throws IllegalMoveException, IllegalCardException {
        opponent = new Opponent(.1);
        opponent.getHand().addCard(new Card(1, Suit.Club));
        double odds = opponent.calculateOdds(1, 4);
        Assert.assertTrue("Having one card in hand and four of the same number card will return cheat of .1", .1 == opponent.calculateCheat(odds));
    }

    /**
     * With play card number 1 and two 1 cards in the hand, getCardsToPlay will return index of the one cards
     */
    @Test
    public void getPlayIndexForCardNumberCorresponds() throws IllegalCardException {
        opponent.getHand().addCard(new Card(1, Suit.Club));
        opponent.getHand().addCard(new Card(2, Suit.Club));
        opponent.getHand().addCard(new Card(1, Suit.Diamond));
        int[] cards_indicies = opponent.getCardsToPlay(1);
        Assert.assertTrue("The resulting array should be size 2", 2 == cards_indicies.length);
        Assert.assertTrue("First index should have card of number 1", 1 == opponent.getHand().getCards().get(cards_indicies[0]).getNumber());
        Assert.assertTrue("Second index should have card of number 1", 1 == opponent.getHand().getCards().get(cards_indicies[1]).getNumber());
    }

    /**
     * With play card number 1 and two 13 cards in the hand, getCardsToPlay will return index of the 13 cards
     */
    @Test
    public void getPlayIndexForCardNumberOneBelow() throws IllegalCardException {
        opponent.getHand().addCard(new Card(13, Suit.Club));
        opponent.getHand().addCard(new Card(2, Suit.Club));
        opponent.getHand().addCard(new Card(13, Suit.Diamond));
        int[] cards_indicies = opponent.getCardsToPlay(1);
        Assert.assertTrue("The resulting array should be size 2", 2 == cards_indicies.length);
        Assert.assertTrue("First index should have card of number 13", 13 == opponent.getHand().getCards().get(cards_indicies[0]).getNumber());
        Assert.assertTrue("Second index should have card of number 13", 13 == opponent.getHand().getCards().get(cards_indicies[1]).getNumber());
    }

    /**
     * With play card number 1 and two 2 cards in the hand, getCardsToPlay will return index of the two cards
     */
    @Test
    public void getPlayIndexForCardNumberOneAbove() throws IllegalCardException {
        opponent.getHand().addCard(new Card(2, Suit.Club));
        opponent.getHand().addCard(new Card(3, Suit.Club));
        opponent.getHand().addCard(new Card(2, Suit.Diamond));
        int[] cards_indicies = opponent.getCardsToPlay(1);
        Assert.assertTrue("The resulting array should be size 2", 2 == cards_indicies.length);
        Assert.assertTrue("First index should have card of number 2", 2 == opponent.getHand().getCards().get(cards_indicies[0]).getNumber());
        Assert.assertTrue("Second index should have card of number 2", 2 == opponent.getHand().getCards().get(cards_indicies[1]).getNumber());
    }

    /**
     * If there isn't a card above, the same, or below, will return random cards that are a lie
     */
    @Test
    public void lieCardsAreGenerated() throws IllegalCardException{
        opponent.getHand().addCard(new Card(2, Suit.Club));
        opponent.getHand().addCard(new Card(3, Suit.Club));
        opponent.getHand().addCard(new Card(2, Suit.Diamond));
        int[] cards_indicies = opponent.getCardsToPlay(10);
        ArrayList<Card> cards = opponent.getHand().getCards();
        for (int i = 0; i < cards_indicies.length; i++){
            int num = cards.get(i).getNumber();
            Assert.assertFalse("i index is equal to 10", 10 == num);
            Assert.assertFalse("i index is equal to 11", 11 == num);
            Assert.assertFalse("i index is equal to 9", 9 == num);
        }
    }

    /**
     * If -1 is passed to getCardsToPlay then any card can be played
     */
    @Test
    public void anyCardCanBePlayedAreGenerated() throws IllegalCardException{
        opponent.getHand().addCard(new Card(2, Suit.Club));
        opponent.getHand().addCard(new Card(3, Suit.Club));
        opponent.getHand().addCard(new Card(2, Suit.Diamond));

        int[] cards_indicies = opponent.getCardsToPlay(-1);
        ArrayList<Card> cards = opponent.getHand().getCards();

        for (int i = 0; i < cards_indicies.length; i++){
            int num = cards.get(i).getNumber();
            System.out.println(num);
        }
    }







}
