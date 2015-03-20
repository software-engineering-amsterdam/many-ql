package uva.qls.ast.component;

import uva.qls.ast.style.visitor.StyleTable;
import uva.qls.ast.CodeLines;
import uva.qls.ast.statements.Statement;
import uva.qls.ast.statements.visitor.StatementVisitor;

public abstract class Component extends Statement{
	
	public abstract <T> T accept(StatementVisitor<T> visitor);
	public abstract String getName();
	public abstract void componentStyle(StyleTable style);
	public abstract StyleTable getStyle();
	
	public Component(CodeLines _codeLines) {
		super(_codeLines);
	}
}
