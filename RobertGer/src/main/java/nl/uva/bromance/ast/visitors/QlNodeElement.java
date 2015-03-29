package nl.uva.bromance.ast.visitors;

public interface QlNodeElement {

    void accept(QLNodeVisitor visitor);
}
