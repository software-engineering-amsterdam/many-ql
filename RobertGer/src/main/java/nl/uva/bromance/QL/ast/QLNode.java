package nl.uva.bromance.QL.ast;

import nl.uva.bromance.QL.expressions.unary.Primitive;
import nl.uva.bromance.QL.typechecking.SymbolTable;
import nl.uva.bromance.QL.typechecking.exceptions.TypeCheckingError;

import java.util.List;

public abstract class QLNode extends Node<QLNode> {

    public QLNode(int ln) {
        super(ln);
    }

    public void accept(QLNodeVisitorInterface visitor) {
        visitor.visit(this);
        for (QLNode child : this.getChildren()) {
            child.accept(visitor);
        }
    }

    /*Typechecking does not throw errors but passes along a list of exception to which a typeChecking error can be added.
    * The alternative would be to throw TypeCheckingError's. However that would stop the typechecking dead in it's track
    * after the first Error is found.*/
    public Primitive typeCheck(SymbolTable s, List<TypeCheckingError> exceptions){
        return null;
    }
}