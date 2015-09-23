package nl.uva.bromance.QL.ast.nodes;

import nl.uva.bromance.QL.ast.QLNode;
import nl.uva.bromance.QL.ast.QLNodeVisitorInterface;
import nl.uva.bromance.QL.expressions.primitives.NumberPrimitive;
import nl.uva.bromance.QL.expressions.unary.Primitive;
import nl.uva.bromance.QL.typechecking.SymbolTable;
import nl.uva.bromance.QL.typechecking.exceptions.DuplicateIdentifierException;
import nl.uva.bromance.QL.typechecking.exceptions.TypeCheckingError;

import java.util.List;

public class Calculation extends QLNode{
    private final String identifier;
    private final NumberPrimitive type;

    public Calculation(int ln, String identifier) {
        super(ln);
        this.identifier = identifier;
        this.type = NumberPrimitive.defaultValue(ln);
    }

    @Override
    public Primitive typeCheck(SymbolTable s, List<TypeCheckingError> exceptions) {
        return type;
    }

    @Override
    public void accept(QLNodeVisitorInterface visitor) {
        visitor.visit(this);
        for (QLNode child : this.getChildren()) {
            child.accept(visitor);
        }
    }

    //TODO: Typecheck for number primitive;

    public void addToSymbolTable(SymbolTable s, List<TypeCheckingError> exceptions) {
        Primitive lookup = s.lookup(identifier);
        if(lookup == null){
            s.add(identifier, this.type, this);
        }
        else{
            exceptions.add(new DuplicateIdentifierException("You have a duplicate calculation definition on line: " + this.getLineNumber()));
        }
    }
}
