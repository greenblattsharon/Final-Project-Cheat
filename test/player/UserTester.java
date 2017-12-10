package player;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTester {
    User user;

    @Before
    public void setup(){user = new User();}

    /**
     * Constructing User using Factory
     */
    @Test
    public void correctInstanceFromFactory(){
        UserFactory uf = new UserFactory();
        User fromFactory = uf.createPlayer(.1);
        Assert.assertTrue(fromFactory instanceof User);
    }
}
