package org.nlamah.QL.TypeChecker;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QBase.QBaseAbstractTypeChecker;
import org.nlamah.QL.Error.ExpressionTypeMismatchError;
import org.nlamah.QBase.QBaseHelper;
import org.nlamah.QL.Interfaces.QLNodeVisitor;
import org.nlamah.QL.Model.Expression.Abstract.BinaryExpression;
import org.nlamah.QL.Model.Expression.Abstract.EqualityExpression;
import org.nlamah.QL.Model.Expression.Abstract.Expression;
import org.nlamah.QL.Model.Expression.Abstract.UnaryExpression;
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

public class ExpressionTypeChecker extends QBaseAbstractTypeChecker implements QLNodeVisitor 
{
	public ExpressionTypeChecker(Form form)
	{
		super();

		form.accept(this);
	}

	private void checkForErrorInEqualityExpression(EqualityExpression expression)
	{
		Expression leftHandExpression = (Expression) expression.leftHandExpression().accept(this);
		Expression rightHandExpression = (Expression) expression.rightHandExpression().accept(this);

		if ( ! (leftHandExpression.type().equals(rightHandExpression.type())))
		{
			errors.add(new ExpressionTypeMismatchError(expression));
		}
	}

	private void checkForErrorInBinaryExpression(BinaryExpression expression, QBaseQuestionType type)
	{
		Expression leftHandExpression = (Expression) expression.leftHandExpression().accept(this);
		Expression rightHandExpression = (Expression) expression.rightHandExpression().accept(this);

		checkIfResultExpressionIsOfType(leftHandExpression, type);
		checkIfResultExpressionIsOfType(rightHandExpression, type);
	}

	private void checkForErrorInUnaryExpression(UnaryExpression expression, QBaseQuestionType type)
	{
		Expression visitedExpression = (Expression) expression.expression().accept(this);

		checkIfResultExpressionIsOfType(visitedExpression, type);
	}

	private void checkIfResultExpressionIsOfType(Expression expression, QBaseQuestionType type)
	{		
		switch (expression.type())
		{
		case BOOLEAN:
		{
			if (type != QBaseQuestionType.BOOLEAN)
			{
				errors.add(new ExpressionTypeMismatchError(expression));
			}

			break;
		}
		case NUMBER:
		{
			if (type != QBaseQuestionType.NUMBER)
			{
				errors.add(new ExpressionTypeMismatchError(expression));
			}

			break;
		}
		case TEXT:
		{
			if (type != QBaseQuestionType.TEXT)
			{
				errors.add(new ExpressionTypeMismatchError(expression));
			}

			break;
		}
		default:
		{

		}
		}
	}

	@Override
	public QLNode visit(AddExpression expression)
	{
		checkForErrorInBinaryExpression(expression, QBaseQuestionType.NUMBER);

		return expression;
	}

	@Override
	public QLNode visit(AndExpression expression)
	{		
		checkForErrorInBinaryExpression(expression, QBaseQuestionType.BOOLEAN);

		return expression;
	}

	@Override
	public QLNode visit(DivideExpression expression)
	{
		checkForErrorInBinaryExpression(expression, QBaseQuestionType.NUMBER);

		return expression;
	}

	@Override
	public QLNode visit(EqualExpression expression)
	{
		checkForErrorInEqualityExpression(expression);

		return expression;
	}

	@Override
	public QLNode visit(GreaterThanExpression expression)
	{
		checkForErrorInBinaryExpression(expression, QBaseQuestionType.NUMBER);

		return expression;
	}

	@Override
	public QLNode visit(GreaterThanEqualExpression expression)
	{
		checkForErrorInBinaryExpression(expression, QBaseQuestionType.NUMBER);

		return expression;
	}

	@Override
	public QLNode visit(MultiplyExpression expression)
	{
		checkForErrorInBinaryExpression(expression, QBaseQuestionType.NUMBER);

		return expression;
	}

	@Override
	public QLNode visit(OrExpression expression)
	{
		checkForErrorInBinaryExpression(expression, QBaseQuestionType.BOOLEAN);

		return expression;
	}

	public QLNode visit(SmallerThanEqualExpression expression)
	{
		checkForErrorInBinaryExpression(expression, QBaseQuestionType.NUMBER);

		return expression;
	}

	@Override
	public QLNode visit(SmallerThanExpression expression)
	{
		checkForErrorInBinaryExpression(expression, QBaseQuestionType.NUMBER);

		return expression;
	}

	@Override
	public QLNode visit(SubtractExpression expression)
	{
		checkForErrorInBinaryExpression(expression, QBaseQuestionType.NUMBER);

		return expression;
	}

	@Override
	public QLNode visit(UnEqualExpression expression)
	{
		checkForErrorInEqualityExpression(expression);

		return expression;
	}

	@Override
	public QLNode visit(MinusExpression expression)
	{
		checkForErrorInUnaryExpression(expression, QBaseQuestionType.NUMBER);

		return expression;
	}

	@Override
	public QLNode visit(NotExpression expression)
	{
		checkForErrorInUnaryExpression(expression, QBaseQuestionType.BOOLEAN);

		return expression;
	}

	@Override
	public QLNode visit(PlusExpression expression)
	{
		checkForErrorInUnaryExpression(expression, QBaseQuestionType.NUMBER);

		return expression;
	}

	@Override
	public QLNode visit(BooleanLiteral booleanLiteral) 
	{
		return booleanLiteral;
	}

	@Override
	public QLNode visit(IdentifierLiteral identifierLiteral) 
	{		
		return identifierLiteral;
	}

	@Override
	public QLNode visit(NumberLiteral numberLiteral) 
	{
		return numberLiteral;
	}

	@Override
	public QLNode visit(TextLiteral textLiteral) 
	{
		return textLiteral;
	}

	@Override
	public QLNode visit(ConditionalBlock conditionalBlock) 
	{
		if (conditionalBlock.ifThenBlock() != null)
		{
			conditionalBlock.ifThenBlock().accept(this);
		}

		if (QBaseHelper.arrayExistsAndHasElements(conditionalBlock.elseIfThenBlocks()))
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
		Expression expression = (Expression) elseIfThenBlock.expression().accept(this);

		if (expression.type() != QBaseQuestionType.BOOLEAN)
		{
			errors.add(new ExpressionTypeMismatchError(expression));
		}

		if (QBaseHelper.arrayExistsAndHasElements(elseIfThenBlock.childElements()))
		{
			for (FormElement childElement : elseIfThenBlock.childElements())
			{
				childElement.accept(this);
			}
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
	public QLNode visit(Form form) 
	{
		for (FormElement childElement : form.childElements())
		{
			childElement.accept(this);
		}

		return null;
	}

	@Override
	public QLNode visit(IfThenBlock ifThenBlock) 
	{
		Expression expression = (Expression) ifThenBlock.expression().accept(this);

		if (expression.type() != QBaseQuestionType.BOOLEAN)
		{
			errors.add(new ExpressionTypeMismatchError(expression));
		}

		if (QBaseHelper.arrayExistsAndHasElements(ifThenBlock.childElements()))
		{
			for (FormElement childElement : ifThenBlock.childElements())
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
		Expression expression = (Expression) computedQuestion.expression().accept(this);

		if (expression.type() != computedQuestion.returnType())
		{
			errors.add(new ExpressionTypeMismatchError(expression));
		}

		return null;
	}
}
