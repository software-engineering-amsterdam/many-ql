package uva.ql.interpreter.typecheck.table;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uva.ql.ast.expressions.*;
import uva.ql.ast.expressions.literals.*;
import uva.ql.supporting.ExpressionSupporting;

public class ExpressionTable extends Table <Identifier, Expression>{

	private Map<String, List<Expression>> expressionTable;
	private ExpressionSupporting exprSupporting;
	
	public ExpressionTable(){
		this.expressionTable = new HashMap<String, List<Expression>>();
		this.exprSupporting = new ExpressionSupporting(this, null, null, null, null);
	}
	
	public Expression getExpressionOfTypeClass(Identifier identifier, String object){
		
		for (Expression expr : this.retrieveValues(identifier))
			if (!(expr.getClass().getName().equals(StringLiteral.class.getName()))){
				
				return expr;
			}
		
		return this.exprSupporting.initialiseExpression(object);
	}
	
	public List<Expression> retrieveValues(Identifier identifier){
		return this.expressionTable.get(identifier.evaluatedValue());
	}
	
	public boolean expressionExists(Expression _expression){
		for (String key : this.expressionTable.keySet()){
			for (Expression _expr : this.expressionTable.get(key)){
				if (_expr.evaluate().getValue().equals(_expression.evaluate().getValue()))
					return true;
			}
		}
		return false;
	}
	
	public void updateValue(Identifier _identifier, Expression _expression){
		Expression _expressionToRemove = null;
		
		for (Expression expr : this.retrieveValues(_identifier)){
			if (!expr.getClass().getName().equals(StringLiteral.class.getName()))
				_expressionToRemove = expr;
		}
		
		this.removeExpression(_identifier, _expressionToRemove);
		this.retrieveValues(_identifier).add(_expression);
	}
	public void removeExpression(Identifier _identifier, Expression _expression){
		List<Expression> expressions = this.retrieveValues(_identifier);

		if (_expression != null){
			expressions.remove(this.indexOf(expressions, _expression));
			this.expressionTable.put(_identifier.evaluatedValue(), expressions);
		}
	}
	
	private int indexOf(List<Expression> _exprs, Expression _expression){
		for (int i=0; i < _exprs.size(); i++){
			if (_expression.equals(_exprs.get(i))) {
				return i;
			}
		}
		return -1;
	}
	
	
	@Override
	public void putValue(Identifier identifier, Expression value) {
		List<Expression> lst = this.retrieveValues(identifier);
		
		if (lst == null)
			lst = new ArrayList<Expression>();
		
		lst.add(value);
		
		this.expressionTable.put(identifier.evaluatedValue(), lst);
	}

	@Override
	public boolean keyExists(Identifier identifier) {
		return this.expressionTable.containsKey(identifier.evaluatedValue());
	}

	public boolean keyExistsForType(Identifier identifier, Object object){
		for (Expression expr : this.retrieveValues(identifier))
			if (expr.getClass().getSimpleName().equals(object))
				return true;
		return false;
	}
	
	@Override
	public boolean valueExists(Identifier identifier, Expression value) {
		return this.expressionTable.containsValue(value);
	}
	
	@Override
	public Expression retrieveValue(Identifier identifier) {
		return null;
	}
	
	@Override
	public String toString() {
		String s = "";
		for (String key : this.expressionTable.keySet())
			s += key + " " + this.expressionTable.get(key) + " ";
		return s;
	}
	
	public void printExpressionTable(){
		for (String key : this.expressionTable.keySet()){
			System.out.println(key);
			for (Expression expression : this.retrieveValues(new Identifier(key, null))){
				System.out.println("=====> " + expression.toString());
			}
		}
	}

}
