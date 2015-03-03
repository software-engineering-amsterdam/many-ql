package uva.qls.ast.style;

import uva.qls.ast.CodeLines;
import uva.qls.ast.value.GenericValue;

public abstract class Font extends Style{

	public Font(CodeLines _codeLines) {
		super(_codeLines);
	}
	
	public abstract GenericValue<?> evaluate();
	public abstract String toString();
	
}
