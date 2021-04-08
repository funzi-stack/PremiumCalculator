package application.service;

import application.domen.InsuredObject;
import application.domen.Policy;
import application.domen.SubInsuredObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class InsurancePremiumCalculator {

    RiskCalculationMapHolder mapHolder = new RiskCalculationMapHolder();
    /**
     * @param policy
     * @return calculated premium in BigDecimal format.
     */
    public BigDecimal calculate(Policy policy) {
        BigDecimal premium = BigDecimal.ZERO;
        List<InsuredObject> insuredObjects = policy.getInsuredObjects();
        List<SubInsuredObject> subInsuredObjects = getSubInsuredObjects(insuredObjects);
        for (RiskType riskType : RiskType.values()) {
            Map<String, Function<List<SubInsuredObject>, BigDecimal>> tempMap = mapHolder.riskCalculationMap();
            Function<List<SubInsuredObject>, BigDecimal> targetFunction = tempMap.getOrDefault(riskType.name(), e -> new BigDecimal("0"));
            premium = premium.add(targetFunction.apply(subInsuredObjects));
        }
        return premium;
    }
    /**
     * @param insuredObjects
     * @return list of sub-insured objects.
     */
    List<SubInsuredObject> getSubInsuredObjects(List<InsuredObject> insuredObjects) {
        List<SubInsuredObject> subInsuredObjects = new ArrayList<>();
        for (InsuredObject insuredObject : insuredObjects) {
            subInsuredObjects.addAll(insuredObject.getSubInsuredObjects());
        }
        return subInsuredObjects;
    }
}
