package org.example.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class BaseRepositoty<ID, ENTITY extends BaseEntity<ID>> implements Repository<ID, ENTITY> {

    private final List<ENTITY> entityList = new ArrayList<>();

    @Override
    public Optional<ENTITY> findById(ID id) {
        return entityList.stream().filter(entity -> entity.getId().equals(id)).findFirst();
    }

    @Override
    public List<ENTITY> findAll() {
        return entityList;
    }

    @Override
    public ENTITY add(ENTITY entity) {
        System.out.println(entity);
        entityList.add(entity);
        return entity;
    }

    @Override
    public void remove(ID id) {
        entityList.removeIf(entity -> entity.getId().equals(id));
    }
}
