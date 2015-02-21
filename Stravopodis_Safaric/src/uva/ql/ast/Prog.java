package uva.ql.ast;

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
}
