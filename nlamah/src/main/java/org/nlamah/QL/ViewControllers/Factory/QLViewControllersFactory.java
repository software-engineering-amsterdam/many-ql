package org.nlamah.QL.ViewControllers.Factory;

import java.util.ArrayList;

import org.nlamah.QL.Helper.Helper;
import org.nlamah.QL.Interfaces.QLFormElementVisitor;
import org.nlamah.QL.Model.Form.BooleanQuestion;
import org.nlamah.QL.Model.Form.ComputedQuestion;
import org.nlamah.QL.Model.Form.ConditionalBlock;
import org.nlamah.QL.Model.Form.ElseIfThenBlock;
import org.nlamah.QL.Model.Form.ElseThenBlock;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.Model.Form.IfThenBlock;
import org.nlamah.QL.Model.Form.NumberQuestion;
import org.nlamah.QL.Model.Form.TextQuestion;
import org.nlamah.QL.Model.Form.Abstract.DeclaringFormElement;
import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.ViewControllers.Form.BooleanQuestionViewController;
import org.nlamah.QL.ViewControllers.Form.ComputedQuestionViewController;
import org.nlamah.QL.ViewControllers.Form.ConditionalBlockViewController;
import org.nlamah.QL.ViewControllers.Form.ElseIfThenBlockViewController;
import org.nlamah.QL.ViewControllers.Form.ElseThenBlockViewController;
import org.nlamah.QL.ViewControllers.Form.IfThenBlockViewController;
import org.nlamah.QL.ViewControllers.Form.NumberQuestionViewController;
import org.nlamah.QL.ViewControllers.Form.TextQuestionViewController;
import org.nlamah.QL.ViewControllers.Form.Abstract.DeclaringFormElementViewController;
import org.nlamah.QL.ViewControllers.Form.Abstract.FormElementViewController;
import org.nlamah.QL.Views.Form.ElseIfThenBlockView;

public class QLViewControllersFactory implements QLFormElementVisitor
{	
	FormElementViewController rootViewController;
	FormElementViewController currentlyCreatedViewController;
	
	public QLViewControllersFactory(FormElementViewController rootViewController)
	{
		super();	
		
		this.rootViewController = rootViewController;
	}
	
	public ArrayList<FormElementViewController> createChildViewControllers(DeclaringFormElement declaringFormElement)
	{
		ArrayList<FormElementViewController> childViewControllers = null;
		
		if (Helper.arrayExistsAndHasElements(declaringFormElement.childElements()))
		{
			childViewControllers = new ArrayList<FormElementViewController>();
			
			for (FormElement formElement : declaringFormElement.childElements())
			{
				formElement.accept(this);
				
				childViewControllers.add(currentlyCreatedViewController);
			}
		}
		
		return childViewControllers;
	}
	
	private void createAndAddChildViewControllers(DeclaringFormElementViewController viewController, DeclaringFormElement formElement)
	{
		viewController.setChildViewControllers(createChildViewControllers(formElement));
		
		currentlyCreatedViewController = viewController;
		
		currentlyCreatedViewController.setRootViewController(this.rootViewController);
	}
	
	private ConditionalBlockViewController createIfThenBlockViewController(ConditionalBlockViewController conditionalBlockViewController, IfThenBlock ifThenBlock)
	{
		IfThenBlockViewController ifThenBlockViewController = null;
		
		if (ifThenBlock != null)
		{
			ifThenBlockViewController = new IfThenBlockViewController(ifThenBlock);
			ifThenBlockViewController.setChildViewControllers(createChildViewControllers(ifThenBlock));
		}
		
		conditionalBlockViewController.setIfThenBlockViewController(ifThenBlockViewController);
		
		return conditionalBlockViewController;
	}
	
