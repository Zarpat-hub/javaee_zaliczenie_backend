package com.example.javaee_project.services;

import com.example.javaee_project.models.AppRole;
import com.example.javaee_project.models.AppUser;
import com.example.javaee_project.repositories.IAppRoleRepository;
import com.example.javaee_project.repositories.IAppUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AppUserService implements IAppUserService{
    private final IAppUserRepository appUserRepository;
    private final IAppRoleRepository appRoleRepository;

    @Override
    public AppUser saveAppUser(AppUser appUser) {
        log.info("Saving new user {} to the database", appUser.getUsername());
        addRoleToUser(appUser, "ROLE_USER");
        return appUserRepository.save(appUser);
    }

    @Override
    public AppRole saveAppRole(AppRole appRole) {
        log.info("Saving new role {} to the database",appRole.getName());
        return appRoleRepository.save(appRole);
    }

    @Override
    public void addRoleToUser(AppUser user, String roleName) {
        log.info("Adding role {} to user {}", roleName, user.getUsername());
        AppRole role = appRoleRepository.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public AppUser getAppUser(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> getAppUsers() {
        return appUserRepository.findAll();
    }
}
