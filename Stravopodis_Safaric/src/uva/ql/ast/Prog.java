package uva.ql.ast;

import uva.ql.ast.value.GenericValue;
import uva.ql.ast.visitor.StatementVisitorInterface;

public class Prog extends ASTNode{
	
	private Form form;
	
	public Prog (Form _form, CodeLines _codeLines){
		super(_codeLines);
		this.form = _form;
	}
	
	public Form getForm(){
		return this.form;
	}
	
	@Override
	public GenericValue<?> evaluate() {
		return null;
	}
	
	public <T> T accept(StatementVisitorInterface<T> visitor){
		return visitor.visitProg(this);
	}
	
	@Override
	public String toString(){
		return "Prog(" + this.form.toString() + ")";
	}
}
