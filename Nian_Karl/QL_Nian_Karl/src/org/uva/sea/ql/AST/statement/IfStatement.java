package org.uva.sea.ql.AST.statement;


import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.AST.Node;
import org.uva.sea.ql.AST.expression.Expression;
import org.uva.sea.ql.AST.value.BooleanValue;
import org.uva.sea.ql.AST.visitor.Visitor;

public class IfStatement extends Statement{

	private List<Statement> statementList;
	
	private final Expression expr;
	
	public IfStatement(Expression expr) {
		this.expr = expr;
		this.statementList = new ArrayList<Statement>();
	}
	
	public void addStatement(Statement statement) {
		statementList.add(statement);
	}

	public Statement getStatement(int i) {
		if (i >= this.statementList.size()) {
			throw new IndexOutOfBoundsException("Index out of bound on " + i + " with size: " + this.statementList.size());
		}
		return this.statementList.get(i);
	}
	
	public List<Statement> getStatements() {
		return statementList;
	}
	
	public Expression getExpr() {
		return expr;
	}
	
	public BooleanValue interpretExpression(){
		return (BooleanValue) expr.interpretExpression();
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
