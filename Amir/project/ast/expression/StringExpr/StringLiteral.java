package project.ast.expression.StringExpr;

import java.util.HashSet;

import project.TypeCheckVisitor;
import project.ast.expression.VariablesCollectionVisitor;
import project.ast.expression.booleanExpr.ExpressionEvaluationVisitor;
import project.ast.value.StringTypeValue;
import project.ast.value.TypeValue;
import project.ast.values.Value;
import project.typeChecking.ErrorObject;

public class StringLiteral implements StringExpression {
	
	public String str;
	
	public StringLiteral (String str){
		this.str = str;
	}
	public String getValue (){
		return str;
	}

	@Override
	public Value accept(ExpressionEvaluationVisitor visitor){
		return visitor.visit(this);//..visitAdditionExpr(toAdd);
	}
	
	@Override
	public void accept(VariablesCollectionVisitor visitor) {
		visitor.visit(this);//..visitAdditionExpr(toAdd);
	}
	@Override
	public TypeValue getType() {
		return new StringTypeValue(str);
	}
	
	@Override
	public HashSet<ErrorObject> accept(TypeCheckVisitor visitor) {
		// TODO Auto-generated method stub
		return null;
	}
}
