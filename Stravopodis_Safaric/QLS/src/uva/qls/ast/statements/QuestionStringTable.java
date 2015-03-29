package uva.qls.ast.statements;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uva.ql.ast.expressions.Expression;
import uva.ql.interpreter.typecheck.TypeCheckVisitor;
import uva.qls.interpreter.typecheck.table.SymbolTable;


public class QuestionStringTable{

	private Map<String, String> questionString;
	
	public QuestionStringTable(){
		this.questionString = new HashMap<String, String>();
	}
	
	public QuestionStringTable getQLQuestionStrings(TypeCheckVisitor typeCheckQL, SymbolTable _symbolTable){
		
		for (String symbolTableKey : _symbolTable.getTable().keySet()){

			List<Expression> expressions = typeCheckQL.getExpressionTable().retrieveValues(symbolTableKey);
			
			for (Expression expression : expressions){
				if (expression.getClass().equals(uva.ql.ast.expressions.literals.StringLiteral.class))
					this.putValue(symbolTableKey, String.valueOf(expression.evaluate().getValue()));
			}
		}
		
		return this;
	}
	
	public void putValue(String identifier, String value) {
		this.questionString.put(identifier, value);
	}

	public String retrieveValue(String identifier) {
		return this.questionString.get(identifier);
	}

	@Override
	public String toString() {
		return this.questionString.toString();
	}

}
