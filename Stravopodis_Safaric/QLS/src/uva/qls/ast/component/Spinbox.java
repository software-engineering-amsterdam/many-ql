package uva.qls.ast.component;

import java.util.ArrayList;
import java.util.List;

import uva.qls.ast.CodeLines;
import uva.qls.ast.statements.visitor.StatementVisitor;
import uva.qls.ast.style.Style;
import uva.qls.ast.value.GenericValue;
import uva.qls.supporting.*;

public class Spinbox extends Component{

	public Spinbox(CodeLines _codeLines, ArrayList<Style> _style) {
		super(_codeLines);
		this.style = _style;
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visitSpinbox(this);
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
	public void componentStyle(List<Style> style) {
		this.style = style;
	}
	
	@Override
	public String toString(){
		return "Spinbox(" + this.style.toString() + ")";
	}
	
	@Override
	public String getName() {
		return this.getClass().getSimpleName().toLowerCase();
	}

}
