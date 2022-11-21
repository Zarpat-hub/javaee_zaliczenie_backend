package com.example.javaee_project.repositories;

import com.example.javaee_project.models.AppOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<AppOrder, Long> {
}
