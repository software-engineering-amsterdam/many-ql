package nl.uva.bromance.ast.visitors;

public interface QLSNodeElement {

    void accept(QLSNodeVisitor visitor);
}
