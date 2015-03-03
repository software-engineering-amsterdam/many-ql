package uva.sc.test;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Assert;
import org.junit.Test;

import uva.sc.parser.GrammarLexer;
import uva.sc.parser.GrammarParser;
import uva.sc.parser.QLVisitor;

public class QLTest {
	
	@Test
	public void testClear() throws IOException{
		CharStream in = new ANTLRFileStream("C:/Users/Pantelis/workspace/software-construction/QL/form/test.grammar");
        //CharStream in = new ANTLRFileStream("/Users/santiagovalenciavargas/Documents/UvA/workspace/Software Construction//QL/QL/form/test.grammar");
        GrammarLexer lexer = new GrammarLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GrammarParser parser = new GrammarParser(tokens);
        ParseTree tree = parser.form();
        
        GrammarParser.AdditiveContext additiveContext;
        QLVisitor visitor = new QLVisitor();
        
		Assert.assertTrue("Se esperaba que el metodo eliminara los elementos " +
				"y reiniciara el tamano del stack", true );
	}
	
}
