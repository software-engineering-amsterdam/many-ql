package org.nlamah.QL.Model.Form;

import java.util.List;

import org.nlamah.QL.Model.Form.Abstract.QLNode;
import org.nlamah.QBase.QBaseHelper;
import org.nlamah.QL.Interfaces.QLFormElementVisitor;
import org.nlamah.QL.Interfaces.QLNodeVisitor;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.Model.Form.Abstract.DeclaringFormElement;
import org.nlamah.QL.Model.Form.Abstract.FormQuestion;
import org.nlamah.QL.TypeChecker.DeclaredFormQuestionsCollector;
import org.nlamah.QL.TypeChecker.ReferencedQuestionsCollector;

public class Form extends DeclaringFormElement
{
	private List<FormQuestion> declaredQuestions;
	private List<IdentifierLiteral> referencedQuestions;

	private String title;

	public Form(String title, List<FormElement> formElements) 
	{
		super(formElements);

		this.title = title;
	}

	public String getTitle()
	{
		return this.title;
	}

	public List<FormQuestion> declaredQuestions()
	{
		if (!QBaseHelper.arrayExistsAndHasElements(declaredQuestions))
		{
			declaredQuestions = new DeclaredFormQuestionsCollector(this).questions();
		}

		return declaredQuestions;
	}

	public List<IdentifierLiteral> referencedQuestions()
	{
		if (!QBaseHelper.arrayExistsAndHasElements(referencedQuestions))
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
