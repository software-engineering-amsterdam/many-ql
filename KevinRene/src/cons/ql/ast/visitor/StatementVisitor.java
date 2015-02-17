package cons.ql.ast.visitor;

import cons.ql.ast.Statement;
import cons.ql.ast.statement.Block;
import cons.ql.ast.statement.ComputedQuestion;
import cons.ql.ast.statement.Form;
import cons.ql.ast.statement.If;
import cons.ql.ast.statement.Question;

public interface StatementVisitor extends Visitor {
	default void visit(Block blockNode) {
		for(Statement statement : blockNode.statements()) {
			statement.accept(this);
		}
	}
	
	default void visit(ComputedQuestion compQuestionNode) {
		compQuestionNode.getIdent().accept(this);
		compQuestionNode.getType().accept(this);
		compQuestionNode.getText().accept(this);
		compQuestionNode.getExpression().accept(this);
	}
	
	default void visit(Form formNode) {
		formNode.getIdent().accept(this);
		formNode.getBlock().accept(this);
	}
	
	default void visit(If ifNode) {
		ifNode.getExpression().accept(this);
		ifNode.getBlock().accept(this);
	}
	
	default void visit(Question questionNode) {
		questionNode.getIdent().accept(this);
		questionNode.getType().accept(this);
		questionNode.getText().accept(this);
	}
}
