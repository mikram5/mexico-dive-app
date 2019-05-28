package com.mikeramey.divedb.logic.user;

import com.mikeramey.divedb.logic.model.Role;

public interface RoleRepository {

    Role findByRole(String role);

}
