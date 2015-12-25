package com.takeneat.services.api.v1;

import com.takeneat.services.api.exceptions.BadRequestException;
import com.takeneat.services.api.exceptions.NotFoundException;
import com.takeneat.services.api.utils.ApiConstants;
import com.takeneat.services.api.v1.dto.LoginRequestDTO;
import com.takeneat.services.api.v1.dto.UserDTO;
import com.takeneat.services.model.User;
import com.takeneat.services.users.UsersService;
import io.swagger.annotations.Api;
import java.util.Objects;
import javax.validation.Valid;
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
    public Long login(@RequestBody @Valid LoginRequestDTO request) throws BadRequestException {
        Long userId = usersService.login(request.getEmail(), request.getPassword(), request.getMobileId());
        if (userId == null) {
            throw new BadRequestException("Wrong credentials");
        }
        return userId;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserDTO get(@PathVariable("id") long userId) throws NotFoundException {
        User user = usersService.get(userId);
        if (Objects.isNull(user)) {
            throw new NotFoundException(String.valueOf(userId));
        }
        UserDTO dto = new UserDTO();
        dto.setEmail(user.getEmail());
        dto.setFirstname(user.getFirstname());
        dto.setId(user.getId());
        dto.setLastname(user.getLastname());
        dto.setMobileId(user.getMobileId());
        return dto;
    }

}
