package ql.ast.visitor;

import ql.ast.Statement;
import ql.ast.statement.Block;
import ql.ast.statement.ComputedQuestion;
import ql.ast.statement.Form;
import ql.ast.statement.If;
import ql.ast.statement.IfElse;
import ql.ast.statement.Question;

public interface StatementVisitor<T> extends Visitor<T> {
	default T visit(Block blockNode) {
		for(Statement statement : blockNode.statements()) {
			statement.accept(this);
		}
		return null;
	}
	
	default T visit(ComputedQuestion compQuestionNode) {
		compQuestionNode.getIdentifier().accept(this);
		compQuestionNode.getType().accept(this);
		compQuestionNode.getText().accept(this);
		compQuestionNode.getExpression().accept(this);
		return null;
	}
	
	default T visit(Form formNode) {
		formNode.getIdentifier().accept(this);
		formNode.getBlock().accept(this);
		return null;
	}
	
	default T visit(If ifNode) {
		ifNode.getExpression().accept(this);
		ifNode.getBlock().accept(this);
		return null;
	}
	
	default T visit(IfElse ifElseNode) {
		ifElseNode.getExpression().accept(this);
		ifElseNode.getIfBranch().accept(this);
		ifElseNode.getElseBranch().accept(this);
		return null;
	}
	
	default T visit(Question questionNode) {
		questionNode.getIdentifier().accept(this);
		questionNode.getType().accept(this);
		questionNode.getText().accept(this);
		return null;
	}
}
