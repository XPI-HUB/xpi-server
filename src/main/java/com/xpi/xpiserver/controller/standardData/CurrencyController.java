package com.xpi.xpiserver.controller.standardData;


import com.xpi.xpiserver.service.standardData.CurrencyService;
import java.util.Currency;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/*
 * User: Avinash Vijayvargiya
 * Date: 03/05/24
 * Time: 7:59pm
 */

@RestController
@RequestMapping("/api")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/getAllCurrency")
    public ResponseEntity<Set<Currency>> getAllCurrency() {
        return currencyService.getAllCurrencies();
    }
}
