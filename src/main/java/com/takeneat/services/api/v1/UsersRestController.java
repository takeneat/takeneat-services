package com.takeneat.services.api.v1;

import com.takeneat.services.api.utils.ApiConstants;
import com.takeneat.services.api.v1.dto.LoginRequestDTO;
import com.takeneat.services.api.v1.dto.UserDTO;
import com.takeneat.services.model.User;
import com.takeneat.services.users.UsersService;
import io.swagger.annotations.Api;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author paoesco
 */
@Api
@RestController
@RequestMapping(ApiConstants.PATH_V1 + "/users")
public class UsersRestController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Long login(@RequestBody LoginRequestDTO request) {
        return usersService.login(request.getEmail(), request.getPassword(), request.getMobileId());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserDTO get(@PathVariable("id") long userId) {
        User user = usersService.get(userId);
        UserDTO dto = new UserDTO();
        if (Objects.isNull(user)) {
            return dto;
        }
        dto.setEmail(user.getEmail());
        dto.setFirstname(user.getFirstname());
        dto.setId(user.getId());
        dto.setLastname(user.getLastname());
        dto.setMobileId(user.getMobileId());
        return dto;
    }

}
