package org.nlamah.QL.Builders;

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
import org.nlamah.QL.Model.Form.Abstract.FormQuestion;
import org.nlamah.QL.Model.Form.Abstract.QLNode;

public class FragmentedFormElementFinder implements QLNodeVisitor
{
	private FormElement lastVisitedFormElement;

	public FormElement findFragementedFormElementForQuestion(FormQuestion question)
	{
		question.accept(this);

		assert(lastVisitedFormElement != null);

		return lastVisitedFormElement;
	}

	@Override
	public QLNode visit(AddExpression addExpression) 
	{
		addExpression.parentNode().accept(this);

		return null;
	}

	@Override
	public QLNode visit(AndExpression andExpression) 
	{
		andExpression.parentNode().accept(this);

		return null;
	}

	@Override
	public QLNode visit(DivideExpression divideExpression) 
	{
		divideExpression.parentNode().accept(this);

		return null;
	}

	@Override
	public QLNode visit(EqualExpression equalExpression) 
	{
		equalExpression.parentNode().accept(this);

		return null;

	}

	@Override
	public QLNode visit(GreaterThanExpression greaterThanExpression) 
	{
		greaterThanExpression.parentNode().accept(this);

		return null;
	}

	@Override
	public QLNode visit(GreaterThanEqualExpression greaterThanEqualExpression) 
	{
		greaterThanEqualExpression.parentNode().accept(this);

		return null;
	}

	@Override
	public QLNode visit(MultiplyExpression multiplyExpression) 
	{
		multiplyExpression.parentNode().accept(this);

		return null;
	}

	@Override
	public QLNode visit(OrExpression orExpression) 
	{
		orExpression.parentNode().accept(this);

		return null;
	}

	@Override
	public QLNode visit(SmallerThanExpression smallerThanExpression) 
	{
		smallerThanExpression.parentNode().accept(this);

		return null;
	}

	@Override
	public QLNode visit(SmallerThanEqualExpression smallerThanEqualExpression) 
	{
		smallerThanEqualExpression.parentNode().accept(this);

		return null;
	}

	@Override
	public QLNode visit(SubtractExpression subtractExpression) 
	{
		subtractExpression.parentNode().accept(this);

		return null;
	}

	@Override
	public QLNode visit(UnEqualExpression unEqualExpression) 
	{
		unEqualExpression.parentNode().accept(this);

		return null;
	}

	@Override
	public QLNode visit(BooleanLiteral booleanLiteral) 
	{
		booleanLiteral.parentNode().accept(this);

		return null;
	}

	@Override
	public QLNode visit(IdentifierLiteral identifierLiteral) 
	{
		identifierLiteral.parentNode().accept(this);

		return null;
	}

	@Override
	public QLNode visit(NumberLiteral numberLiteral) 
	{
		numberLiteral.parentNode().accept(this);

		return null;
	}

	@Override
	public QLNode visit(TextLiteral textLiteral) 
	{
		textLiteral.parentNode().accept(this);

		return null;
	}

	@Override
	public QLNode visit(MinusExpression minusExpression) 
	{
		minusExpression.parentNode().accept(this);

		return null;
	}

	@Override
	public QLNode visit(NotExpression notExpression) 
	{
		notExpression.parentNode().accept(this);

		return null;
	}

	@Override
	public QLNode visit(PlusExpression plusExpression) 
	{
		plusExpression.parentNode().accept(this);

		return null;
	}

	@Override
	public QLNode visit(ConditionalBlock conditionalBlock) 
	{
		lastVisitedFormElement = conditionalBlock;

		conditionalBlock.parentNode().accept(this);

		return null;
	}

	@Override
	public QLNode visit(ElseIfThenBlock elseIfThenBlock) 
	{
		lastVisitedFormElement = elseIfThenBlock;

		elseIfThenBlock.parentNode().accept(this);

		return null;
	}

	@Override
	public QLNode visit(ElseThenBlock elseThenBlock) 
	{
		lastVisitedFormElement = elseThenBlock;

		elseThenBlock.parentNode().accept(this);

		return null;
	}

	@Override
	public QLNode visit(Form form) 
	{
		return null;
	}

	@Override
	public QLNode visit(IfThenBlock ifThenBlock) 
	{
		lastVisitedFormElement = ifThenBlock;

		ifThenBlock.parentNode().accept(this);

		return null;
	}

	@Override
	public QLNode visit(InputQuestion inputQuestion) 
	{
		lastVisitedFormElement = inputQuestion;

		inputQuestion.parentNode().accept(this);

		return null;
	}

	@Override
	public QLNode visit(ComputedQuestion computedQuestion) 
	{
		lastVisitedFormElement = computedQuestion;

		computedQuestion.parentNode().accept(this);

		return null;
	}
}