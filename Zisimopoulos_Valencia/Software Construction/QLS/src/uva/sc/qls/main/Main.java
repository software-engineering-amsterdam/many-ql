package uva.sc.qls.main;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.ANTLRFileStream;

import uva.sc.ql.ast.IQLExpressionNode;
import uva.sc.ql.evaluator.EvaluatorVisitor;
import uva.sc.ql.gui.GUIVisitor;
import uva.sc.ql.parser.ASTGeneratorVisitor;
import uva.sc.ql.parser.QLGrammarLexer;
import uva.sc.ql.parser.QLGrammarParser;
import uva.sc.qls.ast.IQLSNode;
import uva.sc.qls.parser.*;
import uva.sc.qls.typeChecker.TypeCheckerVisitor;

public class Main {
	public static void main(String[] args) throws Exception {

		//CharStream in = new ANTLRFileStream("C:/Users/Pantelis/git/software-construction/QLS/form/test.grammar");
		/*
		 * CharStream in = new ANTLRFileStream(
		 * "/Users/santiagovalenciavargas/Documents/UvA/workspace/Software Construction/QL_QLS/QLS/form/test.grammar"
		 * ); QLSGrammarLexer lexer = new QLSGrammarLexer(in); CommonTokenStream
		 * tokens = new CommonTokenStream(lexer); QLSGrammarParser parser = new
		 * QLSGrammarParser(tokens); ParseTree tree = parser.stylesheet();
		 * 
		 * ASTGeneratorVisitor visitor = new ASTGeneratorVisitor(); IQLSNode
		 * questionnaire = (IQLSNode) visitor.visit(tree);
		 * //System.out.print(questionnaire);
		 * 
		 * TypeCheckerVisitor tc = new TypeCheckerVisitor();
		 * questionnaire.accept(tc); System.out.println(tc.getErrors());
		 */

		//QL
		CharStream in = new ANTLRFileStream("/Users/santiagovalenciavargas/Documents/UvA/workspace/Software Construction/QL_QLS/QL/form/test.grammar");
		QLGrammarLexer lexer = new QLGrammarLexer(in);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		QLGrammarParser parser = new QLGrammarParser(tokens);
		ParseTree tree = parser.form();

		uva.sc.ql.parser.ASTGeneratorVisitor visitor = new ASTGeneratorVisitor();
		IQLExpressionNode questionnaire = (IQLExpressionNode) visitor.visit(tree);
		//System.out.print(questionnaire);

		uva.sc.ql.typeChecker.TypeCheckerVisitor tc = new uva.sc.ql.typeChecker.TypeCheckerVisitor();
		questionnaire.accept(tc);

		EvaluatorVisitor eval = new EvaluatorVisitor();
		try {
			questionnaire.accept(eval);
		}
		catch (Exception e) {
		}

		GUIVisitor v = new GUIVisitor(eval);
		questionnaire.accept(v);

		//QLS
		CharStream qlsin = new ANTLRFileStream("/Users/santiagovalenciavargas/Documents/UvA/workspace/Software Construction/QL_QLS/QLS/form/test.grammar");
		QLSGrammarLexer qlslexer = new QLSGrammarLexer(qlsin);
		CommonTokenStream qlstokens = new CommonTokenStream(qlslexer);
		QLSGrammarParser qlsparser = new QLSGrammarParser(qlstokens);
		ParseTree qlstree = qlsparser.stylesheet();

		ASTGeneratorVisitor qlsvisitor = new ASTGeneratorVisitor();
		IQLSNode qlsquestionnaire = (IQLSNode) qlsvisitor.visit(qlstree);
		//System.out.print(questionnaire);

		TypeCheckerVisitor qlstc = new TypeCheckerVisitor(v);
		qlsquestionnaire.accept(qlstc);
		//System.out.println(tc.getErrors());

	}
}
