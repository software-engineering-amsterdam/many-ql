package uva.ql.ast.visitor;

import uva.ql.ast.ASTNode;
import uva.ql.ast.Form;
import uva.ql.ast.Prog;
import uva.ql.ast.question.Question;
import uva.ql.ast.statements.Assign;
import uva.ql.ast.statements.IfStatement;
import uva.ql.ast.statements.Statement;

public interface StatementVisitorInterface<T> {
	
	public T visitProg(Prog prog);
	public T visitForm(Form form);
	public T visitASTNode(ASTNode node);
	
	public T visitStatement(Statement statement);
	public T visitQuestion(Question question);
	public T visitIfStatement(IfStatement ifStatement);
	public T visitAssign(Assign assign);
}
