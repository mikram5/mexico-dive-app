package com.mikeramey.divedb.logic.user;

import com.mikeramey.divedb.logic.user.User;

public interface UserRepository {

    User getUserByUserName(String username);

    User save(User user);
}
