package ar.uba.fi.tdd.rulogic.model.entities;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

public class FactTest {

    @Test
    public void equivalentFactsAreEqualTest() {

        Fact f1 = new Fact("man", Arrays.asList("John"));
        Fact f2 = new Fact("man", Arrays.asList("John"));

        Assert.assertTrue(f1.equals(f2));
        Assert.assertTrue(f2.equals(f1));
    }

    @Test
    public void differentFactAreNotEqualTest() {

        Fact f1 = new Fact("man", Arrays.asList("John"));
        Fact f2 = new Fact("woman", Arrays.asList("Molly"));

        Assert.assertFalse(f1.equals(f2));
        Assert.assertFalse(f2.equals(f1));
    }

    @Test
    public void factsWithDiffetentPredicatesAreNotEqualTest() {

        Fact f1 = new Fact("man", Arrays.asList("John"));
        Fact f2 = new Fact("woman", Arrays.asList("John"));

        Assert.assertFalse(f1.equals(f2));
        Assert.assertFalse(f2.equals(f1));
    }

    @Test
    public void factsWithDiffetentArgsAreNotEqualTest() {

        Fact f1 = new Fact("man", Arrays.asList("John"));
        Fact f2 = new Fact("man", Arrays.asList("Molly"));

        Assert.assertFalse(f1.equals(f2));
        Assert.assertFalse(f2.equals(f1));
    }

    @Test
    public void factsWithDiffetentOrderOfArgsAreNotEqualTest() {

        Fact f1 = new Fact("father", Arrays.asList("John", "Rosamund"));
        Fact f2 = new Fact("father", Arrays.asList("Rosamund", "John"));

        Assert.assertFalse(f1.equals(f2));
        Assert.assertFalse(f2.equals(f1));
    }
}
