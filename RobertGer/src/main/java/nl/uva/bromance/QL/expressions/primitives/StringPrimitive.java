package nl.uva.bromance.QL.expressions.primitives;

import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import nl.uva.bromance.QL.expressions.unary.Primitive;
import nl.uva.bromance.QL.gui.QLGUI;

public class StringPrimitive extends Primitive {

    private String value;

    public StringPrimitive(String value) {
        this.value = value;
    }

    String getValue(){
        return value;
    }

    @Override
    public BooleanPrimitive isEqual(Primitive rhs) {
        return new BooleanPrimitive(value.equals(((StringPrimitive) rhs).getValue()));
    }

    @Override
    public Primitive evaluate() {
        return this;
    }

    @Override
    public void drawQuestion(VBox questionArea, QLGUI qlGui) {
        TextField textField = new TextField();
        textField.getStyleClass().add("question");
        textField.setMaxWidth(630);
        if (value != null) {
            textField.setText(value);
        }
        if (qlGui.getFocusUuid() == uuid)
            qlGui.setFocusedNode(textField);

        textField.positionCaret(textField.getLength());
        // Disable any input other than numbers
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() == 0) {
                value = null;
            } else {
                value = newValue;
            }
            qlGui.renderWithFocus(uuid);
        });
        questionArea.getChildren().add(textField);
    }
}
