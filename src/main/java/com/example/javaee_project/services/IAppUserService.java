package com.example.javaee_project.services;

import com.example.javaee_project.models.AppRole;
import com.example.javaee_project.models.AppUser;

import java.util.List;

public interface IAppUserService {
    AppUser saveAppUser(AppUser appUser);
    AppRole saveAppRole(AppRole appRole);
    void addRoleToUser(AppUser user, String roleName);

    AppUser getAppUser(String username);
    List<AppUser> getAppUsers();
}
