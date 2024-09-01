package com.co.ecommerce.web;

import com.co.ecommerce.service.OrderService;
import com.co.ecommerce.web.dto.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestBody OrderDTO orderDTO) {
        orderService.createOrder(orderDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDTO> getOrders() {
        return orderService.getOrders();
    }

    @GetMapping("/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public OrderDTO getOrder(@PathVariable long orderId) {
        return orderService.getOrderById(orderId);
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOrderById(@PathVariable long orderId) {
        orderService.deletedOrderById(orderId);
    }

    @PutMapping("/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateOrder(@PathVariable long orderId, @RequestBody OrderDTO orderDTO) {
        orderDTO.setOrderId(orderId);
        orderService.updateOrder(orderDTO);
    }

}
