package nl.uva.se.visitor;

import nl.uva.se.ast.form.Form;

public interface FormVisitor {
	
	public void visit(Form form);

}
