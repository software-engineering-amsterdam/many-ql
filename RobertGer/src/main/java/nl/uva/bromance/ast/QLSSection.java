package nl.uva.bromance.ast;

import nl.uva.bromance.ast.visitors.QlsNodeVisitor;

public class QLSSection extends QLSNode {
    private String identifier;

    public QLSSection(int lineNumber, String id) {
        super(lineNumber);
        if (id != null) {
            this.identifier = id.substring(1, id.length() - 1).toLowerCase();
        } else {
            System.err.println("Root Error: No identifier specified");
        }
    }

    @Override
    public void accept(QlsNodeVisitor visitor) {
        visitor.visit(this);
        for (QLSNode child : this.getChildren()) {
            child.accept(visitor);
        }
    }

    public String getIdentifier() {
        return identifier;
    }
}
