package game;

import card.IllegalCardException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import player.Opponent;
import player.User;

public class InitializeStateTester {
    Game game;

    @Before
    public void setup() throws IllegalCardException {game = new Game(1);}

    /**
     * After creating the game there the currentState should be InitializeState
     */
    @Test
    public void afterInitializeCurrentStateIsInitializeState(){
        Assert.assertTrue("Current state should be initialize state", game.getCurrentState() instanceof InitializeState);
    }



    /**
     * InitializeState initializes the deck
     */
    @Test
    public void initializeStateInitializesTheDeck(){
        Assert.assertNotNull("Deck is not null", game.deck);
    }

    /**
     * InitializeState creates 4 players
     */
    @Test
    public void initializeStateCreatesFourPlayers(){
        Assert.assertTrue("First player is User", game.players[0] instanceof User);
        Assert.assertTrue("Second player is Opponent", game.players[1] instanceof Opponent);
        Assert.assertTrue("Third player is Opponent", game.players[2] instanceof Opponent);
        Assert.assertTrue("Fourth player is Opponent", game.players[3] instanceof Opponent);
    }

    /**
     * After InitializeState, the 4 players each have 13 cards
     */
    @Test
    public void initializeStateFourPlayersHaveThirteenCardsEach(){
        Assert.assertTrue("First player has 13 cards",  13 == game.players[0].getHand().getSize());
        Assert.assertTrue("Second player has 13 cards", 13 == game.players[1].getHand().getSize());
        Assert.assertTrue("Third player has 13 cards", 13 == game.players[2].getHand().getSize());
        Assert.assertTrue("Fourth player has 13 cards", 13 == game.players[3].getHand().getSize());
    }


}
