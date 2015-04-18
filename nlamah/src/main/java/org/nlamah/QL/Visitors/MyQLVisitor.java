package org.nlamah.QL.Visitors;

import java.util.ArrayList;

import org.nlamah.QL.QLBaseVisitor;
import org.nlamah.QL.QLParser;
import org.nlamah.QL.Helper.Helper;
import org.nlamah.QL.Model.Expression.Abstract.Expression;
import org.nlamah.QL.Model.Expression.Binary.AddExpression;
import org.nlamah.QL.Model.Expression.Binary.AndExpression;
import org.nlamah.QL.Model.Expression.Binary.DivideExpression;
import org.nlamah.QL.Model.Expression.Binary.EqualExpression;
import org.nlamah.QL.Model.Expression.Binary.GreaterThanEqualExpression;
import org.nlamah.QL.Model.Expression.Binary.GreaterThanExpression;
import org.nlamah.QL.Model.Expression.Binary.MultiplyExpression;
import org.nlamah.QL.Model.Expression.Binary.OrExpression;
import org.nlamah.QL.Model.Expression.Binary.SmallerThanEqualExpression;
import org.nlamah.QL.Model.Expression.Binary.SmallerThanExpression;
import org.nlamah.QL.Model.Expression.Binary.SubtractExpression;
import org.nlamah.QL.Model.Expression.Binary.UnEqualExpression;
import org.nlamah.QL.Model.Expression.Literal.BooleanLiteral;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Expression.Literal.NumberLiteral;
import org.nlamah.QL.Model.Expression.Literal.TextLiteral;
import org.nlamah.QL.Model.Expression.Unary.MinusExpression;
import org.nlamah.QL.Model.Expression.Unary.NotExpression;
import org.nlamah.QL.Model.Expression.Unary.PlusExpression;
import org.nlamah.QL.Model.Form.BooleanQuestion;
import org.nlamah.QL.Model.Form.ComputedQuestion;
import org.nlamah.QL.Model.Form.ConditionalBlock;
import org.nlamah.QL.Model.Form.ElseIfThenBlock;
import org.nlamah.QL.Model.Form.ElseThenBlock;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.Model.Form.IfThenBlock;
import org.nlamah.QL.Model.Form.NumberQuestion;
import org.nlamah.QL.Model.Form.TextQuestion;
import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.Model.Form.Abstract.QLNode;
import org.nlamah.QL.Model.Form.Abstract.QuestionReturnType;

public class MyQLVisitor extends QLBaseVisitor<QLNode> 
{
	private ArrayList<IdentifierLiteral> referencedIdentifiers;
	
	public ArrayList<IdentifierLiteral> referencedIdentifiers()
	{
		return this.referencedIdentifiers;
	}	
	
	private void addReferencedIdentifier(IdentifierLiteral identifier)
	{
		if (!Helper.arrayExistsAndHasElements(referencedIdentifiers))
		{
			referencedIdentifiers = new ArrayList<IdentifierLiteral>();
		}
		
		referencedIdentifiers.add(identifier);
	}
	
	private String removeSurroundingCharacters(String string) 
	{
	    return string.substring(1, string.length() - 1);
	}
	
	@Override
	public QLNode visitForm(QLParser.FormContext ctx)
	{
		String formName = ctx.Identifier().getText();
		
	    ArrayList<FormElement> formElements = new ArrayList<>();
	
	    for (QLParser.FormElementContext contextualFormElement : ctx.formElement()) 
	    {
	        FormElement formElement = (FormElement) contextualFormElement.accept(this);
	        formElements.add(formElement);
	    }
	
	    return new Form(formName, formElements);
	}
	
	@Override 
	public QLNode visitComputedQuestion(QLParser.ComputedQuestionContext ctx) 
	{ 
		IdentifierLiteral identifier = new IdentifierLiteral(ctx.Identifier().getText());
		TextLiteral questionText = new TextLiteral(removeSurroundingCharacters(ctx.questionString().getText()));
		
		String type = ctx.type.getText().toUpperCase();
		
		QuestionReturnType returnType = QuestionReturnType.NUMBER;
		
		try 
		{
			returnType = QuestionReturnType.valueOf(type);
        } 
		catch(IllegalArgumentException ex) 
		{
			//TODO
        }
		
		Expression expression = (Expression)ctx.expression().accept(this);
		
		return new ComputedQuestion(identifier, questionText, returnType, expression);
	}

	@Override 
	public QLNode visitBooleanQuestion(QLParser.BooleanQuestionContext ctx) 
	{ 
		IdentifierLiteral identifier = new IdentifierLiteral(ctx.Identifier().getText());		
		TextLiteral questionText = new TextLiteral(removeSurroundingCharacters(ctx.questionString().getText()));
		
		return new BooleanQuestion(identifier, questionText);
	}

