package model;

import java.util.ArrayList;

public class Rule {
    private int ruleId;
    private String parameter;
    private int alertThreshold;
    private ArrayList<String> users;


    public void setRuleId(int ruleId) {
        this.ruleId = ruleId;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public int getAlertThreshold() {
        return alertThreshold;
    }

    public void setAlertThreshold(int alertThreshold) {
        this.alertThreshold = alertThreshold;
    }

    public ArrayList<String> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<String> users) {
        this.users = users;
    }
}
