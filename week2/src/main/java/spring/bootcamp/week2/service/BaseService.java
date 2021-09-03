package spring.bootcamp.week2.service;

import java.util.List;

public interface BaseService<T> {
    List<T> findAll();
    T findById (int id);
    T save (T object);
    void update (T object);
    void deleteById (int id);
    void deleteByObject (T object);
}
