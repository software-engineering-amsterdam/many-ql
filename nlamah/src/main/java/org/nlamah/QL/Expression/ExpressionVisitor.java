package org.nlamah.QL.Expression;

import org.nlamah.QL.Binary.AddExpression;
import org.nlamah.QL.Binary.AndExpression;
import org.nlamah.QL.Binary.DivideExpression;
import org.nlamah.QL.Binary.EqualExpression;
import org.nlamah.QL.Binary.GreaterThanEqualExpression;
import org.nlamah.QL.Binary.GreaterThanExpression;
import org.nlamah.QL.Binary.MultiplyExpression;
import org.nlamah.QL.Binary.OrExpression;
import org.nlamah.QL.Binary.SmallerThanEqualExpression;
import org.nlamah.QL.Binary.SmallerThanExpression;
import org.nlamah.QL.Binary.SubtractExpression;
import org.nlamah.QL.Binary.UnEqualExpression;
import org.nlamah.QL.Literal.BooleanLiteral;
import org.nlamah.QL.Literal.IdentifierLiteral;
import org.nlamah.QL.Literal.NumberLiteral;
import org.nlamah.QL.Literal.TextLiteral;
import org.nlamah.QL.Literal.ValueExpression;
import org.nlamah.QL.QLASTNode.QLASTNodeVisitor;
import org.nlamah.QL.Unary.MinusExpression;
import org.nlamah.QL.Unary.NotExpression;
import org.nlamah.QL.Unary.PlusExpression;

public class ExpressionVisitor extends QLASTNodeVisitor
{
	public ValueExpression evaluate(AddExpression expression)
	{
		NumberLiteral leftHandLiteral = (NumberLiteral)expression.leftHandExpression().accept(this);
		NumberLiteral rightHandLiteral = (NumberLiteral)expression.rightHandExpression().accept(this);
		
		int addition = leftHandLiteral.value() + rightHandLiteral.value();
		
		return new NumberLiteral(Integer.toString(addition));
	}
	
	public ValueExpression evaluate(AndExpression expression)
	{
		BooleanLiteral leftHandLiteral = (BooleanLiteral)expression.leftHandExpression().accept(this);
		BooleanLiteral rightHandLiteral = (BooleanLiteral)expression.rightHandExpression().accept(this);
		
		boolean andOperation = leftHandLiteral.value() && rightHandLiteral.value();
		
		return new BooleanLiteral(Boolean.toString(andOperation));
	}
	
	public ValueExpression evaluate(DivideExpression expression)
	{
		NumberLiteral leftHandLiteral = (NumberLiteral)expression.leftHandExpression().accept(this);
		NumberLiteral rightHandLiteral = (NumberLiteral)expression.rightHandExpression().accept(this);
		
		double division = (double)leftHandLiteral.value() / (double)rightHandLiteral.value();
		int roundedDivision = (int)Math.round(division);
		
		return new NumberLiteral(Integer.toString(roundedDivision));
	}
	
	public ValueExpression evaluate(EqualExpression expression)
	{
		ValueExpression leftHandLiteral = expression.leftHandExpression().accept(this);
		ValueExpression rightHandLiteral = expression.rightHandExpression().accept(this);
		
		boolean areEqual = leftHandLiteral.equals(rightHandLiteral);
		
		return new BooleanLiteral(Boolean.toString(areEqual));
	}
	
	public ValueExpression evaluate(GreaterThanExpression expression)
	{
		NumberLiteral leftHandLiteral = (NumberLiteral)expression.leftHandExpression().accept(this);
		NumberLiteral rightHandLiteral = (NumberLiteral)expression.rightHandExpression().accept(this);
		
		boolean greaterThan = leftHandLiteral.value() > rightHandLiteral.value();
		
		return new BooleanLiteral(Boolean.toString(greaterThan));
	}
	
	public ValueExpression evaluate(GreaterThanEqualExpression expression)
	{
		NumberLiteral leftHandLiteral = (NumberLiteral)expression.leftHandExpression().accept(this);
		NumberLiteral rightHandLiteral = (NumberLiteral)expression.rightHandExpression().accept(this);
		
		boolean greaterThanEqual = leftHandLiteral.value() >= rightHandLiteral.value();
		
		return new BooleanLiteral(Boolean.toString(greaterThanEqual));
	}
	
	public ValueExpression evaluate(MultiplyExpression expression)
	{
		NumberLiteral leftHandLiteral = (NumberLiteral)expression.leftHandExpression().accept(this);
		NumberLiteral rightHandLiteral = (NumberLiteral)expression.rightHandExpression().accept(this);
		
		int multiplication = leftHandLiteral.value() * rightHandLiteral.value();
		
		return new NumberLiteral(Integer.toString(multiplication));
	}
	
	public ValueExpression evaluate(OrExpression expression)
	{
		BooleanLiteral leftHandLiteral = (BooleanLiteral)expression.leftHandExpression().accept(this);
		BooleanLiteral rightHandLiteral = (BooleanLiteral)expression.rightHandExpression().accept(this);
		
		boolean orOperation = leftHandLiteral.value() || rightHandLiteral.value();
		
		return new BooleanLiteral(Boolean.toString(orOperation));
	}
	
	public ValueExpression evaluate(SmallerThanEqualExpression expression)
	{
		NumberLiteral leftHandLiteral = (NumberLiteral)expression.leftHandExpression().accept(this);
		NumberLiteral rightHandLiteral = (NumberLiteral)expression.rightHandExpression().accept(this);
		
		boolean smallerThanEqual = leftHandLiteral.value() <= rightHandLiteral.value();
		
		return new BooleanLiteral(Boolean.toString(smallerThanEqual));
	}
	
	public ValueExpression evaluate(SmallerThanExpression expression)
	{
		NumberLiteral leftHandLiteral = (NumberLiteral)expression.leftHandExpression().accept(this);
		NumberLiteral rightHandLiteral = (NumberLiteral)expression.rightHandExpression().accept(this);
		
		boolean smallerThan = leftHandLiteral.value() < rightHandLiteral.value();
		
		return new BooleanLiteral(Boolean.toString(smallerThan));
	}
	
	public ValueExpression evaluate(SubtractExpression expression)
	{
		NumberLiteral leftHandLiteral = (NumberLiteral)expression.leftHandExpression().accept(this);
		NumberLiteral rightHandLiteral = (NumberLiteral)expression.rightHandExpression().accept(this);
		
		int subtraction = leftHandLiteral.value() - rightHandLiteral.value();
		
		return new NumberLiteral(Integer.toString(subtraction));
	}
	
	public ValueExpression evaluate(UnEqualExpression expression)
	{
		ValueExpression leftHandLiteral = expression.leftHandExpression().accept(this);
		ValueExpression rightHandLiteral = expression.rightHandExpression().accept(this);
		
		boolean areUnEqual = !leftHandLiteral.equals(rightHandLiteral);
		
		return new BooleanLiteral(Boolean.toString(areUnEqual));
	}
	
	public ValueExpression evaluate(MinusExpression expression)
	{
		NumberLiteral numberLiteral = (NumberLiteral)expression.expression();
		
		int minusNumber = -1 * numberLiteral.value();
		
		return new NumberLiteral(Integer.toString(minusNumber));
	}
	
	public ValueExpression evaluate(NotExpression expression)
	{
		BooleanLiteral booleanLiteral = (BooleanLiteral)expression.expression();
		
		boolean notBoolean = !booleanLiteral.value();
		
		return new BooleanLiteral(Boolean.toString(notBoolean));
	}
	
	public ValueExpression evaluate(PlusExpression expression)
	{
		return expression.expression().accept(this);
	}
	
}