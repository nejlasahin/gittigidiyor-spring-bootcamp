package spring.bootcamp.repository;

import java.util.List;

public interface StudentRepository<T> {
    List<T> studentListByGender(char gender);
    List<T> studentListByCourse(int courseId);
}
