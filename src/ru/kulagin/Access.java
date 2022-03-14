package ru.kulagin;

import ru.kulagin.person.Human;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Access {

    private final List<RuleAcc> rules;

    public Access(RuleAcc... rules){
        this.rules = Arrays.asList(rules);
    }

    public Access(Access a, RuleAcc... rules){
        this.rules = new ArrayList<>(a.getRules());
        this.rules.addAll(Arrays.asList(rules));
    }

    public List<RuleAcc> getRules() {
        return new ArrayList<>(rules);
    }

    public boolean check(Human human){
        for (var rule : rules){
            if (!rule.check(human)) return false;
        }
        return true;
    }
}
