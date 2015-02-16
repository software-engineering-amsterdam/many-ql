package cons.ql.ast.visitor.binder;

import cons.Register;
import cons.ql.ast.expression.literal.QLIdent;
import cons.ql.ast.statement.Question;
import cons.ql.ast.visitor.ExpressionVisitor;
import cons.ql.ast.visitor.StatementVisitor;

public class Binder implements ExpressionVisitor, StatementVisitor  {
	
	private Register register = Register.getInstance();
	
	public void visit(Question questionNode) {
		questionNode.getIdent().accept(this);
		questionNode.getType().accept(this);
		questionNode.getText().accept(this);
		
		register.registerBinding(questionNode.getIdent(), questionNode.getType());
	}
}
