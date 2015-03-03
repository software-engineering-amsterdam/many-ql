package uva.qls.ast.component;

import java.util.ArrayList;

import uva.qls.ast.style.*;
import uva.qls.ast.CodeLines;
import uva.qls.ast.statements.Statement;

public abstract class Component extends Statement{
	
	protected ArrayList<Style> style;
	
	public Component(CodeLines _codeLines) {
		super(_codeLines);
	}
}
