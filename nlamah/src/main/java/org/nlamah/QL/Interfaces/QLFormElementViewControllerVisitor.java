package org.nlamah.QL.Interfaces;

import org.nlamah.QL.ViewControllers.Form.BooleanQuestionViewController;
import org.nlamah.QL.ViewControllers.Form.ComputedQuestionViewController;
import org.nlamah.QL.ViewControllers.Form.ConditionalBlockViewController;
import org.nlamah.QL.ViewControllers.Form.ElseIfThenBlockViewController;
import org.nlamah.QL.ViewControllers.Form.ElseThenBlockViewController;
import org.nlamah.QL.ViewControllers.Form.FormRootViewController;
import org.nlamah.QL.ViewControllers.Form.IfThenBlockViewController;
import org.nlamah.QL.ViewControllers.Form.NumberQuestionViewController;
import org.nlamah.QL.ViewControllers.Form.TextQuestionViewController;

public interface QLFormElementViewControllerVisitor 
{
	public void visit(FormRootViewController FormRootViewController);
	public void visit(BooleanQuestionViewController booleanQuestionViewController);
	public void visit(ComputedQuestionViewController computedQuestionViewController);
	public void visit(NumberQuestionViewController numberQuestionViewController);
	public void visit(TextQuestionViewController textQuestionViewController);
	public void visit(ElseIfThenBlockViewController elseIfThenBlockViewController);
	public void visit(ElseThenBlockViewController elseThenBlockViewController);
	public void visit(IfThenBlockViewController ifThenBlockViewController);
	public void visit(ConditionalBlockViewController conditionalBlockViewController);
}
