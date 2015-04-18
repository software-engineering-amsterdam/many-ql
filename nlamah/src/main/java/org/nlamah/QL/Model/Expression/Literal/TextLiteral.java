package org.nlamah.QL.Model.Expression.Literal;

import org.nlamah.QL.Model.Expression.Abstract.ValueExpression;
import org.nlamah.QL.Model.Form.Abstract.QLNode;
import org.nlamah.QL.Model.Form.Abstract.QuestionReturnType;
import org.nlamah.QL.Visitors.QLNodeVisitor;

public class TextLiteral extends ValueExpression 
{
	public TextLiteral(String textValueString)
	{
		super(textValueString, QuestionReturnType.TEXT);
	}
	
	public String value()
	{
		return valueString;
	}
	
	@Override
	public QLNode accept(QLNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
}
