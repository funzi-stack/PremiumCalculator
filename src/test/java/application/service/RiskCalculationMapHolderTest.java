package application.service;

import application.domen.SubInsuredObject;
import application.service.risks.FireRisk;
import application.service.risks.Risk;
import application.service.risks.TheftRisk;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class RiskCalculationMapHolderTest {
    public RiskCalculationMapHolder victim;
    List<Risk> allAddedRisks;

    @BeforeEach
    void setUp() {
        victim = new RiskCalculationMapHolder();
        allAddedRisks = new ArrayList<>();
        FireRisk fireRisk = new FireRisk();
        TheftRisk theftRisk = new TheftRisk();
        allAddedRisks.add(fireRisk);
        allAddedRisks.add(theftRisk);
    }

    @Test
    void testRiskCalculationMap() {
        Map<String, Function<List<SubInsuredObject>, BigDecimal>> actualResult = victim.riskCalculationMap();
        assertEquals(2, actualResult.size());
    }
}