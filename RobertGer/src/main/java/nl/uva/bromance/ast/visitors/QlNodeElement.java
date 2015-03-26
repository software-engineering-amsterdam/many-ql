package nl.uva.bromance.ast.visitors;

/**
 * Created by Robert on 16-3-2015.
 */
public interface QlNodeElement {

    void accept(QlNodeVisitor visitor);
}
