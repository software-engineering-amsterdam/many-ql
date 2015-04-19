package org.nlamah.QL.Visitors;

import org.nlamah.QL.Interfaces.QLNodeVisitor;
import org.nlamah.QL.Model.Expression.Abstract.ValueExpression;
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

public class ExpressionVisitor implements QLNodeVisitor
{
	@Override
	public ValueExpression visit(AddExpression expression)
	{
		NumberLiteral leftHandLiteral = (NumberLiteral)expression.leftHandExpression().accept(this);
		NumberLiteral rightHandLiteral = (NumberLiteral)expression.rightHandExpression().accept(this);
		
		int addition = leftHandLiteral.value() + rightHandLiteral.value();
		
		return new NumberLiteral(Integer.toString(addition));
	}
	
	@Override
	public ValueExpression visit(AndExpression expression)
	{
		BooleanLiteral leftHandLiteral = (BooleanLiteral)expression.leftHandExpression().accept(this);
		BooleanLiteral rightHandLiteral = (BooleanLiteral)expression.rightHandExpression().accept(this);
		
		boolean andOperation = leftHandLiteral.primitiveValue() && rightHandLiteral.primitiveValue();
		
		return new BooleanLiteral(andOperation ? "yes" : "no");
	}
	
	@Override
	public ValueExpression visit(DivideExpression expression)
	{
		NumberLiteral leftHandLiteral = (NumberLiteral)expression.leftHandExpression().accept(this);
		NumberLiteral rightHandLiteral = (NumberLiteral)expression.rightHandExpression().accept(this);
		
		double division = (double)leftHandLiteral.value() / (double)rightHandLiteral.value();
		int roundedDivision = (int)Math.round(division);
		
		return new NumberLiteral(Integer.toString(roundedDivision));
	}
	
	@Override
	public ValueExpression visit(EqualExpression expression)
	{
		ValueExpression leftHandLiteral = (ValueExpression)expression.leftHandExpression().accept(this);
		ValueExpression rightHandLiteral = (ValueExpression)expression.rightHandExpression().accept(this);
		
		boolean areEqual = leftHandLiteral.equals(rightHandLiteral);
		
		return new BooleanLiteral(areEqual ? "yes" : "no");
	}
	
	@Override
	public ValueExpression visit(GreaterThanExpression expression)
	{
		NumberLiteral leftHandLiteral = (NumberLiteral)expression.leftHandExpression().accept(this);
		NumberLiteral rightHandLiteral = (NumberLiteral)expression.rightHandExpression().accept(this);
		
		boolean greaterThan = leftHandLiteral.value() > rightHandLiteral.value();
		
		return new BooleanLiteral(greaterThan ? "yes" : "no");
	}
	
	@Override
	public ValueExpression visit(GreaterThanEqualExpression expression)
	{
		NumberLiteral leftHandLiteral = (NumberLiteral)expression.leftHandExpression().accept(this);
		NumberLiteral rightHandLiteral = (NumberLiteral)expression.rightHandExpression().accept(this);
		
		boolean greaterThanEqual = leftHandLiteral.value() >= rightHandLiteral.value();
		
		return new BooleanLiteral(greaterThanEqual ? "yes" : "no");
	}
	
	@Override
	public ValueExpression visit(MultiplyExpression expression)
	{
		NumberLiteral leftHandLiteral = (NumberLiteral)expression.leftHandExpression().accept(this);
		NumberLiteral rightHandLiteral = (NumberLiteral)expression.rightHandExpression().accept(this);
		
		int multiplication = leftHandLiteral.value() * rightHandLiteral.value();
		
		return new NumberLiteral(Integer.toString(multiplication));
	}
	
	@Override
	public ValueExpression visit(OrExpression expression)
	{
		BooleanLiteral leftHandLiteral = (BooleanLiteral)expression.leftHandExpression().accept(this);
		BooleanLiteral rightHandLiteral = (BooleanLiteral)expression.rightHandExpression().accept(this);
		
		boolean orOperation = leftHandLiteral.primitiveValue() || rightHandLiteral.primitiveValue();
		
		return new BooleanLiteral(orOperation ? "yes" : "no");
	}
	
