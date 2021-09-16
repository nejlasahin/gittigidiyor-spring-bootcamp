package spring.bootcamp.week5.model;

/**
 * @author Nejla Sahin
 * @version 1.0
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.bootcamp.week5.model.abstracts.BaseEntity;

import javax.persistence.*;

/**
 * Represents an App Error inherited from BaseEntity class.
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "app_error_response")
public class AppError extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // The status of this App Error.
    @Column(name = "status")
    private int status;

    // The message of this App Error.
    @Column(name = "message")
    private String message;

    // The timestamp of this App Error.
    @Column(name = "timestamp")
    private long timestamp;
}
