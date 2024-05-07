package com.xpi.xpiserver.controller.standardData;

import com.xpi.xpiserver.service.standardData.TimeZoneService;
import java.util.HashMap;
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
class TimeZoneControllerTest {

    @InjectMocks
    private TimeZoneController timeZoneController;

    @Mock
    private TimeZoneService timeZoneService;


    @Test
    public void test_getTimeZone() {
        timeZoneController.getTimeZones();
        Mockito.verify(timeZoneService).getTimeZone();
    }

    @Test
    public void test_getTimeZoneByIds() {
        List<String> listOfTimeZone = List.of("Africa/Abidjan");
        HashMap<String, String> actualMapOfTimeZone = new HashMap<>();
        actualMapOfTimeZone.put("Asia/Aden", "GMT+3:00");
        when(timeZoneService.getTimeZoneById(listOfTimeZone))
            .thenReturn(new ResponseEntity<>(actualMapOfTimeZone, HttpStatus.OK));
        ResponseEntity<HashMap<String, String>> expectedMapOfTimeZone =
            timeZoneController.getTimeZoneFromIds(listOfTimeZone);
        Mockito.verify(timeZoneService).getTimeZoneById(listOfTimeZone);
        assertEquals(Objects.requireNonNull(expectedMapOfTimeZone.getBody()).size(),
            listOfTimeZone.size());
        assertNotNull(expectedMapOfTimeZone.getBody());
        assertEquals(HttpStatus.OK, expectedMapOfTimeZone.getStatusCode());
    }
}
