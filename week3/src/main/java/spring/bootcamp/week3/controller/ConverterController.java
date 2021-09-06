package spring.bootcamp.week3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/getDollar")
public class ConverterController {
    @GetMapping
    public double getDollar(){
        double dollar = 8.35;
        return dollar;
    }
}
