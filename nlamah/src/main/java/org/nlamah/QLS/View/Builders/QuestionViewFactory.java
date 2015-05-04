package org.nlamah.QLS.View.Builders;

import org.nlamah.QL.Helper.QLHelper;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.Model.Form.Abstract.FormQuestion;
import org.nlamah.QL.View.Form.BooleanQuestionView;
import org.nlamah.QL.View.Form.NumberQuestionView;
import org.nlamah.QL.View.Form.TextQuestionView;
import org.nlamah.QL.View.Form.Abstract.QuestionView;
import org.nlamah.QL.View.Form.Widgets.CheckboxWidget;
import org.nlamah.QL.View.Form.Widgets.NumberWidget;
import org.nlamah.QL.View.Form.Widgets.TextFieldWidget;
import org.nlamah.QLS.Model.Declaration.StyledQuestion;

public class QuestionViewFactory 
{
	private Form form;
	
	public QuestionViewFactory(Form form)
	{
		super();
		
		this.form = form;
	}
	
	
	public QuestionView viewForStyledQuestion(StyledQuestion question)
	{
		FormQuestion formQuestion = QLHelper.getQuestionWithIdentifier(form.questions(), new IdentifierLiteral(question.identifier().toString()));
		
		switch(formQuestion.returnType())
		{
		case BOOLEAN:
		{
			return new BooleanQuestionView(new CheckboxWidget(null));
		}
		case NUMBER:
		{
			return new NumberQuestionView(new NumberWidget(null));
		}
		case TEXT:
		{
			return new TextQuestionView(new TextFieldWidget(null));
		}
		}
		
		return null;
	}
}
