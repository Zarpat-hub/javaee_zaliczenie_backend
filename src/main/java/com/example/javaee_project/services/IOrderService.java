package com.example.javaee_project.services;

import com.example.javaee_project.models.DTO.OrderDTO;
import com.example.javaee_project.models.AppOrder;

import java.util.List;

public interface IOrderService {
    AppOrder saveOrder(OrderDTO orderDTO);
    AppOrder getOrder(Long id);
    List<AppOrder> getAllUserOrders(String username);
}