	@Override 
	public QLNode visitNumberQuestion(QLParser.NumberQuestionContext ctx) 
	{ 
		IdentifierLiteral identifier = new IdentifierLiteral(ctx.Identifier().getText());
		TextLiteral questionText = new TextLiteral(removeSurroundingCharacters(ctx.questionString().getText()));
		
		return new NumberQuestion(identifier, questionText);
	}

	@Override 
	public QLNode visitTextQuestion(QLParser.TextQuestionContext ctx) 
	{ 
		IdentifierLiteral identifier = new IdentifierLiteral(ctx.Identifier().getText());
		TextLiteral questionText = new TextLiteral(removeSurroundingCharacters(ctx.questionString().getText()));
		
		return new TextQuestion(identifier, questionText);
	}
	
	@Override
	public QLNode visitConditionalBlock(QLParser.ConditionalBlockContext ctx)
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
	public QLNode visitIfThenBlock(QLParser.IfThenBlockContext ctx)
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
	public QLNode visitElseIfThenBlock(QLParser.ElseIfThenBlockContext ctx)
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
	public QLNode visitElseThenBlock(QLParser.ElseThenBlockContext ctx)
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
	public QLNode visitOrExpression(QLParser.OrExpressionContext ctx) 
	{ 
		Expression leftHandExpression = (Expression) ctx.expression(0).accept(this);
        Expression rightHandExpression = (Expression) ctx.expression(1).accept(this);
		
		return new OrExpression(leftHandExpression, rightHandExpression); 
	}
	
	@Override 
	public QLNode visitMultiplyExpression(QLParser.MultiplyExpressionContext ctx)
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
	public QLNode visitAndExpression(QLParser.AndExpressionContext ctx) 
	{ 
		Expression leftHandExpression = (Expression) ctx.expression(0).accept(this);
        Expression rightHandExpression = (Expression) ctx.expression(1).accept(this);
        
        return new AndExpression(leftHandExpression, rightHandExpression);
	}
	
	@Override 
	public QLNode visitParenthesesExpression(QLParser.ParenthesesExpressionContext ctx)
	{
		return (Expression)ctx.expression().accept(this);
	}
	
	@Override 
	public QLNode visitComparisonExpression(QLParser.ComparisonExpressionContext ctx) 
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
	public QLNode visitAdditionExpression(QLParser.AdditionExpressionContext ctx) 
	{ 
		Expression leftHandExpression = (Expression) ctx.expression(0).accept(this);
        Expression rightHandExpression = (Expression) ctx.expression(1).accept(this);
        
        if (ctx.op.getText().equals("+"))
        {
        	return new AddExpression(leftHandExpression, rightHandExpression);
        }
        
        if (ctx.op.getText().equals("-"))
        {
        	return new SubtractExpression(leftHandExpression, rightHandExpression);
        }
        
        return null;
	}
	
	@Override 
	public QLNode visitTextLiteral(QLParser.TextLiteralContext ctx) 
	{ 
		return new TextLiteral(removeSurroundingCharacters(ctx.Text().getText()));
	}
	
	@Override 
	public QLNode visitIdentifierLiteral(QLParser.IdentifierLiteralContext ctx)
	{ 		
		IdentifierLiteral identifier = new IdentifierLiteral(ctx.Identifier().getText());
		addReferencedIdentifier(identifier);
		
		return identifier;
	}
	
	@Override 
	public QLNode visitEqualityExpression(QLParser.EqualityExpressionContext ctx) 
	{ 
		Expression leftHandExpression = (Expression) ctx.expression(0).accept(this);
        Expression rightHandExpression = (Expression) ctx.expression(1).accept(this);
        
        if (ctx.EqualityOperator().getText().equals("=="))
        {
        	return new EqualExpression(leftHandExpression, rightHandExpression);
        }
        
        if (ctx.EqualityOperator().getText().equals("!="))
        {
        	return new UnEqualExpression(leftHandExpression, rightHandExpression);
        }
        
        return null;
	}
	
	@Override 
	public QLNode visitNumberLiteral(QLParser.NumberLiteralContext ctx) 
	{ 
		return new NumberLiteral(ctx.Number().getText());
	}
	
	@Override 
	public QLNode visitUnaryExpression(QLParser.UnaryExpressionContext ctx) 
	{ 
		Expression expression = (Expression) ctx.expression().accept(this);
		
		if (ctx.operator.getText().equals("!"))
		{
			return new NotExpression(expression);
		}
		
		if (ctx.operator.getText().equals("-"))
		{
			return new MinusExpression(expression);
		}
		
		if (ctx.operator.getText().equals("+"))
		{
			return new PlusExpression(expression);
		}
		
		return null;
		
	}
	
	@Override 
	public QLNode visitBooleanLiteral(QLParser.BooleanLiteralContext ctx) 
	{ 
		return new BooleanLiteral(ctx.Boolean().getText());
	}

}
