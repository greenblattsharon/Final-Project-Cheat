package player;

public class OpponentFactory implements AbstractPlayerFactory{

    @Override
    public Opponent createPlayer(int intelligence){
        Opponent player = new Opponent(intelligence);
        return player;
    }
}
