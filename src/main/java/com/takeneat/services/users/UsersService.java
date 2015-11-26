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
     * @param email : email of the user who tries to log in
     * @param password : raw password
     * @return
     */
    public Long login(String email, String password) {
        User user = userDao.findByEmail(email);
        if (user == null) {
            throw new IllegalArgumentException("User does not exist");
        }
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (passwordEncoder.matches(password, user.getPassword())) {
            return user.getId();
        }
        return null;
    }

}
