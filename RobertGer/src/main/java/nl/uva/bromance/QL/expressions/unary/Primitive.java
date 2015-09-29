package nl.uva.bromance.QL.expressions.unary;

import javafx.scene.layout.VBox;
import nl.uva.bromance.QL.exceptions.TypeCheckingError;
import nl.uva.bromance.QL.expressions.Expression;
import nl.uva.bromance.QL.expressions.primitives.BooleanPrimitive;
import nl.uva.bromance.QL.gui.QLGUI;
import nl.uva.bromance.QL.typechecking.SymbolTable;

import java.util.List;
import java.util.UUID;

public abstract class Primitive<T> extends Expression
{
    protected UUID uuid = UUID.randomUUID();

    public Primitive(int ln)
    {
        super(ln);
    }

    public BooleanPrimitive isNotEqual(Primitive rhs, int lineNumber)
    {
        BooleanPrimitive primitive = isEqual(rhs, lineNumber);
        primitive.invert();
        return primitive;
    }

    @Override
    public Primitive typeCheck(SymbolTable s, List<TypeCheckingError> exceptions)
    {
        return this;
    }

    public abstract void drawQuestion(VBox questionArea, QLGUI qlGui);
    public abstract BooleanPrimitive isEqual(Primitive rhs, int lineNumber);
    public abstract T getValue();
}

