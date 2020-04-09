package com.altimetrik.ocrbatch.service;

import com.altimetrik.ocrbatch.entity.FileStorage;
import com.altimetrik.ocrbatch.repository.FileStorageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class DBFileStorageService {

    @Autowired
    private FileStorageRepository fileStorageRepository;

    public FileStorage storeFile(MultipartFile irs941, MultipartFile payroll) throws IOException {
        // Normalize file name
        FileStorage fileStorage = new FileStorage(irs941.getBytes(),irs941.getBytes(),payroll.getBytes());
        return fileStorageRepository.save(fileStorage);

    }

//    public DBFile getFile(String fileId) {
//        return dbFileRepository.findById(fileId)
//                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
//    }
//
//    private BufferedImage createImageFromBytes(byte[] imageData) {
//        ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
//        try {
//            return ImageIO.read(bais);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    /*private BufferedFile createImageFromBytes(byte[] imageData) {
//        ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
//        try {
//            return ImageIO.read(bais);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }*/
//
//    public String readFile(String id) throws IOException, TesseractException, ParseException {
//
//        DBFile f = dbFileRepository.getDBFileById(id);
//
//        Tesseract tesseract = new Tesseract();
//
//        tesseract.setDatapath("src/main/resources/tessdata");
//        tesseract.setLanguage("eng");
//
////        byte[] bytes = f.getData();
//
//        /*System.out.println("pay.PNG");
//
//        File convFile = new File("pay.png");
//        convFile.createNewFile();
//        FileOutputStream fos = new FileOutputStream(convFile);
//        fos.write(f.getData());
//        fos.close();*/
//
//        BufferedImage bufferedImage = createImageFromBytes(f.getData());
//        String result = tesseract.doOCR(bufferedImage);
//
////        String[] lines = result.split("\n");
////        System.out.println("SIZE: " + lines.length);
////
////        String grossTotals = lines[28];
////        String[] lineWords = grossTotals.split(" ");
////        String sbaGrossPay = lineWords[1];
////        NumberFormat format = NumberFormat.getCurrencyInstance();
////        Number number1 = format.parse(sbaGrossPay);
////        System.out.println("empStateLocalTaxes : " +number1.toString());
////
////        String empStateLocalTaxes = lineWords[2];
//////        NumberFormat format = NumberFormat.getCurrencyInstance();
////        Number number = format.parse(empStateLocalTaxes);
////
////        System.out.println("empStateLocalTaxes : " +number.toString());
////
////        System.out.println(lineWords[1]);
////        System.out.println(lineWords[2]);
//
////        System.out.println(wages);
////        String number = "";
////        int counter = 0;
////        for (int i=lineWords.length-1; i>0; i--)
////        {
////            if(lineWords[i].equals("2"))
////            {
////                break;
////            }
////            else {
////                number = lineWords[i].replaceAll("[^a-zA-Z0-9]", ".")+ number;
////            }
////        }
////
//        return result;
//    }
}