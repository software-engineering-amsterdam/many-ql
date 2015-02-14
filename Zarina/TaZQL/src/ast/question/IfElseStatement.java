package ast.question;

import java.util.ArrayList;

import ast.expression.Expression;

public class IfElseStatement extends Questions {

		private Expression ifExpression;
		private ArrayList<Questions> statement;
		
		public IfElseStatement(Expression ifExpression, ArrayList<Questions> statement) {
			this.statement = statement;
			this.ifExpression = ifExpression;
		}
		
		public Expression getExpression(){
			return ifExpression;
		}
		
		public ArrayList<Questions> getStatement(){
			return statement;
		}
		
		@Override
		public <T> T accept(IQuestionVisitor<T> visitor) {
			return visitor.visit(this);
		}
	}


	//'if' '(' expression ')' '{' question+ '}'	