package io.github.gustavocortes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Main {

    @GetMapping("/projetoBase")
    public String projetoBase(){
        return "base";
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}