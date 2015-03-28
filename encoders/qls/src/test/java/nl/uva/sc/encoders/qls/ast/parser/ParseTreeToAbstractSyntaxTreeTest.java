package nl.uva.sc.encoders.qls.ast.parser;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Test;

public class ParseTreeToAbstractSyntaxTreeTest {

	@Test
	public void testSimpleCalculation() {
		int x = 1;
		int y = 2;
		int sum = x + y;
		assertThat(sum, is(3));
	}

	@Test
	public void testVisitPage() throws IOException {
		StylesheetParsingResult result;
		StylesheetParser parser = new StylesheetParser();
		result = parser.parse("somefakefilename");
		assertThat(result, is(notNullValue()));
	}
}
