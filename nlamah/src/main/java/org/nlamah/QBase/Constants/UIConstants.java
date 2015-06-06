package org.nlamah.QBase.Constants;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QL.Model.Expression.Abstract.ValueExpression;
import org.nlamah.QL.Model.Expression.Literal.BooleanLiteral;
import org.nlamah.QL.Model.Expression.Literal.NumberLiteral;
import org.nlamah.QL.Model.Expression.Literal.TextLiteral;

public class UIConstants 
{
	static public int contentWidth()
	{
		return 700;
	}

	static public int labelLeftMargin()
	{
		return 30;
	}

	static public int labelRightMargin()
	{
		return 15;
	}

	static public int widgetWidth()
	{
		return 250;
	}

	static public int widgetRightMargin()
	{
		return 15;
	}

	static public int widgetTopPadding() 
	{
		return 10;
	}

	static public int widgetBottomPadding() 
	{
		return 10;
	}

	static public int labelTopMargin()
	{
		return 15;
	}

	static public int labelBottomMargin()
	{
		return 15;
	}
	static public int defaultQuestionHeight()
	{
		return 50;
	}

	static public int maximumTextFieldHeight()
	{
		return 30;
	}

	static public int navigationViewWidth()
	{
		return 225;
	}

	static public ValueExpression defaultValueForQuestionType(QBaseQuestionType type)
	{
		switch(type)
		{
		case BOOLEAN:return new BooleanLiteral(false);
		case NUMBER:return new NumberLiteral(0);
		case TEXT: return new TextLiteral("");
		default: assert(false);
		}

		return null;
	}
}
