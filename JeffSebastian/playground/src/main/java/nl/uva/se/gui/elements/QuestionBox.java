package nl.uva.se.gui.elements;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import nl.uva.se.ast.statement.Question;
import nl.uva.se.gui.Validator;

public class QuestionBox extends VBox {

	private Validator validator = new Validator();

	public QuestionBox(Question question) {
		addQuestion(question);
	}

	public void addQuestion(Question question) {
		Text title = new Text(question.getQuestion());
		title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		this.getChildren().add(title);

		if (question.getType().getTypeName().equals("boolean")) {
			BooleanQuestionBox booleanQuestionBox = new BooleanQuestionBox(
					question);
			booleanQuestionBox.selectedProperty().addListener(
					addCheckBoxListener(booleanQuestionBox));

			this.getChildren().add(booleanQuestionBox);
		} else {
			TextQuestionBox textQuestionBox = new TextQuestionBox(question);
			textQuestionBox.textProperty().addListener(
					addTextBoxListener(textQuestionBox));

			this.getChildren().add(textQuestionBox);
		}
	}

	private ChangeListener<String> addTextBoxListener(
			final TextQuestionBox textQuestionBox) {
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
			BooleanQuestionBox booleanQuestionBox) {
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