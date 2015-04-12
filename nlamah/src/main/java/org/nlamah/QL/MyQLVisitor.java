package org.nlamah.QL;

import java.util.ArrayList;

import org.nlamah.QL.FormModel.ASTNode;
import org.nlamah.QL.FormModel.ConditionalBlock;
import org.nlamah.QL.FormModel.ElseIfThenBlock;
import org.nlamah.QL.FormModel.ElseThenBlock;
import org.nlamah.QL.FormModel.IfThenBlock;
import org.nlamah.QL.FormModel.InputQuestion;
import org.nlamah.QL.FormModel.Form;
import org.nlamah.QL.FormModel.FormElement;
import org.nlamah.QL.FormModel.LogicalExpressionStub;
import org.nlamah.QL.FormModel.Question;

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
	    
	    return form;
	}
	
	@Override 
	public ASTNode visitQuestion(QLParser.QuestionContext ctx) 
	{ 
		 String identifier = ctx.ID().getText();
		 String type = ctx.TYPE().getText();
		 String questionString = ctx.questionString().getText();
		 
		 Question question = new InputQuestion(identifier, questionString, type);
		 
		 return question;
	}
	
	@Override
	public ASTNode visitConditionalBlock(QLParser.ConditionalBlockContext ctx)
	{
		IfThenBlock ifThenBlock = (IfThenBlock)ctx.ifThenBlock().accept(this);
		
		ArrayList<ElseIfThenBlock> elseIfThenBlocks = new ArrayList<ElseIfThenBlock>();
		
		for (QLParser.ElseIfThenBlockContext elseIfThenBlockContext : ctx.elseIfThenBlock())
		{
			ElseIfThenBlock elseIfThenBlock = (ElseIfThenBlock)elseIfThenBlockContext.accept(this);
			
			elseIfThenBlocks.add(elseIfThenBlock);
		}
		
		ElseThenBlock elseThenBlock = null;
		
		if (ctx.elseThenBlock() != null)
		{
			elseThenBlock = (ElseThenBlock)ctx.elseThenBlock().accept(this);
		}
		
		return new ConditionalBlock(ifThenBlock, elseIfThenBlocks, elseThenBlock);
	}
	
	@Override
	public ASTNode visitIfThenBlock(QLParser.IfThenBlockContext ctx)
	{
		LogicalExpressionStub logicalExpression = (LogicalExpressionStub) ctx.expression().accept(this);
		
		ArrayList<FormElement> formElements = new ArrayList<FormElement>();
		
		for (QLParser.FormElementContext contextualFormElement : ctx.formElement()) 
	    {
	        FormElement formElement = (FormElement) contextualFormElement.accept(this);
	        formElements.add(formElement);
	    }
		
		return new IfThenBlock(logicalExpression, formElements);
	}
	
	@Override
	public ASTNode visitElseIfThenBlock(QLParser.ElseIfThenBlockContext ctx)
	{
		
		LogicalExpressionStub logicalExpression = (LogicalExpressionStub) ctx.expression().accept(this);
		
		ArrayList<FormElement> formElements = new ArrayList<FormElement>();
		
		for (QLParser.FormElementContext contextualFormElement : ctx.formElement()) 
	    {
	        FormElement formElement = (FormElement) contextualFormElement.accept(this);
	        formElements.add(formElement);
	    }
		
		return new ElseIfThenBlock(logicalExpression, formElements);
	}
	
	@Override 
	public ASTNode visitElseThenBlock(QLParser.ElseThenBlockContext ctx)
	{
		ArrayList<FormElement> formElements = new ArrayList<FormElement>();
		
		for (QLParser.FormElementContext contextualFormElement : ctx.formElement()) 
	    {
	        FormElement formElement = (FormElement) contextualFormElement.accept(this);
	        formElements.add(formElement);
	    }
		
		return new ElseThenBlock(formElements);
	}
	
	@Override
	public ASTNode visitIdExpression(QLParser.IdExpressionContext ctx)
	{
		return new LogicalExpressionStub();
	}
}
