package nl.uva.bromance.ast;



import nl.uva.bromance.ast.visitors.QLNodeVisitor;

public class Label extends QLNode {
    private String identifier;

    public Label(int lineNumber, String id) {
        super(lineNumber);
        if (id != null) {
            this.identifier = id.substring(1, id.length() - 1); // Remove double brackets around id
        } else {
            //TODO: Consider putting this in the typechecker.
            System.err.println("Label Error: No identifier specified");
        }
    }

    @Override
    public void accept(QLNodeVisitor visitor) {
        visitor.visit(this);
        for (QLNode child : this.getChildren()) {
            child.accept(visitor);
        }
    }
}
