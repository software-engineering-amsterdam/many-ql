package org.nlamah.QLS.Interfaces;

import org.nlamah.QLS.Model.StylesheetBlock.Page;
import org.nlamah.QLS.Model.StylesheetBlock.Section;
import org.nlamah.QLS.Model.StylesheetBlock.Stylesheet;
import org.nlamah.QLS.View.Controllers.NavigationPageViewController;

public interface QLStylesheetBlockVisitor 
{
	public void visit(Stylesheet stylesheet);
	public void visit(Page page);
	public void visit(Section section);
	public void visit(NavigationPageViewController navigationPageViewController);
}