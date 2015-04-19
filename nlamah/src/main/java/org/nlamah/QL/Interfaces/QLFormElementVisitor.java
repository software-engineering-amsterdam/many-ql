package org.nlamah.QL.Interfaces;

import org.nlamah.QL.Model.Form.BooleanQuestion;
import org.nlamah.QL.Model.Form.ComputedQuestion;
import org.nlamah.QL.Model.Form.ConditionalBlock;
import org.nlamah.QL.Model.Form.ElseIfThenBlock;
import org.nlamah.QL.Model.Form.ElseThenBlock;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.Model.Form.IfThenBlock;
import org.nlamah.QL.Model.Form.NumberQuestion;
import org.nlamah.QL.Model.Form.TextQuestion;

public interface QLFormElementVisitor 
{
	public void visit(Form form);
	public void visit(BooleanQuestion booleanQuestion);
	public void visit(ComputedQuestion computedQuestion);
	public void visit(NumberQuestion numberQuestion);
	public void visit(TextQuestion textQuestion);
	public void visit(ElseIfThenBlock elseIfThenBlock);
	public void visit(ElseThenBlock elseThenBlock);
	public void visit(IfThenBlock ifThenBlock);
	public void visit(ConditionalBlock conditionalBlock);
}
