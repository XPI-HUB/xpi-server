package com.xpi.xpiserver.service.standardData;

/*
 * User: Avinash Vijayvargiya
 * Date: 04/05/24
 * Time: 3:17am
 */

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xpi.xpiserver.model.standardData.Countries;
import com.xpi.xpiserver.utils.Utils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



@Service
public class CountriesService {
    public ResponseEntity<List<Countries>> getAllCountries() {
        try {
            List<Countries> countries = new ArrayList<>();
            JsonNode jsonNode = Utils.readFile("static/countriesData.json", new ObjectMapper());
            for (JsonNode country : jsonNode) {
                countries.add(
                        new Countries(
                                country.get("name").asText(),
                                country.get("dialCode").asText(),
                                country.get("isoCode").asText(),
                                country.get("flag").asText())
                );
            }
            return new ResponseEntity<>(countries, HttpStatus.OK);
        } catch (IOException ioException) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
