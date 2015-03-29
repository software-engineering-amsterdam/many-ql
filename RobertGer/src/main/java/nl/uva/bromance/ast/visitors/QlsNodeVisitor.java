package nl.uva.bromance.ast.visitors;

import nl.uva.bromance.ast.*;

public interface QLSNodeVisitor {

    void visit(QLSPage page);

    void visit(QLSQuestion question);

    void visit(QLSSection section);

    void visit(QLSStylesheet stylesheet);

    void visit(QLSLabel label);
}
