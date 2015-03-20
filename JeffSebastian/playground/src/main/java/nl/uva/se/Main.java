package nl.uva.se;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nl.uva.se.ql.ast.form.Form;
import nl.uva.se.ql.evaluation.ValueTable;
import nl.uva.se.ql.gui.mediators.GuiMediator;
import nl.uva.se.ql.gui.mediators.Mediator;
import nl.uva.se.ql.gui.widgets.panes.QuestionPane;
import nl.uva.se.ql.interpretation.Interpreter;
import nl.uva.se.ql.interpretation.Result;
import nl.uva.se.ql.parser.QLLexer;
import nl.uva.se.ql.parser.QLParser;
import nl.uva.se.ql.parser.QLVisitorImpl;
import nl.uva.se.ql.typechecking.error.ErrorList;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main extends Application{
	
	private QuestionPane questionPane;
	
	private ErrorList errors;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void init() throws Exception {
		try {
			ANTLRFileStream reader = new ANTLRFileStream("./src/main/resources/example.txt");
			QLLexer lexer = new QLLexer(reader);
			TokenStream tokens = new CommonTokenStream(lexer);
			QLParser parser = new QLParser(tokens);
			ParseTree tree = parser.form();
			
			QLVisitorImpl visitor = new QLVisitorImpl();
			Form ast = (Form) visitor.visit(tree);
			Result<ValueTable> result = Interpreter.interpret(ast);
			errors = result.getErrorList();
			Mediator med = new GuiMediator(result.getResult(), ast);
			
			if (!result.getErrorList().hasErrors()) {				
				this.questionPane = med.getQuestionPane();			
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		if (!errors.hasErrors()) {
			Scene scene = new Scene(questionPane, 350, 350);
			primaryStage.setTitle(questionPane.getForm().getId());
			primaryStage.setScene(scene);
			primaryStage.show();
		}
	}
}
