package com.xpi.xpiserver.service.standardData;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/*
 * User: Avinash Vijayvargiya
 * Date: 03/05/24
 * Time: 6:01pm
 */

@Service
public class TimeZoneService {

    public HashMap<String, String> getTimeZone() {
        HashMap<String, String> mapOfTimeZone = new HashMap<>();
        for (String id : TimeZone.getAvailableIDs()) {
            mapOfTimeZone.put(id, getTimeZoneById(TimeZone.getTimeZone(id)));
        }
        return mapOfTimeZone;
    }

    public HashMap<String, String> getTimeZoneById(List<String> timeZoneIds) {
        HashMap<String, String> mapOfTimeZone = new HashMap<>();
        for (String id : timeZoneIds) {
            mapOfTimeZone.put(id, getTimeZoneById(TimeZone.getTimeZone(id)));
        }
        return mapOfTimeZone;
    }

    private String getTimeZoneById(TimeZone timeZone) {
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
