package com.carlhuffmeier.petclinic.services.map;

import com.carlhuffmeier.petclinic.models.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object) {

        if (object == null) {
            throw new RuntimeException("Object cannot be null");
        }

        if (object.getId() == null) {
            object.setId(getNextId());
        }

        map.put(object.getId(), object);
        return object;
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    private Long getNextId() {
        if (map.size() == 0) {
            return 1L;
        }
        return Collections.max(map.keySet()) + 1;
    }
}
