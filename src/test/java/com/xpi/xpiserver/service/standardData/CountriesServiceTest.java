package com.xpi.xpiserver.service.standardData;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xpi.xpiserver.model.standardData.Countries;
import com.xpi.xpiserver.utils.Utils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class CountriesServiceTest {
    @InjectMocks
    private CountriesService countriesService;

    @TempDir
    public File tempDir;

    @Test
    public void getAllCountries_whenSuccess() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode actualNode = Utils.readFile("utils/read-valid.json", objectMapper);
        List<Countries> expectedCountries = new ArrayList<>();

        for (JsonNode country : actualNode) {
            expectedCountries.add(
                    new Countries(
                            country.get("name").asText(),
                            country.get("dialCode").asText(),
                            country.get("isoCode").asText(),
                            country.get("flag").asText())
            );
        }
        ResponseEntity<List<Countries>> response = countriesService.getAllCountries();
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
