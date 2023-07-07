package org.example.product;

import org.example.common.BaseRepositoty;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class ProductRepository extends BaseRepositoty<UUID, Product> {
    {
        List<Product> all = findAll();
        Product lavash = new Product(UUID.randomUUID(), LocalDateTime.now(), LocalDateTime.now(), "pitsa 30 sm", ProductType.MEAL, 27000);
        Product lavashBig = new Product(UUID.randomUUID(), LocalDateTime.now(), LocalDateTime.now(), " pitsa 45sm ", ProductType.MEAL, 31000);
        Product muzqaymoq = new Product(UUID.randomUUID(), LocalDateTime.now(), LocalDateTime.now(), "muzqaymoq shkaladli", ProductType.DESRT, 10000);
        Product muzqaymoq1 = new Product(UUID.randomUUID(), LocalDateTime.now(), LocalDateTime.now(), "muzqaymoq desert", ProductType.DESRT, 10000);
        Product cola = new Product(UUID.randomUUID(), LocalDateTime.now(), LocalDateTime.now(), "COLA", ProductType.DRINK, 10000);
        Product fanta = new Product(UUID.randomUUID(), LocalDateTime.now(), LocalDateTime.now(), "FANTA", ProductType.DRINK, 13000);
        Product ice = new Product(UUID.randomUUID(), LocalDateTime.now(), LocalDateTime.now(), "ICE", ProductType.DRINK, 9000);
        Product qahva = new Product(UUID.randomUUID(), LocalDateTime.now(), LocalDateTime.now(), "Qahva", ProductType.DRINK, 9000);
        Product sok = new Product(UUID.randomUUID(), LocalDateTime.now(), LocalDateTime.now(), "SOK DESERT", ProductType.DRINK, 30000);

        all.add(lavash);
        all.add(lavashBig);
        all.add(muzqaymoq);
        all.add(muzqaymoq1);
        all.add(cola);
        all.add(fanta);
        all.add(ice);
        all.add(qahva);
        all.add(sok);


    }

    private static final ProductRepository repository = new ProductRepository();

    private ProductRepository() {
    }

    public static ProductRepository getInstance() {
        return repository;
    }
}
