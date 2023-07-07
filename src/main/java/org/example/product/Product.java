package org.example.product;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.common.BaseEntity;

import java.time.LocalDateTime;
import java.util.UUID;
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public class Product extends BaseEntity<UUID> {
    private String name;
    private ProductType productType;
    private double price;

    public Product(UUID uuid, LocalDateTime update, LocalDateTime created, String name, ProductType productType, double price) {
        super(uuid, update, created);
        this.name = name;
        this.productType = productType;
        this.price = price;
    }
}
