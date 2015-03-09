package org.uva.sea.ql.encoders.ui;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;

import org.uva.sea.ql.encoders.ast.type.DataTypeVisitor;
import org.uva.sea.ql.encoders.ast.type.BooleanType;
import org.uva.sea.ql.encoders.ast.type.IntegerType;
import org.uva.sea.ql.encoders.ast.type.StringType;
import org.uva.sea.ql.encoders.runtime.RuntimeQuestion;

public class ControlGeneratorVisitor implements DataTypeVisitor<Control> {

	private RuntimeQuestion runtimeQuestion;

	public ControlGeneratorVisitor(RuntimeQuestion runtimeQuestion) {
		this.runtimeQuestion = runtimeQuestion;
	}

	@Override
	public Control visit(BooleanType qlBoolean) {
		CheckBox control = new CheckBox("Yes");
		CheckBoxEventHandler checkBoxEventHandler = new CheckBoxEventHandler(runtimeQuestion);
		control.setOnAction(checkBoxEventHandler);
		return control;
	}

	@Override
	public Control visit(IntegerType qlInteger) {
		TextField control = new TextField() {
			@Override
			public void replaceText(int start, int end, String text) {
				if (text.matches("[0-9]*")) {
					super.replaceText(start, end, text);
				}
			}

			@Override
			public void replaceSelection(String text) {
				if (text.matches("[0-9]*")) {
					super.replaceSelection(text);
				}
			}
		};
		control.setOnKeyReleased(new NumberFieldHandler(runtimeQuestion));
		return control;
	}

	@Override
	public Control visit(StringType qlString) {
		TextField control = new TextField();
		control.setOnKeyReleased(new TextFieldHandler(runtimeQuestion));
		return control;
	}

	private class TextFieldHandler implements EventHandler<Event> {
		private RuntimeQuestion question;

		public TextFieldHandler(RuntimeQuestion question) {
			this.question = question;
		}

		@Override
		public void handle(Event event) {
			TextField textField = (TextField) event.getSource();
			question.setValue(textField.getText());
		}
	}

	private class NumberFieldHandler implements EventHandler<Event> {
		private RuntimeQuestion question;

		public NumberFieldHandler(RuntimeQuestion question) {
			this.question = question;
		}

		@Override
		public void handle(Event event) {
			TextField textField = (TextField) event.getSource();
			String text = textField.getText();
			Integer value = 0;
			if (!text.isEmpty()) {
				value = Integer.valueOf(text);
			}
			question.setValue(value);
		}
	}

	private class CheckBoxEventHandler implements EventHandler<ActionEvent> {
		private RuntimeQuestion question;

		public CheckBoxEventHandler(RuntimeQuestion question) {
			this.question = question;
		}

		@Override
		public void handle(ActionEvent event) {
			CheckBox checkBox = (CheckBox) event.getSource();
			question.setValue(checkBox.isSelected());
		}
	}

}
