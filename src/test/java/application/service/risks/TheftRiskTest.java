package application.service.risks;

import application.domen.SubInsuredObject;
import application.service.RiskType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class TheftRiskTest {
    private SubInsuredObject subInsuredObject1;
    private SubInsuredObject subInsuredObject2;
    private SubInsuredObject subInsuredObject3;
    List<RiskType> insuranceRisks;
    private TheftRisk victim;
    List<SubInsuredObject> subObjects;

    @BeforeEach
    void setUp() {
        victim = new TheftRisk();
        insuranceRisks = new ArrayList<>();
        insuranceRisks.add(RiskType.THEFT);
        subInsuredObject1 = new SubInsuredObject("TV", new BigDecimal("15"), insuranceRisks);
        subInsuredObject2 = new SubInsuredObject("Notebook", new BigDecimal("16"), insuranceRisks);
        subInsuredObject3 = new SubInsuredObject("Phone", new BigDecimal("14"), insuranceRisks);
    }

    @Test
    void testCalculatePremium1() {
        subObjects = new ArrayList<>();
        subObjects.add(subInsuredObject1);
        BigDecimal expectedResult = new BigDecimal("0.75");
        BigDecimal actualResult = victim.calculatePremium(subObjects);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testCalculatePremium2() {
        subObjects = new ArrayList<>();
        subObjects.add(subInsuredObject2);
        BigDecimal expectedResult = new BigDecimal("0.80");
        BigDecimal actualResult = victim.calculatePremium(subObjects);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testCalculatePremium3() {
        subObjects = new ArrayList<>();
        subObjects.add(subInsuredObject3);
        BigDecimal expectedResult = new BigDecimal("1.54");
        BigDecimal actualResult = victim.calculatePremium(subObjects);
        assertEquals(expectedResult, actualResult);
    }
}