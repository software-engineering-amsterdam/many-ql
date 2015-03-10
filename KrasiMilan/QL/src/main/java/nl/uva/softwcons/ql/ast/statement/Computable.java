package nl.uva.softwcons.ql.ast.statement;

import nl.uva.softwcons.ql.ast.expression.Expression;

public interface Computable {
    Expression getExpression();
}
