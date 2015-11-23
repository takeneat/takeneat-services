package com.takeneat.services.users;

import com.takeneat.services.Boot;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author paoesco
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Boot.class)
public class UsersServiceTest {

    @Autowired
    private UsersService usersService;

    @Test
    public void testLoginSuccess() {
        boolean result = usersService.login((long) 1, "test");
        Assert.assertTrue(result);
    }

    @Test
    public void testLoginFailed() {
        boolean result = usersService.login((long) 1, "wrongpass");
        Assert.assertFalse(result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUserDoesNotExist() {
        usersService.login((long) -1, "test");
        Assert.fail();
    }

}
