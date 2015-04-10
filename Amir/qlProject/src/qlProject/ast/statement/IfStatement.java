package qlProject.ast.statement;

import java.util.List;
import java.util.Set;

import qlProject.ast.expression.IExpression;
import qlProject.auxiliary_expression_visitors.VariablesCollectionVisitor;

public class IfStatement implements IStatement {

	private final IExpression condition;
	private final List<IStatement> conditionTrueList;
	private final List<IStatement> conditionFalseList;
	
	public IfStatement(IExpression condition, List<IStatement> trueList,List<IStatement> falseList) {
		this.condition = condition;
		this.conditionTrueList = trueList;
		this.conditionFalseList = falseList;
	}

	
	public IExpression getCondition(){
		return condition;
	}
	
	public Set<String> getExpressionVariables (){
		return (Set<String>)(this.condition.accept(new VariablesCollectionVisitor()));
	}

	public List<IStatement> getIfTrueStatements (){
		return conditionTrueList;
	}

	public List<IStatement> getIfFalseStatements(){
		return conditionFalseList;
	}

	@Override
	public void accept(IStatementsVisitor visitor) {
		visitor.visit(this);
	}

}