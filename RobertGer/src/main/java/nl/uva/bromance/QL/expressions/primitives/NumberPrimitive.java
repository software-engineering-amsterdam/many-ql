package nl.uva.bromance.QL.expressions.primitives;

import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import nl.uva.bromance.QL.expressions.unary.Primitive;
import nl.uva.bromance.QL.gui.QLGUI;

/**
 * Created by Robert on 31-5-2015.
 */
public class NumberPrimitive extends Primitive {

    private Integer value;

    public NumberPrimitive(Integer value) {
        this.value = value;
    }

    int getValue() {
        return value;
    }

    public NumberPrimitive addition(NumberPrimitive rhs) {
        return new NumberPrimitive(this.value + rhs.getValue());
    }
    public NumberPrimitive division(NumberPrimitive rhs) {
        return new NumberPrimitive(this.value / rhs.getValue());
    }
    public NumberPrimitive multiplication(NumberPrimitive rhs) {
        return new NumberPrimitive(this.value * rhs.getValue());
    }
    public NumberPrimitive subtraction(NumberPrimitive rhs) {
        return new NumberPrimitive(this.value - rhs.getValue());
    }
    public BooleanPrimitive biggerThanOrEqual(NumberPrimitive rhs){
        return new BooleanPrimitive(this.value >= rhs.getValue());
    }
    public BooleanPrimitive smallerThanOrEqual(NumberPrimitive rhs){
        return new BooleanPrimitive(this.value <= rhs.getValue());
    }
    public BooleanPrimitive smallerThan(NumberPrimitive rhs){
        return new BooleanPrimitive(this.value < rhs.getValue());
    }
    public BooleanPrimitive biggerThan(NumberPrimitive rhs){
        return new BooleanPrimitive(this.value > rhs.getValue());
    }

    @Override
    public BooleanPrimitive isEqual(Primitive rhs) {
        return new BooleanPrimitive(value == ((NumberPrimitive)rhs).getValue());
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
            textField.setText(value.toString());
        }
        if (qlGui.getFocusUuid() == uuid)
            qlGui.setFocusedNode(textField);

        textField.positionCaret(textField.getLength());
        // Disable any input other than numbers
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[0-9]*")) {
                textField.setText(oldValue);
            } else if (newValue.length() == 0) {
                value = null;
            } else {
                value = Integer.parseInt(newValue);
            }
            qlGui.renderWithFocus(uuid);
        });
        questionArea.getChildren().add(textField);
    }
}
