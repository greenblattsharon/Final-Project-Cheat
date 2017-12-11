package game;

import card.Card;
import card.IllegalCardException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import player.IllegalMoveException;

import java.util.ArrayList;

public class CheatStateTester {

    Game game;


    @Before
    public void setup() throws IllegalCardException {
        game = new Game(1);
        game.setCurrentState(new CheatState(game));
    }

    /**
     * If cheat is -1 then IllegalMoveException is thrown
     */
    @Test(expected = IllegalMoveException.class)
    public void ifIncorrectCheatThenExceptionIsThrown() throws IllegalMoveException, IllegalCardException {
        game.getCurrentState().implementStateResponsibilities();
    }

    /**
     * If lie is true then the player who played before will pick up the deck
     */
    @Test
    public void ifLiePreviousPlayerPicksUpDeck() throws IllegalMoveException, IllegalCardException {
        game.turn = 0;
        game.cheat = 1;
        game.lie = true;

        ArrayList<Card> cards_turn = game.players[game.turn].getHand().getCards();

        Card card = cards_turn.get(0);
        game.players[game.turn].getHand().removeCard(card);
        game.deck.addCard(card);

        Assert.assertTrue("Deck should have one card in it currently", 1 == game.deck.getSize());

        //game.getCurrentState().implementStateResponsibilities();

        //Assert.assertTrue("Player Cheat should have hand of size 14", 14 == game.players[game.cheat].getHand().getSize());
        //Assert.assertTrue("Deck will have size of zero", 0 == game.deck.getSize());

    }

    /**
     * If lie is false then the player who called cheat picks up the deck
     */
    @Test
    public void ifNotLieCheatPlayerPicksUpDeck() throws IllegalMoveException, IllegalCardException {
        game.turn = 0;
        game.cheat = 1;
        game.lie = false;

        ArrayList<Card> cards_turn = game.players[game.turn].getHand().getCards();

        Card card = cards_turn.get(0);
        game.players[game.turn].getHand().removeCard(card);
        game.deck.addCard(card);

        Assert.assertTrue("Deck should have one card in it currently", 1 == game.deck.getSize());

        game.getCurrentState().implementStateResponsibilities();

        //Assert.assertTrue("Player Cheat should have hand of size 14", 14 == game.players[game.cheat].getHand().getSize());
        //Assert.assertTrue("Deck will have size of zero", 0 == game.deck.getSize());
    }

    /**
     * If lie is false and player who played before has zero cards then
     * the gameState is changed to EndGameState
     */
    @Test
    public void ifNotLieAndZeroCardsThenChangeGameState() throws IllegalMoveException, IllegalCardException {

    }
}
