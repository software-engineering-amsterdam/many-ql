package uva.qls.ast.statements.visitor;

import uva.qls.ast.component.visitor.ComponentVisitor;
import uva.qls.ast.literal.visitor.LiteralVisitor;
import uva.qls.ast.statements.*;
import uva.qls.ast.style.visitor.StyleVisitor;
import uva.qls.ast.*;

public interface StatementVisitor<T> extends StyleVisitor<T>, ComponentVisitor<T>, LiteralVisitor<T> {

	public T visitASTNode(ASTNode node);
	public T visitProg(Prog prog);
	public T visitPage(Page page);
	public T visitStyleSheet(StyleSheet styleSheet);
	
	public T visitStatement(Statement statement);
	public T visitDefaultValueComponent(DefaultValue defaultValue);
	public T visitDefaultValueStatements(DefaultValue defaultValue);
	public T visitQuestion(Question question);
	public T visitSection(Section section);
	public T visitSubsection(Subsection subsection);
}
