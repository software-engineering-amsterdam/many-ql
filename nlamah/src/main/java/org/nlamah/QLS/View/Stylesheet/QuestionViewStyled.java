package org.nlamah.QLS.View.Stylesheet;

import java.awt.Color;
import java.awt.Font;

import org.nlamah.QL.Model.Form.Abstract.FormQuestion;
import org.nlamah.QL.View.Form.Abstract.QuestionView;
import org.nlamah.QL.View.Form.Abstract.WidgetView;
import org.nlamah.QLS.Model.StylesheetBlock.StyleBlock;

//TODO what to do with the serial numbers?
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
			Font declaredFont = styleBlock.fontDeclaration().primitiveValue();
		
			Font currentFont = questionLabel.getFont();
			
			Font newFont = new Font(declaredFont.getFontName(), declaredFont.getStyle(), currentFont.getSize());
			
			questionLabel.setFont(newFont);
		}
		
		if (styleBlock.fontSizeDeclaration() != null)
		{
			int declaredFontSize = styleBlock.fontSizeDeclaration().primitiveValue();
			
			Font currentFont = questionLabel.getFont();
			
			Font newFont = new Font(currentFont.getFontName(), currentFont.getStyle(), declaredFontSize);
			
			questionLabel.setFont(newFont);
		}
		
		if (styleBlock.colorDeclaration() != null)
		{
			Color declaredColor = styleBlock.colorDeclaration().primitiveValue();
			
			questionLabel.setForeground(declaredColor);
		}
		
		if (styleBlock.widthDeclaration() != null)
		{
			int declaredWidth = styleBlock.widthDeclaration().primitiveValue();
			
			viewWidth = declaredWidth;
		}
		
		layoutView();
	}
}
