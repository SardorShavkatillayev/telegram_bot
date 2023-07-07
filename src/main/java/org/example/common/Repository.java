package org.example.common;

import javax.ws.rs.OPTIONS;
import java.util.List;
import java.util.Optional;

public interface Repository <ID,ENTITY extends BaseEntity<ID>>{
  Optional<ENTITY> findById(ID id);
    List<ENTITY> findAll();
    ENTITY add(ENTITY entity);
    void remove(ID id);


}
