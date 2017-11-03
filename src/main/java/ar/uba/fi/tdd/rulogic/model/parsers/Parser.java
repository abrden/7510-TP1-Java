package ar.uba.fi.tdd.rulogic.model.parsers;

import java.io.IOException;

public interface Parser {

    Object parse(String sentence) throws IOException;

}
