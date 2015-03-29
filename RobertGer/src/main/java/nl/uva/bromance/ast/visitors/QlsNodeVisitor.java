package nl.uva.bromance.ast.visitors;

import nl.uva.bromance.ast.*;

/**
 * Created by Robert on 16-3-2015.
 */
public interface QLSNodeVisitor {

    void visit(QLSPage page);

    void visit(QLSQuestion question);

    void visit(QLSSection section);

    void visit(QLSStylesheet stylesheet);

    void visit(QLSLabel label);
}
