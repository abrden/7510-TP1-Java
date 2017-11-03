package ar.uba.fi.tdd.rulogic.model.parsers;

import ar.uba.fi.tdd.rulogic.model.entities.Fact;

import java.util.Arrays;
import java.util.List;

public class FactParser implements Parser {

    public Fact parse(String sentence) {
        List<String> parts = Arrays.asList(sentence.split("\\(|,\\s*|\\)\\.|\\)"));
        return new Fact(parts.get(0), parts.subList(1, parts.size()));
    }
}
