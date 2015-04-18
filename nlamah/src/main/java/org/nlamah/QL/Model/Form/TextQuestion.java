package org.nlamah.QL.Model.Form;

import org.nlamah.QL.Model.Expression.Abstract.ValueExpression;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Expression.Literal.TextLiteral;
import org.nlamah.QL.Model.Form.Abstract.InputQuestion;
import org.nlamah.QL.Model.Form.Abstract.QLNode;
import org.nlamah.QL.Model.Form.Abstract.QuestionReturnType;
import org.nlamah.QL.ViewControllers.Form.TextQuestionViewController;
import org.nlamah.QL.ViewControllers.Form.Abstract.FormElementViewController;
import org.nlamah.QL.Visitors.QLNodeVisitor;

public class TextQuestion extends InputQuestion 
{
	private TextLiteral insertedText;
	
	public TextQuestion(IdentifierLiteral identifier, TextLiteral questionText) 
	{
		super(identifier, questionText, QuestionReturnType.TEXT);
		
		insertedText = new TextLiteral("");
	}

	public void setInsertedText(TextLiteral insertedText)
	{
		this.insertedText = insertedText;
	}

	@Override
	protected FormElementViewController createViewController() 
	{
		return new TextQuestionViewController(this);
	}
	
	@Override
	public QLNode accept(QLNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}

	@Override
	public ValueExpression value() 
	{
		return insertedText;
	}
}
