package nl.uva.bromance.ast.visitors;

/**
 * Created by Robert on 26-3-2015.
 */
public interface QLSNodeElement {

    void accept(QLSNodeVisitor visitor);
}
