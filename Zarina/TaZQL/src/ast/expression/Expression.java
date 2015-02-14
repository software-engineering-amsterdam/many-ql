package ast.expression;

import ast.IMainVisitable;

public abstract class Expression implements IMainVisitable {
		public abstract <T> T accept(IExpressionVisitor<T> visitor);
}
