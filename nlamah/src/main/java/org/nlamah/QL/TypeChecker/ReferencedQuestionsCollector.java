package org.nlamah.QL.TypeChecker;

import java.util.ArrayList;
import java.util.List;

import org.nlamah.QBase.Tools.ArrayTools;
import org.nlamah.QL.Interfaces.QLNodeVisitor;
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
import org.nlamah.QL.Model.Form.ComputedQuestion;
import org.nlamah.QL.Model.Form.ConditionalBlock;
import org.nlamah.QL.Model.Form.ElseIfThenBlock;
import org.nlamah.QL.Model.Form.ElseThenBlock;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.Model.Form.IfThenBlock;
import org.nlamah.QL.Model.Form.InputQuestion;
import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.Model.Form.Abstract.QLNode;

public class ReferencedQuestionsCollector implements QLNodeVisitor 
{
	private List<IdentifierLiteral> questions;

	public ReferencedQuestionsCollector(Form form)
	{
		questions = new ArrayList<IdentifierLiteral>();

		form.accept(this);
	}

	public List<IdentifierLiteral> questions()
	{
		return this.questions;
	}

	@Override
	public QLNode visit(AddExpression addExpression) 
	{
		addExpression.leftHandExpression().accept(this);
		addExpression.rightHandExpression().accept(this);

		return null;
	}

	@Override
	public QLNode visit(AndExpression andExpression) 
	{
		andExpression.leftHandExpression().accept(this);
		andExpression.rightHandExpression().accept(this);

		return null;
	}

	@Override
	public QLNode visit(DivideExpression divideExpression) 
	{
		divideExpression.leftHandExpression().accept(this);
		divideExpression.rightHandExpression().accept(this);

		return null;
	}

	@Override
	public QLNode visit(EqualExpression equalExpression) 
	{
		equalExpression.leftHandExpression().accept(this);
		equalExpression.rightHandExpression().accept(this);

		return null;
	}

	@Override
	public QLNode visit(GreaterThanExpression greaterThanExpression) 
	{
		greaterThanExpression.leftHandExpression().accept(this);
		greaterThanExpression.rightHandExpression().accept(this);

		return null;
	}

	@Override
	public QLNode visit(GreaterThanEqualExpression greaterThanEqualExpression) 
	{
		greaterThanEqualExpression.leftHandExpression().accept(this);
		greaterThanEqualExpression.rightHandExpression().accept(this);

		return null;
	}

	@Override
	public QLNode visit(MultiplyExpression multiplyExpression) 
	{
		multiplyExpression.leftHandExpression().accept(this);
		multiplyExpression.rightHandExpression().accept(this);

		return null;
	}

	@Override
	public QLNode visit(OrExpression orExpression) 
	{
		orExpression.leftHandExpression().accept(this);
		orExpression.rightHandExpression().accept(this);

		return null;
	}

	@Override
	public QLNode visit(SmallerThanExpression smallerThanExpression) 
	{
		smallerThanExpression.leftHandExpression().accept(this);
		smallerThanExpression.rightHandExpression().accept(this);

		return null;
	}

	@Override
	public QLNode visit(SmallerThanEqualExpression smallerThanEqualExpression) 
	{
		smallerThanEqualExpression.leftHandExpression().accept(this);
		smallerThanEqualExpression.rightHandExpression().accept(this);

		return null;
	}

	@Override
	public QLNode visit(SubtractExpression subtractExpression) 
	{
		subtractExpression.leftHandExpression().accept(this);
		subtractExpression.rightHandExpression().accept(this);

		return null;
	}

	@Override
	public QLNode visit(UnEqualExpression unEqualExpression) 
	{
		unEqualExpression.leftHandExpression().accept(this);
		unEqualExpression.rightHandExpression().accept(this);

		return null;
	}

	@Override
	public QLNode visit(BooleanLiteral booleanLiteral) 
	{
		return null;
	}

	@Override
	public QLNode visit(IdentifierLiteral identifierLiteral) 
	{
		questions.add(identifierLiteral);

		return null;
	}

	@Override
	public QLNode visit(NumberLiteral numberLiteral) 
	{
		return null;
	}

	@Override
	public QLNode visit(TextLiteral textLiteral) 
	{
		return null;
	}

	@Override
	public QLNode visit(MinusExpression minusExpression) 
	{
		minusExpression.expression().accept(this);

		return null;
	}

	@Override
	public QLNode visit(NotExpression notExpression) 
	{
		notExpression.expression().accept(this);

		return null;
	}

	@Override
	public QLNode visit(PlusExpression plusExpression) 
	{

		plusExpression.expression().accept(this);

		return null;
	}

	@Override
	public QLNode visit(ConditionalBlock conditionalBlock) 
	{

		if (conditionalBlock.ifThenBlock() != null)
		{
			conditionalBlock.ifThenBlock().accept(this);
		}

		if (ArrayTools.arrayExistsAndHasElements(conditionalBlock.elseIfThenBlocks()))
		{
			for (ElseIfThenBlock elseIfThenBlock : conditionalBlock.elseIfThenBlocks())
			{
				elseIfThenBlock.accept(this);
			}
		}

		if (conditionalBlock.elseThenBlock() != null)
		{
			conditionalBlock.elseThenBlock().accept(this);
		}

		return null;
	}

	@Override
	public QLNode visit(ElseIfThenBlock elseIfThenBlock) 
	{
		elseIfThenBlock.expression().accept(this);

		for (FormElement childElement : elseIfThenBlock.childElements())
		{
			childElement.accept(this);
		}

		return null;
	}

	@Override
	public QLNode visit(ElseThenBlock elseThenBlock) 
	{
		for (FormElement childElement : elseThenBlock.childElements())
		{
			childElement.accept(this);
		}

		return null;
	}

	@Override
	public QLNode visit(IfThenBlock ifThenBlock) 
	{
		ifThenBlock.expression().accept(this);

		for (FormElement childElement : ifThenBlock.childElements())
		{
			childElement.accept(this);
		}

		return null;
	}

	@Override
	public QLNode visit(Form form) 
	{
		if (ArrayTools.arrayExistsAndHasElements(form.childElements()))
		{
			for (FormElement childElement : form.childElements())
			{
				childElement.accept(this);
			}
		}

		return null;
	}

	@Override
	public QLNode visit(InputQuestion inputQuestion) 
	{		
		return null;
	}

	@Override
	public QLNode visit(ComputedQuestion computedQuestion) 
	{
		computedQuestion.expression().accept(this);

		return null;
	}
}