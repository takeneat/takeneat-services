package com.takeneat.services.users;

import com.takeneat.services.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
     * @param mobileId : Id of the mobile. Store it if successful login.
     * @return
     */
    @Transactional
    public Long login(String email, String password, String mobileId) {
        User user = userDao.findByEmail(email);
        if (user == null) {
            throw new IllegalArgumentException("User does not exist");
        }
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (passwordEncoder.matches(password, user.getPassword())) {
            // adding mobile id when login. We keep the most up to date mobile phone
            // to which we will send notifications
            user.setMobileId(mobileId);
            return user.getId();
        }
        return null;
    }

    public User get(long userId) {
        return userDao.findOne(userId);
    }

}
