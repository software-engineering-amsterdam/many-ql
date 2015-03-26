package nl.uva.bromance.ast;

import nl.uva.bromance.ast.visitors.NodeVisitor;

public class Questionnaire extends QLNode {
    private String identifier;

    public Questionnaire(int lineNumber, String id) {
        super(lineNumber);
        this.identifier = id;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
        for (QLNode child : this.getChildren()) {
            child.accept(visitor);
        }
    }

}
