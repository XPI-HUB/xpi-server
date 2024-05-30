package com.xpi.xpiserver.service.standardData;

import java.util.Currency;
import java.util.Objects;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class CurrencyServiceTest {

    @InjectMocks
    private CurrencyService currencyService;

    @Test
    public void test_getAllCurrencies() {
        ResponseEntity<Set<Currency>> currencies = currencyService.getAllCurrencies();
        Assertions.assertEquals(currencies.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(Objects.requireNonNull(currencies.getBody()).size(), 156);
    }

}
