package com.altimetrik.ocrbatch.service;

import com.altimetrik.ocrbatch.entity.ApplicationDetails;
import com.altimetrik.ocrbatch.entity.FileStorage;
import com.altimetrik.ocrbatch.repository.FileStorageRepository;
import com.altimetrik.ocrbatch.utils.Utils;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

@Service
public class GrossPayrollFormProcessingService {

    @Autowired
    private FileStorageRepository fileStorageRepository;

    @Autowired
    private Tesseract tesseract;

    public ApplicationDetails processGrossPayroll(ApplicationDetails appDetails, FileStorage fileStorage) throws IOException, TesseractException, ParseException {

        BufferedImage bufferedImage = Utils.createImageFromBytes(fileStorage.getIrs941());
        String result = tesseract.doOCR(bufferedImage);

        String[] lines = result.split("\n");
        System.out.println("SIZE: " + lines.length);

        String grossTotals = lines[28];
        String[] lineWords = grossTotals.split(" ");
        String sbaGrossPay = lineWords[1];
        NumberFormat format = NumberFormat.getCurrencyInstance();
        Number number1 = format.parse(sbaGrossPay);
        System.out.println("sbaGrossPay : " +number1.toString());

        String empStateLocalTaxes = lineWords[2];
//        NumberFormat format = NumberFormat.getCurrencyInstance();
        Number number = format.parse(empStateLocalTaxes);

        System.out.println("empStateLocalTaxes : " +number.toString());

        appDetails.setPaymentEmployerPayrollTaxesStateLocal(Double.valueOf(number.toString()));

        return null;
    }

}
