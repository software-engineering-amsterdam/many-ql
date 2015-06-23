package org.nlamah.QL.Model.Form;

import org.nlamah.QBase.Constants.QBaseQuestionType;
import org.nlamah.QBase.Constants.UIConstants;
import org.nlamah.QL.Interfaces.QLFormElementVisitor;
import org.nlamah.QL.Interfaces.QLNodeVisitor;
import org.nlamah.QL.Model.Expression.Abstract.ValueExpression;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Expression.Literal.TextLiteral;
import org.nlamah.QL.Model.Form.Abstract.FormQuestion;
import org.nlamah.QL.Model.Form.Abstract.QLNode;

public class InputQuestion extends FormQuestion 
{
	private ValueExpression value;

	public InputQuestion(IdentifierLiteral identifier, TextLiteral questionText, QBaseQuestionType type) 
	{
		super(identifier, questionText, type);

		value = UIConstants.defaultValueForQuestionType(type);
	}

	@Override 
	public boolean equals(Object object) 
	{
		if (!super.equals(object))
		{
			return false;
		}

		if (!(object instanceof InputQuestion))
		{
			return false;
		}
		
		return true;
	}

	@Override
	public void accept(QLFormElementVisitor visitor) 
	{
		visitor.visit(this);
	}

	@Override
	public QLNode accept(QLNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}

	@Override
	public ValueExpression value() 
	{
		return this.value;
	}

	public void setValue(ValueExpression value) 
	{
		this.value = value;
	}
}