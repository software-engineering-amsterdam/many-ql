package uva.qls.ast.component;

import java.util.ArrayList;

import uva.qls.ast.CodeLines;
import uva.qls.ast.statements.visitor.StatementVisitor;
import uva.qls.ast.style.Style;
import uva.qls.ast.value.GenericValue;
import uva.qls.supporting.Tuple;

public class Textbox extends Component {

	public Textbox(CodeLines _codeLines, ArrayList<Style> _style) {
		super(_codeLines);		
		this.style = _style;
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visitTextbox(this);
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
	@Override
	public String toString(){
		return "Textbox(" + this.style.toString() + ")";
	}

}
