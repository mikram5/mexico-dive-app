package com.mikeramey.divedb.logic.repository;

import com.mikeramey.divedb.logic.model.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.List;

public interface UserRepository {

    User getUserByUserNameAndPassword(String username, String password);
}
