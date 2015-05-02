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
		
	public Section(TextValue titleValue, List<Section> sections, List<QuestionDeclaration> questionDeclarations, List<DefaultDeclaration> defaultDeclarations) 
	{
		super(titleValue, sections, defaultDeclarations);
	
		this.questionDeclarations = questionDeclarations;
	}
	
	public List<QuestionDeclaration> questionDeclarations()
	{
		return questionDeclarations;
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

		return true;
	}
}
