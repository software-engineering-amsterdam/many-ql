package org.nlamah.QL.Model.Form;

import java.util.List;

import org.nlamah.QL.Model.Form.Abstract.QLNode;
import org.nlamah.QBase.Tools.ArrayTools;
import org.nlamah.QL.Interfaces.QLFormElementVisitor;
import org.nlamah.QL.Interfaces.QLNodeVisitor;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.Model.Form.Abstract.DeclaringFormElement;
import org.nlamah.QL.Model.Form.Abstract.FormQuestion;
import org.nlamah.QL.TypeChecker.FormQuestionsCollector;
import org.nlamah.QL.TypeChecker.ReferencedQuestionsCollector;

public class Form extends DeclaringFormElement
{
	private List<FormQuestion> questions;
	private List<IdentifierLiteral> referencedQuestions;

	private String title;

	public Form(String title, List<FormElement> formElements) 
	{
		super(formElements);

		this.title = title;
	}

	public String title()
	{
		return this.title;
	}

	public List<FormQuestion> questions()
	{
		if (!ArrayTools.arrayExistsAndHasElements(questions))
		{
			questions = new FormQuestionsCollector(this).questions();
		}

		return questions;
	}

	public List<IdentifierLiteral> referencedQuestions()
	{
		if (!ArrayTools.arrayExistsAndHasElements(referencedQuestions))
		{
			referencedQuestions = new ReferencedQuestionsCollector(this).questions();
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