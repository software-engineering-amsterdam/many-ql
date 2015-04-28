package org.nlamah.QLS.Model;

import org.nlamah.QL.Interfaces.QLNodeVisitor;
import org.nlamah.QL.Model.Form.Abstract.QLNode;

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
	public QLNode accept(QLNodeVisitor visitor) 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
