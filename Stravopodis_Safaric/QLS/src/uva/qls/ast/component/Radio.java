package uva.qls.ast.component;

import java.util.ArrayList;

import uva.qls.ast.CodeLines;
import uva.qls.ast.style.Style;
import uva.qls.supporting.Tuple;

public class Radio extends Component {

	private Tuple<String, String> values;
	
	public Radio(String _valOne, String _valSec, ArrayList<Style> _style , CodeLines _codeLines) {
		super(_codeLines);
		this.values = new Tuple<String, String>(_valOne, _valSec);
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
	public Tuple<String, String> evaluate() {
		return this.values;
	}

}
