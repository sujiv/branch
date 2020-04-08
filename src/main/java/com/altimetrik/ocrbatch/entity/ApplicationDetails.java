package com.altimetrik.ocrbatch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer userInputId;
    private Double FTE_Emp12MnthsPrior;
    private Double empWages;
    private Double lessOwnerWagesExcess100K;
    private Double lessQualifiedSickLeaveWagesUnderFFCRA;
    private Double lessQualifiedFamilyLeaveWagesUnderFFCRA;
    private Double groupHealthCareBenefitsInsPremium;
    private Double paymentRetirementBen;
    private Double paymentEmployerPayrollTaxesStateLocal;
    private Double contractLabor;
    private Double lessIndividualContractLaborExcess100K;
    private Double prior12MnthsCumQualifyingPayrollCost;
    private Double avgMonthlyPayrollcosts;
    private Double multiplier2dot5;
    private Double EDIL_ObtainedFrmJan31ToBeRefinanced;    //Double?
    private Double PPP_LoadAmntLesserOfCalcOr10Mil;    //Double?
    private String fieldComments;   //Contains JSON as string
    private String fieldAutoVerified;   //Contains JSON as string
    private String applicationComments;
    private Boolean processedFlag = false;
    private String processStatus;
    private Timestamp createdTs;

}
