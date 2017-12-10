package game;

import card.IllegalCardException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TurnStateTester {

    Game game;

    @Before
    public void setup() throws IllegalCardException{ game = new Game(1);}

    /**
     * currentState can be set to TurnState
     */
    @Test
    public void setCurrentStateToTurnState(){
        game.setCurrentState(new TurnState(game));
        Assert.assertTrue("Current state is turnState", game.getCurrentState() instanceof TurnState);
    }
}
