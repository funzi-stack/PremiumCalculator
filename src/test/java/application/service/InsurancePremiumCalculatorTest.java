package application.service;

import application.domen.InsuredObject;
import application.domen.Policy;
import application.domen.Status;
import application.domen.SubInsuredObject;
import application.service.risks.FireRisk;
import application.service.risks.TheftRisk;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InsurancePremiumCalculatorTest {
    InsurancePremiumCalculator victim;
    Policy policy;
    InsuredObject insuredObject;
    SubInsuredObject subInsuredObject1;
    SubInsuredObject subInsuredObject2;
    List<RiskType> insuranceRisks1;
    List<RiskType> insuranceRisks2;
    List<SubInsuredObject> subObjects;
    List<InsuredObject> insuredObjects;

    @BeforeEach
    void setUp() {
        insuranceRisks1 = new ArrayList<>();
        insuranceRisks1.add(RiskType.FIRE);
        insuranceRisks2 = new ArrayList<>();
        insuranceRisks2.add(RiskType.THEFT);
        subObjects = new ArrayList<>();
        insuredObjects = new ArrayList<>();
    }

    @Test
    void testCalculate1() {
        subInsuredObject1 = new SubInsuredObject("TV", new BigDecimal("100"), insuranceRisks1);
        subInsuredObject2 = new SubInsuredObject("Notebook", new BigDecimal("8"), insuranceRisks2);
        subObjects.add(subInsuredObject1);
        subObjects.add(subInsuredObject2);
        insuredObject = new InsuredObject("House", subObjects);
        insuredObjects.add(insuredObject);
        policy = new Policy("1212", Status.REGISTERED, insuredObjects);
        victim = new InsurancePremiumCalculator();
        BigDecimal premium = victim.calculate(policy);
        assertEquals(new BigDecimal("2.280"), premium);
    }

    @Test
    void testCalculate2() {
        subInsuredObject1 = new SubInsuredObject("TV", new BigDecimal("500"), insuranceRisks1);
        subInsuredObject2 = new SubInsuredObject("Notebook", new BigDecimal("102.51"), insuranceRisks2);
        subObjects.add(subInsuredObject1);
        subObjects.add(subInsuredObject2);
        insuredObject = new InsuredObject("House", subObjects);
        insuredObjects.add(insuredObject);
        policy = new Policy("1212", Status.REGISTERED, insuredObjects);
        victim = new InsurancePremiumCalculator();
        BigDecimal premium = victim.calculate(policy);
        assertEquals(new BigDecimal("17.1255"), premium);
    }
}