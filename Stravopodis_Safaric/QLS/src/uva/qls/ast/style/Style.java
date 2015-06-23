package uva.qls.ast.style;

import uva.qls.ast.CodeLines;
import uva.qls.ast.statements.Statement;
import uva.qls.ast.statements.visitor.StatementVisitor;
import uva.qls.ast.value.GenericValue;

public abstract class Style extends Statement{

	public Style(CodeLines _codeLines) {
		super(_codeLines);
	}

	@Override
	public abstract String toString();
	public abstract String getStyleType();
	public abstract GenericValue<?> evaluate();
	public abstract <T> T accept(StatementVisitor<T> visitor);
	
}
