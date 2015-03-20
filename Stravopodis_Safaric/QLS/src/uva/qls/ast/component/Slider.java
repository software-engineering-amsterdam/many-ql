package uva.qls.ast.component;

import uva.qls.ast.CodeLines;
import uva.qls.ast.statements.visitor.StatementVisitor;
import uva.qls.ast.style.visitor.StyleTable;
import uva.qls.supporting.*;

public class Slider extends Component{
	
	private Tuple<String, String> minMax;
	private StyleTable style;
	
	public Slider(String _min, String _max, StyleTable _style , CodeLines _codeLines) {
		super(_codeLines);
		this.minMax = new Tuple<String, String>(_min, _max);
		this.style = _style;
	}
	
	
	public Tuple<String, String> getSliderValues(){
		return this.minMax;
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visitSlider(this);
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
		return "Slider(" + this.minMax.toString() + " " + this.style.toString() + ")";
	}

	@Override
	public String getName() {
		return this.getClass().getSimpleName().toLowerCase();
	}
}
