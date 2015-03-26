package nl.uva.bromance.ast;

import nl.uva.bromance.ast.visitors.QlNodeVisitor;

public class Questionnaire extends QLNode {
    private String identifier;

    public Questionnaire(int lineNumber, String id) {
        super(lineNumber);
        this.identifier = id;
    }

    @Override
    public void accept(QlNodeVisitor visitor) {
        visitor.visit(this);
        for (QLNode child : this.getChildren()) {
            child.accept(visitor);
        }
    }

}
