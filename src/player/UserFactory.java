package player;

public class UserFactory implements AbstractPlayerFactory {

    @Override
    public User createPlayer(double intelligence){
        User player = new User();
        return player;
    }
}