	public ValueExpression visit(SmallerThanEqualExpression expression)
	{
		NumberLiteral leftHandLiteral = (NumberLiteral)expression.leftHandExpression().accept(this);
		NumberLiteral rightHandLiteral = (NumberLiteral)expression.rightHandExpression().accept(this);
		
		boolean smallerThanEqual = leftHandLiteral.value() <= rightHandLiteral.value();
		
		return new BooleanLiteral(smallerThanEqual ? "yes" : "no");
	}
	
	@Override
	public ValueExpression visit(SmallerThanExpression expression)
	{
		NumberLiteral leftHandLiteral = (NumberLiteral)expression.leftHandExpression().accept(this);
		NumberLiteral rightHandLiteral = (NumberLiteral)expression.rightHandExpression().accept(this);
		
		boolean smallerThan = leftHandLiteral.value() < rightHandLiteral.value();
		
		return new BooleanLiteral(smallerThan ? "yes" : "no");
	}
	
	@Override
	public ValueExpression visit(SubtractExpression expression)
	{
		NumberLiteral leftHandLiteral = (NumberLiteral)expression.leftHandExpression().accept(this);
		NumberLiteral rightHandLiteral = (NumberLiteral)expression.rightHandExpression().accept(this);
		
		int subtraction = leftHandLiteral.value() - rightHandLiteral.value();
		
		return new NumberLiteral(Integer.toString(subtraction));
	}
	
	@Override
	public ValueExpression visit(UnEqualExpression expression)
	{
		ValueExpression leftHandLiteral = (ValueExpression)expression.leftHandExpression().accept(this);
		ValueExpression rightHandLiteral = (ValueExpression)expression.rightHandExpression().accept(this);
		
		boolean areUnEqual = !leftHandLiteral.equals(rightHandLiteral);
		
		return new BooleanLiteral(areUnEqual ? "yes" : "no");
	}
	
	@Override
	public ValueExpression visit(MinusExpression expression)
	{
		NumberLiteral numberLiteral = (NumberLiteral) expression.expression().accept(this);
		
		int minusNumber = -1 * numberLiteral.value();
		
		return new NumberLiteral(Integer.toString(minusNumber));
	}
	
	@Override
	public ValueExpression visit(NotExpression expression)
	{
		BooleanLiteral booleanLiteral = (BooleanLiteral) expression.expression().accept(this);
		
		boolean notBoolean = !booleanLiteral.primitiveValue();
		
		return new BooleanLiteral(notBoolean ? "yes" : "no");
	}
	
	@Override
	public ValueExpression visit(PlusExpression expression)
	{
		return (ValueExpression) expression.expression().accept(this);
	}

	@Override
	public ValueExpression visit(BooleanLiteral booleanLiteral) 
	{
		return booleanLiteral;
	}

	@Override
	public ValueExpression visit(IdentifierLiteral identifierLiteral) 
	{
		return identifierLiteral.representedValue();
	}

	@Override
	public ValueExpression visit(NumberLiteral numberLiteral) 
	{
		return numberLiteral;
	}

	@Override
	public ValueExpression visit(TextLiteral textLiteral) 
	{
		return textLiteral;
	}

	@Override
	public ValueExpression visit(BooleanQuestion booleanQuestion) 
	{
		return booleanQuestion.checked();
	}

	@Override
	public ValueExpression visit(ComputedQuestion computedQuestion) 
	{
		return computedQuestion.computedValue();
	}

	@Override
	public ValueExpression visit(ConditionalBlock conditionalBlock) 
	{
		//The EpxressionVisitor should not call this visit method
		assert false;
		
		return null;
	}

	@Override
	public ValueExpression visit(ElseIfThenBlock elseIfThenBlock) 
	{
		//The EpxressionVisitor should not call this visit method
		assert false;
				
		return null;
	}

	@Override
	public ValueExpression visit(ElseThenBlock elseThenBlock) 
	{
		//The EpxressionVisitor should not call this visit method
		assert false;
				
		return null;
	}

	@Override
	public ValueExpression visit(Form form) 
	{
		//The EpxressionVisitor should not call this visit method
				
		assert false;
				
		return null;
	}

	@Override
	public ValueExpression visit(IfThenBlock ifThenBlock) 
	{
		//The EpxressionVisitor should not call this visit method
		assert false;
				
		return null;
	}

	@Override
	public ValueExpression visit(NumberQuestion numberQuestion) 
	{
		return numberQuestion.insertedNumber();
	}

	@Override
	public ValueExpression visit(TextQuestion textQuestion) 
	{
		return textQuestion.insertedText();
	}
}