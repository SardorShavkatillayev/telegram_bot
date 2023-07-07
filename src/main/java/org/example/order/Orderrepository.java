package org.example.order;

import org.example.common.BaseRepositoty;

import java.util.UUID;

public class Orderrepository extends BaseRepositoty<UUID, Order> {

    private static final Orderrepository orderrepository = new Orderrepository();

    private Orderrepository() {}


    public static Orderrepository getInstance() {
        return orderrepository;
    }
}
