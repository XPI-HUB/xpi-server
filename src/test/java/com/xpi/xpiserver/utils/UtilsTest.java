package com.xpi.xpiserver.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xpi.xpiserver.model.standardData.Countries;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class UtilsTest {

    @TempDir
    public File tempDir;

    @Test
    public void test_readValidJsonFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode actualNode = Utils.readFile("utils/read-valid.json", objectMapper);
        List<Countries> countries = new ArrayList<>();

        for (JsonNode country : actualNode) {
            countries.add(
                    new Countries(
                            country.get("name").asText(),
                            country.get("dialCode").asText(),
                            country.get("isoCode").asText(),
                            country.get("flag").asText())
            );
        }
        assertEquals(2, countries.size());
        assertEquals("AF", countries.getFirst().getIsoCode());
        assertEquals("Afghanistan", countries.getFirst().getName());
        assertEquals("+93", countries.getFirst().getDialCode());
        assertEquals("https://cdn.kcak11.com/CountryFlags/countries/af.svg",
            countries.getFirst().getFlag());
    }

    @Test
    public void testReadFile_NotFound() {
        ObjectMapper objectMapper = new ObjectMapper();
        assertThrows(IOException.class, () -> Utils.readFile("invalid_path.json", objectMapper));
    }

    @Test
    public void testReadFile_InvalidPath() throws IOException {
        String invalidPath = "invalid/path/file.json";
        assertThrows(IOException.class, () -> Utils.readFile(invalidPath, new ObjectMapper()));
    }

    @Test
    public void testReadFile_InvalidJson() throws IOException {
        File testFile = new File(tempDir, "test.json");
        String invalidData = "This is not valid JSON";
        FileWriter writer = new FileWriter(testFile, StandardCharsets.UTF_8);
        writer.write(invalidData);
        writer.close();
        ObjectMapper objectMapper = new ObjectMapper();
        assertThrows(FileNotFoundException.class,
                () -> Utils.readFile(testFile.getPath(), objectMapper));
    }
}
