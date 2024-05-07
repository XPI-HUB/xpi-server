package com.xpi.xpiserver.controller.standardData;

import com.xpi.xpiserver.model.standardData.Countries;
import com.xpi.xpiserver.service.standardData.CountriesService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CountriesControllerTest {

    @InjectMocks
    private CountriesController countriesController;

    @Mock
    private CountriesService countriesService;

    @Test
    void test_getAllCountries_whenSuccess() throws IOException {
        List<Countries> expectedCountriesList = new ArrayList<>();
        expectedCountriesList.add(
                new Countries("Afghanistan",
                        "+93",
                        "AF",
                        "https://cdn.kcak11.com/CountryFlags/countries/af.svg"));
        expectedCountriesList.add(
                new Countries("India",
                        "+91",
                        "IN",
                        "https://cdn.kcak11.com/CountryFlags/countries/in.svg"));

        when(countriesService.getAllCountries())
                .thenReturn(new ResponseEntity<>(expectedCountriesList, HttpStatus.OK));
        ResponseEntity<List<Countries>> actualCountriesList = countriesController.getAllCountries();

        Mockito.verify(countriesService).getAllCountries();
        assertEquals(actualCountriesList.getBody(), expectedCountriesList);
        assertEquals(HttpStatus.OK, actualCountriesList.getStatusCode());
        assertEquals(2, Objects.requireNonNull(actualCountriesList.getBody()).size());
        assertNotNull(actualCountriesList.getBody());
    }
}
