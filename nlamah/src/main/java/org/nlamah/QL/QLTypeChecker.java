package org.nlamah.QL;

import org.nlamah.QL.Error.QLError;
import org.nlamah.QL.Helper.Helper;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.Visitors.ConnectRelatedNodesVisitor;

public class QLTypeChecker 
{
	public static Form check(Form form)
	{
		connectRelatedNodesAndAssignErrors(form);
		
		return form;
	}
	
	private static void connectRelatedNodesAndAssignErrors(Form form)
	{
		if (Helper.arrayExistsAndHasElements(form.referencedQuestions))
    	{
    		for (IdentifierLiteral identifier : form.referencedQuestions)
        	{
    			ConnectRelatedNodesVisitor visitor = new ConnectRelatedNodesVisitor();
    			
        		identifier.accept(visitor);
        		System.out.println("identifier: " + identifier.toString());
        		System.out.println("errors:");
        		
        		if (Helper.arrayExistsAndHasElements(visitor.getErrors()))
        		{
        			for (QLError error : visitor.getErrors())
        			{
        				form.addError(error);
        			}
        		}
        	}
    	}
	}
}
