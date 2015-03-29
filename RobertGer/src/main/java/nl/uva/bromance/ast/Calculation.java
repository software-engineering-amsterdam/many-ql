package nl.uva.bromance.ast;

import nl.uva.bromance.ast.visitors.QLNodeVisitor;


public class Calculation extends QLNode{
    private String identifier;

    public Calculation(int lineNumber, String id) {
        super(lineNumber);
        this.identifier = id;
    }

    //TODO: Find fix for childType
    @Override
    public void accept(QLNodeVisitor visitor) {
        visitor.visit(this);
        for (QLNode child : this.getChildren()) {
            child.accept(visitor);
        }
    }
}