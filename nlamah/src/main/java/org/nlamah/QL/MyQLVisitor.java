package org.nlamah.QL;

import java.util.ArrayList;

import org.nlamah.QL.FormModel.ASTNode;
import org.nlamah.QL.FormModel.Form;
import org.nlamah.QL.FormModel.FormElement;

public class MyQLVisitor extends QLBaseVisitor<ASTNode> 
{
	@Override
	public ASTNode visitForm(QLParser.FormContext ctx)
	{
		String formName = ctx.ID().getText();
	    ArrayList<FormElement> formElements = new ArrayList<>();
	
	    for (QLParser.FormElementContext contextualFormElement : ctx.formElement()) 
	    {
	        FormElement formElement = (FormElement) contextualFormElement.accept(this);
	        formElements.add(formElement);
	    }
	
	    Form form = new Form(formName, formElements);
	   // form.setLineNumber(this.getLineNumber(ctx));
	    return form;
	}
	
}
