package org.nlamah.QL.Model.Form;

import org.nlamah.QL.Interfaces.QLFormElementVisitor;
import org.nlamah.QL.Interfaces.QLNodeVisitor;
import org.nlamah.QL.Model.Expression.Abstract.Expression;
import org.nlamah.QL.Model.Expression.Abstract.ValueExpression;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Expression.Literal.TextLiteral;
import org.nlamah.QL.Model.Form.Abstract.QLNode;
import org.nlamah.QL.Model.Form.Abstract.Question;
import org.nlamah.QL.Model.Form.Abstract.QuestionReturnType;

public class ComputedQuestion extends Question 
{
	private Expression expression;
	
	public ComputedQuestion(IdentifierLiteral identifier, TextLiteral questionText, QuestionReturnType type, Expression expression) 
	{
		super(identifier, questionText, type);
		
		this.expression = expression;
	}
	
	@Override
	public ValueExpression value() 
	{
		return null;
	}
	
	@Override 
	 public boolean equals(Object object) 
	 {
		if (!super.equals(object))
		 {
			 return false;
		 }
		 
		 if (!(object instanceof ComputedQuestion))
		 {
			 return false;
		 }
		 
		 ComputedQuestion value = (ComputedQuestion)object;
		 
		 if (!(this.expression.equals(value.expression)))
		 {
			 return false;
		 }
		 
		 return true;
	 }
	
	
	
	@Override
	public QLNode accept(QLNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}

	@Override
	public void accept(QLFormElementVisitor visitor) 
	{
		visitor.visit(this);	
	}
}
