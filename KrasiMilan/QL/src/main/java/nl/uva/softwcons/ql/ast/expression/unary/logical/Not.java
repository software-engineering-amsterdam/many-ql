package nl.uva.softwcons.ql.ast.expression.unary.logical;

import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.ast.expression.Expression;
import nl.uva.softwcons.ql.ast.expression.ExpressionVisitor;
import nl.uva.softwcons.ql.ast.expression.unary.UnaryExpression;

public class Not extends UnaryExpression {

    public Not(Expression expr, LineInfo lineInfo) {
        super(expr, lineInfo);
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
