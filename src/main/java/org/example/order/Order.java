package org.example.order;

import org.telegram.telegrambots.meta.api.objects.Location;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.common.BaseEntity;
import org.example.product.Product;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor

public class Order extends BaseEntity<UUID> {

    private List<Product> list;
    private Location location;
    private String cookId;
    private String customerId;
    private String courirId;
    private OrderState orderState;



    @Builder
    public Order(UUID uuid, LocalDateTime update, LocalDateTime created,
                 List<Product> list, Location location, String cookId,
                 String customerId, String courirId, OrderState orderState) {
        super(uuid, update, created);
        this.list = list;
        this.location = location;
        this.cookId = cookId;
        this.customerId = customerId;
        this.courirId = courirId;
        this.orderState = orderState;
    }
}
