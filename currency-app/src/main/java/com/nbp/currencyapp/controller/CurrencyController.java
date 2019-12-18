package com.nbp.currencyapp.controller;

import com.nbp.currencyapp.domain.CurrencyRate;
import com.nbp.currencyapp.dto.ExchangeDTO;
import com.nbp.currencyapp.service.CurrencyService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }
    @GetMapping("/currencies")
    public List<CurrencyRate> getCurrencies(){
        return currencyService.getAllCurrencyRates();
    }

    @GetMapping("/currency/convert")
    public ExchangeDTO exchangeGet(
            @RequestParam(name = "amount") BigDecimal amount,
            @RequestParam(name = "baseCurrency") String baseCurrency,
            @RequestParam(name = "targetCurrency") String targetCurrency) {
        return currencyService.convert(amount, baseCurrency, targetCurrency);
    }


    @ExceptionHandler(NumberFormatException.class)
    public String numberFormatExceptionHandler() {
        return "Given amount must be a number";
    }

    @ExceptionHandler(IllegalStateException.class)
    public String illegalStateExceptionHandler(IllegalStateException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(RestClientException.class)
    public String restClientExceptionHandler(IllegalStateException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(NoSuchElementException.class)
    public String noSuchElementExceptionHandler() {
        return "Given currency ISOcode does not exsist check list of available currencies";
    }


}
