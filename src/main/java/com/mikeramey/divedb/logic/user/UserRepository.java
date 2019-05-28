package com.mikeramey.divedb.logic.user;

import com.mikeramey.divedb.logic.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    User getUserByUserName(String username);

    User save(User user);
}
