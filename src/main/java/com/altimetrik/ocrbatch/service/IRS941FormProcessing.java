package com.altimetrik.ocrbatch.service;

import com.altimetrik.ocrbatch.entity.ApplicationDetails;
import com.altimetrik.ocrbatch.entity.FileStorage;
import com.altimetrik.ocrbatch.repository.FileStorageRepository;
import net.sourceforge.tess4j.Tesseract;
import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;

@Service
public class IRS941FormProcessing {

    @Autowired
    private FileStorageRepository fileStorageRepository;

    @Autowired
    private Tesseract tesseract;


    public ApplicationDetails processIrs941(ApplicationDetails appDetails, FileStorage fileStorage) {

        JSONObject appFieldCommentsObj = new JSONObject(appDetails.getFieldComments());
        JSONObject appAutoVerifiedObj = new JSONObject(appDetails.getFieldAutoVerified());

        byte[] bytes = fileStorage.getIrs941();

//        BufferedImage bufferedImage = Utils.createImageFromBytes(fileStorage.getIrs941());

        String name = "irs941."+ FilenameUtils.getExtension(fileStorage.getIrs941OrginalFilesName());

        System.out.println("name " + name);

        String irs941ocroutput = null;
        try {
            File convFile = new File(name);
            convFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(bytes);
            fos.close();
            irs941ocroutput = tesseract.doOCR(convFile);

            convFile.delete();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("EXCEPTION! Skipping IRS941 OCR processing for FileStorage with ID: " + fileStorage.getBlobID());

            return appDetails;
        }


        try {
            String[] lines = irs941ocroutput.split("\n");
            System.out.println("SIZE: " + lines.length);

            String wages = lines[16];
            String[] lineWords = wages.split(" ");
            System.out.println(wages);
            String number = "";
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
            appAutoVerifiedObj.put("empWages", "Y");
        }catch (Exception e) {
            e.printStackTrace();
            appFieldCommentsObj.put("empWages", e.getMessage());
        }

        //Saving the updated JSON fields
        appDetails.setFieldAutoVerified(appFieldCommentsObj.toString());
        appDetails.setFieldAutoVerified(appAutoVerifiedObj.toString());

        return appDetails;
    }

}
