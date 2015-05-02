package org.nlamah.QLS.Model.StylesheetBlock;

import java.util.List;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Abstract.QLStylesheetBlock;
import org.nlamah.QLS.Model.Declaration.DefaultDeclaration;
import org.nlamah.QLS.Model.Declaration.QuestionDeclaration;
import org.nlamah.QLS.Model.Value.TextValue;

public class Section extends QLStylesheetBlock
{
	private List<QuestionDeclaration> questionDeclarations;
	private List<Section> sections;
	
	public Section(TextValue titleValue, List<Section> sections, List<QuestionDeclaration> questionDeclarations, List<DefaultDeclaration> defaultDeclarations) 
	{
		super(titleValue, defaultDeclarations);
	
		this.questionDeclarations = questionDeclarations;
		
		this.sections = sections;
		
		for (Section section : sections)
		{
			section.setParentNode(this);
		}
	}
	
	public List<QuestionDeclaration> questionDeclarations()
	{
		return questionDeclarations;
	}
	
	public List<Section> sections()
	{
		return sections;
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
