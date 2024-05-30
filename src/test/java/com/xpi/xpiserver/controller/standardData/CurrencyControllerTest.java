package com.xpi.xpiserver.controller.standardData;

import com.xpi.xpiserver.service.standardData.CurrencyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CurrencyControllerTest {

    @Mock
    private CurrencyService currencyService;

    @InjectMocks
    private CurrencyController currencyController;

    @Test
    public void test_whenCurrencyWhenSuccess() {
        currencyController.getAllCurrency();
        Mockito.verify(currencyService, Mockito.times(1)).getAllCurrencies();
    }
}
