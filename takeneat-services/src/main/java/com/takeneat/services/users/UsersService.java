package com.takeneat.services.users;

import com.takeneat.services.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Service managing users.
 *
 * @author paoesco
 */
@Service
public class UsersService {

    @Autowired
    private UserDao userDao;

    /**
     * Login method. Test password against encoded password in database.
     *
     * @param userId : id of the user who tries to log in
     * @param password : raw password
     * @return
     */
    public boolean login(Long userId, String password) {
        User user = userDao.findOne(userId);
        if (user == null) {
            throw new IllegalArgumentException("User does not exist");
        }
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(password, user.getPassword());
    }

}
