package uva.qls.ast.component;

import uva.qls.ast.CodeLines;
import uva.qls.supporting.Tuple;

public class Slider extends Component{
	
	private Tuple<String, String> minMax;
	
	public Slider(String _min, String _max, CodeLines _codeLines) {
		super(_codeLines);
		this.minMax = new Tuple<String, String>(_min, _max);
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
		return this.minMax;
	}
}
