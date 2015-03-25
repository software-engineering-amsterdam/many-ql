package uva.qls.ast.component;

import uva.qls.ast.CodeLines;
import uva.qls.ast.statements.visitor.StatementVisitor;
import uva.qls.ast.style.visitor.StyleTable;

public class Spinbox extends Component{
	
	private StyleTable style;
	
	public Spinbox(CodeLines _codeLines, StyleTable _style) {
		super(_codeLines);
		this.style = _style;
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visitSpinbox(this);
	}

	@Override
	public void componentStyle(StyleTable style) {
		this.style = style;
	}
	
	@Override
	public StyleTable getStyle() {
		return this.style;
	}
	
	@Override
	public String toString(){
		return "Spinbox(" + this.style.toString() + ")";
	}
	
	@Override
	public String getName() {
		return this.getClass().getSimpleName().toLowerCase();
	}

}
