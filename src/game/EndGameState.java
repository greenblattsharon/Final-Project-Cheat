package game;

import card.IllegalCardException;

public class EndGameState implements GameState {

    Game game;

    public EndGameState(Game game) {
        this.game = game;
    }

    @Override
    public void implementStateResponsibilities() throws IllegalCardException {

    }
}
