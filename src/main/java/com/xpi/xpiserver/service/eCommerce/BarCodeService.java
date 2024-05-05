package com.xpi.xpiserver.service.eCommerce;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;
import org.springframework.stereotype.Service;



@Service
public class BarCodeService {
    public BufferedImage generateBarCode(final String text)
            throws BarcodeException, OutputException {
        Barcode barcode = BarcodeFactory.createCode128(text.toLowerCase());
        File outputfile = new File("barcode.jpg");
        try {
            ImageIO.write(BarcodeImageHandler.getImage(barcode), "jpg", outputfile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return BarcodeImageHandler.getImage(barcode);
    }
}
