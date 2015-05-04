package org.nlamah.QL.Interfaces;

import org.nlamah.QL.View.Controllers.BooleanQuestionViewController;
import org.nlamah.QL.View.Controllers.ComputedQuestionViewController;
import org.nlamah.QL.View.Controllers.ConditionalBlockViewController;
import org.nlamah.QL.View.Controllers.ElseIfThenBlockViewController;
import org.nlamah.QL.View.Controllers.ElseThenBlockViewController;
import org.nlamah.QL.View.Controllers.FormRootViewController;
import org.nlamah.QL.View.Controllers.IfThenBlockViewController;
import org.nlamah.QL.View.Controllers.NumberQuestionViewController;
import org.nlamah.QL.View.Controllers.TextQuestionViewController;

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
