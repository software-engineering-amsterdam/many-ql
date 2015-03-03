package uva.qls.ast.component;

import java.util.ArrayList;

import uva.qls.ast.CodeLines;
import uva.qls.ast.value.StringValue;
import uva.qls.supporting.Tuple;
import uva.qls.ast.literal.StringLiteral;
import uva.qls.ast.style.*;

public class Checkbox extends Component{
	
	private StringLiteral value;
	
	public Checkbox(StringLiteral _value, ArrayList<Style> _style, CodeLines _codeLines) {
		super(_codeLines);
		this.value = _value;
		this.style = _style;
	}
	
	@Override
	public Tuple<Integer, Integer> getLOCTuple() {
		return this.codeLines.getCodeLocation();
	}

	@Override
	public CodeLines getLOC() {
		return this.codeLines;
	}

	@Override
	public StringValue evaluate() {
		return new StringValue(this.value.evaluatedValue());
	}
	@Override
	public String toString(){
		return "Checkbox(" + this.value.evaluatedValue() + " " + this.style.toString() + ")";
	}
}
