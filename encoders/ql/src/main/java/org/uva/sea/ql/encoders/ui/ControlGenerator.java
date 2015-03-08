package org.uva.sea.ql.encoders.ui;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;

import org.uva.sea.ql.encoders.ast.type.DataTypeVisitor;
import org.uva.sea.ql.encoders.ast.type.QLBoolean;
import org.uva.sea.ql.encoders.ast.type.QLInteger;
import org.uva.sea.ql.encoders.ast.type.QLString;
import org.uva.sea.ql.encoders.runtime.RuntimeQuestion;

public class ControlGenerator implements DataTypeVisitor<Control> {

	private RuntimeQuestion runtimeQuestion;

	public ControlGenerator(RuntimeQuestion runtimeQuestion) {
		this.runtimeQuestion = runtimeQuestion;
	}

	@Override
	public Control visit(QLBoolean qlBoolean) {
		Control control = new CheckBox("Yes");
		CheckBoxEventHandler checkBoxEventHandler = new CheckBoxEventHandler(runtimeQuestion);
		((ButtonBase) control).setOnAction(checkBoxEventHandler);
		return control;
	}

	@Override
	public Control visit(QLInteger qlInteger) {
		Control control = new TextField();
		control.setOnKeyReleased(new TextFieldHandler(runtimeQuestion));
		return control;
	}

	@Override
	public Control visit(QLString qlString) {
		Control control = new TextField();
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
