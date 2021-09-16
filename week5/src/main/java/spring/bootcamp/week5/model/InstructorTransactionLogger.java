package spring.bootcamp.week5.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.bootcamp.week5.enums.InstructorType;
import spring.bootcamp.week5.enums.TransactionType;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "instructors_salary_change")
public class InstructorTransactionLogger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long instructorId;
    private double salaryBefore;
    private double salaryAfter;
    private double transactionRate;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    private LocalDate transactionDateTime;
    private String clientIpAddress;
    private String clientUrl;
    private String sessionActivityId;

}
