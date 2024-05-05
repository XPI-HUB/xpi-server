package com.xpi.xpiserver.controller.eCommerce;

import com.google.zxing.WriterException;
import com.xpi.xpiserver.service.eCommerce.QRCodeService;
import java.awt.image.BufferedImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class QRCodeController {

    @Autowired
    QRCodeService qRCodeService;

    @GetMapping(path = "/qrCode", produces = "image/jpg")
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public BufferedImage generateQRcode(final @RequestParam String text) throws WriterException {
        return qRCodeService.generateQRcode(text);
    }
}
