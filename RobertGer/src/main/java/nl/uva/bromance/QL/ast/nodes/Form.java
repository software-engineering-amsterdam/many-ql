package nl.uva.bromance.QL.ast.nodes;

import nl.uva.bromance.QL.ast.QLNode;
import nl.uva.bromance.QL.ast.QLNodeVisitorInterface;
import nl.uva.bromance.QL.exceptions.TypeCheckingError;
import nl.uva.bromance.QL.expressions.unary.Primitive;
import nl.uva.bromance.QL.typechecking.SymbolTable;

import java.util.List;

public class Form extends QLNode{

    private String identifier;

    public Form(String identifier, int ln) {
        super(ln);
        this.identifier = identifier;
    }

    public String getIdentifier(){
        return this.identifier;
    }

    public void accept(QLNodeVisitorInterface visitor) {
        visitor.visit(this);
        for (QLNode child : this.getChildren()) {
            child.accept(visitor);
        }
    }

    @Override
    public Primitive typeCheck(SymbolTable s, List<TypeCheckingError> exceptions) {
        return null;
    }
}
