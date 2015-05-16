package org.nlamah.QLS.Model.StylesheetBlock;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.nlamah.QBase.EqualityStating;
import org.nlamah.QBase.QBaseEqualityState;
import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Abstract.SectionItem;
import org.nlamah.QLS.Model.Abstract.StyleDeclaration;
import org.nlamah.QLS.Model.Declaration.ColorDeclaration;
import org.nlamah.QLS.Model.Declaration.FontDeclaration;
import org.nlamah.QLS.Model.Declaration.FontSizeDeclaration;
import org.nlamah.QLS.Model.Declaration.WidgetDeclaration;
import org.nlamah.QLS.Model.Declaration.WidthDeclaration;

public class DefaultBlock extends SectionItem implements EqualityStating
{
	public Stack<QBaseEqualityState> equalityStateStack;
	
	private QBaseQuestionType questionType;
	
	private ColorDeclaration colorDeclaration;
	private FontDeclaration fontDeclaration;
	private FontSizeDeclaration fontSizeDeclaration;
	private WidgetDeclaration widgetDeclaration;
	private WidthDeclaration widthDeclaration;
	
	public DefaultBlock(QBaseQuestionType questionType, List<StyleDeclaration> styleDeclarations)
	{
		super();

		assert(styleDeclarations != null);
		
		assignStyleDeclarations(styleDeclarations);
		
		this.questionType = questionType;
		
		equalityStateStack = new Stack<QBaseEqualityState>();
		equalityStateStack.push(QBaseEqualityState.ALL_PROPERTIES);
		
		for (StyleDeclaration styleDeclaration : styleDeclarations)
		{
			styleDeclaration.setParentNode(this);
		}
	}
	
	private void assignStyleDeclarations(List<StyleDeclaration> styleDeclarations)
	{
		for (StyleDeclaration styleDeclaration : styleDeclarations)
		{
			if (styleDeclaration instanceof ColorDeclaration)
			{
				colorDeclaration = (ColorDeclaration) styleDeclaration;
			}
			else if (styleDeclaration instanceof FontDeclaration)
			{
				fontDeclaration = (FontDeclaration) styleDeclaration;
			}
			else if (styleDeclaration instanceof FontSizeDeclaration)
			{
				fontSizeDeclaration = (FontSizeDeclaration) styleDeclaration;
			}
			else if (styleDeclaration instanceof WidgetDeclaration)
			{
				widgetDeclaration = (WidgetDeclaration) styleDeclaration;
			}
			else if (styleDeclaration instanceof WidthDeclaration)
			{
				widthDeclaration = (WidthDeclaration) styleDeclaration;
			}
			else
			{
				assert(false);
			}
		}
	}
	
	public QBaseQuestionType questionType()
	{
		return questionType;
	}
	
	public List<StyleDeclaration> styleDeclarations()
	{	
		List<StyleDeclaration> styleDeclarationsToReturn = new ArrayList<StyleDeclaration>();
		
		if (colorDeclaration != null)
		{
			styleDeclarationsToReturn.add(colorDeclaration);
		}
		
		if (fontDeclaration != null)
		{
			styleDeclarationsToReturn.add(fontDeclaration);
		}
		
		if (fontSizeDeclaration != null)
		{
			styleDeclarationsToReturn.add(fontSizeDeclaration);
		}
		
		if (widgetDeclaration != null)
		{
			styleDeclarationsToReturn.add(widgetDeclaration);
		}
		
		if (widthDeclaration != null)
		{
			styleDeclarationsToReturn.add(widthDeclaration);
		}
		
		return styleDeclarationsToReturn;
	}
	
	public void overWriteStyleDeclaration(StyleDeclaration styleDeclaration)
	{
		if (styleDeclaration instanceof ColorDeclaration)
		{
			colorDeclaration = (ColorDeclaration) styleDeclaration;
		}
		else if (styleDeclaration instanceof FontDeclaration)
		{
			fontDeclaration = (FontDeclaration) styleDeclaration;
		}
		else if (styleDeclaration instanceof FontSizeDeclaration)
		{
			fontSizeDeclaration = (FontSizeDeclaration) styleDeclaration;
		}
		else if (styleDeclaration instanceof WidgetDeclaration)
		{
			widgetDeclaration = (WidgetDeclaration) styleDeclaration;
		}
		else if (styleDeclaration instanceof WidthDeclaration)
		{
			widthDeclaration = (WidthDeclaration) styleDeclaration;
		}
		else
		{
			assert(false);
		}
	}

	public ColorDeclaration colorDeclaration() 
	{
		return colorDeclaration;
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

	@Override
	public QLSNode accept(QLSNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
	
	@Override
	public String toString()
	{
		//TODO
		return questionType.toString();
	}
	
	@Override 
	public boolean equals(Object object) 
	{
		
		switch(equalityStateStack.peek())
		{
		case QUESTIONTYPE_ONLY:
		{
			if (!(object instanceof DefaultBlock))
			{
				return false;
			}
			
			DefaultBlock value = (DefaultBlock) object;
			
			if (this.questionType != value.questionType)
			{
				return false;
			}
			
			break;
		}
		default:
		{
			if (!(object instanceof DefaultBlock))
			{
				return false;
			}
			
			DefaultBlock value = (DefaultBlock) object;
			
			if (this.questionType != value.questionType)
			{
				return false;
			}
			
			if (!this.styleDeclarations().equals(value.styleDeclarations()))
			{
				return false;
			}			
			
			break;
		}
		}
		
		return true;
	}
	
	@Override
	public int hashCode()
	{
		return questionType.toString().hashCode();
	}

	@Override
	public void push(QBaseEqualityState state) 
	{
		equalityStateStack.push(state);
	}

	@Override
	public QBaseEqualityState popState() 
	{
		return equalityStateStack.pop();
	}
}
