package uva.ql.typecheck;

import uva.ql.ast.statements.*;
import uva.ql.ast.expressions.*;

public class Symbol {

	protected Statement statement;
	protected String name;
	protected Type type;
	
	public Symbol (Statement statement, String name, Type type){
		this.statement = statement;
		this.name = name;
		this.type = type;
		
	}
	
	public Statement getStatement() {
		return statement;
		
	}
	
	public String getName() {
		return name;
		}
	public Type getType() {
		
		return type;
	}
	
	public String toString() {
		
		if(type != null) return '<' + getName() + ':' + type +'>';
		return getName();
	}
}


