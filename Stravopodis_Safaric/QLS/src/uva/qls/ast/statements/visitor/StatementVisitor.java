package uva.qls.ast.statements.visitor;

import uva.qls.ast.ASTNode;
import uva.qls.ast.Page;
import uva.qls.ast.Prog;
import uva.qls.ast.StyleSheet;
import uva.qls.ast.component.visitor.ComponentVisitor;
import uva.qls.ast.literal.visitor.LiteralVisitor;
import uva.qls.ast.statements.DefaultValue;
import uva.qls.ast.statements.Question;
import uva.qls.ast.statements.Section;
import uva.qls.ast.statements.Statement;
import uva.qls.ast.statements.Subsection;
import uva.qls.ast.style.visitor.StyleVisitor;
import uva.qls.ast.type.TypeVisitor;

public interface StatementVisitor<T> extends StyleVisitor<T>, ComponentVisitor<T>, LiteralVisitor<T>, TypeVisitor<T>{

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
