package project.ast.expression.StringExpr;

import java.util.HashSet;

import project.TypeCheckVisitor;
import project.ast.expression.Expression;
import project.ast.expression.VariablesCollectionVisitor;
import project.ast.expression.booleanExpr.ExpressionEvaluationVisitor;
import project.ast.value.TypeValue;
import project.ast.values.Value;
import project.typeChecking.ErrorObject;

public interface StringExpression extends Expression {
	public TypeValue getType();
//	public int getValue();
	public Value accept(ExpressionEvaluationVisitor visitor);
	// accept (binaryExpressioinvisitor)
	public void accept(VariablesCollectionVisitor visitor);
	
//	public Map<String, Id> getExpressionVariables();//{
//		VariablesCollectionVisitor variablesCollector = new VariablesCollectionVisitor(new HashMap<String, Id>());
//		this.arithmeticExpr.accept(variablesCollector);
//		return variablesCollector.idMap;
//	}
	 public HashSet<ErrorObject> accept(TypeCheckVisitor visitor); 
}
// fix hierarchy - arithmetic / binary