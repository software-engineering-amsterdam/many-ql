package org.nlamah.QL.TypeChecker;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QL.Error.IdentifierTypeMismatchError;
import org.nlamah.QL.Model.Form.Abstract.QLNode;
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

public class IdentifierTypeChecker extends TypeCheckerAbstract
{
	private QBaseQuestionType expectedIdentifierType;
	private IdentifierLiteral identifier;
	
	public IdentifierTypeChecker(IdentifierLiteral identifier)
	{
		super();
		
		this.identifier = identifier;
		
		identifier.accept(this);
	}

	@Override
	public QLNode visit(AddExpression expression)
	{
		expectedIdentifierType = QBaseQuestionType.NUMBER;
	
		return null;
	}

	@Override
	public QLNode visit(AndExpression expression)
	{	
		expectedIdentifierType = QBaseQuestionType.BOOLEAN;
		
		return null;
	}

	@Override
	public QLNode visit(DivideExpression expression)
	{
		expectedIdentifierType = QBaseQuestionType.NUMBER;
		
		return null;
	}

	@Override
	public QLNode visit(EqualExpression expression)
	{
		if (identifier.equals(expression.leftHandExpression()) && (expression.rightHandExpression() instanceof IdentifierLiteral))
		{
			expectedIdentifierType = ((IdentifierLiteral) expression.rightHandExpression()).type();
		}
		else if (identifier.equals(expression.rightHandExpression()) && (expression.leftHandExpression() instanceof IdentifierLiteral))
		{
			expectedIdentifierType = ((IdentifierLiteral) expression.leftHandExpression()).type();
		}
		else if (identifier.equals(expression.leftHandExpression()))
		{
			expectedIdentifierType = expression.rightHandExpression().type();
		}
		else if (identifier.equals(expression.rightHandExpression()))
		{
			expectedIdentifierType = expression.leftHandExpression().type();
		}
		
		return null;
	}

	@Override
	public QLNode visit(GreaterThanExpression expression)
	{
		expectedIdentifierType = QBaseQuestionType.NUMBER;
		
		return null;
	}

	@Override
	public QLNode visit(GreaterThanEqualExpression expression)
	{
		expectedIdentifierType = QBaseQuestionType.NUMBER;
		
		return null;
	}

	@Override
	public QLNode visit(MultiplyExpression expression)
	{
		expectedIdentifierType = QBaseQuestionType.NUMBER;
		
		return null;
	}

	@Override
	public QLNode visit(OrExpression expression)
	{
		expectedIdentifierType = QBaseQuestionType.NUMBER;
		
		return null;
	}

	@Override
	public QLNode visit(SmallerThanEqualExpression expression)
	{
		expectedIdentifierType = QBaseQuestionType.NUMBER;
		
		return null;
	}

	@Override
	public QLNode visit(SmallerThanExpression expression)
	{
		expectedIdentifierType = QBaseQuestionType.NUMBER;
		
		return null;
	}

	@Override
	public QLNode visit(SubtractExpression expression)
	{
		expectedIdentifierType = QBaseQuestionType.NUMBER;
		
		return null;
	}

	@Override
	public QLNode visit(UnEqualExpression expression)
	{
		if (identifier.equals(expression.leftHandExpression()) && (expression.rightHandExpression() instanceof IdentifierLiteral))
		{
			expectedIdentifierType = ((IdentifierLiteral) expression.rightHandExpression()).type();
		}
		else if (identifier.equals(expression.rightHandExpression()) && (expression.leftHandExpression() instanceof IdentifierLiteral))
		{
			expectedIdentifierType = ((IdentifierLiteral) expression.leftHandExpression()).type();
		}
		else if (identifier.equals(expression.leftHandExpression()))
		{
			expectedIdentifierType = expression.rightHandExpression().type();
		}
		else if (identifier.equals(expression.rightHandExpression()))
		{
			expectedIdentifierType = expression.leftHandExpression().type();
		}
		
		return null;
	}

	@Override
	public QLNode visit(MinusExpression expression)
	{
		expectedIdentifierType = QBaseQuestionType.NUMBER;
		
		return null;
	}

	@Override
	public QLNode visit(NotExpression expression)
	{
		expectedIdentifierType = QBaseQuestionType.BOOLEAN;
		
		return null;
	}

	@Override
	public QLNode visit(PlusExpression expression)
	{
		expectedIdentifierType = QBaseQuestionType.NUMBER;
		
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
		identifierLiteral.parentNode().accept(this);
		
		if (identifierLiteral.type() != expectedIdentifierType)
		{			
			errors.add(new IdentifierTypeMismatchError(identifier));
		}
		
		expectedIdentifierType = identifierLiteral.type();
		
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
	public QLNode visit(BooleanQuestion booleanQuestion) 
	{
		assert false;
		
		return null;
	}

	@Override
	public QLNode visit(ComputedQuestion computedQuestion) 
	{		
		expectedIdentifierType = computedQuestion.returnType();
		
		return null;
	}

	@Override
	public QLNode visit(ConditionalBlock conditionalBlock) 
	{
		assert false;

		return null;
	}

	@Override
	public QLNode visit(ElseIfThenBlock elseIfThenBlock) 
	{			
		expectedIdentifierType = QBaseQuestionType.BOOLEAN;

		return null;
	}

	@Override
	public QLNode visit(ElseThenBlock elseThenBlock) 
	{		
		assert false;

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
		expectedIdentifierType = QBaseQuestionType.BOOLEAN;

		return null;	
	}

	@Override
	public QLNode visit(NumberQuestion numberQuestion) 
	{
		assert false;
		
		return null;
	}

	@Override
	public QLNode visit(TextQuestion textQuestion) 
	{
		assert false;
		
		return null;
	}
}
