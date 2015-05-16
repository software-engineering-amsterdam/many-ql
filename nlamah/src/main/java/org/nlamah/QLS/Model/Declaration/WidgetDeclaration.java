package org.nlamah.QLS.Model.Declaration;

import java.util.Map;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QL.Model.Expression.Abstract.ValueExpression;
import org.nlamah.QL.Model.Expression.Literal.TextLiteral;
import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Abstract.StyleDeclaration;
import org.nlamah.QLS.Model.Value.WidgetTypeEnum;

public class WidgetDeclaration extends StyleDeclaration 
{
	WidgetTypeEnum widgetType;
	QBaseQuestionType returnType;
	Map<TextLiteral, ? extends ValueExpression> values;

	public WidgetDeclaration(WidgetTypeEnum widgetType, QBaseQuestionType returnType, Map<TextLiteral, ? extends ValueExpression> values) 
	{
		super(null);

		this.widgetType = widgetType;
		this.returnType = returnType;
		this.values = values;
	}

	public QBaseQuestionType returnType()
	{
		return returnType;
	}

	public WidgetTypeEnum widgetType()
	{
		return widgetType;
	}

	public Map<TextLiteral, ? extends ValueExpression> values()
	{
		return values;
	}

	@Override
	public QLSNode accept(QLSNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}

	@Override 
	public boolean equals(Object object) 
	{
		if (!super.equals(object))
		{
			return false;
		}

		if (!(object instanceof WidgetDeclaration))
		{
			return false;
		}

		WidgetDeclaration value = (WidgetDeclaration) object;

		if (value.returnType != this.returnType)
		{
			return false;
		}
		
		if (value.values == null && this.values == null)
		{
			return true;
		}

		if (value.values.equals(this.values))
		{
			return false;
		}

		return true;
	}
}
