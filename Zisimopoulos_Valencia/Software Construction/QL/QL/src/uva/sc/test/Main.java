package uva.sc.test;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import uva.sc.parser.*;

public class Main {
    public static void main(String[] args) throws Exception {
    	String form = "form taxOfficeExample {" + "\n" +
    				"\"Did you sell a house in 2010?\"" + "\n" +
    				"hasSoldHouse: boolean" +  "\n" +
    				"//\"Did you buy a house in 2010?\"" + "\n" + 
    				"//hasBoughtHouse: boolean" +  "\n" +
    				"\"Did you enter a loan?\"" + "\n" +
    				"hasMaintLoan: boolean" + "\n\n" +
    				"if (hasSoldHouse) {" +  "\n" +
    				"\"What was the selling price?\""+ "\n" +
    				"sellingPrice: money" +  "\n" +
    				"\"Private debts for the sold house:\"" + "\n" +
    				"privateDebt: money" + "\n" +
    				"\"Value residue:\"" + "\n" +
    				"valueResidue: money =" +  "\n" +
    				"(sellingPrice - privateDebt)" +  "\n" +
    				"}" + "\n" +
    				"\"Did you sell a house in 2010?\"" + "\n" +
    				"hasSoldHouse: boolean" +  "\n" +
    				"}";
        CharStream in = new ANTLRInputStream(form);
        GrammarLexer lexer = new GrammarLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GrammarParser parser = new GrammarParser(tokens);
        ParseTree tree = parser.form();
        String[] arg0 = { "-visitor", "/Users/santiagovalenciavargas/Documents/UvA/workspace/Software Construction/QL/src/uva/sc/parser/Grammar.g4", "-package", "uva.sc.parser" };
        org.antlr.v4.Tool.main(arg0);
        //System.out.print(tree.toStringTree(parser));
    }
}
