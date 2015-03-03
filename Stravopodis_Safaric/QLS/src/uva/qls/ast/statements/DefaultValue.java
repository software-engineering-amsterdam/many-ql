package uva.qls.ast.statements;

import java.util.List;

import uva.qls.ast.CodeLines;
import uva.qls.ast.component.Component;
import uva.qls.ast.primitive.Type;
import uva.qls.ast.value.GenericValue;
import uva.qls.supporting.Tuple;

public class DefaultValue extends Statement {
	
	private Type type;
	private Component component;
	private List<Statement> statement;

	
	public DefaultValue (Type _type,Component _component, CodeLines _codeLines ){
		super(_codeLines);
		this.component=_component;
		this.type=_type;
	}
	
	public DefaultValue(Type _type, List<Statement> _statement, CodeLines _codeLines){
		super(_codeLines);
		this.statement=_statement;
		this.type=_type;
	}
	
	public Type getType(){
		return this.type;
	}
	public List<Statement> getStatement(){
		return this.statement;
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
		return this.statement 	!= null ? "DefaultValue(" + this.getType().toString() + "," + this.statement.toString()
								: "DefaultValue(" + this.getType().toString() + "," + this.component.toString() + ")";
	}
}
