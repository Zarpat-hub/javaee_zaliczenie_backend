package com.example.javaee_project.services;

import com.example.javaee_project.models.AppUser;
import com.example.javaee_project.models.DTO.OrderDTO;
import com.example.javaee_project.models.AppOrder;
import com.example.javaee_project.models.Product;
import com.example.javaee_project.repositories.IOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService{
    private final IOrderRepository orderRepository;
    private final IProductService productService;
    private final IAppUserService userService;

    @Override
    public AppOrder saveOrder(OrderDTO orderDTO) {
        AppOrder appOrder = new AppOrder();
        List<Product> products = orderDTO.getProductIds().stream().map(id -> productService.getProductById(id)).collect(Collectors.toList());
        double totalCost = products.stream()
                .reduce(0.0, (subtotal, element) -> subtotal + element.getPrice(), Double::sum);
        AppUser user = userService.getAppUser(orderDTO.getUsername());

        appOrder.setProducts(products);
        appOrder.setTotalCost(totalCost);
        appOrder.setUserId(user.getId());

        return orderRepository.save(appOrder);
    }

    @Override
    public AppOrder getOrder(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public List<AppOrder> getAllUserOrders(String username) {
        return orderRepository.findAll().stream().filter(o -> o.getUserId() == userService.getAppUser(username).getId()).collect(Collectors.toList());
    }
}
