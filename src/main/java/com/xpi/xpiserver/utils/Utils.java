package com.xpi.xpiserver.utils;

/*
 * User: Avinash Vijayvargiya
 * Date: 04/05/24
 * Time: 3:14am
 */

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.springframework.core.io.ClassPathResource;


public class Utils {
    public static JsonNode readFile(final String path, final ObjectMapper objectMapper)
            throws IOException {
        return objectMapper
                .readTree(new ClassPathResource(path)
                        .getFile());
    }
}
