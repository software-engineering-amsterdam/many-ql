package nl.uva.sc.encoders.qlruntime.ui.control;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import nl.uva.sc.encoders.ql.ast.type.BooleanType;
import nl.uva.sc.encoders.ql.ast.type.IntegerType;
import nl.uva.sc.encoders.ql.ast.type.StringType;
import nl.uva.sc.encoders.ql.visitor.DataTypeVisitor;
import nl.uva.sc.encoders.qlruntime.model.RuntimeQuestion;
import nl.uva.sc.encoders.qlruntime.model.value.BooleanValue;
import nl.uva.sc.encoders.qlruntime.model.value.IntegerValue;
import nl.uva.sc.encoders.qlruntime.model.value.StringValue;

public class ControlGenerator implements DataTypeVisitor<ControlPropertyChangeWrapper> {

	private RuntimeQuestion runtimeQuestion;

	public ControlGenerator(RuntimeQuestion runtimeQuestion) {
		this.runtimeQuestion = runtimeQuestion;
	}

	@Override
	public CheckBoxPropertyChangeWrapper visit(BooleanType qlBoolean) {
		CheckBox checkBox = new CheckBox("Yes");
		checkBox.setOnAction(event -> {
			CheckBox checkBox1 = (CheckBox) event.getSource();
			runtimeQuestion.setValue(new BooleanValue(checkBox1.isSelected()));
		});
		return new CheckBoxPropertyChangeWrapper(checkBox);
	}

	@Override
	public NumberFieldPropertyChangeWrapper visit(IntegerType integerType) {
		final NumberField numberField = new NumberField();
		numberField.setOnKeyReleased(event -> {
			KeyCode keyCode = event.getCode();
			if (!keyCode.isDigitKey()) {
				return;
			}
			TextField textField1 = (TextField) event.getSource();
			String text = textField1.getText();
			Integer value = 0;
			if (!text.isEmpty()) {
				try {
					value = Integer.valueOf(text);
				} catch (NumberFormatException e) {
					numberField.setNumber(value);
					runtimeQuestion.setValue(new IntegerValue(value));
					Alert alert = new Alert(AlertType.WARNING);
					alert.setContentText(text + " is not a valid number.");
					alert.show();
				}
			}
		});
		return new NumberFieldPropertyChangeWrapper(numberField);
	}

	@Override
	public TextFieldPropertyChangeWrapper visit(StringType stringType) {
		TextField textField = new TextField();
		textField.setOnKeyReleased(event -> {
			KeyCode keyCode = event.getCode();
			if (keyCode.isNavigationKey() || keyCode.isFunctionKey() || keyCode.isMediaKey()) {
				return;
			}
			TextField textField1 = (TextField) event.getSource();
			StringValue value = new StringValue(textField1.getText());
			runtimeQuestion.setValue(value);
		});
		return new TextFieldPropertyChangeWrapper(textField);
	}
}
