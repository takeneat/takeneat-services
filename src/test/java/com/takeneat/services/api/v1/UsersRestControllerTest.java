package com.takeneat.services.api.v1;

import com.takeneat.services.test.AbstractWebIntegrationTest;
import com.takeneat.services.api.v1.dto.LoginRequestDTO;
import com.takeneat.services.test.TestConstants;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author paoesco
 */
public class UsersRestControllerTest extends AbstractWebIntegrationTest {

    @Test
    public void testLoginSuccess() {
        LoginRequestDTO request = new LoginRequestDTO();
        request.setEmail("test@takeneat.com");
        request.setPassword("test");
        Long result = restTemplate.postForObject(getPathV1() + "/users/login", request, Long.class);
        Assert.assertNotNull(result);
        Assert.assertEquals(TestConstants.USER_LOGIN_ID, result.longValue());
    }

    @Test
    public void testLoginFailed() {
        LoginRequestDTO request = new LoginRequestDTO();
        request.setEmail("test@takeneat.com");
        request.setPassword("wrongpassword");
        Long result = restTemplate.postForObject(getPathV1() + "/users/login", request, Long.class);
        Assert.assertNull(result);
    }

}
