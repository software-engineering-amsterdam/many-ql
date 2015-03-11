package ql.ast.visitor;

import ql.ast.Statement;
import ql.ast.statement.Block;
import ql.ast.statement.ComputedQuestion;
import ql.ast.statement.Form;
import ql.ast.statement.If;
import ql.ast.statement.IfElse;
import ql.ast.statement.Question;

public abstract class StatementVisitor<T> {
	private ExpressionVisitor<?> expressionVisitor;
	
	public void setExpressionVisitor(ExpressionVisitor<?> expressionVisitor) {
		this.expressionVisitor = expressionVisitor;
	}
	
	public T visit(Block blockNode) {
		for(Statement statement : blockNode.statements()) {
			statement.accept(this);
		}
		return null;
	}
	
	public T visit(ComputedQuestion compQuestionNode) {
		compQuestionNode.getIdentifier().accept(expressionVisitor);
		compQuestionNode.getType().accept(expressionVisitor);
		compQuestionNode.getText().accept(expressionVisitor);
		compQuestionNode.getExpression().accept(expressionVisitor);
		return null;
	}
	
	public T visit(Form formNode) {
		formNode.getIdentifier().accept(expressionVisitor);
		formNode.getBlock().accept(this);
		return null;
	}
	
	public T visit(If ifNode) {
		ifNode.getExpression().accept(expressionVisitor);
		ifNode.getBlock().accept(this);
		return null;
	}
	
	public T visit(IfElse ifElseNode) {
		ifElseNode.getExpression().accept(expressionVisitor);
		ifElseNode.getIfBranch().accept(this);
		ifElseNode.getElseBranch().accept(this);
		return null;
	}
	
	public T visit(Question questionNode) {
		questionNode.getIdentifier().accept(expressionVisitor);
		questionNode.getType().accept(expressionVisitor);
		questionNode.getText().accept(expressionVisitor);
		return null;
	}
}
