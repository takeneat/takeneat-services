package com.takeneat.services.api.v1;

import com.takeneat.services.test.AbstractWebIntegrationTest;
import com.takeneat.services.api.v1.dto.LoginRequestDTO;
import com.takeneat.services.api.v1.dto.UserDTO;
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
        request.setMobileId(TestConstants.MOBILE_ID);
        Long result = restTemplate.postForObject(getPathV1() + "/users/login", request, Long.class);
        Assert.assertNotNull(result);
        Assert.assertEquals(TestConstants.USER_LOGIN_ID, result.longValue());
    }

    @Test
    public void testLoginFailed() {
        LoginRequestDTO request = new LoginRequestDTO();
        request.setEmail("test@takeneat.com");
        request.setPassword("wrongpassword");
        request.setMobileId(TestConstants.MOBILE_ID);
        Long result = restTemplate.postForObject(getPathV1() + "/users/login", request, Long.class);
        Assert.assertNull(result);
    }

    @Test
    public void testGetUserKO() {
        UserDTO result = restTemplate.getForObject(getPathV1() + "/users/-1", UserDTO.class);
        Assert.assertNotNull(result);
        Assert.assertNull(result.getId());
    }

    @Test
    public void testGetUserOK() {
        UserDTO result = restTemplate.getForObject(getPathV1() + "/users/" + TestConstants.COOK_ID, UserDTO.class);
        Assert.assertNotNull(result);
        Assert.assertEquals(TestConstants.COOK_ID, result.getId().longValue());
        Assert.assertEquals("cook@takeneat.com", result.getEmail());
        Assert.assertEquals("Cook firstname", result.getFirstname());
        Assert.assertEquals("Cook lastname", result.getLastname());
        Assert.assertEquals("1234567890", result.getMobileId());
    }

}
