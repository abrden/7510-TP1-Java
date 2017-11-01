package ar.uba.fi.tdd.rulogic.model.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Rule {

    private Fact signature;
    private List<Fact> facts;

    public Rule(Fact signature, List<Fact> facts) {
        this.signature = signature;
        this.facts = facts;
    }

    public Fact getSignature() {
        return signature;
    }

    public List<Fact> getFacts() {
        return facts;
    }

    private Map<String, String> variablesMap(List<String> args) {
        Map<String, String> varmap = new HashMap<String, String>();
        List<String> argNames = signature.getArgs();

        for (int i = 0; i < args.size(); i++)
            varmap.put(argNames.get(i), args.get(i));

        return varmap;
    }

    private Fact evaluateFact(Fact fact, Map<String, String> varmap) {
        List<String> evaluatedFactArgs = fact.getArgs().stream()
                .map(factArgs -> varmap.get(factArgs))
                .collect(Collectors.toList());
        return new Fact(fact.getPredicate(), evaluatedFactArgs);
    }

    public List<Fact> evaluate(List<String> args) {
        final Map<String, String> varmap = variablesMap(args);
        return facts.stream()
                .map(fact -> evaluateFact(fact, varmap))
                .collect(Collectors.toList());
    }

}
