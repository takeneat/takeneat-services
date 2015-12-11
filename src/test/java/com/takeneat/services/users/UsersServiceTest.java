package com.takeneat.services.users;

import com.takeneat.services.model.User;
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

    @Autowired
    private UserDao userDao;

    @Test
    public void testLoginSuccess() {
        Long result = usersService.login("test@takeneat.com", "test", TestConstants.MOBILE_ID);
        Assert.assertNotNull(result);
        Assert.assertEquals(TestConstants.USER_LOGIN_ID, result.longValue());
        User user = userDao.findOne(result);
        Assert.assertNotNull(user);
        Assert.assertEquals(TestConstants.MOBILE_ID, user.getMobileId());
    }

    @Test
    public void testLoginFailed() {
        Long result = usersService.login("test@takeneat.com", "wrongpass", TestConstants.MOBILE_ID);
        Assert.assertNull(result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUserDoesNotExist() {
        usersService.login("falsemail@takeneat.com", "test", TestConstants.MOBILE_ID);
        Assert.fail();
    }

    @Test
    public void getUserKO() {
        User user = usersService.get(-1);
        Assert.assertNull(user);
    }

    @Test
    public void getUserOK() {
        User user = usersService.get(TestConstants.COOK_ID);
        Assert.assertNotNull(user);
        Assert.assertEquals(TestConstants.COOK_ID, user.getId().longValue());
        Assert.assertEquals("cook@takeneat.com", user.getEmail());

    }

}
