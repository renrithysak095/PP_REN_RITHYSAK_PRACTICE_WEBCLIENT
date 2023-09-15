package com.example.practice_webclient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Main", version = "1.0", description = "Rithysak Ren"))
public class PracticeWebclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticeWebclientApplication.class, args);
    }

}
