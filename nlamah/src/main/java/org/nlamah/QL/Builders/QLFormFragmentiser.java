package org.nlamah.QL.Builders;

import java.util.ArrayList;
import java.util.List;

import org.nlamah.QL.Interfaces.QLFormElementVisitor;
import org.nlamah.QL.Model.Form.ComputedQuestion;
import org.nlamah.QL.Model.Form.ConditionalBlock;
import org.nlamah.QL.Model.Form.ElseIfThenBlock;
import org.nlamah.QL.Model.Form.ElseThenBlock;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.Model.Form.IfThenBlock;
import org.nlamah.QL.Model.Form.InputQuestion;
import org.nlamah.QL.Model.Form.Abstract.FormElement;

public class QLFormFragmentiser implements QLFormElementVisitor
{
	private Form fragmentedForm;
	
	private List<FormElement> justAcceptedFragementedFormElementList;
	
	private ConditionalBlock currentConditionalBlock;
	
	public QLFormFragmentiser(Form form) 
	{
		super();
		
		form.accept(this);
	}

	public Form form()
	{
		return fragmentedForm;
	}
	
	@Override
	public void visit(Form form) 
	{
		List<FormElement> newFormElements = new ArrayList<FormElement>();
		
		for (FormElement formElement : form.childElements())
		{
			formElement.accept(this);
			
			newFormElements.addAll(justAcceptedFragementedFormElementList);
		}
		
		fragmentedForm = new Form(form.title(), newFormElements);
	}

	@Override
	public void visit(ElseIfThenBlock elseIfThenBlock) 
	{
		List<FormElement> fragementedElseIfThenBlockList = new ArrayList<FormElement>();
		
		for (FormElement childElement : elseIfThenBlock.childElements())
		{
			childElement.accept(this);
			
			for (FormElement justAcceptedElement : justAcceptedFragementedFormElementList)
			{
				//IfThenBlock
				IfThenBlock emptyIfThenBlock = new IfThenBlock(currentConditionalBlock.ifThenBlock().expression(), new ArrayList<FormElement>());
				
				//ElseIfThenBlocks
				List<ElseIfThenBlock> copiedElseIfThenBlocks = new ArrayList<ElseIfThenBlock>();
				
				for (ElseIfThenBlock loopedElseIfThenBlock : currentConditionalBlock.elseIfThenBlocks())
				{					
					ElseIfThenBlock copiedElseIfThenBlock;
					
					if (loopedElseIfThenBlock.equals(elseIfThenBlock))
					{
						List<FormElement> singleFormElementList = new ArrayList<FormElement>();

						singleFormElementList.add(justAcceptedElement);
						
						copiedElseIfThenBlock = new ElseIfThenBlock(loopedElseIfThenBlock.expression(), singleFormElementList);
					}
					else
					{
						copiedElseIfThenBlock = new ElseIfThenBlock(loopedElseIfThenBlock.expression(), new ArrayList<FormElement>());
					}
					
					copiedElseIfThenBlocks.add(copiedElseIfThenBlock);
					
				}
				
				//ElseThenBlock
				ElseThenBlock emptyElseThenBlock = new ElseThenBlock(new ArrayList<FormElement>());
				
				//ConditionalBlock
				ConditionalBlock newConditionalBlock = new ConditionalBlock(emptyIfThenBlock, copiedElseIfThenBlocks, emptyElseThenBlock);
				
				fragementedElseIfThenBlockList.add(newConditionalBlock);
			}
		}
		
		justAcceptedFragementedFormElementList = fragementedElseIfThenBlockList;
	}

