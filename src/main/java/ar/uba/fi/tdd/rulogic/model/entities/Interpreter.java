package ar.uba.fi.tdd.rulogic.model.entities;

public class Interpreter {

    private DataBase db;

    public Interpreter(String dbPath) {
        db = parseDataBase(dbPath);
    }

    private DataBase parseDataBase(String dbPath) {
        // TODO
        return null;
    }

    public boolean answer(String query) {
        // TODO
        return true;
    }

    /*
    this.checkQuery = function (query) {
    let parseQuery = function (query) {
      if (query.match(/[^\(]+\([^\)]+\)/))
        return FactParser(query);
    };

    let parsedQuery = parseQuery(query);
    if (parsedQuery) {
      if (database.factQuery(parsedQuery) || database.ruleQuery(parsedQuery))
        return true;
      else
        return false;
    }
  };
     */
}
