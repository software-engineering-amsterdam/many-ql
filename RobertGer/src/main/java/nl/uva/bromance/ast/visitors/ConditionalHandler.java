package nl.uva.bromance.ast.visitors;

import nl.uva.bromance.ast.*;
import nl.uva.bromance.ast.conditionals.ElseIfStatement;
import nl.uva.bromance.ast.conditionals.IfStatement;

/**
 * Created by Robert on 16-3-2015.
 */
public class ConditionalHandler extends NullQLNodeVisitor {

    public void handle(QLNode qlNode)
    { qlNode.accept(this);}

    @Override
    public void visit(Input input) {
        input.handleExpressionResult();
    }

    @Override
    public void visit(IfStatement ifStatement) {
        ifStatement.handleExpressionResult();
    }

    @Override
    public void visit(ElseIfStatement elseIfStatement) {
        elseIfStatement.handleExpressionResult();
    }
}
