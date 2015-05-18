package org.nlamah.QL.Interfaces;

import org.nlamah.QL.Model.Form.ComputedQuestion;
import org.nlamah.QL.Model.Form.ConditionalBlock;
import org.nlamah.QL.Model.Form.ElseIfThenBlock;
import org.nlamah.QL.Model.Form.ElseThenBlock;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.Model.Form.IfThenBlock;
import org.nlamah.QL.Model.Form.InputQuestion;

public interface QLFormElementVisitor 
{
	public void visit(Form form);
	public void visit(ElseIfThenBlock elseIfThenBlock);
	public void visit(ElseThenBlock elseThenBlock);
	public void visit(IfThenBlock ifThenBlock);
	public void visit(ConditionalBlock conditionalBlock);
	public void visit(InputQuestion inputQuestion);
	public void visit(ComputedQuestion computedQuestion);
}