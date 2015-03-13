package uva.qls.ast.component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import uva.qls.ast.CodeLines;
import uva.qls.ast.statements.visitor.StatementVisitor;
import uva.qls.ast.style.Style;
import uva.qls.ast.value.StringValue;
import uva.qls.supporting.*;

public class Dropdown extends Component{

	private Tuple<String, String> values;
	
	public Dropdown(String _valOne, String _valSec, ArrayList<Style> _style, CodeLines _codeLines) {
		super(_codeLines);
		this.values = new Tuple<String, String>(_valOne, _valSec);
		this.style = _style;
	}

	public ArrayList<String> getComponents(){
		return new ArrayList<>(Arrays.asList(this.getNullValue().getValue(), this.values.k, this.values.l));
	}
	
	public StringValue getNullValue(){
		return new StringValue("");
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visitDropDown(this);
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
	
	@Override
	public void componentStyle(List<Style> style) {
		this.style = style;
	}
	
	@Override
	public String toString(){
		return "Dropdown(" + this.values.toString() + " " + this.style.toString() + ")";
	}

	@Override
	public String getName() {
		return this.getClass().getSimpleName().toLowerCase();
	}

}
