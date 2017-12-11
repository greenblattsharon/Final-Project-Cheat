package game;

import card.IllegalCardException;

public class CheatState implements GameState{
    Game game;

    public CheatState(Game game){
        this.game = game;
    }

    @Override
    public void implementStateResponsibilities() throws IllegalCardException {

    }
}
