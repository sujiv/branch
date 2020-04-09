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
    private String fieldAutoVerified = "{\"FTE_Emp12MnthsPrior\":\"N\",\"empWages\":\"N\",\"lessOwnerWagesExcess100K\":\"N\",\"lessQualifiedSickLeaveWagesUnderFFCRA\":\"N\",\"lessQualifiedFamilyLeaveWagesUnderFFCRA\":\"N\",\"groupHealthCareBenefitsInsPremium\":\"N\",\"paymentRetirementBen\":\"N\",\"paymentEmployerPayrollTaxesStateLocal\":\"N\",\"contractLabor\":\"N\",\"lessIndividualContractLaborExcess100K\":\"N\",\"prior12MnthsCumQualifyingPayrollCost\":\"N\",\"avgMonthlyPayrollcosts\":\"N\",\"multiplier2dot5\":\"N\",\"EDIL_ObtainedFrmJan31ToBeRefinanced\":\"N\",\"PPP_LoadAmntLesserOfCalcOr10Mil\":\"N\"}\n";
    private String applicationComments = "{\n" +
            "    \"FTE_Emp12MnthsPrior\": \"\",\n" +
            "    \"empWages\": \"\",\n" +
            "    \"lessOwnerWagesExcess100K\": \"\",\n" +
            "    \"lessQualifiedSickLeaveWagesUnderFFCRA\": \"\",\n" +
            "    \"lessQualifiedFamilyLeaveWagesUnderFFCRA\": \"\",\n" +
            "    \"groupHealthCareBenefitsInsPremium\": \"\",\n" +
            "    \"paymentRetirementBen\": \"\",\n" +
            "    \"paymentEmployerPayrollTaxesStateLocal\": \"\",\n" +
            "    \"contractLabor\": \"\",\n" +
            "    \"lessIndividualContractLaborExcess100K\": \"\",\n" +
            "    \"prior12MnthsCumQualifyingPayrollCost\": \"\",\n" +
            "    \"avgMonthlyPayrollcosts\": \"\",\n" +
            "    \"multiplier2dot5\": \"\",\n" +
            "    \"EDIL_ObtainedFrmJan31ToBeRefinanced\": \"\",\n" +
            "    \"PPP_LoadAmntLesserOfCalcOr10Mil\": \"\"\n" +
            "}";
    private Boolean processedFlag = false;
    private String processStatus;
    private Timestamp createdTs;

}
