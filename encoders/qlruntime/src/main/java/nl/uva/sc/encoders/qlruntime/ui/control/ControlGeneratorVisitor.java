package nl.uva.sc.encoders.qlruntime.ui.control;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import nl.uva.sc.encoders.ql.ast.type.BooleanType;
import nl.uva.sc.encoders.ql.ast.type.IntegerType;
import nl.uva.sc.encoders.ql.ast.type.StringType;
import nl.uva.sc.encoders.ql.visitor.DataTypeVisitor;
import nl.uva.sc.encoders.qlruntime.model.RuntimeQuestion;
import nl.uva.sc.encoders.qlruntime.value.BooleanValue;
import nl.uva.sc.encoders.qlruntime.value.IntegerValue;
import nl.uva.sc.encoders.qlruntime.value.StringValue;

public class ControlGeneratorVisitor implements DataTypeVisitor<ControlWrapper> {

	private RuntimeQuestion runtimeQuestion;

	public ControlGeneratorVisitor(RuntimeQuestion runtimeQuestion) {
		this.runtimeQuestion = runtimeQuestion;
	}

	@Override
	public CheckBoxWrapper visit(BooleanType qlBoolean) {
		CheckBox checkBox = new CheckBox("Yes");
		CheckBoxEventHandler checkBoxEventHandler = new CheckBoxEventHandler(runtimeQuestion);
		checkBox.setOnAction(checkBoxEventHandler);
		return new CheckBoxWrapper(checkBox);
	}

	@Override
	public TextFieldWrapper visit(IntegerType integerType) {
		TextField textField = new TextField() {
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
		textField.setOnKeyReleased(new NumberFieldHandler(runtimeQuestion));
		return new TextFieldWrapper(textField);
	}

	@Override
	public TextFieldWrapper visit(StringType stringType) {
		TextField textField = new TextField();
		textField.setOnKeyReleased(new TextFieldHandler(runtimeQuestion));
		return new TextFieldWrapper(textField);
	}

	private class TextFieldHandler implements EventHandler<Event> {
		private RuntimeQuestion question;

		public TextFieldHandler(RuntimeQuestion question) {
			this.question = question;
		}

		@Override
		public void handle(Event event) {
			TextField textField = (TextField) event.getSource();
			StringValue value = new StringValue(textField.getText());
			question.setValue(value);
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
			question.setValue(new IntegerValue(value));
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
			question.setValue(new BooleanValue(checkBox.isSelected()));
		}
	}

}
