package org.nlamah.QLS.Model;

import java.util.List;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;

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
}
