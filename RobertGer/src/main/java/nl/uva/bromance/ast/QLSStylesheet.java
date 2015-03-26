package nl.uva.bromance.ast;

import nl.uva.bromance.ast.visitors.QlsNodeVisitor;

public class QLSStylesheet extends QLSNode {

    public QLSStylesheet(int lineNumber) {
        super(lineNumber);
    }

    @Override
    public void accept(QlsNodeVisitor visitor) {
        visitor.visit(this);
        for (QLSNode child : this.getChildren()) {
            child.accept(visitor);
        }
    }
}
