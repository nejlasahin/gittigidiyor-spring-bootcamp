package spring.bootcamp.week5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.bootcamp.week5.model.InstructorTransactionLogger;

public interface InstructorTransactionLoggerRepository extends JpaRepository<InstructorTransactionLogger, Long> {
}
