package ast.expression;

import ast.AST;


public abstract class Expression extends AST {
		public abstract <T> T accept(IExpressionVisitor<T> visitor);
		public abstract String toString();
}
