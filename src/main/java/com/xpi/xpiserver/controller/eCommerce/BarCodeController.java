package com.xpi.xpiserver.controller.eCommerce;

import com.xpi.xpiserver.service.eCommerce.BarCodeService;
import java.awt.image.BufferedImage;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BarCodeController {

    @Autowired
    BarCodeService barCodeService;

    @GetMapping(path = "/barCode", produces = MediaType.IMAGE_PNG_VALUE)
    public BufferedImage generateBarCode(final @RequestParam String text)
            throws OutputException, BarcodeException {
        return barCodeService.generateBarCode(text);
    }
}
