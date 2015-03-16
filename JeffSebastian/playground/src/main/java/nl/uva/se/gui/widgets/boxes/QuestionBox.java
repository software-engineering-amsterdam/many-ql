package nl.uva.se.gui.widgets.boxes;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import nl.uva.se.gui.validators.Validator;
import nl.uva.se.gui.widgets.questions.BooleanQuestion;
import nl.uva.se.gui.widgets.questions.TextQuestion;
import nl.uva.se.ql.ast.statement.Question;

public class QuestionBox extends VBox {
	
	private final Question question;

	public QuestionBox(Question question) {
		this.question = question;
		addQuestion(question);
	}

	public void addQuestion(Question question) {
		//TODO: Use a Visitor 
		title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		this.getChildren().add(title);

		if (question.getType().getTypeName().equals("boolean")) {
			BooleanQuestion booleanQuestionBox = new BooleanQuestion(
					question);
			booleanQuestionBox.selectedProperty().addListener(
					addCheckBoxListener(booleanQuestionBox));

			this.getChildren().add(booleanQuestionBox);
		} else {
			TextQuestion textQuestionBox = new TextQuestion(question);
			textQuestionBox.textProperty().addListener(
					addTextBoxListener(textQuestionBox));

			this.getChildren().add(textQuestionBox);
		}
	}
	
	public Question getQuestion(){
		return this.question;
	}

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
	}
}