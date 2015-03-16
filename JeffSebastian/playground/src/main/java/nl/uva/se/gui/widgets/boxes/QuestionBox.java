package nl.uva.se.gui.widgets.boxes;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import nl.uva.se.gui.builders.QuestionBuilder;
import nl.uva.se.ql.ast.statement.Question;

public class QuestionBox extends VBox {
	
	private final Question question;

	public QuestionBox(Question question) {
		this.question = question;
		addQuestion(question);
	}

	public void addQuestion(Question question) {		
		//Add label to the QuestionBox
		Label title = new Label(question.getLabel());
		this.getChildren().add(title);
		
		//Add the widget to the QuestionBox
		Node widget = question.getType().accept(new QuestionBuilder(question));
		this.getChildren().add(widget);
	}
	
	public Question getQuestion(){
		return this.question;
	}

	/*
	private ChangeListener<String> addTextBoxListener(
			final TextQuestion textQuestionBox) {
		return new ChangeListener<String>() {

			public void changed(ObservableValue<? extends String> observable,
					String oldValue, String newValue) {
				System.out.println("TextField oldvalue: " + oldValue
						+ " newValue: " + newValue);
				if (!validator.match(textQuestionBox.getQuestion(), oldValue,
						newValue) && !newValue.equals("")) {
					textQuestionBox.setText(oldValue);
					System.out.println("this should only except numbers");
				}
			}
		};
	}

	private ChangeListener<Boolean> addCheckBoxListener(
			BooleanQuestion booleanQuestionBox) {
		return new ChangeListener<Boolean>() {

			public void changed(ObservableValue<? extends Boolean> observable,
					Boolean oldValue, Boolean newValue) {
				System.out.println("TextField oldvalue: " + oldValue
						+ " newValue: " + newValue);
				if (!validator.match(booleanQuestionBox.getQuestion(),
						oldValue, newValue)) {
					System.out.println("No checkbox should be checked.");
				}
			}
		};
	} */
}