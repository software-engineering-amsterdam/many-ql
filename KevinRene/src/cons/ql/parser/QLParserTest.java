package cons.ql.parser;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.Reader;
import java.io.StringReader;

public class QLParserTest {
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
	public void testParsableAssignedForm() {
		Reader reader = new StringReader(
				"form newForm { houseValue : money { \"what is your house?\" assign(105050*238482/2342)} }"
				);
		QLLexer lexer = new QLLexer(reader);
		QLParser parser = new QLParser(lexer);

		lexer.nextToken();
		assertTrue(parser.parse());
		
		assertEquals("Form(newForm, Block(ComputedQuestion(houseValue, 105050 * 238482 / 2342, "
				+ "\"what is your house?\", 105050 * 238482 / 2342)))", parser.getResult().toString());
	}
	
	@Test
	public void testConditionalForm() {
		Reader reader = new StringReader(
				"form taxOfficeExample {"
				+ 	"hasSoldHouse : boolean {"
				+ 		"\"Did you sell a house in 2010?\""
				+ 	"}"
				+ 	"if(5 == 5) {"
				+ 		"houseValue : money {"
				+ 			"\"Lol I dont care\""
				+ 		"}"
				+ 	"}"
				+ "}"
				);
		QLLexer lexer = new QLLexer(reader);
		QLParser parser = new QLParser(lexer);

		lexer.nextToken();
		assertTrue(parser.parse());
		
		assertEquals("Form(taxOfficeExample, Block(Question(hasSoldHouse, null, "
				+ "\"Did you sell a house in 2010?\"), IfThen(5 == 5, "
				+ "Block(Question(houseValue, null, \"Lol I dont care\")))))", parser.getResult().toString());
	}
	
	@Test
	public void testParsableComputerQuestion() {
		Reader reader = new StringReader(
				  "form taxOfficeExample {"
				+ 	"hasSoldHouse : boolean {"
				+ 		"\"Did you sell a house in 2010?\""
				+ 	"}"
				+ 	"houseValue : money {"
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
				+ "\"Did you sell a house in 2010?\"), ComputedQuestion(houseValue, "
				+ "5000.0, \"Your house is worth:\", 5000.0)))", parser.getResult().toString());
	}	
}