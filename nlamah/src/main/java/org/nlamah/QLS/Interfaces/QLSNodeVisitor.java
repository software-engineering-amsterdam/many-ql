package org.nlamah.QLS.Interfaces;

import org.nlamah.QLS.Model.CheckBoxWidgetType;
import org.nlamah.QLS.Model.DefaultDeclaration;
import org.nlamah.QLS.Model.HexNumberValue;
import org.nlamah.QLS.Model.IdentifierValue;
import org.nlamah.QLS.Model.NumberValue;
import org.nlamah.QLS.Model.Page;
import org.nlamah.QLS.Model.QLSNode;
import org.nlamah.QLS.Model.QLStyleSheet;
import org.nlamah.QLS.Model.QuestionDeclaration;
import org.nlamah.QLS.Model.RadioButtonWidgetType;
import org.nlamah.QLS.Model.SectionDeclaration;
import org.nlamah.QLS.Model.SpinBoxWidgetType;
import org.nlamah.QLS.Model.TextValue;
import org.nlamah.QLS.Model.TypeValue;
import org.nlamah.QLS.Model.WidgetDeclaration;

public interface QLSNodeVisitor 
{
	public QLSNode visit(QLStyleSheet stylesheet);
	public QLSNode visit(Page page);
	
	public QLSNode visit(SectionDeclaration sectionDeclaration);
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
}
