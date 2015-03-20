package uva.qls.ast.component;

import uva.qls.ast.CodeLines;
import uva.qls.ast.statements.visitor.StatementVisitor;
import uva.qls.ast.style.visitor.StyleTable;

public class Textbox extends Component {

	private StyleTable style;
	
	public Textbox(CodeLines _codeLines, StyleTable _style) {
		super(_codeLines);		
		this.style = _style;
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visitTextbox(this);
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
		return "Textbox(" + this.style + ")";
	}

	@Override
	public String getName() {
		return this.getClass().getSimpleName().toLowerCase();
	}
	
}
