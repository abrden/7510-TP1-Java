package ar.uba.fi.tdd.rulogic.model.parsers;

import ar.uba.fi.tdd.rulogic.model.entities.Fact;
import ar.uba.fi.tdd.rulogic.model.entities.Rule;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RuleParser implements Parser {

    public Rule parse(String sentence) {
        List<String> parts = Arrays.asList(sentence.split("\\s*:-\\s*|\\)\\s*,\\s*|\\."));
        List<Fact> facts = parts.stream().map(part -> new FactParser().parse(part)).collect(Collectors.toList());
        return new Rule(facts.get(0), facts.subList(1, facts.size()));
    }
}
