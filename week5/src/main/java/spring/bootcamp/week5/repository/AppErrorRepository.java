package spring.bootcamp.week5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.bootcamp.week5.model.AppError;

public interface AppErrorRepository extends JpaRepository<AppError, Long> {
}
