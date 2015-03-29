package nl.uva.bromance.ast.visitors;

import nl.uva.bromance.ast.QLSPage;
import nl.uva.bromance.ast.QLSQuestion;
import nl.uva.bromance.ast.QLSSection;
import nl.uva.bromance.ast.QLSStylesheet;

/**
 * Created by Robert on 26-3-2015.
 */
public class NullQLSNodeVisitor implements QLSNodeVisitor {
    @Override
    public void visit(QLSPage page) {
    }

    @Override
    public void visit(QLSQuestion question) {
    }

    @Override
    public void visit(QLSSection section) {
    }

    @Override
    public void visit(QLSStylesheet stylesheet) {
    }
}
