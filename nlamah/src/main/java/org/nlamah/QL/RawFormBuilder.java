package org.nlamah.QL;

import java.util.ArrayList;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.nlamah.QL.QLBaseVisitor;
import org.nlamah.QL.QLParser;
import org.nlamah.QL.Model.Error.Abstract.ParsingError;
import org.nlamah.QL.Model.Error.Parsing.EnumRecognitionError;
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
import org.nlamah.QL.Model.Form.Abstract.Question;
import org.nlamah.QL.Model.Form.Abstract.LiteralType;

public class RawFormBuilder extends QLBaseVisitor<QLNode> 
{	
	private ParseTree tree;
	
	private ArrayList<ParsingError> errors;
	
	public RawFormBuilder(ParseTree tree)
	{
		super();
		
		this.tree = tree;
		
		errors = new ArrayList<ParsingError>();
	}
	
	public Form build()
	{
		return (Form) tree.accept(this);
	}
	
	public ArrayList<ParsingError> errors()
	{
		return this.errors;
	}

	private String removeSurroundingCharacters(String string) 
	{
		return string.substring(1, string.length() - 1);
	}

	private void addSourceCodePosition(QLNode node, ParserRuleContext ctx)
	{
		node.startsOnLine = ctx.getStart().getLine();
		node.startsAtCharacterPosition = ctx.getStart().getCharPositionInLine();
		node.nodeString = ctx.getStart().getText();
		node.endsOnLine = ctx.getStop().getLine();
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

		Form form = new Form(formName, formElements);

		addSourceCodePosition(form, ctx);

		return form; 
	}

	@Override 
	public QLNode visitComputedQuestion(QLParser.ComputedQuestionContext ctx) 
	{ 
		IdentifierLiteral identifier = new IdentifierLiteral(ctx.Identifier().getText());
		addSourceCodePosition(identifier, ctx);
		
		TextLiteral questionText = new TextLiteral(removeSurroundingCharacters(ctx.Text().getText()));
		addSourceCodePosition(questionText, ctx);

		String type = ctx.type.getText().toUpperCase();

		LiteralType returnType = null;

		try 
		{
			returnType = LiteralType.valueOf(type);
		} 
		catch(Exception ex) 
		{
			errors.add(new EnumRecognitionError(type, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine()));
		}

		Expression expression = (Expression)ctx.expression().accept(this);

		Question question = new ComputedQuestion(identifier, questionText, returnType, expression);

		addSourceCodePosition(question, ctx);

		return question;
	}

	@Override 
	public QLNode visitBooleanQuestion(QLParser.BooleanQuestionContext ctx) 
	{ 
		IdentifierLiteral identifier = new IdentifierLiteral(ctx.Identifier().getText());
		addSourceCodePosition(identifier, ctx);
		
		TextLiteral questionText = new TextLiteral(removeSurroundingCharacters(ctx.Text().getText()));
		addSourceCodePosition(questionText, ctx);

		Question question = new BooleanQuestion(identifier, questionText);

		addSourceCodePosition(question, ctx);

		return question;
	}

	@Override 
	public QLNode visitNumberQuestion(QLParser.NumberQuestionContext ctx) 
	{ 
		IdentifierLiteral identifier = new IdentifierLiteral(ctx.Identifier().getText());
		addSourceCodePosition(identifier, ctx);
		
		TextLiteral questionText = new TextLiteral(removeSurroundingCharacters(ctx.Text().getText()));
		addSourceCodePosition(questionText, ctx);

		Question question = new NumberQuestion(identifier, questionText);

		addSourceCodePosition(question, ctx);

		return question;
	}

	@Override 
	public QLNode visitTextQuestion(QLParser.TextQuestionContext ctx) 
	{ 
		IdentifierLiteral identifier = new IdentifierLiteral(ctx.Identifier().getText());
		addSourceCodePosition(identifier, ctx);
		
		TextLiteral questionText = new TextLiteral(removeSurroundingCharacters(ctx.Text().getText()));
		addSourceCodePosition(questionText, ctx);

		Question question = new TextQuestion(identifier, questionText);

		addSourceCodePosition(question, ctx);

		return question;
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

		ConditionalBlock conditionalBlock = new ConditionalBlock(ifThenBlock, elseIfThenBlocks, elseThenBlock);

		addSourceCodePosition(conditionalBlock, ctx);

		return conditionalBlock;
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

		IfThenBlock ifThenBlock =  new IfThenBlock(logicalExpression, formElements);

		addSourceCodePosition(ifThenBlock, ctx);

		return ifThenBlock;
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

		ElseIfThenBlock elseIfThenBlock = new ElseIfThenBlock(expression, formElements);

		addSourceCodePosition(elseIfThenBlock, ctx);

		return elseIfThenBlock;
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

		ElseThenBlock elseThenBlock = new ElseThenBlock(formElements);

		addSourceCodePosition(elseThenBlock, ctx);

		return elseThenBlock;
	}

	@Override 
	public QLNode visitOrExpression(QLParser.OrExpressionContext ctx) 
	{ 
		Expression leftHandExpression = (Expression) ctx.expression(0).accept(this);
		Expression rightHandExpression = (Expression) ctx.expression(1).accept(this);

		OrExpression expression = new OrExpression(leftHandExpression, rightHandExpression); 

		addSourceCodePosition(expression, ctx);

		return expression;
	}

