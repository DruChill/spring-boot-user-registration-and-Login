package net.enjoy.springboot.registrationlogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class RegistrationLoginApplication {

    public static void main(String[] args) {

        //agrega esto importante
        Dotenv dotenv = Dotenv.load();
                System.setProperty("SPRING_DATASOURCE_USERNAME", dotenv.get("SPRING_DATASOURCE_USERNAME"));
                System.setProperty("SPRING_DATASOURCE_PASSWORD", dotenv.get("SPRING_DATASOURCE_PASSWORD"));
        //hasta aquí

        SpringApplication.run(RegistrationLoginApplication.class, args);
    }
}
