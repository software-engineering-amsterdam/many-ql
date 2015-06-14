package nl.uva.bromance.QL.ast.nodes;

import nl.uva.bromance.QL.ast.QLNode;
import nl.uva.bromance.QL.ast.QLNodeVisitorInterface;

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
}
