package spring.bootcamp.week2.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface StudentDAO<Student> extends BaseDAO<Student> {
}
