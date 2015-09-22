package nl.uva.bromance.QL.controlstructures;

import nl.uva.bromance.QL.ast.QLNode;
import nl.uva.bromance.QL.expressions.unary.Primitive;
import nl.uva.bromance.QL.typechecking.SymbolTable;
import nl.uva.bromance.QL.typechecking.exceptions.TypeCheckingError;

import java.util.List;

public class Else extends QLNode{
    public Else(int ln) {
        super(ln);
    }
}
