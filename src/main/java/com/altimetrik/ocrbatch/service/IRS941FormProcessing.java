package com.altimetrik.ocrbatch.service;

import com.altimetrik.ocrbatch.entity.ApplicationDetails;
import com.altimetrik.ocrbatch.entity.FileStorage;
import com.altimetrik.ocrbatch.repository.FileStorageRepository;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.aspectj.apache.bcel.classfile.LineNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class IRS941FormProcessing {

    @Autowired
    private FileStorageRepository fileStorageRepository;

    @Autowired
    private Tesseract tesseract;

    public ApplicationDetails processIrs941(ApplicationDetails appDetails, FileStorage fileStorage) throws IOException, TesseractException {

        byte[] bytes = fileStorage.getIrs941();

        File convFile = new File("irs");
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(fileStorage.getIrs941());
        fos.close();

        String irs941ocroutput = tesseract.doOCR(convFile);

        String[] lines = irs941ocroutput.split("\n");
        System.out.println("SIZE: " + lines.length);

        String wages = lines[16];
        String[] lineWords = wages.split(" ");
        System.out.println(wages);
        String number = "";
        int counter = 0;
        for (int i=lineWords.length-1; i>0; i--)
        {
            if(lineWords[i].equals("2"))
            {
                break;
            }
            else {
                number = lineWords[i].replaceAll("[^a-zA-Z0-9]", ".")+ number;
            }
        }

        appDetails.setEmpWages(Double.valueOf(number));

        return appDetails;
    }

}
