package nl.uva.bromance.ast.visitors;

import nl.uva.bromance.ast.QLNode;
import nl.uva.bromance.ast.conditionals.ElseIfStatement;
import nl.uva.bromance.ast.conditionals.ElseStatement;
import nl.uva.bromance.ast.conditionals.IfStatement;

public class ConditionalHandler extends NullQLNodeVisitor {

    private boolean makeChildrenInvisible = false;

    public void handle(QLNode qlNode) {
        qlNode.accept(this);
    }

    @Override
    public void visit(IfStatement ifStatement) {
        makeChildrenInvisible = false;
        ifStatement.handleExpressionResult();
        if (ifStatement.ExpressionEvaluatesToTrue()) {
            makeChildrenInvisible = true;
        }
    }

    @Override
    public void visit(ElseIfStatement elseIfStatement) {
        if (makeChildrenInvisible) {
            elseIfStatement.setChildrenVisible(false);
        } else {
            elseIfStatement.handleExpressionResult();
            if (elseIfStatement.ExpressionEvaluatesToTrue()) {
                makeChildrenInvisible = true;
            }
        }
    }

    @Override
    public void visit(ElseStatement elseStatement) {
        if (makeChildrenInvisible) {
            elseStatement.setChildrenVisible(false);
        } else {
            elseStatement.setChildrenVisible(true);
        }
    }
}
