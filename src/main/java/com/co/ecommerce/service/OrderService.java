package com.co.ecommerce.service;

import com.co.ecommerce.repository.*;
import com.co.ecommerce.entity.*;
import com.co.ecommerce.web.dto.OrderDTO;
import com.co.ecommerce.web.dto.OrderDetailDTO;
import com.co.ecommerce.web.mapper.OrderDetailMapper;
import com.co.ecommerce.web.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;
    private final ShipperRepository shipperRepository;
    private final ProductRepository productRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final OrderMapper orderMapper;
    private final OrderDetailMapper orderDetailMapper;

    // Create Order
    public void createOrder(OrderDTO orderDTO) {
        // Retrieve the customer, employee, and shipper from the database
        Customer customer = customerRepository.findById(orderDTO.getCustomerId())
                .orElseThrow(
                        () -> new RuntimeException("Customer not found")
                );
        Employee employee = employeeRepository.findById(orderDTO.getEmployeeId())
                .orElseThrow(
                        () -> new RuntimeException("Employee not found")
                );
        Shipper shipper = shipperRepository.findById(orderDTO.getShipperId())
                .orElseThrow(
                        () -> new RuntimeException("Shipper not found")
                );

        // Create a new Order object
        Order order = orderMapper.mapOrderDTOToOrder(orderDTO);
        order.setCustomer(customer);
        order.setEmployee(employee);
        order.setShipper(shipper);
        order.setOrderDate(LocalDate.now());

        // Create OrderDetails
        List<OrderDetail> orderDetails = new ArrayList<>();
        for (OrderDetailDTO orderDetailDTO : orderDTO.getOrderDetails()) {
            Product product = productRepository.findById(orderDetailDTO.getProductId())
                    .orElseThrow(
                            () -> new RuntimeException("Product not found")
                    );
            OrderDetail orderDetail = orderDetailMapper.mapOrderDetailDTOToOrderDetail(orderDetailDTO);
            orderDetail.setOrder(order);
            orderDetail.setProduct(product);
            orderDetail.setQuantity(orderDetailDTO.getQuantity());
            orderDetails.add(orderDetail);
        }
        order.setOrderDetails(orderDetails);

        // Save the order
        orderRepository.save(order);
    }

    // Find All Orders
    public List<OrderDTO> getOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(order -> {
                    OrderDTO orderDTO = orderMapper.mapOrderToOrderDTO(order);
                    orderDTO.setOrderDetails(orderMapper.mapOrderDetailsToOrderDetailDTO(order.getOrderDetails()));
                    return orderDTO;
                })
                .collect(Collectors.toList());
    }

    // Find Oder by ID
    public OrderDTO getOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(
                        () -> new RuntimeException ("Order not found")
                );
        OrderDTO orderDTO = orderMapper.mapOrderToOrderDTO(order);
        orderDTO.setOrderDetails(orderMapper.mapOrderDetailsToOrderDetailDTO(order.getOrderDetails()));
        return orderDTO;
    }

    // Deleted Order By ID
    public void deletedOrderById(Long orderId){
        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new RuntimeException("Order not found")
        );
        orderRepository.delete(order);
    }

    // Update Order
    public void updateOrder(OrderDTO orderDTO) {
        Order order = orderRepository.findById(orderDTO.getOrderId())
                .orElseThrow(
                        () -> new RuntimeException("Order not found")
                );

        // Update order details
        order.setCustomer(customerRepository.findById(orderDTO.getCustomerId())
                .orElseThrow(
                        () -> new RuntimeException("Customer not found")
                ));
        order.setEmployee(employeeRepository.findById(orderDTO.getEmployeeId())
                .orElseThrow(
                        () -> new RuntimeException("Employee not found")
                ));
        order.setShipper(shipperRepository.findById(orderDTO.getShipperId())
                .orElseThrow(
                        () -> new RuntimeException("Shipper not found")
                ));
        order.setOrderDate(LocalDate.now());

        // Update order details
        List<OrderDetail> existingOrderDetails = order.getOrderDetails();
        existingOrderDetails.clear();

        for (OrderDetailDTO orderDetailDTO : orderDTO.getOrderDetails()) {
            Product product = productRepository.findById(orderDetailDTO.getProductId())
                    .orElseThrow(
                            () -> new RuntimeException("Product not found")
                    );
            OrderDetail orderDetail;
            if (orderDetailDTO.getOrderId() != null) {
                orderDetail = orderDetailRepository.findById(orderDetailDTO.getOrderId())
                        .orElseThrow(
                                () -> new RuntimeException("Order detail not found")
                        );
            } else {
                orderDetail = new OrderDetail();
            }
            orderDetailMapper.mapOrderDetailDTOToOrderDetail(orderDetailDTO);
            orderDetail.setOrder(order);
            orderDetail.setProduct(product);
            orderDetail.setQuantity(orderDetailDTO.getQuantity());
            existingOrderDetails.add(orderDetail);
        }

        // Save the updated order
        orderRepository.save(order);

        // Return the updated order DTO
        OrderDTO updatedOrderDTO = orderMapper.mapOrderToOrderDTO(order);
        updatedOrderDTO.setOrderDetails(orderMapper.mapOrderDetailsToOrderDetailDTO(order.getOrderDetails()));
    }

}


