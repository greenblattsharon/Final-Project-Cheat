package player;

public class UserFactory implements AbstractPlayerFactory {

    @Override
    public User createPlayer(int intelligence){
        User player = new User();
        return player;
    }
}
