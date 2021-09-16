package spring.bootcamp.week5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class Week5Application {

    public static void main(String[] args) {
        SpringApplication.run(Week5Application.class, args);
    }

}
