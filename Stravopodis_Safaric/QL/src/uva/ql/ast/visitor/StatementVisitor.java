package uva.ql.ast.visitor;

import uva.ql.ast.Node;
import uva.ql.ast.Form;
import uva.ql.ast.Prog;
import uva.ql.ast.statements.Assign;
import uva.ql.ast.statements.IfStatement;
import uva.ql.ast.statements.Question;
import uva.ql.ast.statements.Statement;

public interface StatementVisitor<T> {
	
	public T visitProg(Prog prog);
	public T visitForm(Form form);
	public T visitASTNode(Node node);
	
	public T visitStatement(Statement statement);
	public T visitSimpleQuestion(Question question);
	public T visitComputedQuestion(Question question);
	public T visitIfStatement(IfStatement ifStatement);
	public T visitAssign(Assign assign);
}
