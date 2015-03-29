package uva.qls.ast.component;


import uva.qls.ast.CodeLines;
import uva.qls.ast.literal.StringLiteral;
import uva.qls.ast.statements.visitor.StatementVisitor;
import uva.qls.ast.style.visitor.StyleTable;

public class Checkbox extends Component{
	
	private StringLiteral value;
	private StyleTable style;
	
	public Checkbox(StringLiteral _value, StyleTable _style, CodeLines _codeLines) {
		super(_codeLines);
		this.value = _value;
		this.style = _style;
	}
	
	public String getCheckboxValue(){
		return this.value.toString();
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visitCheckBox(this);
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
		return "Checkbox(" + this.value.toString() + " " + this.style.toString() + ")";
	}

	@Override
	public String getName() {
		return this.getClass().getSimpleName().toLowerCase();
	}
}
