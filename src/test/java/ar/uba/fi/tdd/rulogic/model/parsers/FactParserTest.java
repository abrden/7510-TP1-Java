package ar.uba.fi.tdd.rulogic.model.parsers;

import ar.uba.fi.tdd.rulogic.model.entities.Fact;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class FactParserTest {

    @Test
    public void singleArgFactParseWithPeriodTest() {

        String sentence = "man(John).";

        Fact fact = new FactParser().parse(sentence);

        Assert.assertEquals(fact.getPredicate(), "man");
        Assert.assertEquals(fact.getArgs(), Arrays.asList("John"));
    }

    @Test
    public void singleArgFactParseWithoutPeriodTest() {

        String sentence = "man(John)";

        Fact fact = new FactParser().parse(sentence);

        Assert.assertEquals(fact.getPredicate(), "man");
        Assert.assertEquals(fact.getArgs(), Arrays.asList("John"));
    }

    @Test
    public void multipleArgFactParseWithPeriodTest() {

        String sentence = "daughter(Rosamund, John).";

        Fact fact = new FactParser().parse(sentence);

        Assert.assertEquals(fact.getPredicate(), "daughter");
        Assert.assertEquals(fact.getArgs(), Arrays.asList("Rosamund", "John"));
    }

    @Test
    public void multipleArgFactParseWithoutPeriodTest() {

        String sentence = "daughter(Rosamund, John)";

        Fact fact = new FactParser().parse(sentence);

        Assert.assertEquals(fact.getPredicate(), "daughter");
        Assert.assertEquals(fact.getArgs(), Arrays.asList("Rosamund", "John"));
    }

    @Test
    public void multipleArgFactParseWithoutSpaceTest() {

        String sentence = "daughter(Rosamund,John)";

        Fact fact = new FactParser().parse(sentence);

        Assert.assertEquals(fact.getPredicate(), "daughter");
        Assert.assertEquals(fact.getArgs(), Arrays.asList("Rosamund", "John"));
    }

    @Test
    public void multipleArgFactParseMantainsOrderTest() {

        String sentence = "daughter(Rosamund, John)";

        Fact fact = new FactParser().parse(sentence);

        Assert.assertFalse(fact.getArgs().equals(Arrays.asList("John", "Rosamund")));
    }
}
