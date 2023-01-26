package me.alekseinovikov.polarbookshop.polarbookshopcatalogservice.controller;

import lombok.RequiredArgsConstructor;
import me.alekseinovikov.polarbookshop.polarbookshopcatalogservice.config.PolarProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor

@RestController
public class HomeController {

    private final PolarProperties polarProperties;

    @GetMapping("/")
    public String home() {
        return polarProperties.getGreeting();
    }

}
