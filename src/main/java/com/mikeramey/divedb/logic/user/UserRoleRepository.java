package com.mikeramey.divedb.logic.user;

public interface UserRoleRepository {

    void addUserRoleLink(int userId, int roleId);
}
