package com.xpi.xpiserver.controller.dataExtraction;

import com.xpi.xpiserver.service.dataExtraction.ReadabilityService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api")
public class ReadabilityController {

    @Autowired
    ReadabilityService readabilityService;

    @PostMapping(path = "/readability", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String readability(final @RequestBody MultipartFile file) throws IOException {
        return readabilityService.readability(file);
    }
}
