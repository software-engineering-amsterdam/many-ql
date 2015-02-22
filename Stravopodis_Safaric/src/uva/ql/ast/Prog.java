package uva.ql.ast;

import uva.ql.ast.value.GenericValue;
import uva.ql.ast.visitor.VisitorInterface;

public class Prog extends ASTNode{
	
	private Form form;
	
	public Prog (Form _form, CodeLines _codeLines){
		super(_codeLines);
		this.form = _form;
	}
	public Form getProg(){
		return this.form;
	}
	
	@Override
	public String toString(){
		return "Prog(" + this.form.toString() + ")";
	}
	@Override
	public GenericValue<?> evaluate() {
		return null;
	}
	public <T> void accept(VisitorInterface<T> visitor){
		visitor.visitProg(this);
	}
}
