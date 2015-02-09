package cons.ql.parser.test;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.Reader;
import java.io.StringReader;

import cons.ql.ast.ASTNode;
import cons.ql.ast.expr.binary.Add;
import cons.ql.ast.expr.Int;
import cons.ql.parser.QLLexer;
import cons.ql.parser.QLParser;

public class ParserTest {

	@Test
	public void testZeroToken() {
		Reader myReader = new StringReader("");
		QLLexer lexer = new QLLexer(myReader);
		
		assertEquals("Return 0 when nothing is done.", 0, lexer.getToken());
	}
	
	@Test
	public void testParsableString() {
		Reader reader = new StringReader("5 + 5");
		QLLexer lexer = new QLLexer(reader);
		QLParser parser = new QLParser(lexer);

		lexer.nextToken();
		assertTrue(parser.parse());
		
		ASTNode expectedNode = new Add(new Int(5), new Int(5));
		assertEquals(expectedNode.toString(), parser.getResult().toString());
	}
}
