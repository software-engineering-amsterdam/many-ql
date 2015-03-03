package uva.qls.ast.style;

import uva.qls.ast.CodeLines;
import uva.qls.ast.statements.Statement;
import uva.qls.ast.value.GenericValue;
import uva.qls.supporting.Tuple;

public abstract class Style extends Statement{

	public Style(CodeLines _codeLines) {
		super(_codeLines);
	}

	public abstract GenericValue<?> evaluate();
	@Override
	public abstract String toString();
	
	@Override
	public Tuple<Integer, Integer> getLOCTuple() {
		return this.codeLines.getCodeLocation();
	}

	@Override
	public CodeLines getLOC() {
		return this.codeLines;
	}

}
