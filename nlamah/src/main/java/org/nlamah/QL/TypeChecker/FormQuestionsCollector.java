package org.nlamah.QL.TypeChecker;

import java.util.ArrayList;
import java.util.List;

import org.nlamah.QBase.QBaseHelper;
import org.nlamah.QL.Interfaces.QLFormElementVisitor;
import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.Model.Form.Abstract.FormQuestion;
import org.nlamah.QL.Model.Form.BooleanQuestion;
import org.nlamah.QL.Model.Form.ComputedQuestion;
import org.nlamah.QL.Model.Form.ConditionalBlock;
import org.nlamah.QL.Model.Form.ElseIfThenBlock;
import org.nlamah.QL.Model.Form.ElseThenBlock;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.Model.Form.IfThenBlock;
import org.nlamah.QL.Model.Form.NumberQuestion;
import org.nlamah.QL.Model.Form.TextQuestion;

public class FormQuestionsCollector implements QLFormElementVisitor 
{
	private List<FormQuestion> questions;
	
	public FormQuestionsCollector(Form form)
	{
		questions = new ArrayList<FormQuestion>();
		
		form.accept(this);
	}
	
	public List<FormQuestion> questions()
	{
		return questions;
	}

	@Override
	public void visit(Form form) 
	{
		if (QBaseHelper.arrayExistsAndHasElements(form.childElements()))
		{
			for (FormElement childElement : form.childElements())
			{
				childElement.accept(this);
			}
		}
	}

	@Override
	public void visit(BooleanQuestion booleanQuestion) 
	{
		questions.add(booleanQuestion);
	}

	@Override
	public void visit(ComputedQuestion computedQuestion) 
	{
		questions.add(computedQuestion);
	}

	@Override
	public void visit(NumberQuestion numberQuestion) 
	{
		questions.add(numberQuestion);
	}

	@Override
	public void visit(TextQuestion textQuestion) 
	{
		questions.add(textQuestion);

	}

	@Override
	public void visit(ElseIfThenBlock elseIfThenBlock) 
	{
		for (FormElement childElement : elseIfThenBlock.childElements())
		{
			childElement.accept(this);
		}
	}

	@Override
	public void visit(ElseThenBlock elseThenBlock) 
	{
		for (FormElement childElement : elseThenBlock.childElements())
		{
			childElement.accept(this);
		}
	}

	@Override
	public void visit(IfThenBlock ifThenBlock) 
	{
		for (FormElement childElement : ifThenBlock.childElements())
		{
			childElement.accept(this);
		}
	}

	@Override
	public void visit(ConditionalBlock conditionalBlock) 
	{
		if (conditionalBlock.ifThenBlock() != null)
		{
			conditionalBlock.ifThenBlock().accept(this);
		}
		
		if (QBaseHelper.arrayExistsAndHasElements(conditionalBlock.elseIfThenBlocks()))
		{
			for (ElseIfThenBlock elseIfThenBlock : conditionalBlock.elseIfThenBlocks())
			{
				elseIfThenBlock.accept(this);
			}
		}
		
		if (conditionalBlock.elseThenBlock() != null)
		{
			conditionalBlock.elseThenBlock().accept(this);
		}
	}
}
