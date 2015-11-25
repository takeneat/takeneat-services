package com.takeneat.services.users;

import com.takeneat.services.test.AbstractServiceTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author paoesco
 */
public class UsersServiceTest extends AbstractServiceTest {

    @Autowired
    private UsersService usersService;

    @Test
    public void testLoginSuccess() {
        boolean result = usersService.login("test@takeneat.com", "test");
        Assert.assertTrue(result);
    }

    @Test
    public void testLoginFailed() {
        boolean result = usersService.login("test@takeneat.com", "wrongpass");
        Assert.assertFalse(result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUserDoesNotExist() {
        usersService.login("falsemail@takeneat.com", "test");
        Assert.fail();
    }

}
