package org.nlamah.QLS.Builders;

import org.nlamah.QL.View.Form.Abstract.WidgetView;
import org.nlamah.QL.View.Form.Widgets.CheckboxWidgetView;
import org.nlamah.QL.View.Form.Widgets.NumberFieldWidgetView;
import org.nlamah.QL.View.Form.Widgets.RadioButtonWidgetView;
import org.nlamah.QL.View.Form.Widgets.SpinnerWidgetView;
import org.nlamah.QL.View.Form.Widgets.TextFieldWidgetView;
import org.nlamah.QLS.Model.Declaration.WidgetDeclaration;

public class WidgetViewFactory 
{
	static public WidgetView widgetViewForStyle(WidgetDeclaration widgetDeclaration)
	{
		switch (widgetDeclaration.widgetType())
		{
		case CHECKBOX: return new CheckboxWidgetView();
		case NUMBERFIELD: return new NumberFieldWidgetView();
		case RADIOBUTTON: return new RadioButtonWidgetView(widgetDeclaration.values(), widgetDeclaration.returnType());
		case SPINBOX:return new SpinnerWidgetView(widgetDeclaration.returnType());
		case TEXTFIELD: return new TextFieldWidgetView();
		default:
		{
			assert(false);
		}
		}
		
		return null;
	}
}
