package cons.ql.parser;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.Reader;
import java.io.StringReader;

import cons.ql.ast.ASTNode;
import cons.ql.ast.expression.arithmetic.Add;
import cons.ql.ast.expression.literal.QLInt;

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
		
		assertEquals("5 + 5", parser.getResult().toString());
	}

	@Test
	public void testParsableForm() {
		Reader reader = new StringReader(
				"form taxOfficeExample {"
				+ "hasSoldHouse : boolean {"
				+ "\"Did you sell a house in 2010?\""
				+ "}"
				+ "}"
				);
		QLLexer lexer = new QLLexer(reader);
		QLParser parser = new QLParser(lexer);

		lexer.nextToken();
		assertTrue(parser.parse());
		
		assertEquals("Form(taxOfficeExample, Block(Question(hasSoldHouse, null, "
				+ "\"Did you sell a house in 2010?\")))", parser.getResult().toString());
	}
	
	@Test
	public void testParsableComputerQuestion() {
		Reader reader = new StringReader(
				  "form taxOfficeExample {"
				+ 	"hasSoldHouse : boolean {"
				+ 		"\"Did you sell a house in 2010?\""
				+ 	"}"
				+ 	"hasSoldHouse : money {"
				+ 		"\"Your house is worth:\""
				+ 		"assign(5000.0)"
				+ 	"}"
				+ "}"
				);
		QLLexer lexer = new QLLexer(reader);
		QLParser parser = new QLParser(lexer);

		lexer.nextToken();
		assertTrue(parser.parse());
		
		assertEquals("Form(taxOfficeExample, Block(Question(hasSoldHouse, null, "
				+ "\"Did you sell a house in 2010?\"), ComputedQuestion(hasSoldHouse, "
				+ "5000.0, \"Your house is worth:\", 5000.0)))", parser.getResult().toString());
	}	
}