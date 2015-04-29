package org.nlamah.QL.Model.Expression.Literal;

import org.nlamah.QL.Model.Form.Abstract.QLNode;
import org.nlamah.QL.Interfaces.QLNodeVisitor;
import org.nlamah.QL.Model.Expression.Abstract.ValueExpression;
import org.nlamah.QL.Model.Form.Abstract.LiteralType;

public class TextLiteral extends ValueExpression 
{
	public TextLiteral(String textValueString)
	{
		super(textValueString, LiteralType.TEXT);
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
