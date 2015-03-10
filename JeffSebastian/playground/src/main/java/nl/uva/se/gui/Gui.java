package nl.uva.se.gui;

//TODO REMOVE THIS CLASS BEFORE HANDING IN!
import java.util.Collections;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nl.uva.se.gui.elements.ConditionBox;
import nl.uva.se.gui.elements.QuestionBox;
import nl.uva.se.gui.elements.QuestionPane;
import nl.uva.se.ql.ast.form.Form;
import nl.uva.se.ql.ast.statement.Condition;
import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.ast.statement.Statement;
import nl.uva.se.ql.ast.type.BooleanType;
import nl.uva.se.ql.ast.type.DecimalType;
public class Gui extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		List<Statement> statements = Collections.emptyList();
		Form form = new Form("1", 1, 1, statements); 
		QuestionPane questionPane = new QuestionPane(form);
		
		Question age = new Question(1, 1, "2", new BooleanType(), "wat is your age?"); 
		Question that = new Question(1,1, "3", new DecimalType(), "wat is that?");	
				
		QuestionBox thatQuestionBox = new QuestionBox(that);
		
		Condition condition = new Condition(1, 2, null, statements);
		ConditionBox conditionBox = new ConditionBox(condition);
		conditionBox.addQuestionBox(thatQuestionBox);
		
		questionPane.addQuestion(age);
		questionPane.addConditionBox(conditionBox);
		
		
		Scene scene = new Scene(questionPane, 350, 350);
		primaryStage.setTitle(questionPane.getForm().getId());
		primaryStage.setScene(scene);
		primaryStage.show();		
	}

}
