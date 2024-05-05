package com.xpi.xpiserver.service.eCommerce;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.imgscalr.Scalr;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageThumbnailService {
    public BufferedImage resizeImage(final MultipartFile file, final int y) throws IOException {
        byte[] bytes = file.getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        BufferedImage image = ImageIO.read(inputStream);
        BufferedImage resizedImage = Scalr.resize(image, y);
        File outputfile = new File("resize.jpg");
        try {
            ImageIO.write(resizedImage, "jpg", outputfile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return resizedImage;
    }
}
