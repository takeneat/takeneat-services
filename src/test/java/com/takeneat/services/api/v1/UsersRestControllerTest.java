package com.takeneat.services.api.v1;

import com.takeneat.services.api.exceptions.ExceptionDTO;
import com.takeneat.services.test.AbstractWebIntegrationTest;
import com.takeneat.services.api.v1.dto.LoginRequestDTO;
import com.takeneat.services.api.v1.dto.UserDTO;
import com.takeneat.services.test.TestConstants;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
        ResponseEntity<ExceptionDTO> response = restTemplate.postForEntity(getPathV1() + "/users/login", request, ExceptionDTO.class);
        Assert.assertNotNull(response);
        Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void testLoginBadRequesWrongEmail() {
        LoginRequestDTO request = new LoginRequestDTO();
        request.setPassword("email@notexists.com");
        request.setPassword("wrongpassword");
        request.setMobileId(TestConstants.MOBILE_ID);
        ResponseEntity<ExceptionDTO> response = restTemplate.postForEntity(getPathV1() + "/users/login", request, ExceptionDTO.class);
        Assert.assertNotNull(response);
        Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void testLoginBadRequestEmail() {
        LoginRequestDTO request = new LoginRequestDTO();
        request.setPassword("wrongpassword");
        request.setMobileId(TestConstants.MOBILE_ID);
        ResponseEntity<ExceptionDTO> response = restTemplate.postForEntity(getPathV1() + "/users/login", request, ExceptionDTO.class);
        Assert.assertNotNull(response);
        Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void testLoginBadRequestPassword() {
        LoginRequestDTO request = new LoginRequestDTO();
        request.setEmail("test@takeneat.com");
        request.setMobileId(TestConstants.MOBILE_ID);
        ResponseEntity<ExceptionDTO> response = restTemplate.postForEntity(getPathV1() + "/users/login", request, ExceptionDTO.class);
        Assert.assertNotNull(response);
        Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void testGetUserKO() {
        ResponseEntity<UserDTO> result = restTemplate.getForEntity(getPathV1() + "/users/-1", UserDTO.class);
        Assert.assertNotNull(result);
        Assert.assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
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
