package com.altimetrik.ocrbatch.service;

import com.altimetrik.ocrbatch.entity.ApplicationDetails;
import com.altimetrik.ocrbatch.entity.FileStorage;
import com.altimetrik.ocrbatch.repository.FileStorageRepository;
import com.altimetrik.ocrbatch.utils.Utils;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.io.FilenameUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

@Service
public class GrossPayrollFormProcessingService {

    @Autowired
    private FileStorageRepository fileStorageRepository;

    @Autowired
    private Tesseract tesseract;

    public ApplicationDetails processGrossPayroll(ApplicationDetails appDetails, FileStorage fileStorage) throws IOException, TesseractException {

        JSONObject appCommentsObj = new JSONObject(appDetails.getApplicationComments());
        JSONObject appAutoVerifiedObj = new JSONObject(appDetails.getFieldAutoVerified());

        byte[] bytes = fileStorage.getGrossPayroll();
//        BufferedImage bufferedImage = Utils.createImageFromBytes(fileStorage.getGrossPayroll());
        String name = "payroll."+ FilenameUtils.getExtension(fileStorage.getGrossPayrollOrginalFilesName());

        System.out.println("name " + name);
        File convFile = new File(name);
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(bytes);
        fos.close();

        String payrollOcrResult = tesseract.doOCR(convFile);

        convFile.delete();

        String[] lines = payrollOcrResult.split("\n");
        System.out.println("SIZE: " + lines.length);

        String grossTotals = lines[28];
        String[] lineWords = grossTotals.split(" ");
        System.out.println(grossTotals);
        String sbaGrossPay = lineWords[1];
        NumberFormat format = NumberFormat.getCurrencyInstance();

        System.out.println("sbaGrossPay " + sbaGrossPay);
        Number number1 = null;
        try {
            number1 = format.parse(sbaGrossPay);
            System.out.println("sbaGrossPay : " +number1.toString());
            //TODO: set SBS GROSS PAY VALUE to appDetails
        } catch (ParseException e) {
            e.printStackTrace();
            //TODO: set SBS GROSS PAY exception comment to appDetails
        }

        String empStateLocalTaxes = lineWords[2];
        Number number = null;
        try {
            number = format.parse(empStateLocalTaxes);
            System.out.println("empStateLocalTaxes : " +number.toString());

            appDetails.setPaymentEmployerPayrollTaxesStateLocal(Double.valueOf(number.toString()));
        } catch (ParseException e) {
            e.printStackTrace();
            appCommentsObj.put("paymentEmployerPayrollTaxesStateLocal", e.getMessage());

        }

        try {
            String empBenifts = lineWords[4].replaceAll("[^0-9]", "");
            System.out.println("empBenifts : " +empBenifts);
            appDetails.setPaymentRetirementBen(Double.valueOf(empBenifts));
            appAutoVerifiedObj.put("paymentRetirementBen", "Y");
        }catch (Exception e) {
            e.printStackTrace();
            appCommentsObj.put("paymentRetirementBen", e.getMessage());
        }

        try {
            String payrollCost = lineWords[5].replaceAll("[^0-9]", "");
            System.out.println("payrollCost : " +payrollCost);
            appDetails.setPrior12MnthsCumQualifyingPayrollCost(Double.valueOf(payrollCost));
            appAutoVerifiedObj.put("prior12MnthsCumQualifyingPayrollCost", "Y");
        }catch (Exception e) {
            e.printStackTrace();
            appCommentsObj.put("prior12MnthsCumQualifyingPayrollCost", e.getMessage());
        }


        try {
            String AvgTotals = lines[29];
            System.out.println(AvgTotals);
            String[] AvgTotalWords = AvgTotals.split(" ");
            String AvgVal = AvgTotalWords[1];
            Number number3 = null;
            number3 = format.parse(AvgVal);
            System.out.println("AvgVal : " +number3);
            appDetails.setAvgMonthlyPayrollcosts(Double.valueOf(number3.toString()));
            appAutoVerifiedObj.put("paymentEmployerPayrollTaxesStateLocal", "Y");
        } catch (Exception e) {
            e.printStackTrace();
            appCommentsObj.put("paymentEmployerPayrollTaxesStateLocal", e.getMessage());
        }

        try {
            //for restricting to 2 decimals
            Double valueForCal2dot5 = appDetails.getAvgMonthlyPayrollcosts()* 2.5d;
            DecimalFormat df = new DecimalFormat("#.##");
            valueForCal2dot5 = Double.valueOf(df.format(valueForCal2dot5));
            appDetails.setMultiplier2dot5(valueForCal2dot5);

            appAutoVerifiedObj.put("multiplier2dot5", "Y");
        }catch (Exception e) {
            e.printStackTrace();
            appCommentsObj.put("multiplier2dot5", e.getMessage());
        }

        try {
            if(appDetails.getMultiplier2dot5() > 10000000.00)
                appDetails.setPPP_LoadAmntLesserOfCalcOr10Mil(10000000.00);
            else
                appDetails.setPPP_LoadAmntLesserOfCalcOr10Mil(appDetails.getMultiplier2dot5());

            appAutoVerifiedObj.put("PPP_LoadAmntLesserOfCalcOr10Mil", "Y");
        }catch (Exception e) {
            e.printStackTrace();
            appCommentsObj.put("PPP_LoadAmntLesserOfCalcOr10Mil", e.getMessage());
        }

        return appDetails;
    }

}
