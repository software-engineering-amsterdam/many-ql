package org.nlamah.QL.Visitors;

import java.util.ArrayList;

import org.nlamah.QL.Helper.Helper;
import org.nlamah.QL.Model.Expression.Binary.AddExpression;
import org.nlamah.QL.Model.Expression.Binary.AndExpression;
import org.nlamah.QL.Model.Expression.Binary.DivideExpression;
import org.nlamah.QL.Model.Expression.Binary.EqualExpression;
import org.nlamah.QL.Model.Expression.Binary.GreaterThanEqualExpression;
import org.nlamah.QL.Model.Expression.Binary.GreaterThanExpression;
import org.nlamah.QL.Model.Expression.Binary.MultiplyExpression;
import org.nlamah.QL.Model.Expression.Binary.OrExpression;
import org.nlamah.QL.Model.Expression.Binary.SmallerThanEqualExpression;
import org.nlamah.QL.Model.Expression.Binary.SmallerThanExpression;
import org.nlamah.QL.Model.Expression.Binary.SubtractExpression;
import org.nlamah.QL.Model.Expression.Binary.UnEqualExpression;
import org.nlamah.QL.Model.Expression.Literal.BooleanLiteral;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Expression.Literal.NumberLiteral;
import org.nlamah.QL.Model.Expression.Literal.TextLiteral;
import org.nlamah.QL.Model.Expression.Unary.MinusExpression;
import org.nlamah.QL.Model.Expression.Unary.NotExpression;
import org.nlamah.QL.Model.Expression.Unary.PlusExpression;
import org.nlamah.QL.Model.Form.BooleanQuestion;
import org.nlamah.QL.Model.Form.ComputedQuestion;
import org.nlamah.QL.Model.Form.ConditionalBlock;
import org.nlamah.QL.Model.Form.ElseIfThenBlock;
import org.nlamah.QL.Model.Form.ElseThenBlock;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.Model.Form.IfThenBlock;
import org.nlamah.QL.Model.Form.NumberQuestion;
import org.nlamah.QL.Model.Form.TextQuestion;
import org.nlamah.QL.Model.Form.Abstract.DeclaringFormElement;
import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.Model.Form.Abstract.QLNode;
import org.nlamah.QL.ViewControllers.Form.BooleanQuestionViewController;
import org.nlamah.QL.ViewControllers.Form.ComputedQuestionViewController;
import org.nlamah.QL.ViewControllers.Form.ConditionalBlockViewController;
import org.nlamah.QL.ViewControllers.Form.ElseIfThenBlockViewController;
import org.nlamah.QL.ViewControllers.Form.ElseThenBlockViewController;
import org.nlamah.QL.ViewControllers.Form.IfThenBlockViewController;
import org.nlamah.QL.ViewControllers.Form.NumberQuestionViewController;
import org.nlamah.QL.ViewControllers.Form.TextQuestionViewController;
import org.nlamah.QL.ViewControllers.Form.Abstract.DeclaringFormElementViewController;
import org.nlamah.QL.ViewControllers.Form.Abstract.FormElementViewController;

public class QLViewControllersFactory implements QLNodeVisitor 
{	
	FormElementViewController cc;
	
	public QLViewControllersFactory()
	{
		super();	
	}
	
	public ArrayList<FormElementViewController> childViewControllers(DeclaringFormElement declaringFormElement)
	{
		ArrayList<FormElementViewController> childViewControllers = null;
		
		if (Helper.arrayExistsAndHasElements(declaringFormElement.childElements()))
		{
			childViewControllers = new ArrayList<FormElementViewController>();
			
			for (FormElement formElement : declaringFormElement.childElements())
			{
				formElement.accept(this);
				
				childViewControllers.add(cc);
			}
		}
		
		return childViewControllers;
	}
	

	@Override
	public QLNode visit(AddExpression addExpression) 
	{
		assert false;
		return null;
	}

	@Override
	public QLNode visit(AndExpression andExpression) 
	{
		assert false;
		return null;
	}

