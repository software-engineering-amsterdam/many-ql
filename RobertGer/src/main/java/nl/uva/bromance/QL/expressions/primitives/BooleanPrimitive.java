package nl.uva.bromance.QL.expressions.primitives;

import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import nl.uva.bromance.QL.expressions.unary.Primitive;
import nl.uva.bromance.QL.gui.QLGUI;

public class BooleanPrimitive extends Primitive {

    private boolean value;

    boolean getValue(){
        return value;
    }

    public BooleanPrimitive(boolean value){
        this.value = value;
    }

    public BooleanPrimitive or(BooleanPrimitive rhs){
        return new BooleanPrimitive(this.value || rhs.getValue());
    }

    public BooleanPrimitive and(BooleanPrimitive rhs){
        return new BooleanPrimitive(this.value && rhs.getValue());
    }

    @Override
    public BooleanPrimitive isEqual(Primitive rhs) {
        return new BooleanPrimitive(value == ((BooleanPrimitive)rhs).getValue());
    }

    @Override
    public void drawQuestion(VBox questionArea, QLGUI qlGui) {
        CheckBox cb = new CheckBox();
        cb.getStyleClass().add("question");
        questionArea.getChildren().add(cb);

        if (qlGui.getFocusUuid() == uuid)
            qlGui.setFocusedNode(cb);

        // Disable any input other than numbers
        /*cb.selectedProperty().addListener((observable, oldValue, newValue) -> {
            value = newValue;
            qlGui.renderWithFocus(uuid);
        });*/

        questionArea.getChildren().add(cb);
    }

    public void invert()
    {
        this.value = !this.value;
    }

    @Override
    public Primitive evaluate() {
        return this;
    }
}
