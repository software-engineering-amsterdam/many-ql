package org.nlamah.QL.TypeChecker;

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
import org.nlamah.QL.Model.Form.BooleanQuestion;
import org.nlamah.QL.Model.Form.ComputedQuestion;
import org.nlamah.QL.Model.Form.ConditionalBlock;
import org.nlamah.QL.Model.Form.ElseIfThenBlock;
import org.nlamah.QL.Model.Form.ElseThenBlock;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.Model.Form.IfThenBlock;
import org.nlamah.QL.Model.Form.NumberQuestion;
import org.nlamah.QL.Model.Form.TextQuestion;
import org.nlamah.QL.Model.Form.Abstract.QLNode;

public class CyclicDependencyChecker implements QLNodeVisitor 
{

	@Override
	public QLNode visit(AddExpression addExpression) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLNode visit(AndExpression andExpression) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLNode visit(DivideExpression divideExpression) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLNode visit(EqualExpression equalExpression) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLNode visit(GreaterThanExpression greaterThanExpression) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLNode visit(GreaterThanEqualExpression greaterThanEqualExpression) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLNode visit(MultiplyExpression multiplyExpression) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLNode visit(OrExpression orExpression) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLNode visit(SmallerThanExpression smallerThanExpression) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLNode visit(SmallerThanEqualExpression smallerThanEqualExpression) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLNode visit(SubtractExpression subtractExpression) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLNode visit(UnEqualExpression unEqualExpression) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLNode visit(BooleanLiteral booleanLiteral) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLNode visit(IdentifierLiteral identifierLiteral) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLNode visit(NumberLiteral numberLiteral) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLNode visit(TextLiteral textLiteral) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLNode visit(MinusExpression minusExpression) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLNode visit(NotExpression notExpression) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLNode visit(PlusExpression plusExpression) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLNode visit(BooleanQuestion booleanQuestion) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLNode visit(ComputedQuestion computedQuestion) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLNode visit(ConditionalBlock conditionalBlock) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLNode visit(ElseIfThenBlock elseIfThenBlock) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLNode visit(ElseThenBlock elseThenBlock) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLNode visit(Form form) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLNode visit(IfThenBlock ifThenBlock) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLNode visit(NumberQuestion numberQuestion) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLNode visit(TextQuestion textQuestion) 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
