package nl.uva.bromance.QL.expressions.primitives;

import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import nl.uva.bromance.QL.expressions.unary.Primitive;
import nl.uva.bromance.QL.gui.QLGUI;
import nl.uva.bromance.QL.typechecking.SymbolTable;

public class NumberPrimitive extends Primitive {

    private Integer value;
    private Boolean negative = false;

    public NumberPrimitive(Integer value, int lineNumber) {
        super(lineNumber);
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public NumberPrimitive addition(NumberPrimitive rhs, int lineNumber) {
        return new NumberPrimitive(this.value + rhs.getValue(), lineNumber);
    }

    public NumberPrimitive division(NumberPrimitive rhs, int lineNumber) {
        return new NumberPrimitive(this.value / rhs.getValue(), lineNumber);
    }

    public NumberPrimitive multiplication(NumberPrimitive rhs, int lineNumber) {
        return new NumberPrimitive(this.value * rhs.getValue(), lineNumber);
    }

    public NumberPrimitive subtraction(NumberPrimitive rhs, int lineNumber) {
        return new NumberPrimitive(this.value - rhs.getValue(), lineNumber);
    }

    public BooleanPrimitive biggerThanOrEqual(NumberPrimitive rhs, int lineNumber) {
        return new BooleanPrimitive(this.value >= rhs.getValue(),lineNumber);
    }

    public BooleanPrimitive smallerThanOrEqual(NumberPrimitive rhs, int lineNumber) {
        return new BooleanPrimitive(this.value <= rhs.getValue(), lineNumber);
    }

    public BooleanPrimitive smallerThan(NumberPrimitive rhs, int lineNumber) {
        return new BooleanPrimitive(this.value < rhs.getValue(), lineNumber);
    }

    public BooleanPrimitive biggerThan(NumberPrimitive rhs, int lineNumber) {
        return new BooleanPrimitive(this.value > rhs.getValue(), lineNumber);
    }

    @Override
    public BooleanPrimitive isEqual(Primitive rhs, int lineNumber) {
        return new BooleanPrimitive(value == ((NumberPrimitive) rhs).getValue(), lineNumber);
    }

    @Override
    public Primitive evaluate(SymbolTable s) {
        return this;
    }

    @Override
    public void drawQuestion(VBox questionArea, QLGUI qlGui) {
        TextField textField = new TextField();
        textField.getStyleClass().add("question");
        textField.setMaxWidth(100);

        if (value != null)
            textField.setText(value.toString());
        else if (negative)
            textField.setText("-");

        if (qlGui.getFocusUuid() == uuid)
            qlGui.setFocusedNode(textField);

        textField.positionCaret(textField.getLength());
        // Disable any input other than numbers
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.matches("-?[0-9]*")) {
                if (newValue.length() == 0) {
                    value = null;
                    negative = false;
                } else if (newValue.equals("-")) {
                    value = null;
                    negative = true;
                } else {
                    // Catch integer overflow
                    try {
                        value = Integer.parseInt(newValue);
                    } catch (java.lang.NumberFormatException ex) {
                        if (negative)
                            value = Integer.MIN_VALUE;
                        else
                            value = Integer.MAX_VALUE;
                    }
                }
            }

            qlGui.renderWithFocus(uuid);
        });

        questionArea.getChildren().add(textField);
    }

    public static NumberPrimitive defaultValue(int lineNumber)
    {
        return new NumberPrimitive(0,lineNumber);
    }
}
