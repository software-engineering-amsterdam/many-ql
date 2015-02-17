package uva.ql.ast;

public class Prog extends ASTClass{
	private Form form;
	
	public Prog (Form _form){
		this.form = _form;
	}
	public Form getProg(){
		return this.form;
	}
}
