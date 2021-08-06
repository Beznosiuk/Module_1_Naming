package com.epam.engx.cleancode.naming.task1.delivery;

import com.epam.engx.cleancode.naming.task1.OrderService;
import com.epam.engx.cleancode.naming.task1.thirdpartyjar.DeliveryService;
import com.epam.engx.cleancode.naming.task1.thirdpartyjar.NotDeliverableOrderException;
import com.epam.engx.cleancode.naming.task1.thirdpartyjar.Order;
import com.epam.engx.cleancode.naming.task1.thirdpartyjar.OrderFulfilmentService;
import com.epam.engx.cleancode.naming.task1.thirdpartyjar.Product;

import java.util.List;

public class DeliveryOrderService implements OrderService {

    private DeliveryService deliveryService;
    private OrderFulfilmentService orderFulfilmentService;

    public void setDeliveryService(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    public void setOrderFulfilmentService(OrderFulfilmentService orderFulfilmentService) {
        this.orderFulfilmentService = orderFulfilmentService;
    }

    @Override
    public void submitOrder(Order order) {
        if (deliveryService.isDeliverable(order)) {
            List<Product> products = order.getProducts();
            orderFulfilmentService.fulfilProducts(products);
        } else {
            throw new NotDeliverableOrderException();
        }
    }
}
