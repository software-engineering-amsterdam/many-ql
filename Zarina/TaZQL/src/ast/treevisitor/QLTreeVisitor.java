package ast.treevisitor;

import ast.expression.variables.Id;
import ast.expression.variables.StringVariable;
import ast.form.Form;
import ast.question.SimpleQuestion;


public interface QLTreeVisitor<T> {
	
	T visitForm(Form form);
	T visitSimpleQuestion(SimpleQuestion simpleQuestion);
	
	T visitId(Id id);
	T visitText(StringVariable string);
}
