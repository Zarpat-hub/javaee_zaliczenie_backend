package com.example.javaee_project.controllers;

import com.example.javaee_project.models.DTO.OrderDTO;
import com.example.javaee_project.models.AppOrder;
import com.example.javaee_project.services.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173")
public class OrderController {
    private final IOrderService orderService;

    @PostMapping
    public ResponseEntity<AppOrder> makeOrder(@RequestBody OrderDTO orderDTO)
    {
        return ResponseEntity.ok(orderService.saveOrder(orderDTO));
    }
}
