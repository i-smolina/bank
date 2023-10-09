package com.example.bank.model.currency;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CurrencyRate {
    private long timestamp;
    private String fromCurrency;
    private String toCurrency;
    private BigDecimal rate;
}
