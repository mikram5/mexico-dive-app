package com.mikeramey.divedb.logic.repository;

import com.mikeramey.divedb.logic.model.User;
import org.springframework.stereotype.Repository;

public interface UserRepository {

    User getUserByUserName(String username);

    User save(User user);
}
