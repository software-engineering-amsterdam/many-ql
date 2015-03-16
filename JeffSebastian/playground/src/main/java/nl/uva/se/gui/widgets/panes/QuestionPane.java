package nl.uva.se.gui.widgets.panes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import nl.uva.se.gui.widgets.boxes.ConditionBox;
import nl.uva.se.gui.widgets.boxes.QuestionBox;
import nl.uva.se.ql.ast.form.Form;
import nl.uva.se.ql.ast.statement.Condition;
import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.evaluation.ValueTable;

public class QuestionPane extends BorderPane {

	private VBox vbox;
	public final Form form;
	private ValueTable values;

	public QuestionPane(Form form, ValueTable values) {
		this.form = form;
		vbox = new VBox();
		this.setBottom(addHBox());
		this.setLeft(vbox);
		this.values = values;
	}

	private HBox addHBox() {
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(15, 12, 15, 12));
		hbox.setSpacing(10);
		hbox.setStyle("-fx-background-color: #336699;");

		Button buttonReset = new Button("Reset");
		buttonReset.setPrefSize(100, 20);
		buttonReset.setOnAction(resetListener());

		Button buttonContinue = new Button("Continue");
		buttonContinue.setPrefSize(100, 20);
		buttonContinue.setOnAction(continueListener());

		hbox.getChildren().addAll(buttonReset, buttonContinue);

		return hbox;
	}

	public void addCondition(Condition condition) {
		ConditionBox conditionBox = new ConditionBox(condition);
		conditionBox.setVisible(true);
		vbox.getChildren().add(conditionBox);
	}

	public void addConditionBox(ConditionBox conditionBox) {
		conditionBox.setVisible(true);
		vbox.getChildren().add(conditionBox);
	}

	public void addQuestion(Question question) {
		QuestionBox questionBox = new QuestionBox(question);
		vbox.getChildren().add(questionBox);
	}

	public void addQuestionBox(QuestionBox questionBox) {
		vbox.getChildren().add(questionBox);
	}

	public Form getForm() {
		return this.form;
	}

	public void hideAllConditions() {
		for (Node node : vbox.getChildren()) {
			if (node instanceof ConditionBox) {
				node.managedProperty().bind(node.visibleProperty()); 
				node.setVisible(false);
			}
		}
	}
	
	public void showAllConditions() {
		for (Node node : vbox.getChildren()) {
			if (node instanceof ConditionBox) {
				node.managedProperty().bind(node.visibleProperty()); 
				node.setVisible(true);
			}
		}
	}

	private EventHandler<ActionEvent> resetListener() {
		return new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				// TODO Reset all fields.
				System.out.println("Should reset all fields.");
				showAllConditions();
			}
		};
	}

	private EventHandler<ActionEvent> continueListener() {
		return new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				// TODO Export all and close application.
				System.out.println("Should export answers and close the app.");
				hideAllConditions();
			}
		};
	}
}
