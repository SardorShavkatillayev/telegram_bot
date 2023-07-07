package org.example.order;

import org.example.product.ProductRepository;
import org.example.user.User;
import org.telegram.telegrambots.meta.api.objects.Location;

import java.time.LocalDateTime;

public class OrderService {
    private final Orderrepository orderrepository = Orderrepository.getInstance();

    public Order createOrder(Location location, User user) {
        Order order = Order.builder()
                .location(location)
                .customerId(user.getId())
                .created(LocalDateTime.now())
                .orderState(OrderState.ADD_PRODUCT)
                .update(LocalDateTime.now()).
                build();
        orderrepository.add(order);
        return order;


    }

}
