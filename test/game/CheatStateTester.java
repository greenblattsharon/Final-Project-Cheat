package game;

import card.IllegalCardException;
import org.junit.Before;
import org.junit.Test;
import player.IllegalMoveException;

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

    }

    /**
     * If lie is false then the player who called cheat picks up the deck
     */
    @Test
    public void ifNotLieCheatPlayerPicksUpDeck() throws IllegalMoveException, IllegalCardException {

    }

    /**
     * If lie is false and player who played before has zero cards then
     * the gameState is changed to EndGameState
     */
    @Test
    public void ifNotLieAndZeroCardsThenChangeGameState() throws IllegalMoveException, IllegalCardException {

    }
}
