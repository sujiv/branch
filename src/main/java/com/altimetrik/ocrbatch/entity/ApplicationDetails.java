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
    private Integer userInputId;
    private Double FTE_Emp12MnthsPrior = 0.0;
    private Double empWages = 0.0;
    private Double lessOwnerWagesExcess100K = 0.0;
    private Double lessQualifiedSickLeaveWagesUnderFFCRA = 0.0;
    private Double lessQualifiedFamilyLeaveWagesUnderFFCRA = 0.0;
    private Double groupHealthCareBenefitsInsPremium = 0.0;
    private Double paymentRetirementBen = 0.0;
    private Double paymentEmployerPayrollTaxesStateLocal = 0.0;
    private Double contractLabor = 0.0;
    private Double lessIndividualContractLaborExcess100K = 0.0;
    private Double prior12MnthsCumQualifyingPayrollCost = 0.0;
    private Double avgMonthlyPayrollcosts = 0.0;
    private Double multiplier2dot5 = 0.0;
    private Double EDIL_ObtainedFrmJan31ToBeRefinanced = 0.0;
    private Double PPP_LoadAmntLesserOfCalcOr10Mil = 0.0;
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
    private Timestamp createdTs = new Timestamp(System.currentTimeMillis());

}
