package org.nlamah.QLS.Model;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;

public class QuestionDeclaration extends QLSNode
{
	private IdentifierValue identifier;
	private WidgetDeclaration widgetDeclaration;
	
	public QuestionDeclaration(IdentifierValue identifier, WidgetDeclaration widgetDeclaration)
	{
		super();
		
		this.identifier = identifier;
		this.widgetDeclaration = widgetDeclaration;
	}
	
	public IdentifierValue identifier()
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
