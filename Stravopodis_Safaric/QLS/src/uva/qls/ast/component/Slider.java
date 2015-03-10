package uva.qls.ast.component;

import java.util.ArrayList;

import uva.qls.ast.CodeLines;
import uva.qls.ast.statements.visitor.StatementVisitor;
import uva.qls.ast.style.Style;
import uva.qls.supporting.*;

public class Slider extends Component{
	
	private Tuple<String, String> minMax;
	
	public Slider(String _min, String _max, ArrayList<Style> _style , CodeLines _codeLines) {
		super(_codeLines);
		this.minMax = new Tuple<String, String>(_min, _max);
		this.style = _style;
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visitSlider(this);
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
	@Override
	public String toString(){
		return "Slider(" + this.minMax.toString() + " " + this.style.toString() + ")";
	}

	@Override
	public String getName() {
		return this.getClass().getSimpleName().toLowerCase();
	}
}
