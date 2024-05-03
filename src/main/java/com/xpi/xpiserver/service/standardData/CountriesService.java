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
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CountriesService {
    public List<Countries> getAllCountries() throws IOException {
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
        return countries;
    }
}
