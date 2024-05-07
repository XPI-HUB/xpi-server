package com.xpi.xpiserver.service.standardData;

import java.util.Currency;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/*
 * User: Avinash Vijayvargiya
 * Date: 03/05/24
 * Time: 8:00pm
 */

@Service
public class CurrencyService {
    public ResponseEntity<Set<Currency>> getAllCurrencies() {
        Set<Currency> currencies = new HashSet<>();
        try {
            Locale[] locs = Locale.getAvailableLocales();
            for (Locale loc : locs) {
                try {
                    Currency currency = Currency.getInstance(loc);
                    if (currency != null) {
                        currencies.add(currency);
                    }
                } catch (Exception e) {
                    //                Do Nothing
                }
            }
            return new ResponseEntity<>(currencies, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(currencies, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
