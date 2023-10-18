package com.example.bank.kafka;

import com.example.bank.model.currency.CurrencyRate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class CurrencyRateListener {
    @KafkaListener(topics = "${currency.topic.name}", groupId = "currency-rate",
            properties = {"com.example.bank.model.currency.CurrencyRate"})
    public CurrencyRate listenCurrencyRate(CurrencyRate rate) {
        System.out.println("Received:" + rate.getRate());
        return rate;
    }
}
