package game;

import card.IllegalCardException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import player.User;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class TurnStateTester {

    Game game;
    TurnState turnState;

    @Before
    public void setup() throws IllegalCardException{
        game = new Game(1);
        turnState = new TurnState(game);
        game.setCurrentState(turnState);}

    /**
     * currentState can be set to TurnState
     */
    @Test
    public void setCurrentStateToTurnState(){
        Assert.assertTrue("Current state is turnState", game.getCurrentState() instanceof TurnState);
    }

    /**
     * The first turn of turn state will have the user as the player for the turn
     */
    @Test
    public void firstTurnWillHaveUserAsPlayer(){
        Assert.assertTrue("First player is a user", game.players[game.turn] instanceof User);
    }

    /**
     * ConvertCardNumber will return 13 when give 0
     */
    @Test
    public void thirteenIsReturnedWhenGivenZero(){
        int num = turnState.convertCardNumber(0);
        Assert.assertTrue("ConvertCardNumber will return 13 when given 0", 13 == num);
    }

    /**
     * ConvertCardNumber will return 1 when give 14
     */
    @Test
    public void oneIsReturnedWhenGivenFourteen(){
        int num = turnState.convertCardNumber(14);
        Assert.assertTrue("ConvertCardNumber will return 1 when given 14", 1 == num);
    }

    /**
     * generateLastCardNumber will ask the user for what number they want
     * when the user lies and the any card is valid
     */
    @Test
    public void askUserToSetLast_Card(){
        String stimulatedOutput = "5";
        InputStream in = new ByteArrayInputStream(stimulatedOutput.getBytes());
        System.setIn(in);

        int num = turnState.generateLastCardNumber(-1);

        Assert.assertTrue("The return int should be what the user set", 5 == num);
    }

    /**
     * generateLastCardNumber will pick a random number if any card is a valid move
     */
    @Test
    public void randomNumberGeneratedWhenAnyCardIsValid(){
        game.turn = 1;

        int num = turnState.generateLastCardNumber(-1);

        Assert.assertTrue("The returned int will be higher than 1", 1 <= num);
        Assert.assertTrue("The returned int will be lower than 13", 13 >= num);
    }

    /**
     * generateLastCardNumber will pick random up, stay, or down when last_card is not anything
     */
    @Test
    public void randomNumberWithinGameParametersForValidMoveIsChose(){

    }

    /**
     * areAllCardsTheSame will return true when given an array of all the same cards
     */
    @Test
    public void returnTrueWhenAllCardsAreTheSame(){

    }

    /**
     * areAllCardsTheSame will return false when given an array of different cards
     */
    @Test
    public void returnFalseWhenCardsAreDifferent(){

    }

    /**
     * wasTurnALie will return true if cards all were not the same
     */
    @Test
    public void returnTrueLieWhenCardsAreDifferent(){

    }

    /**
     * wasTurnALie will return false if cards are the same and last_card == -1
     */
    @Test
    public void returnFalseLieWhenCardsAreSameAndLast_CardIsAnything(){

    }

    /**
     * wasTurnALie will return false if cards are the same and equal to either the last_card
     * last_card + 1 or last_card - 1
     */
    @Test
    public void returnFalseLieWhenCardsAreSameAndMoveValidWithLastCard(){

    }

    /**
     * wasTurnALie will return true if cards are the same and not valid with last_card
     */
    @Test
    public void returnTrueLieWhenCardsAreSameAndMoveNotValidWithLastCard(){

    }

    /**
     * Having the user as the player for the turn will allow the user to play cards
     * The user cannot call Cheat
     */
    @Test
    public void userCanPlayCards()throws IllegalCardException{

    }

    /**
     * Having an opponent as the player will cause the opponent to play cards
     * The user will not call Cheat
     */
    @Test
    public void opponentPlayCardsNoCheatCalledByUser() throws IllegalCardException{

    }

    /**
     * Having an opponent as the player will cause the opponent to play cards
     * The user will call Cheat
     */
    @Test
    public void opponentPlayCardsCheatCalledByUser() throws IllegalCardException{

    }

    /**
     * The user will put down the last card without Cheat being called
     * and change the gameState to endGameState
     */
    @Test
    public void userPutsDownLastCardAndChangesGameState() throws IllegalCardException{

    }


}
