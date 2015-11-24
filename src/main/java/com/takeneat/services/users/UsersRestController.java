package com.takeneat.services.users;

import com.takeneat.services.users.dto.LoginRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author paoesco
 */
@RestController
@RequestMapping("/users")
public class UsersRestController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Boolean login(@RequestBody LoginRequestDTO request) {
        return usersService.login(request.getEmail(), request.getPassword());
    }

}
