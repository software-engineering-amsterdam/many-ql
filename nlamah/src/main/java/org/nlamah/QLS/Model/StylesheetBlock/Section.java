package org.nlamah.QLS.Model.StylesheetBlock;

import java.util.List;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Abstract.SectionItem;
import org.nlamah.QLS.Model.Value.TextValue;

public class Section extends SectionItem
{
	private List<? extends SectionItem> sectionItems;
	private int depthLevel;
	
	public Section(TextValue titleValue, List<? extends SectionItem> sectionItems, List<DefaultBlock> defaultBlocks, int depthLevel) 
	{
		super(titleValue, defaultBlocks);
		
		this.sectionItems = sectionItems;
		
		this.depthLevel = depthLevel;
		
		for (SectionItem sectionItem : sectionItems)
		{
			sectionItem.setParentNode(this);
		}
	}
	
	public Section(TextValue titleValue, List<? extends SectionItem> sectionItems, List<DefaultBlock> defaultBlocks) 
	{
		this(titleValue, sectionItems, defaultBlocks, -1);
	}
	
	public List<? extends SectionItem> sectionItems()
	{
		return sectionItems;
	}
	
	public int depthLevel()
	{
		return depthLevel;
	}

	@Override
	public QLSNode accept(QLSNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
	
	@Override 
	public boolean equals(Object object) 
	{
		if (!super.equals(object))
		{
			return false;
		}

		if (!(object instanceof Section))
		{
			return false;
		}
		
		Section value = (Section)object;
		
		if (!(sectionItems.equals(value.sectionItems)))
		{
			return false;
		}

		return true;
	}
}
