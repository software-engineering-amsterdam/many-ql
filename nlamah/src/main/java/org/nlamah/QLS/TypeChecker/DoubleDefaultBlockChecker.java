package org.nlamah.QLS.TypeChecker;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.nlamah.QBase.QBaseAbstractTypeChecker;
import org.nlamah.QBase.QBaseEqualityState;
import org.nlamah.QBase.QBaseHelper;
import org.nlamah.QLS.Error.DoubleDefaultBlockError;
import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Abstract.SectionItem;
import org.nlamah.QLS.Model.Declaration.ColorDeclaration;
import org.nlamah.QLS.Model.Declaration.FontDeclaration;
import org.nlamah.QLS.Model.Declaration.FontSizeDeclaration;
import org.nlamah.QLS.Model.Declaration.WidgetDeclaration;
import org.nlamah.QLS.Model.Declaration.WidthDeclaration;
import org.nlamah.QLS.Model.StylesheetBlock.DefaultBlock;
import org.nlamah.QLS.Model.StylesheetBlock.Page;
import org.nlamah.QLS.Model.StylesheetBlock.Section;
import org.nlamah.QLS.Model.StylesheetBlock.StyleBlock;
import org.nlamah.QLS.Model.StylesheetBlock.StyledQuestion;
import org.nlamah.QLS.Model.StylesheetBlock.Stylesheet;
import org.nlamah.QLS.Model.Value.IdentifierValue;

public class DoubleDefaultBlockChecker extends QBaseAbstractTypeChecker implements QLSNodeVisitor 
{
	public DoubleDefaultBlockChecker(Stylesheet stylesheet) 
	{
		super();
		
		stylesheet.accept(this);
	}
	
	private void gatherErrors(List<DefaultBlock> defaultBlocks)
	{		
		Set<DefaultBlock> set = QBaseHelper.getSetWithDuplicatedObjects(defaultBlocks, QBaseEqualityState.QUESTIONTYPE_ONLY);
		
		if (set.size() > 0)
		{
			for (DefaultBlock defaultBlock : set)
			{
				List<DefaultBlock> defaultBlocksWithSameType = defaultBlocksWithSameType(defaultBlocks, defaultBlock);
				
				errors.add(new DoubleDefaultBlockError(new ArrayList<DefaultBlock>(defaultBlocksWithSameType)));
			}
		}
	}
	
	private List<DefaultBlock> defaultBlocksWithSameType(List<DefaultBlock> defaultBlocks, DefaultBlock referenceDeclaration)
	{
		List<DefaultBlock> returnList = new ArrayList<DefaultBlock>();
		
		for (DefaultBlock defaultBlock : defaultBlocks)
		{
			if (defaultBlock.questionType() == referenceDeclaration.questionType())
			{
				returnList.add(defaultBlock);
			}
		}
		
		return returnList;
	}

	@Override
	public QLSNode visit(Stylesheet stylesheet) 
	{	
		gatherErrors(stylesheet.defaultBlocks());
		
		for (Page page : stylesheet.pages())
		{
			page.accept(this);
		}
		
		return null;
	}
	
	@Override
	public QLSNode visit(Page page) 
	{
		gatherErrors(page.defaultBlocks());
		
		for (Section section : page.sections())
		{
			section.accept(this);
		}
		
		return null;
	}

	@Override
	public QLSNode visit(Section section) 
	{
		gatherErrors(section.defaultBlocks());
		
		for (SectionItem sectionItem : section.sectionItems())
		{
			sectionItem.accept(this);
		}
		
		return null;
	}

	@Override
	public QLSNode visit(WidgetDeclaration widgetDeclaration) 
	{
		assert(false);
		
		return null;
	}

	@Override
	public QLSNode visit(StyledQuestion styledQuestion) 
	{		
		return null;
	}

	@Override
	public QLSNode visit(DefaultBlock defaultBlock) 
	{
		assert(false);
		
		return null;
	}

	@Override
	public QLSNode visit(StyleBlock styleBlock)
	{
		assert(false);
		
		return null;
	}

	@Override
	public QLSNode visit(IdentifierValue identifierValue) 
	{
		assert(false);
		
		return null;
	}

	@Override
	public QLSNode visit(ColorDeclaration colorDeclaration) 
	{
		assert(false);
		
		return null;
	}

	@Override
	public QLSNode visit(FontDeclaration fontDeclaration) 
	{
		assert(false);
		
		return null;
	}

	@Override
	public QLSNode visit(FontSizeDeclaration fontSizeDeclaration) 
	{
		assert(false);
		
		return null;
	}

	@Override
	public QLSNode visit(WidthDeclaration widthDeclaration) 
	{
		assert(false);
		
		return null;
	}
}
