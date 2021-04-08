package application.service;

import application.domen.SubInsuredObject;
import application.service.risks.FireRisk;
import application.service.risks.Risk;
import application.service.risks.TheftRisk;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
/**
 * @return Hashmap in which key is type of the risk of sub-insured object and
 * value is function of premium calculation of particular risk.
 *
 */
public class RiskCalculationMapHolder {
    List<Risk> allAddedRisks;

    public RiskCalculationMapHolder(){
        allAddedRisks = new ArrayList<>();
        FireRisk fireRisk = new FireRisk();
        TheftRisk theftRisk = new TheftRisk();
        allAddedRisks.add(fireRisk);
        allAddedRisks.add(theftRisk);
    }

    Map<String, Function<List<SubInsuredObject>, BigDecimal>> riskCalculationMap (){
        Map<String, Function<List<SubInsuredObject>, BigDecimal>> map = new HashMap<>();
        for (Risk allAddedRisk : allAddedRisks) {
            map.put(allAddedRisk.getRiskType().name(), allAddedRisk::calculatePremium);
        }
        return map;
    }
}
