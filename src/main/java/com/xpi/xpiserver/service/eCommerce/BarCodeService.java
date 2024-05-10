package com.xpi.xpiserver.service.eCommerce;

import java.io.ByteArrayOutputStream;
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
    public byte[] generateBarCode(final String text)
        throws BarcodeException, OutputException, IOException {
        Barcode barcode = BarcodeFactory.createCode128(text);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(BarcodeImageHandler.getImage(barcode),
            "png", byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
