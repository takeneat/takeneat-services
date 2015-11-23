package com.takeneat.services.users;

import com.takeneat.services.test.AbstractWebIntegrationTest;
import com.takeneat.services.users.dto.LoginRequestDTO;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author paoesco
 */
public class UsersRestControllerTest extends AbstractWebIntegrationTest {

    @Test
    public void testLoginSuccess() {
        LoginRequestDTO request = new LoginRequestDTO();
        request.setUserId((long) 1);
        request.setPassword("test");
        Boolean result = restTemplate.postForObject(getBaseurl() + "/users/login", request, Boolean.class);
        Assert.assertTrue(result);
    }

    @Test
    public void testLoginFailed() {
        LoginRequestDTO request = new LoginRequestDTO();
        request.setUserId((long) 1);
        request.setPassword("testsssss");
        Boolean result = restTemplate.postForObject(getBaseurl() + "/users/login", request, Boolean.class);
        Assert.assertFalse(result);
    }

}
