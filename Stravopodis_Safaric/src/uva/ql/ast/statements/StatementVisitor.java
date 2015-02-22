package uva.ql.ast.statements;

import uva.ql.ast.declarations.Declaration;
import uva.ql.ast.question.Question;

public interface StatementVisitor<T> {
	
	public T visitStatement(Statement statement);
	public T visitQuestion(Question question);
	public T visitDeclaration(Declaration declaration);
	public T visitIfStatement(IfStatement ifStatement);
	public T visitAssign(Assign assign);
}
