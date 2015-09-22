package nl.uva.bromance.QL.ast.nodes;

import nl.uva.bromance.QL.ast.QLNode;
import nl.uva.bromance.QL.ast.QLNodeVisitorInterface;
import nl.uva.bromance.QL.expressions.primitives.NumberPrimitive;
import nl.uva.bromance.QL.expressions.unary.Primitive;
import nl.uva.bromance.QL.typechecking.SymbolTable;
import nl.uva.bromance.QL.typechecking.exceptions.DuplicateQuestionIdentifierException;
import nl.uva.bromance.QL.typechecking.exceptions.TypeCheckingError;

import java.awt.font.NumericShaper;
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
        Primitive lookup = s.lookup(identifier);
        if(lookup == null){
            //TODO: We need to think about how we are going to assign a value to a calculation. For typechecking this will do. For evaluation expressions it will not.
            s.add(identifier, this.type);
        }
        else{
            //TODO: New duplicate exception for calculations? Or we could just use TypeCheckingError for everything.
            exceptions.add(new DuplicateQuestionIdentifierException("You have a duplicate calculation definition with a different type on line: " + this.getLineNumber()));
        }
        return s.lookup(identifier);
    }

    @Override
    public void accept(QLNodeVisitorInterface visitor) {
        visitor.visit(this);
        for (QLNode child : this.getChildren()) {
            child.accept(visitor);
        }
    }
}
