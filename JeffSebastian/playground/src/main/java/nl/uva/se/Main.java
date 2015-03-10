package nl.uva.se;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nl.uva.se.ast.form.Form;
import nl.uva.se.gui.elements.QuestionPane;
import nl.uva.se.interpretation.Interpreter;
import nl.uva.se.parser.QLLexer;
import nl.uva.se.parser.QLParser;
import nl.uva.se.parser.QLVisitorImpl;
import nl.uva.se.visitor.GuiVisitor;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main extends Application{
	
	private QuestionPane questionPane;
	
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
			
			GuiVisitor guiVisitor = new GuiVisitor();
			guiVisitor.visit(ast);
			this.questionPane = guiVisitor.getQuestionPane();			
			Interpreter.interpret(ast);
			
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
