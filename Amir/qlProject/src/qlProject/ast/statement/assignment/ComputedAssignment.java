package qlProject.ast.statement.assignment;

import java.util.Set;

import qlProject.ast.expression.IExpression;
import qlProject.ast.statement.IStatementsVisitor;
import qlProject.ast.type.Type;
import qlProject.auxiliary_expression_visitors.VariablesCollectionVisitor;

public class ComputedAssignment extends Assignment {

	private final IExpression e;

	public ComputedAssignment (String id, String text, Type type, IExpression e){
		super(id, text, type);
		this.e = e;
	}


	public Set<String> getExpressionVariables (){

		Set<String> ids = (Set<String>)(this.e.accept(new VariablesCollectionVisitor()));
		return ids;
	}

	public IExpression getExpression(){
		return this.e;
	}

	@Override
	public void accept(IStatementsVisitor visitor) {
		visitor.visit(this);
	}

}