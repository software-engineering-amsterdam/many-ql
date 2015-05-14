package org.nlamah.QLS.Builders;

import org.nlamah.QL.View.Form.Abstract.WidgetView;
import org.nlamah.QL.View.Form.Widgets.CheckboxWidgetView;
import org.nlamah.QL.View.Form.Widgets.RadioButtonWidgetView;
import org.nlamah.QL.View.Form.Widgets.SpinBoxWidgetView;
import org.nlamah.QLS.Model.Declaration.WidgetDeclaration;

public class WidgetViewFactory 
{
	static public WidgetView widgetViewForStyle(WidgetDeclaration widgetDeclaration)
	{
		switch (widgetDeclaration.widgetType())
		{
		case CHECKBOX:
			break;
		case NUMBERFIELD:
			break;
		case RADIOBUTTON:
			break;
		case SPINBOX:
			break;
		case TEXTFIELD:
			break;
		default:
			break;	
		}
		
		
//		if (style instanceof CheckBoxWidget)
//		{
//			return new CheckboxWidgetView();
//		}
//		else if (style instanceof RadioButtonWidget)
//		{
//			return new RadioButtonWidgetView();
//		}
//		else if (style instanceof SpinBoxWidget)
//		{
//			return new SpinBoxWidgetView();
//		}
//		else
//		{
//			assert(false);
//		}
		
		return null;
	}
}
