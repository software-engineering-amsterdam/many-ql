package ast.question;

import java.util.List;

import ast.expression.Expression;

public abstract class IfElseStatement extends IfStatement {

		private Expression ifExpression;
		private List<Question> ifStatement, elseStatement;
		
		public IfElseStatement(Expression ifExpression, List<Question> ifStatement, List<Question> elseStatement) {
			super(ifExpression, ifStatement);
			this.elseStatement = elseStatement;
		}
		
		public List<Question> getElseStatement(){
			return elseStatement;
		}
				
		@Override
		public <T> T accept(IQuestionVisitor<T> visitor) {
			return visitor.visit(this);
		}
		@Override
		public String toString() {
			String output = "if " + " ( " + this.ifExpression + " ) { ";
			for(Question q: ifStatement)
				output += q.toString() + "\n";
			output += " } else { ";
			for(Question qe: elseStatement)
				output += qe.toString() + "\n";
			output += " }";
			return output;
		}
	}
