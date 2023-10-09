package com.example.bank.controller;

import com.example.bank.model.currency.CurrencyRate;
import com.example.bank.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class CurrencyController {
    private final CurrencyService currencyService;

    @GetMapping("currencies")
    public Map<String, String> currencies() {
        return currencyService.currencies();
    }

    @GetMapping("currency/rate/{from}/{to}")
    public CurrencyRate currencyRate(@PathVariable String from, @PathVariable String to) {
        return currencyService.convertCurrency(from, to);
    }
}
