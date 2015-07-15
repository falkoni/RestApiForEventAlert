package model;

import java.util.ArrayList;
import java.util.HashMap;

public class RuleModel {

    //Supposed to serve as a database implementig the CRUD operations

    //only Create, and Read implemented

    HashMap<Integer, Rule> ruleMap = new HashMap<Integer, Rule>();

    public int addRule(Rule r){
        int id = ruleMap.size() + 1;
        r.setRuleId(id);
        ruleMap.put(id,r);
        return id;
    }

    public ArrayList<Rule> getAllRules() {
        ArrayList<Rule> rules = new ArrayList<Rule>();

        for(Rule r : ruleMap.values()){
            rules.add(r);
        }

        return rules;

    }

}
