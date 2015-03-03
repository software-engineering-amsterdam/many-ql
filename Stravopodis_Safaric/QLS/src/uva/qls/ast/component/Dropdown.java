package uva.qls.ast.component;

import uva.qls.ast.CodeLines;
import uva.qls.ast.value.StringValue;
import uva.qls.supporting.Tuple;

public class Dropdown extends Component{

	private Tuple<String, String> values;
	
	public Dropdown(String _valOne, String _valSec, CodeLines _codeLines) {
		super(_codeLines);
		this.values = new Tuple<String, String>(_valOne, _valSec);
	}

	public StringValue getNullValue(){
		return new StringValue("");
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
	public Tuple<String, String> evaluate() {
		return this.values;
	}

}
