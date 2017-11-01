package ar.uba.fi.tdd.rulogic.model;

import static org.mockito.MockitoAnnotations.initMocks;

import ar.uba.fi.tdd.rulogic.model.entities.Interpreter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

public class InterpreterTest {

	@InjectMocks
	private Interpreter i;

	@Before
	public void setUp() throws Exception {
		initMocks(this);
	}

	@Test
	public void test() {

		Assert.assertTrue(this.i.answer("varon (javier)."));

	}

}
