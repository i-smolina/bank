package com.example.bank.service.feignclient;

import com.example.bank.model.currency.CurrencyRate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient("currency-service")
public interface CurrencyFeignClient {
    @RequestMapping(method = RequestMethod.GET, value = "currencies", consumes = "application/json")
    Map<String, String> currencies();

    @GetMapping("currency/rate/{from}/{to}")
    CurrencyRate convertCurrency(@PathVariable String from, @PathVariable String to);
}
