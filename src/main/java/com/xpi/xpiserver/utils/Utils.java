package com.xpi.xpiserver.utils;
/*
 * User: Avinash Vijayvargiya
 * Date: 04/05/24
 * Time: 3:14am
 */

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class Utils {
    public static JsonNode readFile(String path, ObjectMapper objectMapper) throws IOException {
        return objectMapper
                .readTree(new ClassPathResource(path)
                        .getFile());
    }
}
