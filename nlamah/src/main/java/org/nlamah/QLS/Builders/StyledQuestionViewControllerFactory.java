package org.nlamah.QLS.Builders;

import org.nlamah.QL.Model.Form.BooleanQuestion;
import org.nlamah.QL.Model.Form.NumberQuestion;
import org.nlamah.QL.Model.Form.TextQuestion;
import org.nlamah.QL.Model.Form.Abstract.FormQuestion;
import org.nlamah.QL.View.Controllers.QuestionViewController;
import org.nlamah.QLS.Model.Abstract.WidgetStyle;
import org.nlamah.QLS.Model.Value.Widget.CheckBoxWidget;
import org.nlamah.QLS.Model.Value.Widget.RadioButtonWidget;
import org.nlamah.QLS.Model.Value.Widget.SpinBoxWidget;

public class StyledQuestionViewControllerFactory 
{
	public QuestionViewController createViewController(FormQuestion question, WidgetStyle widget)
	{
		if (question instanceof BooleanQuestion)
		{
			if (widget instanceof CheckBoxWidget)
			{
				
			}
			else if (widget instanceof RadioButtonWidget)
			{
				
			}
			else if (widget instanceof SpinBoxWidget)
			{
				
			}
			else
			{
				assert(false);
			}
		}
		else if (question instanceof NumberQuestion)
		{
			if (widget instanceof CheckBoxWidget)
			{
				
			}
			else if (widget instanceof RadioButtonWidget)
			{
				
			}
			else if (widget instanceof SpinBoxWidget)
			{
				
			}
			else
			{
				assert(false);
			}
		}
		else if (question instanceof TextQuestion)
		{
			if (widget instanceof CheckBoxWidget)
			{
				
			}
			else if (widget instanceof RadioButtonWidget)
			{
				
			}
			else if (widget instanceof SpinBoxWidget)
			{
				
			}
			else
			{
				assert(false);
			}
		}
		else
		{
			assert(false);
		}
		
		
		return null;
	}
}
