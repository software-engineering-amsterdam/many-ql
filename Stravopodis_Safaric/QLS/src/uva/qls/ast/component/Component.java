package uva.qls.ast.component;

import java.util.ArrayList;
import uva.qls.ast.style.*;
import uva.qls.ast.CodeLines;
import uva.qls.ast.statements.Statement;
import uva.qls.ast.statements.visitor.StatementVisitor;

public abstract class Component extends Statement{
	
	protected ArrayList<Style> style;
	public abstract <T> T accept(StatementVisitor<T> visitor);
	public abstract String getName();
	
	public Component(CodeLines _codeLines) {
		super(_codeLines);
	}
}