	@Override
	public QLNode visit(DivideExpression divideExpression) 
	{
		assert false;
		return null;
	}

	@Override
	public QLNode visit(EqualExpression equalExpression) 
	{
		assert false;
		return null;
	}

	@Override
	public QLNode visit(GreaterThanExpression greaterThanExpression) 
	{
		assert false;
		return null;
	}

	@Override
	public QLNode visit(GreaterThanEqualExpression greaterThanEqualExpression) 
	{
		assert false;
		return null;
	}

	@Override
	public QLNode visit(MultiplyExpression multiplyExpression) 
	{
		assert false;
		return null;
	}

	@Override
	public QLNode visit(OrExpression orExpression) 
	{
		assert false;
		return null;
	}

	@Override
	public QLNode visit(SmallerThanExpression smallerThanExpression) 
	{
		assert false;
		return null;
	}

	@Override
	public QLNode visit(SmallerThanEqualExpression smallerThanEqualExpression) 
	{
		assert false;
		return null;
	}

	@Override
	public QLNode visit(SubtractExpression subtractExpression) 
	{
		assert false;
		return null;
	}

	@Override
	public QLNode visit(UnEqualExpression unEqualExpression) 
	{
		assert false;
		return null;
	}

	@Override
	public QLNode visit(BooleanLiteral booleanLiteral) 
	{
		assert false;
		return null;
	}

	@Override
	public QLNode visit(IdentifierLiteral identifierLiteral) 
	{
		assert false;
		return null;
	}

	@Override
	public QLNode visit(NumberLiteral numberLiteral) 
	{
		assert false;
		return null;
	}

	@Override
	public QLNode visit(TextLiteral textLiteral) 
	{
		assert false;
		return null;
	}

	@Override
	public QLNode visit(MinusExpression minusExpression) 
	{
		assert false;
		return null;
	}

	@Override
	public QLNode visit(NotExpression notExpression) 
	{
		assert false;
		return null;
	}

	@Override
	public QLNode visit(PlusExpression plusExpression) 
	{
		assert false;
		return null;
	}

	@Override
	public QLNode visit(BooleanQuestion booleanQuestion) 
	{
		cc = new BooleanQuestionViewController(booleanQuestion);
		
		return null;
	}

	@Override
	public QLNode visit(ComputedQuestion computedQuestion) 
	{
		cc = new ComputedQuestionViewController(computedQuestion);
		
		return null;
	}

	@Override
	public QLNode visit(ConditionalBlock conditionalBlock) 
	{
		cc = new ConditionalBlockViewController(conditionalBlock);
		
		return null;
	}

	@Override
	public QLNode visit(ElseIfThenBlock elseIfThenBlock) 
	{	
		DeclaringFormElementViewController dvc = new ElseIfThenBlockViewController(elseIfThenBlock);
		
		dvc.setChildViewControllers(childViewControllers(elseIfThenBlock));
		
		cc = dvc;
		
		return null;
	}

	@Override
	public QLNode visit(ElseThenBlock elseThenBlock) 
	{
		DeclaringFormElementViewController dvc = new ElseThenBlockViewController(elseThenBlock);
		
		dvc.setChildViewControllers(childViewControllers(elseThenBlock));
		
		cc = dvc;
		
		return null;
	}

	@Override
	public QLNode visit(Form form) 
	{
		assert false;
		
		return null;
	}

	@Override
	public QLNode visit(IfThenBlock ifThenBlock) 
	{
		DeclaringFormElementViewController dvc = new IfThenBlockViewController(ifThenBlock);
		
		dvc.setChildViewControllers(childViewControllers(ifThenBlock));
		
		cc = dvc;
		
		return null;
	}

	@Override
	public QLNode visit(NumberQuestion numberQuestion) 
	{
		cc = new NumberQuestionViewController(numberQuestion);
		
		return null;
	}

	@Override
	public QLNode visit(TextQuestion textQuestion) 
	{
		
		cc = new TextQuestionViewController(textQuestion);
		
		return null;
	}

}
