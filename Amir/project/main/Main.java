//hasSoldHouse "Did you SELL a house in 2014?" boolean
//if (hasSoldHouse) {
//money4 "mon4 txt" integer
//money5 "mon5 txt" integer
//}
//hasBoughtHouse "Did you BUY a house in 2014?" boolean
//money1 "mon1 txt" integer
//if (3 > 1) {
//money2 "mon2 txt" integer
//money3 "mon3 txt" integer
//}
//testingLabels "label test" integer ( money1 + 5)
//testingLabels2 "label test3" integer ( money1 + money2)

package project.main;

//money4 "mon4 txt" integer (money2 > false)
// Things I could test:      	      transitive closure function		//add to question: is nested

import java.io.File;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.io.FileUtils;

import project.ast.FormObject;
import project.grammar.QuestionnaireBuilderVisitor;
import project.grammar.qlGrammarLexer;
import project.grammar.qlGrammarParser;
import project.typeChecking.TypeChecker;

public class Main {

	static public String tmp = "";
	private Main()
	{
	}
	public static void main(String[] args) {
		try

		{

			File aa = new File("E:/tstst.txt");//		QuestionnaireBuilderVisitor formBuilder = new QuestionnaireBuilderVisitor();
			String str = FileUtils.readFileToString(aa);//			System.out.println(str);
			ANTLRInputStream bb = new ANTLRInputStream(str);
			qlGrammarLexer lexer = new qlGrammarLexer(bb);
			CommonTokenStream tokens = new CommonTokenStream( lexer );
			qlGrammarParser parser = new qlGrammarParser( tokens );
			ParseTree tree = parser.form() ;
			QuestionnaireBuilderVisitor formBuilder = new QuestionnaireBuilderVisitor();
			FormObject questionnaire = (FormObject)formBuilder.visit(tree);
			System.out.println(tree.toStringTree(parser));

			QuestionPopulatorVisitor questionPopulator = new QuestionPopulatorVisitor();

			questionPopulator.visit(questionnaire);
			TypeChecker checker = new TypeChecker(questionPopulator);//                new TypeChecker(questionPopulator.errors).visit(questionnaire);
			checker.visit(questionnaire);
			checker.showErrors();
			//    FormGUI.main(questionnaire);
		} 
		catch (Exception exc) {
			System.err.println(exc.getMessage());
		}
	}
}	
		
	