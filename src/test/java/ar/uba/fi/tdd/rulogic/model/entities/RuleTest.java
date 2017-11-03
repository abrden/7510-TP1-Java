package ar.uba.fi.tdd.rulogic.model.entities;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class RuleTest {

    Rule daughterRule = new Rule(new Fact("daughter", Arrays.asList("X", "Y")),
            Arrays.asList(
                    new Fact("father", Arrays.asList("Y", "X")),
                    new Fact("woman", Arrays.asList("X"))
            ));

    @Test
    public void daughterEvaluationTest() {

        List<Fact> e = daughterRule.evaluate(Arrays.asList("Rosamund", "John"));

        Assert.assertTrue(e.size() == 2);
        Assert.assertTrue(e.get(0).getPredicate().equals("father"));
        Assert.assertTrue(e.get(0).getArgs().equals(Arrays.asList("John", "Rosamund")));
        Assert.assertTrue(e.get(1).getPredicate().equals("woman"));
        Assert.assertTrue(e.get(1).getArgs().equals(Arrays.asList("Rosamund")));
    }

}
