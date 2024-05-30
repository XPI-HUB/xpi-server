package com.xpi.xpiserver.service.standardData;

import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


/*
 * User: Avinash Vijayvargiya
 * Date: 03/05/24
 * Time: 6:01pm
 */

@Service
public class TimeZoneService {

    public ResponseEntity<HashMap<String, String>> getTimeZone() {
        HashMap<String, String> mapOfTimeZone = new HashMap<>();
        try {
            for (String id : TimeZone.getAvailableIDs()) {
                mapOfTimeZone.put(id, getTimeZoneById(TimeZone.getTimeZone(id)));
            }
            return new ResponseEntity<>(mapOfTimeZone, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(mapOfTimeZone, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<HashMap<String, String>> getTimeZoneById(final List<String> timeZoneIds) {
        HashMap<String, String> mapOfTimeZone = new HashMap<>();
        try {
            for (String id : timeZoneIds) {
                mapOfTimeZone.put(id, getTimeZoneById(TimeZone.getTimeZone(id)));
            }
            return new ResponseEntity<>(mapOfTimeZone, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(mapOfTimeZone, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private String getTimeZoneById(final TimeZone timeZone) {
        long hours = TimeUnit.MILLISECONDS
                .toHours(timeZone.getRawOffset());
        long minutes = TimeUnit.MILLISECONDS
                .toMinutes(timeZone.getRawOffset()) - TimeUnit.HOURS.toMinutes(hours);
        minutes = Math.abs(minutes);

        String result;
        if (hours > 0) {
            result = String.format("GMT+%d:%02d", hours, minutes);
        } else {
            result = String.format("GMT%d:%02d", hours, minutes);
        }
        return result;
    }


}
