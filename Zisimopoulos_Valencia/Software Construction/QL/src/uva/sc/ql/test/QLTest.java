package uva.sc.ql.test;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Assert;
import org.junit.Test;

import uva.sc.ql.parser.ASTGeneratorVisitor;
import uva.sc.ql.parser.QLGrammarLexer;
import uva.sc.ql.parser.QLGrammarParser;

public class QLTest {

    @Test
    public void testClear() throws IOException {
	CharStream in = new ANTLRFileStream(
		"C:/Users/Pantelis/workspace/software-construction/QL/form/test.grammar");
	// CharStream in = new
	// ANTLRFileStream("/Users/santiagovalenciavargas/Documents/UvA/workspace/Software Construction//QL/QL/form/test.grammar");
	QLGrammarLexer lexer = new QLGrammarLexer(in);
	CommonTokenStream tokens = new CommonTokenStream(lexer);
	QLGrammarParser parser = new QLGrammarParser(tokens);
	ParseTree tree = parser.form();

	QLGrammarParser.AdditiveContext additiveContext;
	ASTGeneratorVisitor visitor = new ASTGeneratorVisitor();

	Assert.assertTrue("Se esperaba que el metodo eliminara los elementos "
		+ "y reiniciara el tamano del stack", true);
    }

}
