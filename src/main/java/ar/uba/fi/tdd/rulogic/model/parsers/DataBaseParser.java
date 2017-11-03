package ar.uba.fi.tdd.rulogic.model.parsers;

import ar.uba.fi.tdd.rulogic.model.entities.DataBase;
import ar.uba.fi.tdd.rulogic.model.entities.Fact;
import ar.uba.fi.tdd.rulogic.model.entities.Malformation;
import ar.uba.fi.tdd.rulogic.model.entities.Rule;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseParser implements Parser {

    public DataBase parse(String dbPath) throws IOException {
        File dbFile = new File(dbPath);

        List<Fact> facts = new ArrayList<>();
        List<Rule> rules = new ArrayList<>();
        List<Malformation> malformations = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(dbFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.matches(".+\\(.+\\)\\s*:-\\s*.*\\.")) {
                    rules.add(new RuleParser().parse(line));
                } else if (line.matches(".+\\(.+\\)\\.")) {
                    facts.add(new FactParser().parse(line));
                } else {
                    malformations.add(new Malformation(line));
                }
            }
        }

        return new DataBase(facts, rules, malformations);
    }
}
