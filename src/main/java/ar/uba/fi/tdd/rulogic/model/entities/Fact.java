package ar.uba.fi.tdd.rulogic.model.entities;

import java.util.List;

public class Fact {

    private String predicate;
    private List<String> args;

    public Fact(String predicate, List<String> args) {
        this.predicate = predicate;
        this.args = args;
    }

    public String getPredicate() {
        return predicate;
    }

    public List<String> getArgs() {
        return args;
    }

    public boolean equals(Fact other) {
        if (other == null) return false;

        if (predicate != null ? !predicate.equals(other.predicate) : other.predicate != null) return false;
        return args != null ? args.equals(other.args) : other.args == null;
    }

}
