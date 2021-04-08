package application.domen;

import java.util.List;
/**
 * Policy can have multiple policy objects and
 * each policy object can have multiple sub-objects.
 */
public class Policy {
    private String policyNumber;
    private Status status;
    List<InsuredObject> insuredObjects;

    public Policy(String policyNumber, Status status, List<InsuredObject> insuredObjects) {
        this.policyNumber = policyNumber;
        this.status = status;
        this.insuredObjects = insuredObjects;
    }

    public List<InsuredObject> getInsuredObjects() {
        return insuredObjects;
    }
}
