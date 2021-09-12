package spring.bootcamp.week4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class Week4Application {

    public static void main(String[] args) {
        SpringApplication.run(Week4Application.class, args);
    }

}
