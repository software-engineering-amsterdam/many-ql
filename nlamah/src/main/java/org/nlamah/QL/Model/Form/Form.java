package org.nlamah.QL.Model.Form;

import java.util.ArrayList;

import org.nlamah.QL.Model.Form.Abstract.QLNode;
import org.nlamah.QL.Helper.QLHelper;
import org.nlamah.QL.Interfaces.QLFormElementVisitor;
import org.nlamah.QL.Interfaces.QLNodeVisitor;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.Model.Form.Abstract.DeclaringFormElement;
import org.nlamah.QL.Model.Form.Abstract.Question;
import org.nlamah.QL.TypeChecker.GatherDeclaredQuestions;
import org.nlamah.QL.TypeChecker.GatherReferencedQuestions;

public class Form extends DeclaringFormElement
{
	private ArrayList<Question> declaredQuestions;
	private ArrayList<IdentifierLiteral> referencedQuestions;

	private String title;

	public Form(String title, ArrayList<FormElement> formElements) 
	{
		super(formElements);

		this.title = title;
	}

	public String getTitle()
	{
		return this.title;
	}

	public ArrayList<Question> declaredQuestions()
	{
		if (!QLHelper.arrayExistsAndHasElements(declaredQuestions))
		{
			declaredQuestions = new GatherDeclaredQuestions(this).declaredQuestions();
		}

		return declaredQuestions;
	}

	public ArrayList<IdentifierLiteral> referencedQuestions()
	{
		if (!QLHelper.arrayExistsAndHasElements(referencedQuestions))
		{
			referencedQuestions = new GatherReferencedQuestions(this).referencedQuestions();
		}

		return referencedQuestions;
	}

	@Override 
	public boolean equals(Object object) 
	{
		if (!super.equals(object))
		{
			return false;
		}

		if (!(object instanceof Form))
		{
			return false;
		}

		Form value = (Form)object;

		if (!(this.title.equals(value.title)))
		{
			return false;
		}

		return true;
	}

	@Override
	public QLNode accept(QLNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}

	@Override
	public void accept(QLFormElementVisitor visitor) 
	{
		visitor.visit(this);
	}
}
