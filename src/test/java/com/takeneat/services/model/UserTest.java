package com.takeneat.services.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author paoesco
 */
public class UserTest {

    @Test
    public void testGetFullname() {
        User user = new User();
        user.setFirstname("Firstname");
        user.setLastname("Lastname");
        Assert.assertEquals("Firstname Lastname", user.getFullname());
    }

}
