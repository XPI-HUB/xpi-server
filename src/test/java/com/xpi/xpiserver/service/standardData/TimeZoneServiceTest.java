package com.xpi.xpiserver.service.standardData;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class TimeZoneServiceTest {

    @InjectMocks
    private TimeZoneService timeZoneService;

    @Test
    public void test_getTimeZone_whenStatusOk() {
        ResponseEntity<HashMap<String, String>> response = timeZoneService.getTimeZone();
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        HashMap<String, String> responseBody = response.getBody();
        assertNotNull(responseBody);
        assertEquals(631, responseBody.size());

    }

    @Test
    public void test_getTimeZoneByIds_whenStatusOk() {
        List<String> listOfTimeZone = List.of("Africa/Abidjan");
        ResponseEntity<HashMap<String, String>> response =
            timeZoneService.getTimeZoneById(List.of("Africa/Abidjan"));
        assertEquals(Objects.requireNonNull(response.getBody()).size(), 1);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(listOfTimeZone, response.getBody().keySet().stream().toList());
    }
}
