package org.nlamah.QL.TypeChecker;

import java.util.ArrayList;
import java.util.List;

import org.nlamah.QL.Helper.QLHelper;
import org.nlamah.QL.Interfaces.QLFormElementVisitor;
import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.Model.Form.Abstract.Question;
import org.nlamah.QL.Model.Form.BooleanQuestion;
import org.nlamah.QL.Model.Form.ComputedQuestion;
import org.nlamah.QL.Model.Form.ConditionalBlock;
import org.nlamah.QL.Model.Form.ElseIfThenBlock;
import org.nlamah.QL.Model.Form.ElseThenBlock;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.Model.Form.IfThenBlock;
import org.nlamah.QL.Model.Form.NumberQuestion;
import org.nlamah.QL.Model.Form.TextQuestion;

public class GatherDeclaredQuestions implements QLFormElementVisitor 
{
	private List<Question> declaredQuestions;
	
	public GatherDeclaredQuestions(Form form)
	{
		declaredQuestions = new ArrayList<Question>();
		
		form.accept(this);
	}
	
	public List<Question> declaredQuestions()
	{
		return declaredQuestions;
	}

	@Override
	public void visit(Form form) 
	{
		if (QLHelper.arrayExistsAndHasElements(form.childElements()))
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
		declaredQuestions.add(booleanQuestion);
	}

	@Override
	public void visit(ComputedQuestion computedQuestion) 
	{
		declaredQuestions.add(computedQuestion);
	}

	@Override
	public void visit(NumberQuestion numberQuestion) 
	{
		declaredQuestions.add(numberQuestion);
	}

	@Override
	public void visit(TextQuestion textQuestion) 
	{
		declaredQuestions.add(textQuestion);

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
		
		if (QLHelper.arrayExistsAndHasElements(conditionalBlock.elseIfThenBlocks()))
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
