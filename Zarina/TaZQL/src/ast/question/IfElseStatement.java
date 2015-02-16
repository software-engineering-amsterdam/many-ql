package ast.question;

import java.util.ArrayList;

import ast.expression.Expression;

public class IfElseStatement extends IQuestionVisitable {

		private Expression ifExpression;
		private ArrayList<IQuestionVisitable> statement;
		
		public IfElseStatement(Expression ifExpression, ArrayList<IQuestionVisitable> statement) {
			this.statement = statement;
			this.ifExpression = ifExpression;
		}
		
		public Expression getExpression(){
			return ifExpression;
		}
		
		public ArrayList<IQuestionVisitable> getStatement(){
			return statement;
		}
				
		@Override
		public <T> T accept(IQuestionVisitor<T> visitor) {
			return visitor.visit(this);
		}
	}


	//'if' '(' expression ')' '{' question+ '}'	