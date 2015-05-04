package org.nlamah.QLS.Model.StylesheetBlock;

import java.util.List;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Abstract.StylesheetBlock;
import org.nlamah.QLS.Model.Declaration.DefaultDeclaration;
import org.nlamah.QLS.Model.Declaration.StyledQuestion;
import org.nlamah.QLS.Model.Value.TextValue;

public class Section extends StylesheetBlock
{
	private List<StyledQuestion> questionDeclarations;
	private List<Section> sections;
	private int depthLevel;
	
	public Section(TextValue titleValue, List<Section> sections, List<StyledQuestion> questionDeclarations, List<DefaultDeclaration> defaultDeclarations, int depthLevel) 
	{
		super(titleValue, defaultDeclarations);
	
		this.questionDeclarations = questionDeclarations;
		
		this.sections = sections;
		
		this.depthLevel = depthLevel;
		
		for (Section section : sections)
		{
			section.setParentNode(this);
		}
	}
	
	public Section(TextValue titleValue, List<Section> sections, List<StyledQuestion> questionDeclarations, List<DefaultDeclaration> defaultDeclarations) 
	{
		this(titleValue, sections, questionDeclarations, defaultDeclarations, -1);
	}
	
	public List<StyledQuestion> questionDeclarations()
	{
		return questionDeclarations;
	}
	
	public List<Section> sections()
	{
		return sections;
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
		
		if (!(questionDeclarations.equals(value.questionDeclarations)))
		{
			return false;
		}
		
		if (!(sections.equals(value.sections)))
		{
			return false;
		}

		return true;
	}
}
