package application.service.risks;

import application.domen.SubInsuredObject;
import application.service.RiskType;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public interface Risk {
    default List<SubInsuredObject> getSubObjectListByRiskType(List<SubInsuredObject> subInsuredObjects, RiskType risk) {
        return subInsuredObjects.stream()
                .filter(subObjects -> subObjects.getInsuranceRisks().contains(risk))
                .collect(Collectors.toList());
    }

    BigDecimal calculatePremium(List<SubInsuredObject> subObjects);
    RiskType getRiskType();
}
