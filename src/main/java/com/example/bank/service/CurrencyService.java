package com.example.bank.service;

import com.example.bank.model.currency.CurrencyRate;
import com.example.bank.service.feignclient.CurrencyFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CurrencyService {
    private final CurrencyFeignClient currencyFeignClient;

    public Map<String, String> currencies() {
        return currencyFeignClient.currencies();
    }

    public CurrencyRate convertCurrency(String from, String to) {
        return currencyFeignClient.convertCurrency(from, to);
    }
}
