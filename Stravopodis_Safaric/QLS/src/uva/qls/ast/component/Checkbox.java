package uva.qls.ast.component;

import java.util.ArrayList;

import uva.qls.ast.CodeLines;
import uva.qls.ast.value.StringValue;
import uva.qls.supporting.Tuple;
import uva.qls.ast.style.*;

public class Checkbox extends Component{
	
	private String value;
	
	public Checkbox(String _value, ArrayList<Style> _style, CodeLines _codeLines) {
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
		return new StringValue(this.value);
	}
}
