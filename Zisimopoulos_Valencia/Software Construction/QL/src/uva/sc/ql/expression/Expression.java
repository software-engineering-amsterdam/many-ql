package uva.sc.ql.expression;

import uva.sc.core.types.Type;
import uva.sc.ql.ast.IQLExpressionNode;
import uva.sc.ql.ast.IQLExpressionNodeVisitor;

public abstract class Expression<T> implements IQLExpressionNode {

    @SuppressWarnings("hiding")
    public abstract <T> T accept(IQLExpressionNodeVisitor<T> visitor);

    public T getValue() {
	return null;
    }

    public Type getType() {
	return null;
    }

}
