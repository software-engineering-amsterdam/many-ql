package uva.qls.ast.component;

import java.util.ArrayList;
import java.util.Arrays;

import uva.qls.ast.CodeLines;
import uva.qls.ast.statements.visitor.StatementVisitor;
import uva.qls.ast.style.visitor.StyleTable;
import uva.qls.ast.value.StringValue;
import uva.qls.supporting.*;

public class Dropdown extends Component{

	private Tuple<String, String> values;
	private StyleTable style;
	
	public Dropdown(String _valOne, String _valSec, StyleTable _style, CodeLines _codeLines) {
		super(_codeLines);
		this.values = new Tuple<String, String>(_valOne.replaceAll("[\"]", ""), _valSec.replaceAll("[\"]", ""));
		this.style = _style;
	}

	public ArrayList<String> getComponents(){
		return new ArrayList<>(Arrays.asList(this.getNullValue().getValue(), this.values.getTuple().getX(), this.values.getTuple().getY()));
	}
	
	public StringValue getNullValue(){
		return new StringValue("");
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visitDropDown(this);
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
		return "Dropdown(" + this.values.toString() + " " + this.style + ")";
	}

	@Override
	public String getName() {
		return this.getClass().getSimpleName().toLowerCase();
	}

}
