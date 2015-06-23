package nl.uva.bromance.QL.ast;

public abstract class QLNode extends Node<QLNode> {

    public QLNode(int ln) {
        super(ln);
    }

    public void accept(QLNodeVisitorInterface visitor) {
        visitor.visit(this);
        for (QLNode child : this.getChildren()) {
            child.accept(visitor);
        }
    }
}