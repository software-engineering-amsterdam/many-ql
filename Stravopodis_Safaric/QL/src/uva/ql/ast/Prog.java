package uva.ql.ast;

import uva.ql.ast.visitor.StatementVisitor;

public class Prog extends Node{
	
	private Form form;
	
	public Prog (Form _form, CodeLines _codeLines){
		super(_codeLines);
		this.form = _form;
	}
	
	public Form getForm(){
		return this.form;
	}
	
	public <T> T accept(StatementVisitor<T> visitor){
		return visitor.visitProg(this);
	}
	
	@Override
	public String toString(){
		return "Prog(" + this.form.toString() + ")";
	}
}
