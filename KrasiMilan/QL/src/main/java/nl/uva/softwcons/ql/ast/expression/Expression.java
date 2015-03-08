package nl.uva.softwcons.ql.ast.expression;

import nl.uva.softwcons.ql.ast.ASTNode;

public abstract class Expression implements ASTNode {

    public abstract <T> T accept(ExpressionVisitor<T> visitor);
}
