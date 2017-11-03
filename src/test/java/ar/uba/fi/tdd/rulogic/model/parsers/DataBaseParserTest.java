package ar.uba.fi.tdd.rulogic.model.parsers;

import ar.uba.fi.tdd.rulogic.model.entities.DataBase;
import ar.uba.fi.tdd.rulogic.model.entities.Fact;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

public class DataBaseParserTest {

    @Test
    public void factsDbParseTest() throws IOException {

        String dbFile = "src/main/resources/facts.db";

        DataBase db = new DataBaseParser().parse(dbFile);

        Assert.assertEquals(db.getFacts().size(), 3);
        Assert.assertEquals(db.getRules().size(), 0);
        Assert.assertEquals(db.getMalformations().size(), 0);
    }

    @Test
    public void rulesDbParseTest() throws IOException {

        String dbFile = "src/main/resources/rules.db";

        DataBase db = new DataBaseParser().parse(dbFile);

        Assert.assertEquals(db.getFacts().size(), 13);
        Assert.assertEquals(db.getRules().size(), 4);
        Assert.assertEquals(db.getMalformations().size(), 2);
    }

    @Test
    public void malformationsDbParseTest() throws IOException {

        String dbFile = "src/main/resources/malformations.db";

        DataBase db = new DataBaseParser().parse(dbFile);

        Assert.assertEquals(db.getFacts().size(), 3);
        Assert.assertEquals(db.getRules().size(), 0);
        Assert.assertEquals(db.getMalformations().size(), 3);
    }
}
