package com.altimetrik.ocrbatch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInput {

    @Id
    private Integer userInputId;

    private String legalName;
    private String primaryContact;
    private String businessPhone;
    private String TIN_EIN_SIN;
    private String accounts;    //????????
    private String email;
    private Boolean nonProfit = false;
    private Boolean vetOrg = false;
    private Boolean tribal = false;
    private Boolean indCont = false;
    private Boolean selfEmp = false;
    private String tradeName;
    private String businessEntityType;
    private Double avgMonthlyPayrollcosts;
    private Integer numJobs;
    private String addInfo;
    private Boolean eligibilityLine1 = false;
    private Boolean eligibilityLine2 = false;
    private Boolean eligibilityLine3 = false;
    private Boolean eligibilityLine4 = false;
    private Boolean eligibilityLine5 = false;
    private Boolean eligibilityLine6 = false;
    private Boolean certifyLine1 = false;
    private Boolean certifyLine2 = false;
    private Boolean certifyLine3 = false;
    private Boolean certifyLine4 = false;
    private Boolean certifyLine5 = false;
    private Boolean certifyLine6 = false;
    private Boolean certifyLine7 = false;
    private String signatureAuthRep;
    private String signatureOwner;
    private Boolean irs941Uploaded = false;
    private Boolean healthcareCostsUploaded = false;
    private Boolean grossPayrollUploaded = false;

    private String status;  //ENUM ?
//    private Timestamp createdTs;

//    private Boolean isBatchProcessed = false;


}
