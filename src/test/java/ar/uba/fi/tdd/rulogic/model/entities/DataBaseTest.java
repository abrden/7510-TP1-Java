package ar.uba.fi.tdd.rulogic.model.entities;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DataBaseTest {

    @Test
    public void dbWithMalformationsTest() {

        List<Fact> facts = Arrays.asList(
                new Fact("man", Arrays.asList("John"))
        );

        List<Rule> rules = Arrays.asList(
                new Rule(new Fact("daughter", Arrays.asList("X", "Y")),
                        Arrays.asList(
                                new Fact("father", Arrays.asList("Y", "X")),
                                new Fact("woman", Arrays.asList("X"))
                        ))
        );

        List<Malformation> malformations = Arrays.asList(
                new Malformation("woman(")
        );

        DataBase db = new DataBase(facts, rules, malformations);

        Assert.assertTrue(db.hasMalformations());
    }

    @Test
    public void dbWithoutMalformationsTest() {

        List<Fact> facts = Arrays.asList(
                new Fact("man", Arrays.asList("John"))
        );

        List<Rule> rules = Arrays.asList(
                new Rule(new Fact("daughter", Arrays.asList("X", "Y")),
                        Arrays.asList(
                                new Fact("father", Arrays.asList("Y", "X")),
                                new Fact("woman", Arrays.asList("X"))
                        ))
        );

        List<Malformation> malformations = Arrays.asList();

        DataBase db = new DataBase(facts, rules, malformations);

        Assert.assertFalse(db.hasMalformations());
    }

    @Test
    public void positiveFactQueryTest() {

        List<Fact> facts = Arrays.asList(
                new Fact("man", Arrays.asList("John"))
        );

        List<Rule> rules = Arrays.asList(
                new Rule(new Fact("daughter", Arrays.asList("X", "Y")),
                        Arrays.asList(
                                new Fact("father", Arrays.asList("Y", "X")),
                                new Fact("woman", Arrays.asList("X"))
                        ))
        );

        List<Malformation> malformations = Arrays.asList();

        DataBase db = new DataBase(facts, rules, malformations);

        Assert.assertTrue(db.factQuery(new Fact("man", Arrays.asList("John"))));
    }

    @Test
    public void negativeFactQueryTest() {

        List<Fact> facts = Arrays.asList(
                new Fact("man", Arrays.asList("John"))
        );

        List<Rule> rules = Arrays.asList(
                new Rule(new Fact("daughter", Arrays.asList("X", "Y")),
                        Arrays.asList(
                                new Fact("father", Arrays.asList("Y", "X")),
                                new Fact("woman", Arrays.asList("X"))
                        ))
        );

        List<Malformation> malformations = Arrays.asList();

        DataBase db = new DataBase(facts, rules, malformations);

        Assert.assertFalse(db.factQuery(new Fact("woman", Arrays.asList("Rosamund"))));
    }

    @Test
    public void positiveRuleQueryTest() {

        List<Fact> facts = Arrays.asList(
                new Fact("man", Arrays.asList("John")),
                new Fact("woman", Arrays.asList("Rosamund")),
                new Fact("father", Arrays.asList("John", "Rosamund"))
        );

        List<Rule> rules = Arrays.asList(
                new Rule(new Fact("daughter", Arrays.asList("X", "Y")),
                        Arrays.asList(
                                new Fact("father", Arrays.asList("Y", "X")),
                                new Fact("woman", Arrays.asList("X"))
                        ))
        );

        List<Malformation> malformations = Arrays.asList();

        DataBase db = new DataBase(facts, rules, malformations);

        Assert.assertTrue(db.ruleQuery(new Fact("daughter", Arrays.asList("Rosamund", "John"))));
    }

    @Test
    public void negativeRuleQueryTest() {

        List<Fact> facts = Arrays.asList(
                new Fact("man", Arrays.asList("John")),
                new Fact("woman", Arrays.asList("Rosamund")),
                new Fact("father", Arrays.asList("John", "Rosamund"))
        );

        List<Rule> rules = Arrays.asList(
                new Rule(new Fact("daughter", Arrays.asList("X", "Y")),
                        Arrays.asList(
                                new Fact("father", Arrays.asList("Y", "X")),
                                new Fact("woman", Arrays.asList("X"))
                        ))
        );

        List<Malformation> malformations = Arrays.asList();

        DataBase db = new DataBase(facts, rules, malformations);

        Assert.assertFalse(db.ruleQuery(new Fact("daughter", Arrays.asList("Molly", "John"))));
    }

    @Test
    public void nonExistentRuleQueryTest() {

        List<Fact> facts = Arrays.asList(
                new Fact("man", Arrays.asList("John")),
                new Fact("woman", Arrays.asList("Rosamund")),
                new Fact("father", Arrays.asList("John", "Rosamund"))
        );

        List<Rule> rules = Arrays.asList(
                new Rule(new Fact("daughter", Arrays.asList("X", "Y")),
                        Arrays.asList(
                                new Fact("father", Arrays.asList("Y", "X")),
                                new Fact("woman", Arrays.asList("X"))
                        ))
        );

        List<Malformation> malformations = Arrays.asList();

        DataBase db = new DataBase(facts, rules, malformations);

        Assert.assertFalse(db.ruleQuery(new Fact("friends", Arrays.asList("Molly", "John"))));
    }

}
