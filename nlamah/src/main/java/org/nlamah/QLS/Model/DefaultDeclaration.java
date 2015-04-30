package org.nlamah.QLS.Model;

import java.util.List;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;

public class DefaultDeclaration extends SectionElement 
{
	private QuestionType questionType;
	private List<StyleDeclaration> styleDeclarations;
	
	public DefaultDeclaration(QuestionType questionType, List<StyleDeclaration> styleDeclarations)
	{
		super();
		
		this.questionType = questionType;
		this.styleDeclarations = styleDeclarations;
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
}
