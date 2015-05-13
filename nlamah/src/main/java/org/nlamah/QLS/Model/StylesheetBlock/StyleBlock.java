package org.nlamah.QLS.Model.StylesheetBlock;

import java.util.List;

import org.nlamah.QLS.Model.Abstract.StyleDeclaration;
import org.nlamah.QLS.Model.Declaration.ColorDeclaration;
import org.nlamah.QLS.Model.Declaration.FontDeclaration;
import org.nlamah.QLS.Model.Declaration.FontSizeDeclaration;
import org.nlamah.QLS.Model.Declaration.WidgetDeclaration;
import org.nlamah.QLS.Model.Declaration.WidthDeclaration;

public class StyleBlock extends DefaultBlock 
{
	private ColorDeclaration colorDeclaration;
	private FontDeclaration fontDeclaration;
	private FontSizeDeclaration fontSizeDeclaration;
	private WidgetDeclaration widgetDeclaration;
	private WidthDeclaration widthDeclaration;
	
	public StyleBlock(List<StyleDeclaration> styleDeclarations) 
	{
		super(null, styleDeclarations);
	}

	public ColorDeclaration colorDeclaration() 
	{
		return (ColorDeclaration) getStyleDeclarationFor(colorDeclaration);
	}

	public FontDeclaration fontDeclaration() 
	{
		return fontDeclaration;
	}

	public FontSizeDeclaration fontSizeDeclaration() 
	{
		return fontSizeDeclaration;
	}

	public WidgetDeclaration widgetDeclaration() 
	{
		return widgetDeclaration;
	}

	public WidthDeclaration widthDeclaration() 
	{
		return widthDeclaration;
	}
	
	private StyleDeclaration getStyleDeclarationFor(StyleDeclaration styleDeclaration)
	{
		assert(styleDeclaration.getClass() != null);
		
		for (StyleDeclaration loopedStyleDeclaration : styleDeclarations())
		{
			if (styleDeclaration.getClass().equals(loopedStyleDeclaration.getClass()))
			{
				return loopedStyleDeclaration;
			}
		}
		
		return null;
	}
}
