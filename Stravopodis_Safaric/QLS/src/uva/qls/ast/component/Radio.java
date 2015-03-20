package uva.qls.ast.component;


import uva.qls.ast.CodeLines;
import uva.qls.ast.statements.visitor.StatementVisitor;
import uva.qls.ast.style.visitor.StyleTable;
import uva.qls.supporting.*;

public class Radio extends Component {

	private Tuple<String, String> values;
	private StyleTable style;
	
	public Radio(String _valOne, String _valSec, StyleTable _style , CodeLines _codeLines) {
		super(_codeLines);
		this.values = new Tuple<String, String>(_valOne, _valSec);
		this.style = _style;
	}

	public Tuple<String, String> getRadioValues(){
		return this.values;
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visitRadio(this);
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
		return "Radio(" + this.values.toString() + " " + this.style + ")";
	}

	@Override
	public String getName() {
		return this.getClass().getSimpleName().toLowerCase();
	}

}
