package com.xpi.xpiserver.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class HelloControllerTest {

    @InjectMocks
    private HelloController helloController;

    @Test
    public void hello() {
        assertEquals("Hello", helloController.hello());
    }

    @Test
    public void test_whenInputIsSingle() {
        Map<String, String> actualMap = new HashMap<>();
        actualMap.put("key","value");
        Map<String, String> expectedMap = helloController.hellos(actualMap);
        assertEquals(expectedMap.size(), actualMap.size());
        assertEquals(expectedMap.get("key"), actualMap.get("key"));
        assertEquals(expectedMap.get("key"), "value");
        assertEquals(expectedMap, actualMap);
    }

    @Test
    public void test_whenInputIsEmpty() {
        Map<String, String> actualMap = new HashMap<>();
        Map<String, String> expectedMap = helloController.hellos(actualMap);
        assertEquals(expectedMap.size(), actualMap.size());
        assertEquals(expectedMap.get("key"), actualMap.get("key"));
        assertNull(expectedMap.get("key"));
        assertEquals(expectedMap, actualMap);
    }

}