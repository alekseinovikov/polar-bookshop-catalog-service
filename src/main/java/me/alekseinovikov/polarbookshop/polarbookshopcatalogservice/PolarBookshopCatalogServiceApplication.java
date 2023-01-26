package me.alekseinovikov.polarbookshop.polarbookshopcatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class PolarBookshopCatalogServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PolarBookshopCatalogServiceApplication.class, args);
    }

}
