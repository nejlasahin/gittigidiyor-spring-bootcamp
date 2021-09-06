package spring.bootcamp.week3converter.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/api")
public class RestClientController {

    private static final String webUrl = "http://localhost:8080/api/getDollar";

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/{convertType}/{amount}")
    public ResponseEntity<Double> usdToTry(@PathVariable(name = "convertType") String convertType,@PathVariable(name = "amount")int amount){
        ResponseEntity<String> result= restTemplate.getForEntity(webUrl, String.class);
        String dollar = result.getBody();
        double d = Double.parseDouble(dollar);
        double cash;
        if(convertType.equals("usdToTry")){ //usdTotry
            cash=amount/d;
        }else { // tryToUsd
            cash=d*amount;
        }
        return new ResponseEntity<>(cash, HttpStatus.OK);
    }


}
