package com.takeneat.services.users;

import com.takeneat.services.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author paoesco
 */
public interface UserDao extends JpaRepository<User, Long> {

}
