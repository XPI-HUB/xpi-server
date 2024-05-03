package com.xpi.xpiserver.controller.standardData;
/*
 * User: Avinash Vijayvargiya
 * Date: 03/05/24
 * Time: 7:59pm
 */

import com.xpi.xpiserver.service.standardData.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Currency;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class CurrencyController {

@Autowired
private CurrencyService currencyService;

    @GetMapping("/getAllCurrency")
    public Set<Currency> getAllCurrency() {
        return currencyService.getAllCurrencies();
    }
}