	@Override
	public void visit(ElseThenBlock elseThenBlock) 
	{
		List<FormElement> fragementedElseThenBlockList = new ArrayList<FormElement>();
		
		for (FormElement childElement : elseThenBlock.childElements())
		{
			childElement.accept(this);
			
			for (FormElement justAcceptedElement : justAcceptedFragementedFormElementList)
			{
				//IfThenBlock
				IfThenBlock emptyIfThenBlock = new IfThenBlock(currentConditionalBlock.ifThenBlock().expression(), new ArrayList<FormElement>());
				
				//ElseIfThenBlocks
				List<ElseIfThenBlock> emptyElseIfThenBlocks = new ArrayList<ElseIfThenBlock>();
				
				for (ElseIfThenBlock elseIfThenBlock : currentConditionalBlock.elseIfThenBlocks())
				{
					ElseIfThenBlock emptyElseIfThenBlock = new ElseIfThenBlock(elseIfThenBlock.expression(), new ArrayList<FormElement>());
					
					emptyElseIfThenBlocks.add(emptyElseIfThenBlock);
				}
				
				//ElseThenBlock
				List<FormElement> singleFormElementList = new ArrayList<FormElement>();

				singleFormElementList.add(justAcceptedElement);
				
				//ConditionalBlock
				ConditionalBlock newConditionalBlock = new ConditionalBlock(emptyIfThenBlock, emptyElseIfThenBlocks, new ElseThenBlock(singleFormElementList));
				
				fragementedElseThenBlockList.add(newConditionalBlock);
			}
		}
		
		justAcceptedFragementedFormElementList = fragementedElseThenBlockList;
		
	}

	@Override
	public void visit(IfThenBlock ifThenBlock) 
	{
		List<FormElement> fragementedIfThenBlockList = new ArrayList<FormElement>();
		
		for (FormElement childElement : ifThenBlock.childElements())
		{
			childElement.accept(this);
			
			for (FormElement justAcceptedElement : justAcceptedFragementedFormElementList)
			{
				//IfThenBlock
				List<FormElement> singleFormElementList = new ArrayList<FormElement>();
				
				singleFormElementList.add(justAcceptedElement);
				
				//ElseIfThenBlocks
				List<ElseIfThenBlock> emptyElseIfThenBlocks = new ArrayList<ElseIfThenBlock>();
				
				for (ElseIfThenBlock elseIfThenBlock : currentConditionalBlock.elseIfThenBlocks())
				{
					ElseIfThenBlock emptyElseIfThenBlock = new ElseIfThenBlock(elseIfThenBlock.expression(), new ArrayList<FormElement>());
					
					emptyElseIfThenBlocks.add(emptyElseIfThenBlock);
				}
				
				//ElseThenBlock
				ElseThenBlock emptyElseThenBlock = new ElseThenBlock(new ArrayList<FormElement>());
				
				//ConditionalBlock
				ConditionalBlock newConditionalBlock = new ConditionalBlock(new IfThenBlock(ifThenBlock.expression(), singleFormElementList), emptyElseIfThenBlocks, emptyElseThenBlock);
				
				fragementedIfThenBlockList.add(newConditionalBlock);
			}
		}
		
		justAcceptedFragementedFormElementList = fragementedIfThenBlockList;
	}

	@Override
	public void visit(ConditionalBlock conditionalBlock) 
	{
		currentConditionalBlock = conditionalBlock;
		
		List<FormElement> fragmentedConditionalBlockList = new ArrayList<FormElement>();
		
		//IfThenBlock
		conditionalBlock.ifThenBlock().accept(this);
		
		fragmentedConditionalBlockList.addAll(justAcceptedFragementedFormElementList);
		
		//ElseIfThenBlocks
		for (ElseIfThenBlock elseIfThenBlock : conditionalBlock.elseIfThenBlocks())
		{
			elseIfThenBlock.accept(this);
			fragmentedConditionalBlockList.addAll(justAcceptedFragementedFormElementList);
		}
		
		//ElseThenBlock
		if (conditionalBlock.elseThenBlock() != null)
		{
			conditionalBlock.elseThenBlock().accept(this);
			fragmentedConditionalBlockList.addAll(justAcceptedFragementedFormElementList);
		}
		
		justAcceptedFragementedFormElementList = fragmentedConditionalBlockList;
	}

	@Override
	public void visit(InputQuestion inputQuestion) 
	{
		justAcceptedFragementedFormElementList = new ArrayList<FormElement>();
		justAcceptedFragementedFormElementList.add(inputQuestion);
	}
	
	@Override
	public void visit(ComputedQuestion computedQuestion) 
	{
		justAcceptedFragementedFormElementList = new ArrayList<FormElement>();
		justAcceptedFragementedFormElementList.add(computedQuestion);
	}
}
