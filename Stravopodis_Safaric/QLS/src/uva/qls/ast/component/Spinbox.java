package uva.qls.ast.component;

import uva.qls.ast.CodeLines;
import uva.qls.ast.value.GenericValue;
import uva.qls.supporting.Tuple;

public class Spinbox extends Component{

	public Spinbox(CodeLines _codeLines) {
		super(_codeLines);
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
	public GenericValue<?> evaluate() {
		return null;
	}

}
