package uva.qls.ast.component;

import uva.qls.ast.CodeLines;
import uva.qls.ast.statements.Statement;

public abstract class Component extends Statement{

	public Component(CodeLines _codeLines) {
		super(_codeLines);
	}
}
