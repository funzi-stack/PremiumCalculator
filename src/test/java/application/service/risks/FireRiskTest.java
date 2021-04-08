package application.service.risks;

import application.domen.SubInsuredObject;
import application.service.RiskType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

class FireRiskTest {
    private SubInsuredObject subInsuredObject1;
    private SubInsuredObject subInsuredObject2;
    List<RiskType> insuranceRisks;
    private FireRisk victim;
    List<SubInsuredObject> subObjects;

    @BeforeEach
    void setUp() {
        victim = new FireRisk();
        insuranceRisks = new ArrayList<>();
        insuranceRisks.add(RiskType.FIRE);
        subInsuredObject1 = new SubInsuredObject("TV", new BigDecimal("99"), insuranceRisks);
        subInsuredObject2 = new SubInsuredObject("Notebook", new BigDecimal("101"), insuranceRisks);
    }

    @Test
    void testCalculatePremium1() {
        subObjects = new ArrayList<>();
        subObjects.add(subInsuredObject1);
        BigDecimal expectedResult = new BigDecimal("1.386");
        BigDecimal actualResult = victim.calculatePremium(subObjects);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    void testCalculatePremium2() {
        subObjects = new ArrayList<>();
        subObjects.add(subInsuredObject2);
        BigDecimal expectedResult = new BigDecimal("2.424");
        BigDecimal actualResult = victim.calculatePremium(subObjects);
        assertEquals(expectedResult, actualResult);
    }
}