package com.heaven.learningspringboot.controller;

import com.heaven.learningspringboot.CurrencyServiceConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    private final CurrencyServiceConfig currency;

    public CurrencyController(CurrencyServiceConfig currency) {
        this.currency = currency;
    }

    @GetMapping
    public CurrencyServiceConfig getCurrency() {
        return currency;
    }
}
