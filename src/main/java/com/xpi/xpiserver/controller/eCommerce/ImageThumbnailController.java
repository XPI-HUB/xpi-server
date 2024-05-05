package com.xpi.xpiserver.controller.eCommerce;

import com.xpi.xpiserver.service.eCommerce.ImageThumbnailService;
import java.awt.image.BufferedImage;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class ImageThumbnailController {

    @Autowired
    private ImageThumbnailService imageThumbnailService;

    @PostMapping(path = "/resize",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = "image/png")
    public BufferedImage resizeImage(final @RequestPart("file") MultipartFile file,
                                     final @RequestParam int y)
            throws IOException{
        return imageThumbnailService.resizeImage(file,y);
    }
}
