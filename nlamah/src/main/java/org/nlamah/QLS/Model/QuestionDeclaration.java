package org.nlamah.QLS.Model;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;

public class QuestionDeclaration extends SectionElement 
{
	private String identifier;
	private WidgetDeclaration widgetDeclaration;
	
	public QuestionDeclaration(String identifier, WidgetDeclaration widgetDeclaration)
	{
		super();
		
		this.identifier = identifier;
		this.widgetDeclaration = widgetDeclaration;
	}
	
	public String identifier()
	{
		return identifier;
	}
	
	public WidgetDeclaration widgetDeclaration()
	{
		return widgetDeclaration;
	}
	
	@Override
	public QLSNode accept(QLSNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
}
