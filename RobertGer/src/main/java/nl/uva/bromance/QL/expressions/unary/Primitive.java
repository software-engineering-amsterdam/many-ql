package nl.uva.bromance.QL.expressions.unary;

import javafx.scene.layout.VBox;
import nl.uva.bromance.QL.expressions.Evaluable;
import nl.uva.bromance.QL.expressions.primitives.BooleanPrimitive;
import nl.uva.bromance.QL.gui.QLGUI;

public abstract class Primitive implements Evaluable {

    public abstract BooleanPrimitive isEqual(Primitive rhs);

    public BooleanPrimitive isNotEqual(Primitive rhs) {
        BooleanPrimitive primitive = isEqual(rhs);
        primitive.invert();
        return primitive;
    }

    public abstract void drawQuestion(VBox questionArea, QLGUI qlGui);
}

