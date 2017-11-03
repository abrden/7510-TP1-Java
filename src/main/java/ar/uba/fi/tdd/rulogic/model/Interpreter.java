package ar.uba.fi.tdd.rulogic.model;

import ar.uba.fi.tdd.rulogic.model.entities.DataBase;
import ar.uba.fi.tdd.rulogic.model.entities.Fact;
import ar.uba.fi.tdd.rulogic.model.parsers.DataBaseParser;
import ar.uba.fi.tdd.rulogic.model.parsers.FactParser;

import java.io.IOException;

public class Interpreter {

    private DataBase db;

    public Interpreter(String dbPath) throws IOException {
        db = new DataBaseParser().parse(dbPath);
    }

    public boolean dbHasMalformations() {
        return db.hasMalformations();
    }

    private Fact parseQuery(String query) {
        if (query.matches("[^(]+\\([^)]+\\)"))
            return new FactParser().parse(query);
        return null;
    }

    public boolean answer(String query) {
        if (db.hasMalformations()) return false;

        Fact parsedQuery = parseQuery(query);
        return ((parsedQuery != null) && (db.factQuery(parsedQuery) || db.ruleQuery(parsedQuery)));
    }

}
