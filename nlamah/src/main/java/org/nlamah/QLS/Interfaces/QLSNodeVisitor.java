package org.nlamah.QLS.Interfaces;

import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Declaration.ColorDeclaration;
import org.nlamah.QLS.Model.Declaration.DefaultDeclaration;
import org.nlamah.QLS.Model.Declaration.FontDeclaration;
import org.nlamah.QLS.Model.Declaration.FontSizeDeclaration;
import org.nlamah.QLS.Model.Declaration.QuestionDeclaration;
import org.nlamah.QLS.Model.Declaration.WidgetDeclaration;
import org.nlamah.QLS.Model.Declaration.WidthDeclaration;
import org.nlamah.QLS.Model.StylesheetBlock.Page;
import org.nlamah.QLS.Model.StylesheetBlock.QLStylesheet;
import org.nlamah.QLS.Model.StylesheetBlock.Section;
import org.nlamah.QLS.Model.Value.FontValue;
import org.nlamah.QLS.Model.Value.HexNumberValue;
import org.nlamah.QLS.Model.Value.IdentifierValue;
import org.nlamah.QLS.Model.Value.NumberValue;
import org.nlamah.QLS.Model.Value.TextValue;
import org.nlamah.QLS.Model.Value.TypeValue;
import org.nlamah.QLS.Model.Value.Widget.CheckBoxWidgetType;
import org.nlamah.QLS.Model.Value.Widget.RadioButtonWidgetType;
import org.nlamah.QLS.Model.Value.Widget.SpinBoxWidgetType;

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
	public QLSNode visit(FontValue fontValue);
	
	public QLSNode visit(ColorDeclaration colorDeclaration);
	public QLSNode visit(FontDeclaration fontDeclaration);
	public QLSNode visit(FontSizeDeclaration fontSizeDeclaration);
	public QLSNode visit(WidthDeclaration widthDeclaration);
}
