package com.xpi.xpiserver.controller.eCommerce;

import com.xpi.xpiserver.service.eCommerce.BarCodeService;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BarCodeController {

    private final BarCodeService barCodeService;

    public BarCodeController(final BarCodeService barCodeService) {
        this.barCodeService = barCodeService;
    }

    @GetMapping(path = "/barcode", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<Resource> generateBarCode(final @RequestParam String text)
        throws IOException, OutputException, BarcodeException {
        byte[] bytes = barCodeService.generateBarCode(text);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Disposition", "attachment; filename=your_file_name");
        return ResponseEntity.ok()
            .headers(headers)
            .contentLength(bytes.length)
            .contentType(MediaType.IMAGE_PNG)
            .body(new InputStreamResource(new ByteArrayInputStream(bytes)));
    }
}
