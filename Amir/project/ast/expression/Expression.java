package project.ast.expression;

import java.util.HashSet;

import project.TypeCheckVisitor;
import project.ast.IGlobalElement;
import project.ast.expression.booleanExpr.ExpressionEvaluationVisitor;
import project.ast.value.TypeValue;
import project.ast.values.Value;
import project.typeChecking.ErrorObject;

public interface Expression extends IGlobalElement{

	public TypeValue getType();
	HashSet<ErrorObject> /*boolean */ accept(TypeCheckVisitor typeCheckVisitor);
	public void accept(VariablesCollectionVisitor variablesCollector);

//	public void accept(VariablesCollectionVisitor visitor);
	
//	{
//	return visitor.visit(this);//..visitAdditionExpr(toAdd);
//}
	
	public Value accept(ExpressionEvaluationVisitor visitor);
	
//	public int accept(ExpressionEvalutaionVisitor visitor){
//		return visitor.visit(this);//..visitAdditionExpr(toAdd);
//		
//	}
	
//	public <T> T accept(QuestionsVisitor<T> visitor) {
//		return visitor.visit(new JFrame(), this);
//	}

}
