package com.mikeramey.divedb.logic.repository;

import com.mikeramey.divedb.logic.model.Role;

public interface RoleRepository {

    Role findByRole(String role);

}
