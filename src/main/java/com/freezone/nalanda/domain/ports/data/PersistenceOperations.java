package com.freezone.nalanda.domain.ports.data;

import java.util.List;

public interface PersistenceOperations<T> {

    T save(T t);

    void saveAll(List<T> its);

    T get(String id);

    T update(T t);

    void delete(String id);
}
