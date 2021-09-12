package spring.bootcamp.week4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.bootcamp.week4.model.AppError;

public interface AppErrorRepository extends JpaRepository<AppError, Long> {
}
