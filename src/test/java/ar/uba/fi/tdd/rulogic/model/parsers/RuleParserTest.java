package ar.uba.fi.tdd.rulogic.model.parsers;

import ar.uba.fi.tdd.rulogic.model.entities.Rule;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RuleParserTest {

    @Test
    public void ruleParseTest() {

        String sentence = "daughter(X, Y) :- woman(X), father(Y, X).";

        Rule rule = new RuleParser().parse(sentence);

        Assert.assertEquals(rule.getSignature().getPredicate(), "daughter");
        Assert.assertEquals(rule.getSignature().getArgs(), Arrays.asList("X", "Y"));
        Assert.assertEquals(rule.getFacts().size(), 2);
        Assert.assertEquals(rule.getFacts().get(0).getPredicate(), "woman");
        Assert.assertEquals(rule.getFacts().get(0).getArgs(), Arrays.asList("X"));
        Assert.assertEquals(rule.getFacts().get(1).getPredicate(), "father");
        Assert.assertEquals(rule.getFacts().get(1).getArgs(), Arrays.asList("Y", "X"));
    }

    @Test
    public void ruleParseWithoutSpacesTest() {

        String sentence = "daughter(X, Y):-woman(X),father(Y, X).";

        Rule rule = new RuleParser().parse(sentence);

        Assert.assertEquals(rule.getSignature().getPredicate(), "daughter");
        Assert.assertEquals(rule.getSignature().getArgs(), Arrays.asList("X", "Y"));
        Assert.assertEquals(rule.getFacts().size(), 2);
        Assert.assertEquals(rule.getFacts().get(0).getPredicate(), "woman");
        Assert.assertEquals(rule.getFacts().get(0).getArgs(), Arrays.asList("X"));
        Assert.assertEquals(rule.getFacts().get(1).getPredicate(), "father");
        Assert.assertEquals(rule.getFacts().get(1).getArgs(), Arrays.asList("Y", "X"));
    }

    @Test
    public void ruleParseWithSimgleFactTest() {

        String sentence = "daughter(X, Y) :- woman(X).";

        Rule rule = new RuleParser().parse(sentence);

        Assert.assertEquals(rule.getSignature().getPredicate(), "daughter");
        Assert.assertEquals(rule.getSignature().getArgs(), Arrays.asList("X", "Y"));
        Assert.assertEquals(rule.getFacts().size(), 1);
        Assert.assertEquals(rule.getFacts().get(0).getPredicate(), "woman");
        Assert.assertEquals(rule.getFacts().get(0).getArgs(), Arrays.asList("X"));
    }

}
