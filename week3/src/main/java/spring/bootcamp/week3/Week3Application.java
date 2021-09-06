package spring.bootcamp.week3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class Week3Application {


    public static void main(String[] args) {
        SpringApplication.run(Week3Application.class, args);
    }

}
