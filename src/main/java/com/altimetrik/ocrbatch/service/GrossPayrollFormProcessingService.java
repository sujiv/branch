package com.altimetrik.ocrbatch.service;

import com.altimetrik.ocrbatch.entity.ApplicationDetails;
import com.altimetrik.ocrbatch.entity.FileStorage;
import com.altimetrik.ocrbatch.repository.FileStorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class GrossPayrollFormProcessingService {

    @Autowired
    private FileStorageRepository fileStorageRepository;

    public ApplicationDetails processGrossPayroll(ApplicationDetails appDetails, FileStorage fileStorage) throws IOException {

        File convFile = new File("test");
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(fileStorage.getGrossPayroll());
        fos.close();

//        String grossPayrollText = tesseract.doOCR(convFile);



        return null;
    }

}
