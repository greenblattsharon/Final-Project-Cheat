package player;

public class OpponentFactory implements AbstractPlayerFactory{

    @Override
    public Opponent createPlayer(double intelligence){
        Opponent player = new Opponent(intelligence);
        return player;
    }
}
