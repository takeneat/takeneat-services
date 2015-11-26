package com.takeneat.services.users;

import com.takeneat.services.test.AbstractServiceTest;
import com.takeneat.services.test.TestConstants;
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
        Long result = usersService.login("test@takeneat.com", "test");
        Assert.assertNotNull(result);
        Assert.assertEquals(TestConstants.USER_LOGIN_ID, result.longValue());
    }

    @Test
    public void testLoginFailed() {
        Long result = usersService.login("test@takeneat.com", "wrongpass");
        Assert.assertNull(result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUserDoesNotExist() {
        usersService.login("falsemail@takeneat.com", "test");
        Assert.fail();
    }

}
