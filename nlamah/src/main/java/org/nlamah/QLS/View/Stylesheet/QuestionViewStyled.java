package org.nlamah.QLS.View.Stylesheet;

import java.awt.Font;

import org.nlamah.QL.Model.Form.Abstract.FormQuestion;
import org.nlamah.QL.View.Form.Abstract.QuestionView;
import org.nlamah.QL.View.Form.Abstract.WidgetView;
import org.nlamah.QLS.Model.StylesheetBlock.StyleBlock;
import org.nlamah.QLS.Model.Value.ColorValue;
import org.nlamah.QLS.Model.Value.FontValue;
import org.nlamah.QLS.Model.Value.NumberValue;

@SuppressWarnings("serial")
public class QuestionViewStyled extends QuestionView 
{
	private StyleBlock styleBlock;
	
	public QuestionViewStyled(QuestionView questionView, StyleBlock styleBlock)
	{
		this(questionView.question(), questionView.widgetView(), styleBlock);
	}
	
	public QuestionViewStyled(FormQuestion question, WidgetView widgetView, StyleBlock styleBlock) 
	{
		super(question, widgetView);
		
		this.styleBlock = styleBlock;
		
		adaptStyle();
	}
	
	private void adaptStyle()
	{
		if (styleBlock.fontDeclaration() != null)
		{
			FontValue fontValue = (FontValue) styleBlock.fontDeclaration().value();
		
			Font currentFont = questionLabel.getFont();
			
			Font newFont = new Font(fontValue.font().getFontName(), fontValue.font().getStyle(), currentFont.getSize());
			
			questionLabel.setFont(newFont);
		}
		
		if (styleBlock.fontSizeDeclaration() != null)
		{
			NumberValue fontSizeValue = (NumberValue) styleBlock.fontSizeDeclaration().value();
			
			Font currentFont = questionLabel.getFont();
			
			Font newFont = new Font(currentFont.getFontName(), currentFont.getStyle(), fontSizeValue.number());
			
			questionLabel.setFont(newFont);
		}
		
		if (styleBlock.colorDeclaration() != null)
		{
			ColorValue colorValue = (ColorValue) styleBlock.colorDeclaration().value();
			
			questionLabel.setForeground(colorValue.color());
		}
		
		layoutView();
	}
}
