package uva.qls.ast.style;

import uva.qls.ast.CodeLines;
import uva.qls.ast.statements.Statement;
import uva.qls.ast.statements.visitor.StatementVisitor;
import uva.qls.ast.value.GenericValue;
import uva.qls.supporting.*;

public abstract class Style extends Statement{

	public Style(CodeLines _codeLines) {
		super(_codeLines);
	}

	@Override
	public abstract String toString();
	public abstract GenericValue<?> evaluate();
	public abstract <T> T accept(StatementVisitor<T> visitor);
	
	@Override
	public Tuple<Integer, Integer> getLOCTuple() {
		return this.codeLines.getCodeLocation();
	}

	@Override
	public CodeLines getLOC() {
		return this.codeLines;
	}

}
