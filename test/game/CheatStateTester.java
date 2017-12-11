package game;

import card.IllegalCardException;
import org.junit.Before;
import org.junit.Test;

public class CheatStateTester {

    Game game;

    @Before
    public void setup() throws IllegalCardException {
        game = new Game(1);
    }

    /**
     * If lie is true then the player who played before will pick up the deck
     */
    @Test
    public void ifLiePreviousPlayerPicksUpDeck() {

    }

    /**
     * If lie is false then the player who called cheat picks up the deck
     */
    @Test
    public void ifNotLieCheatPlayerPicksUpDeck() {

    }

    /**
     * If lie is false and player who played before has zero cards then
     * the gameState is changed to EndGameState
     */
    @Test
    public void ifNotLieAndZeroCardsThenChangeGameState() {
        
    }
}
