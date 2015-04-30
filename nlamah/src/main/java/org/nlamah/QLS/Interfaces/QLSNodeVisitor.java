package org.nlamah.QLS.Interfaces;

import org.nlamah.QLS.Model.CheckBoxWidgetType;
import org.nlamah.QLS.Model.ColorDeclaration;
import org.nlamah.QLS.Model.DefaultDeclaration;
import org.nlamah.QLS.Model.FontDeclaration;
import org.nlamah.QLS.Model.FontSizeDeclaration;
import org.nlamah.QLS.Model.HexNumberValue;
import org.nlamah.QLS.Model.IdentifierValue;
import org.nlamah.QLS.Model.NumberValue;
import org.nlamah.QLS.Model.Page;
import org.nlamah.QLS.Model.QLSNode;
import org.nlamah.QLS.Model.QLStylesheet;
import org.nlamah.QLS.Model.QuestionDeclaration;
import org.nlamah.QLS.Model.RadioButtonWidgetType;
import org.nlamah.QLS.Model.Section;
import org.nlamah.QLS.Model.SpinBoxWidgetType;
import org.nlamah.QLS.Model.TextValue;
import org.nlamah.QLS.Model.TypeValue;
import org.nlamah.QLS.Model.WidgetDeclaration;
import org.nlamah.QLS.Model.WidthDeclaration;

public interface QLSNodeVisitor 
{
	public QLSNode visit(QLStylesheet stylesheet);
	public QLSNode visit(Page page);
	
	public QLSNode visit(Section sectionDeclaration);
	public QLSNode visit(WidgetDeclaration widgetDeclaration);
	public QLSNode visit(QuestionDeclaration questionDeclaration);
	public QLSNode visit(DefaultDeclaration defaultDeclaration);
	
	public QLSNode visit(CheckBoxWidgetType checkBoxWidgetType);
	public QLSNode visit(RadioButtonWidgetType radioButtonWidgetType);
	public QLSNode visit(SpinBoxWidgetType spinBoxWidgetType);
	
	public QLSNode visit(TextValue textValue);
	public QLSNode visit(TypeValue typeValue);
	public QLSNode visit(HexNumberValue hexNumberValue);
	public QLSNode visit(IdentifierValue identifierValue);
	public QLSNode visit(NumberValue numberValue);
	
	public QLSNode visit(ColorDeclaration colorDeclaration);
	public QLSNode visit(FontDeclaration fontDeclaration);
	public QLSNode visit(FontSizeDeclaration fontSizeDeclaration);
	public QLSNode visit(WidthDeclaration widthDeclaration);
}
