package org.nlamah.QL;

import java.util.ArrayList;

import org.nlamah.QL.Binary.AddExpression;
import org.nlamah.QL.Binary.AndExpression;
import org.nlamah.QL.Binary.DivideExpression;
import org.nlamah.QL.Binary.EqualExpression;
import org.nlamah.QL.Binary.GreaterThanEqualExpression;
import org.nlamah.QL.Binary.GreaterThanExpression;
import org.nlamah.QL.Binary.MultiplyExpression;
import org.nlamah.QL.Binary.OrExpression;
import org.nlamah.QL.Binary.SmallerThanEqualExpression;
import org.nlamah.QL.Binary.SmallerThanExpression;
import org.nlamah.QL.Binary.UnEqualExpression;
import org.nlamah.QL.Expression.Expression;
import org.nlamah.QL.FormModel.ASTNode;
import org.nlamah.QL.FormModel.ConditionalBlock;
import org.nlamah.QL.FormModel.ElseIfThenBlock;
import org.nlamah.QL.FormModel.ElseThenBlock;
import org.nlamah.QL.FormModel.IfThenBlock;
import org.nlamah.QL.FormModel.InputQuestion;
import org.nlamah.QL.FormModel.Form;
import org.nlamah.QL.FormModel.FormElement;
import org.nlamah.QL.FormModel.Question;
import org.nlamah.QL.Literal.BooleanLiteral;
import org.nlamah.QL.Literal.IdentifierLiteral;
import org.nlamah.QL.Literal.NumberLiteral;
import org.nlamah.QL.Literal.TextLiteral;
import org.nlamah.QL.Unary.MinusExpression;
import org.nlamah.QL.Unary.NotExpression;
import org.nlamah.QL.Unary.PlusExpression;

public class MyQLVisitor extends QLBaseVisitor<ASTNode> 
{
	@Override
	public ASTNode visitForm(QLParser.FormContext ctx)
	{
		String formName = ctx.Identifier().getText();
		
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
		 String identifier = ctx.Identifier().getText();
		 String type = ctx.Type().getText();
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
		Expression logicalExpression = (Expression) ctx.expression().accept(this);
		
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
		Expression expression = (Expression) ctx.expression().accept(this);
		
		ArrayList<FormElement> formElements = new ArrayList<FormElement>();
		
		for (QLParser.FormElementContext contextualFormElement : ctx.formElement()) 
	    {
	        FormElement formElement = (FormElement) contextualFormElement.accept(this);
	        formElements.add(formElement);
	    }
		
		return new ElseIfThenBlock(expression, formElements);
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
	
//	@Override
//	public ASTNode visitIdentifierLiteral(QLParser.IdentifierLiteralContext ctx)
//	{
//		return new LogicalExpressionStub();
//	}
	
	@Override 
	public ASTNode visitOrExpression(QLParser.OrExpressionContext ctx) 
	{ 
		Expression leftHandExpression = (Expression) ctx.expression(0).accept(this);
        Expression rightHandExpression = (Expression) ctx.expression(1).accept(this);
		
		return new OrExpression(leftHandExpression, rightHandExpression); 
	}
	
	@Override 
	public ASTNode visitMultiplyExpression(QLParser.MultiplyExpressionContext ctx)
	{ 
		Expression leftHandExpression = (Expression) ctx.expression(0).accept(this);
        Expression rightHandExpression = (Expression) ctx.expression(1).accept(this);
        
        if (ctx.MultiplyOperator().getText().equals("*"))
        {
        	return new MultiplyExpression(leftHandExpression, rightHandExpression);
        }
        
        if (ctx.MultiplyOperator().getText().equals("/"))
        {
        	return new DivideExpression(leftHandExpression, rightHandExpression);
        }
        
        return null;
	}

	@Override 
	public ASTNode visitAndExpression(QLParser.AndExpressionContext ctx) 
	{ 
		Expression leftHandExpression = (Expression) ctx.expression(0).accept(this);
        Expression rightHandExpression = (Expression) ctx.expression(1).accept(this);
        
        return new AndExpression(leftHandExpression, rightHandExpression);
	}
	
	@Override 
	public ASTNode visitIdentifierLiteral(QLParser.IdentifierLiteralContext ctx) 
	{ 
		return new IdentifierLiteral(ctx.Identifier().getText());
	}

	
	@Override 
	public ASTNode visitComparisonExpression(QLParser.ComparisonExpressionContext ctx) 
	{ 
		Expression leftHandExpression = (Expression) ctx.expression(0).accept(this);
        Expression rightHandExpression = (Expression) ctx.expression(1).accept(this);
        
        if (ctx.ComparisonOperator().getText().equals("<"))
        {
        	return new SmallerThanExpression(leftHandExpression, rightHandExpression);
        }
        
        if (ctx.ComparisonOperator().getText().equals("<="))
        {
        	return new SmallerThanEqualExpression(leftHandExpression, rightHandExpression);
        }
        
        if (ctx.ComparisonOperator().getText().equals(">"))
        {
        	return new GreaterThanExpression(leftHandExpression, rightHandExpression);
        }
        
        if (ctx.ComparisonOperator().getText().equals(">="))
        {
        	return new GreaterThanEqualExpression(leftHandExpression, rightHandExpression);
        }
        
        return null;
	}
	
	@Override 
	public ASTNode visitAdditionExpression(QLParser.AdditionExpressionContext ctx) 
	{ 
		Expression leftHandExpression = (Expression) ctx.expression(0).accept(this);
        Expression rightHandExpression = (Expression) ctx.expression(1).accept(this);
        
        return new AddExpression(leftHandExpression, rightHandExpression);
	}
	
	@Override 
	public ASTNode visitTextLiteral(QLParser.TextLiteralContext ctx) 
	{ 
		return new TextLiteral(ctx.Text().getText());
	}
	
	@Override 
	public ASTNode visitEqualityExpression(QLParser.EqualityExpressionContext ctx) 
	{ 
		Expression leftHandExpression = (Expression) ctx.expression(0).accept(this);
        Expression rightHandExpression = (Expression) ctx.expression(1).accept(this);
        
        if (ctx.EqualityOperator().getText().equals("=="))
        {
        	return new EqualExpression(leftHandExpression, rightHandExpression);
        }
        
        if (ctx.EqualityOperator().getText().equals("=="))
        {
        	return new UnEqualExpression(leftHandExpression, rightHandExpression);
        }
        
        return null;
	}
	
	@Override 
	public ASTNode visitNumberLiteral(QLParser.NumberLiteralContext ctx) 
	{ 
		return new NumberLiteral(ctx.Number().getText());
	}
	
	@Override 
	public ASTNode visitUnaryExpression(QLParser.UnaryExpressionContext ctx) 
	{ 
		Expression expression = (Expression) ctx.expression().accept(this);
		
		if (ctx.UnaryOperator().getText().equals("!"))
		{
			return new NotExpression(expression);
		}
		
		if (ctx.UnaryOperator().getText().equals("-"))
		{
			return new MinusExpression(expression);
		}
		
		if (ctx.UnaryOperator().getText().equals("+"))
		{
			return new PlusExpression(expression);
		}
		
		return null;
		
	}
	
	@Override 
	public ASTNode visitBooleanLiteral(QLParser.BooleanLiteralContext ctx) 
	{ 
		return new BooleanLiteral(ctx.Boolean().getText());
	}

}