	@Override 
	public QLNode visitMultiplyExpression(QLParser.MultiplyExpressionContext ctx)
	{ 
		Expression leftHandExpression = (Expression) ctx.expression(0).accept(this);
		Expression rightHandExpression = (Expression) ctx.expression(1).accept(this);

		if (ctx.MultiplyOperator().getText().equals("*"))
		{
			MultiplyExpression expression = new MultiplyExpression(leftHandExpression, rightHandExpression); 

			addSourceCodePosition(expression, ctx);

			return expression;
		}

		if (ctx.MultiplyOperator().getText().equals("/"))
		{
			DivideExpression expression = new DivideExpression(leftHandExpression, rightHandExpression); 

			addSourceCodePosition(expression, ctx);

			return expression;
		}

		return null;
	}

	@Override 
	public QLNode visitAndExpression(QLParser.AndExpressionContext ctx) 
	{ 
		Expression leftHandExpression = (Expression) ctx.expression(0).accept(this);
		Expression rightHandExpression = (Expression) ctx.expression(1).accept(this);

		AndExpression expression = new AndExpression(leftHandExpression, rightHandExpression); 

		addSourceCodePosition(expression, ctx);

		return expression;
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
			SmallerThanExpression expression = new SmallerThanExpression(leftHandExpression, rightHandExpression); 

			addSourceCodePosition(expression, ctx);

			return expression;
		}

		if (ctx.ComparisonOperator().getText().equals("<="))
		{
			SmallerThanEqualExpression expression = new SmallerThanEqualExpression(leftHandExpression, rightHandExpression); 

			addSourceCodePosition(expression, ctx);

			return expression;
		}

		if (ctx.ComparisonOperator().getText().equals(">"))
		{
			GreaterThanExpression expression = new GreaterThanExpression(leftHandExpression, rightHandExpression); 

			addSourceCodePosition(expression, ctx);

			return expression;
		}

		if (ctx.ComparisonOperator().getText().equals(">="))
		{
			GreaterThanEqualExpression expression = new GreaterThanEqualExpression(leftHandExpression, rightHandExpression); 

			addSourceCodePosition(expression, ctx);

			return expression;
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
			AddExpression expression = new AddExpression(leftHandExpression, rightHandExpression); 

			addSourceCodePosition(expression, ctx);

			return expression;
		}

		if (ctx.op.getText().equals("-"))
		{
			SubtractExpression expression = new SubtractExpression(leftHandExpression, rightHandExpression); 

			addSourceCodePosition(expression, ctx);

			return expression;
		}

		return null;
	}

	@Override 
	public QLNode visitTextLiteral(QLParser.TextLiteralContext ctx) 
	{ 
		TextLiteral literal = new TextLiteral(removeSurroundingCharacters(ctx.Text().getText()));

		addSourceCodePosition(literal, ctx);

		return literal;
	}

	@Override 
	public QLNode visitIdentifierLiteral(QLParser.IdentifierLiteralContext ctx)
	{ 		
		IdentifierLiteral identifier = new IdentifierLiteral(ctx.Identifier().getText());

		addSourceCodePosition(identifier, ctx);

		return identifier;
	}

	@Override 
	public QLNode visitEqualityExpression(QLParser.EqualityExpressionContext ctx) 
	{ 
		Expression leftHandExpression = (Expression) ctx.expression(0).accept(this);
		Expression rightHandExpression = (Expression) ctx.expression(1).accept(this);

		if (ctx.EqualityOperator().getText().equals("=="))
		{
			EqualExpression expression = new EqualExpression(leftHandExpression, rightHandExpression); 

			addSourceCodePosition(expression, ctx);

			return expression;
		}

		if (ctx.EqualityOperator().getText().equals("!="))
		{
			UnEqualExpression expression = new UnEqualExpression(leftHandExpression, rightHandExpression); 

			addSourceCodePosition(expression, ctx);

			return expression;
		}

		return null;
	}

	@Override 
	public QLNode visitNumberLiteral(QLParser.NumberLiteralContext ctx) 
	{ 
		NumberLiteral literal = new NumberLiteral(ctx.Number().getText());

		addSourceCodePosition(literal, ctx);

		return literal;
	}

	@Override 
	public QLNode visitUnaryExpression(QLParser.UnaryExpressionContext ctx) 
	{ 
		Expression expression = (Expression) ctx.expression().accept(this);

		if (ctx.operator.getText().equals("!"))
		{
			NotExpression notExpression = new NotExpression(expression);

			addSourceCodePosition(notExpression, ctx);

			return notExpression;
		}

		if (ctx.operator.getText().equals("-"))
		{
			MinusExpression minusExpression = new MinusExpression(expression);

			addSourceCodePosition(minusExpression, ctx);

			return minusExpression;
		}

		if (ctx.operator.getText().equals("+"))
		{
			PlusExpression plusExpression = new PlusExpression(expression);

			addSourceCodePosition(plusExpression, ctx);

			return plusExpression;
		}

		return null;
	}

	@Override 
	public QLNode visitBooleanLiteral(QLParser.BooleanLiteralContext ctx) 
	{ 
		BooleanLiteral literal = new BooleanLiteral(ctx.Boolean().getText());

		addSourceCodePosition(literal, ctx);

		return literal;
	}

}
