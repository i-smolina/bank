package com.example.bank.service;

import com.example.bank.model.currency.CurrencyRate;
import com.example.bank.service.feignclient.CurrencyFeignClient;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CurrencyService {
    private final CurrencyFeignClient currencyFeignClient;

    @CircuitBreaker(name="currencyService")
    public Map<String, String> currencies() {
        return currencyFeignClient.currencies();
    }

   @CircuitBreaker(name="currencyService"
           //, fallbackMethod = "buildFallbackCurrencyRate"
           )
    public CurrencyRate convertCurrency(String from, String to) {
        return currencyFeignClient.convertCurrency(from, to);
    }

    @SuppressWarnings("unused")
    private Map<String, String> buildFallbackCurrencies(CallNotPermittedException e) {
        Map<String, String> emptyMap = new HashMap<>();
        emptyMap.put("No content", "Service not available");
        return emptyMap;
    }

    @SuppressWarnings("unused")
    private CurrencyRate buildFallbackCurrencyRate(String from, String to, Throwable t) {
        CurrencyRate currencyRate = new CurrencyRate();
        currencyRate.setFromCurrency(from);
        currencyRate.setToCurrency(to);
        currencyRate.setTimestamp(Timestamp.from(Instant.now()).getTime());
        currencyRate.setRate(BigDecimal.ZERO);
        return currencyRate;
    }
}
