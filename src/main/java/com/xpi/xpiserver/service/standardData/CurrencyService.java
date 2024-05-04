package com.xpi.xpiserver.service.standardData;

import org.springframework.stereotype.Service;

import java.util.Currency;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/*
 * User: Avinash Vijayvargiya
 * Date: 03/05/24
 * Time: 8:00pm
 */
@Service
public class CurrencyService {

    public Set<Currency> getAllCurrencies() {
        Set<Currency> currencies = new HashSet<>();
        Locale[] locs = Locale.getAvailableLocales();

        for (Locale loc : locs) {
            try {
                Currency currency = Currency.getInstance(loc);

                if (currency != null) {
                    currencies.add(currency);
                }
            } catch (Exception exc) {
                // Locale not found
            }
        }

        return currencies;
    }
}
