package spring.bootcamp.repository;

import java.util.List;

public interface CrudRepository<T> {
    List<T> findAll();
    void saveToDatabase(T object);
    void deleteFromDatabase(int id);
    void updateOnDatabase(T object, int id);

}
