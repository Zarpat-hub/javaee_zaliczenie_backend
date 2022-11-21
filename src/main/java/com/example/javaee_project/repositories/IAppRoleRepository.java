package com.example.javaee_project.repositories;

import com.example.javaee_project.models.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppRoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findByName(String name);
}
