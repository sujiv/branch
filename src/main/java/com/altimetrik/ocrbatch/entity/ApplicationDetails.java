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
public class ApplicationDetails {

    //    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;

    private String legalName;
    private String primaryContact;
    private String businessPhone;
    private String TIN_EIN_SIN;
    private String accounts;    //????????
    private String email;
    private String FTE_Emp12MnthsPrior;
    private String empWages;    //Double?
    private String lessOwnerWagesExcess100K;    //Double / Int ?
    private String lessQualifiedSickLeaveWagesUnderFFCRA;    //Double / Int ?
    private String lessQualifiedFamilyLeaveWagesUnderFFCRA;    //Double / Int ?
    private String groupHealthCareBenefitsInsPremium;    //Double / Int ?
    private String paymentRetirementBen;
    private String paymentEmployerPayrollTaxesStateLocal;
    private String contractLabor;
    private String lessIndividualContractLaborExcess100K;    //Double / Int ?
    private String prior12MnthsCumQualifyingPayrollCost;    //Double / Int ?
    private String avgMonthlyPayrollcosts;    //Double / Int ?
    private String multiplier2dot5;    //Double?
    private String EDIL_ObtainedFrmJan31ToBeRefinanced;    //Double?
    private String PPP_LoadAmntLesserOfCalcOr10Mil;    //Double?
    private String fieldComments;    //TEXT? Varchar(255) is not enough
    private String fieldAutoVerified;    //TEXT? Varchar(255) is not enough
    private String applicationComments;    //TEXT? Varchar(255) is not enough
    private Integer blobID;    //TEXT? Varchar(255) is not enough
    private Timestamp createdTs;    //TEXT? Varchar(255) is not enough

//    WHY LEFT OUT?????
    private String tradeName;
    private BusinessEntityType businessEntityType;
    private Double avgMonthlyPayroll;
    private Integer noOfJobs;
    private Boolean nonProfit = false;
    private Boolean vetOrg = false;
    private Boolean tribal = false;
    private Boolean indCont = false;
    private Boolean selfEmployed = false;
    private String additionalInfo;

    private Boolean isBatchProcessed = false;


}
