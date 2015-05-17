package org.nlamah.QLS.Interfaces;

import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Declaration.ColorDeclaration;
import org.nlamah.QLS.Model.Declaration.FontDeclaration;
import org.nlamah.QLS.Model.Declaration.FontSizeDeclaration;
import org.nlamah.QLS.Model.Declaration.WidgetDeclaration;
import org.nlamah.QLS.Model.Declaration.WidthDeclaration;
import org.nlamah.QLS.Model.StylesheetBlock.DefaultBlock;
import org.nlamah.QLS.Model.StylesheetBlock.Page;
import org.nlamah.QLS.Model.StylesheetBlock.StyleBlock;
import org.nlamah.QLS.Model.StylesheetBlock.StyledQuestion;
import org.nlamah.QLS.Model.StylesheetBlock.Stylesheet;
import org.nlamah.QLS.Model.StylesheetBlock.Section;
import org.nlamah.QLS.Model.Value.IdentifierValue;

public interface QLSNodeVisitor 
{
	public QLSNode visit(Stylesheet stylesheet);
	public QLSNode visit(Page page);

	public QLSNode visit(Section section);
	public QLSNode visit(WidgetDeclaration widgetDeclaration);
	public QLSNode visit(StyledQuestion styledQuestion);
	public QLSNode visit(DefaultBlock defaultBlock);
	public QLSNode visit(StyleBlock styleBlock);

	public QLSNode visit(IdentifierValue identifierValue);

	public QLSNode visit(ColorDeclaration colorDeclaration);
	public QLSNode visit(FontDeclaration fontDeclaration);
	public QLSNode visit(FontSizeDeclaration fontSizeDeclaration);
	public QLSNode visit(WidthDeclaration widthDeclaration);
}
