package nl.uva.bromance.ast;

import nl.uva.bromance.ast.visitors.QLNodeVisitor;


public class Form extends QLNode {
    private String identifier;

    public Form(int lineNumber, String id) {
        super(lineNumber);
        this.identifier = id.substring(1, id.length() - 1);
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public void accept(QLNodeVisitor visitor) {
        visitor.visit(this);
        for (QLNode child : this.getChildren()) {
            child.accept(visitor);
        }
    }

}
