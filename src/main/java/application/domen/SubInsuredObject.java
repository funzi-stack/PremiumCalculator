package application.domen;

import application.service.RiskType;

import java.math.BigDecimal;
import java.util.List;
/**
 * Policy sub-objects can be related only to one policy object.
 * The class represent insured items (e.g. electronic devices such as TV).
 */
public class SubInsuredObject {
    private String name;
    private BigDecimal sumInsured;
    private List<RiskType> insuranceRisks;

    public SubInsuredObject(String name, BigDecimal sumInsured, List<RiskType> insuranceRisks) {
        this.name = name;
        this.sumInsured = sumInsured;
        this.insuranceRisks = insuranceRisks;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getSumInsured() {
        return sumInsured;
    }

    public List<RiskType> getInsuranceRisks() {
        return insuranceRisks;
    }
}
