package ast.expression.arithmetic;

import ast.expression.Expression;
import ast.expression.IExpressionVisitor;

public class DivisionExpression extends Expression {
	
		private Expression leftExp, rightExp;
		
		public DivisionExpression (Expression leftExp, Expression rightExp) {
			this.leftExp = leftExp;
			this.rightExp = rightExp;
		}
		
		public Expression getLeftExp() {
			return leftExp;
		}
		
		public Expression getRightExp() {
			return rightExp;
		}
		
		@Override
		public <T> T accept(IExpressionVisitor<T> visitor) {
			return visitor.visit(this);
		}
	}

