package ar.uba.fi.tdd.rulogic.model;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class InterpreterTest {

	@Test
	public void queryOnNonMalformedDbTest() throws IOException {
		String dbPath = "src/main/resources/facts.db";
		Interpreter i = new Interpreter(dbPath);

		Assert.assertTrue(i.answer("man(John)"));
	}

	@Test
	public void queryOnMalformedDbTest() throws IOException {
		String dbPath = "src/main/resources/rules.db";
		Interpreter i = new Interpreter(dbPath);

		Assert.assertFalse(i.answer("varon(juan)"));
	}

	@Test
	public void dbHasMalformationsIsTrueTest() throws IOException {
		String dbPath = "src/main/resources/rules.db";
		Interpreter i = new Interpreter(dbPath);

		Assert.assertTrue(i.dbHasMalformations());
	}

	@Test
	public void queryWithPeriodIsMalformedTest() throws IOException {
		String dbPath = "src/main/resources/facts.db";
		Interpreter i = new Interpreter(dbPath);

		Assert.assertFalse(i.answer("varon(juan)."));
	}

	@Test
	public void malformedQueryTest() throws IOException {
		String dbPath = "src/main/resources/facts.db";
		Interpreter i = new Interpreter(dbPath);

		Assert.assertFalse(i.answer("varon(juan"));
	}


	@Test
	public void ruleQueryOnNonMalformedDbtest() throws IOException {
		String dbPath = "src/main/resources/numbers.db";
		Interpreter i = new Interpreter(dbPath);

		Assert.assertTrue(i.answer("subtract(two, one, one)"));
	}

}
