package com.xpi.xpiserver.controller.standardData;

import com.xpi.xpiserver.model.standardData.Countries;
import com.xpi.xpiserver.service.standardData.CountriesService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/*
 * User: Avinash Vijayvargiya
 * Date: 03/05/24
 * Time: 11:09pm
 */
@RestController
@RequestMapping("/api")
public class CountriesController {

    @Autowired
    private CountriesService countriesService;

    @GetMapping("/getAllCountries")
    public ResponseEntity<List<Countries>> getAllCountries() throws IOException {
        return countriesService.getAllCountries();
    }
}
