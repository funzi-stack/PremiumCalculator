package application.domen;

import java.util.List;
/**
 * Policy objects can have multiple sub-objects and can be related only to one policy.
 * The class represent insured object (e.g. real estate such as house).
 */
public class InsuredObject {
    private String name;
    private List<SubInsuredObject> subInsuredObjects;

    public InsuredObject(String name, List<SubInsuredObject> subInsuredObjects) {
        this.name = name;
        this.subInsuredObjects = subInsuredObjects;
    }

    public List<SubInsuredObject> getSubInsuredObjects() {
        return subInsuredObjects;
    }
}
