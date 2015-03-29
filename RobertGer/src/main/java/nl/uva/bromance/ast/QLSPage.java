package nl.uva.bromance.ast;

import nl.uva.bromance.ast.visitors.QLSNodeVisitor;

public class QLSPage extends QLSNode {
    private String identifier;

    public QLSPage(int lineNumber, String id) {
        super(lineNumber);
        if (id != null) {
            this.identifier = id.substring(1, id.length() - 1).toLowerCase();
        } else {
            System.err.println("Root Error: No identifier specified");
        }
    }

    public String getIdentifier() {
        return identifier;
    }


    @Override
    public void accept(QLSNodeVisitor visitor) {
        visitor.visit(this);
        for (QLSNode child : this.getChildren()) {
            child.accept(visitor);
        }
    }
}
