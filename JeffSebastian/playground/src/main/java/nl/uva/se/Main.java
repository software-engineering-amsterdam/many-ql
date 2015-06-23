package nl.uva.se;

import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nl.uva.se.ql.ast.form.Form;
import nl.uva.se.ql.evaluation.Evaluator;
import nl.uva.se.ql.evaluation.ValueTable;
import nl.uva.se.ql.gui.mediators.GuiMediator;
import nl.uva.se.ql.gui.mediators.Mediator;
import nl.uva.se.ql.gui.widgets.panes.QuestionPane;
import nl.uva.se.ql.parser.QLLexer;
import nl.uva.se.ql.parser.QLParser;
import nl.uva.se.ql.parser.QLVisitorImpl;
import nl.uva.se.ql.typechecking.TypeChecker;
import nl.uva.se.ql.typechecking.error.ErrorList;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main extends Application {

	private QuestionPane questionPane;

	private ErrorList semanticErrors;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void init() throws Exception {
		try {
			ANTLRFileStream reader = new ANTLRFileStream(
					"./src/main/resources/example.txt");
			QLLexer lexer = new QLLexer(reader);
			TokenStream tokens = new CommonTokenStream(lexer);
			QLParser parser = new QLParser(tokens);
			ParseTree tree = parser.form();

			QLVisitorImpl visitor = new QLVisitorImpl();
			Form ast = (Form) visitor.visit(tree);
			semanticErrors = TypeChecker.check(ast);

			if (!semanticErrors.hasErrors()) {
				ValueTable valueTable = Evaluator.evaluate(ast,
						new ValueTable());
				Mediator med = new GuiMediator(valueTable, ast);
				this.questionPane = med.getQuestionPane();
			} else {
				semanticErrors.printAll();
				Platform.exit();
				System.exit(0);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(questionPane, 350, 350);
		primaryStage.setTitle(questionPane.getForm().getId());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