	private ConditionalBlockViewController createElseIfThenBlockViewControllers(ConditionalBlockViewController conditionalBlockViewController, ArrayList<ElseIfThenBlock> elseIfThenBlocks)
	{
		ArrayList<ElseIfThenBlockViewController> elseIfThenBlockViewControllers = null;
		
		if (Helper.arrayExistsAndHasElements(elseIfThenBlocks))
		{
			int numberOfElseIfThenViewControllers = elseIfThenBlocks.size();
			
			elseIfThenBlockViewControllers = new ArrayList<ElseIfThenBlockViewController>(numberOfElseIfThenViewControllers);
			
			for (int i = 0; i < numberOfElseIfThenViewControllers; i++)
			{
				ElseIfThenBlock elseIfThenBlock = elseIfThenBlocks.get(i);
				
				ElseIfThenBlockViewController viewController = new ElseIfThenBlockViewController(elseIfThenBlock);
				
				viewController.setChildViewControllers(createChildViewControllers(elseIfThenBlock));
				
				elseIfThenBlockViewControllers.add(viewController);
			}
		}
		
		conditionalBlockViewController.setElseIfThenBlockViewControllers(elseIfThenBlockViewControllers);
		
		return conditionalBlockViewController;
	}
	
	private ConditionalBlockViewController createElseThenBlockViewController(ConditionalBlockViewController conditionalBlockViewController, ElseThenBlock elseThenBlock)
	{		
		ElseThenBlockViewController elseThenBlockViewController = null;
		
		if (elseThenBlock != null)
		{
			elseThenBlockViewController = new ElseThenBlockViewController(elseThenBlock);
			
			elseThenBlockViewController.setChildViewControllers(createChildViewControllers(elseThenBlock));
		}
		
		conditionalBlockViewController.setElseThenBlockViewController(elseThenBlockViewController);
		
		return conditionalBlockViewController;
	}


	@Override
	public void visit(BooleanQuestion booleanQuestion) 
	{		
		currentlyCreatedViewController = new BooleanQuestionViewController(booleanQuestion);
		
		currentlyCreatedViewController.setRootViewController(this.rootViewController);
	}

	@Override
	public void visit(ComputedQuestion computedQuestion) 
	{
		currentlyCreatedViewController = new ComputedQuestionViewController(computedQuestion);
		
		currentlyCreatedViewController.setRootViewController(this.rootViewController);
	}

	@Override
	public void visit(ConditionalBlock conditionalBlock) 
	{
		ConditionalBlockViewController conditionalBlockViewController = ConditionalBlockViewControllerFactory.createConditionalBlockViewController(conditionalBlock);
		
		conditionalBlockViewController = createIfThenBlockViewController(conditionalBlockViewController, conditionalBlock.ifThenBlock());
		conditionalBlockViewController = createElseIfThenBlockViewControllers(conditionalBlockViewController, conditionalBlock.elseIfThenBlocks());
		conditionalBlockViewController = createElseThenBlockViewController(conditionalBlockViewController, conditionalBlock.elseThenBlock());
		
		currentlyCreatedViewController = conditionalBlockViewController;
		
		currentlyCreatedViewController.setRootViewController(this.rootViewController);
	}

	@Override
	public void visit(ElseIfThenBlock elseIfThenBlock) 
	{	
		DeclaringFormElementViewController declaringFormElementViewController = new ElseIfThenBlockViewController(elseIfThenBlock);
		
		createAndAddChildViewControllers(declaringFormElementViewController, elseIfThenBlock);
	}

	@Override
	public void visit(ElseThenBlock elseThenBlock) 
	{
		DeclaringFormElementViewController declaringFormElementViewController = new ElseThenBlockViewController(elseThenBlock);
		
		createAndAddChildViewControllers(declaringFormElementViewController, elseThenBlock);
	}

	@Override
	public void visit(Form form) 
	{
		assert false;
	}

	@Override
	public void visit(IfThenBlock ifThenBlock) 
	{
		DeclaringFormElementViewController declaringFormElementViewController = new IfThenBlockViewController(ifThenBlock);
		
		createAndAddChildViewControllers(declaringFormElementViewController, ifThenBlock);
	}

	@Override
	public void visit(NumberQuestion numberQuestion) 
	{
		currentlyCreatedViewController = new NumberQuestionViewController(numberQuestion);
		
		currentlyCreatedViewController.setRootViewController(this.rootViewController);
	}

	@Override
	public void visit(TextQuestion textQuestion) 
	{
		currentlyCreatedViewController = new TextQuestionViewController(textQuestion);
		
		currentlyCreatedViewController.setRootViewController(this.rootViewController);
	}
}
