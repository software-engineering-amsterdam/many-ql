package nl.uva.sc.encoders.qlruntime.ui.control;

import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
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
		NumberField numberField = new NumberField();
		numberField.setOnKeyReleased(event -> {
			TextField textField1 = (TextField) event.getSource();
			String text = textField1.getText();
			Integer value = 0;
			if (!text.isEmpty()) {
				value = Integer.valueOf(text);
			}
			runtimeQuestion.setValue(new IntegerValue(value));
		});
		return new NumberFieldPropertyChangeWrapper(numberField);
	}

	@Override
	public TextFieldPropertyChangeWrapper visit(StringType stringType) {
		TextField textField = new TextField();
		textField.setOnKeyReleased(event -> {
			TextField textField1 = (TextField) event.getSource();
			StringValue value = new StringValue(textField1.getText());
			runtimeQuestion.setValue(value);
		});
		return new TextFieldPropertyChangeWrapper(textField);
	}
}
