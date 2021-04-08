package application.service.risks;

import application.domen.SubInsuredObject;
import application.service.RiskType;

import java.math.BigDecimal;
import java.util.List;

public class TheftRisk implements Risk{
    private static final BigDecimal equalOrGreaterSum = new BigDecimal("15");
    private static final BigDecimal overCoefficient = new BigDecimal("0.05");
    private static final BigDecimal defaultCoefficient = new BigDecimal("0.11");

    @Override
    public BigDecimal calculatePremium(List<SubInsuredObject> subObjects) {
        List<SubInsuredObject> targetSubInsuredObject = getSubObjectListByRiskType(subObjects, getRiskType());
        BigDecimal sumInsuredFire = new BigDecimal("0");
        for (SubInsuredObject subInsuredObject : targetSubInsuredObject) {
            sumInsuredFire = sumInsuredFire.add(subInsuredObject.getSumInsured());
        }

        if (sumInsuredFire.compareTo(equalOrGreaterSum) >= 0) {
            return sumInsuredFire.multiply(overCoefficient);
        } else {
            return sumInsuredFire.multiply(defaultCoefficient);
        }
    }

    @Override
    public RiskType getRiskType() {
        return RiskType.THEFT;
    }

}
