package org.nlamah.QL.Builders;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;
import org.nlamah.QBase.QBaseHelper;
import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QBase.Error.EnumRecognitionError;
import org.nlamah.QBase.Error.QBaseParsingError;
import org.nlamah.QL.QLBaseVisitor;
import org.nlamah.QL.QLParser;
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
import org.nlamah.QL.Model.Form.ComputedQuestion;
import org.nlamah.QL.Model.Form.ConditionalBlock;
import org.nlamah.QL.Model.Form.ElseIfThenBlock;
import org.nlamah.QL.Model.Form.ElseThenBlock;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.Model.Form.IfThenBlock;
import org.nlamah.QL.Model.Form.InputQuestion;
import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.Model.Form.Abstract.QLNode;
import org.nlamah.QL.Model.Form.Abstract.FormQuestion;

public class RawFormBuilder extends QLBaseVisitor<QLNode> 
{	
	private List<QBaseParsingError> errors;
	
	public RawFormBuilder()
	{
		super();
		
		errors = new ArrayList<QBaseParsingError>();
	}
	
	public Form buildForm(ParseTree tree)
	{
		return (Form) tree.accept(this);
	}
	
	public List<QBaseParsingError> errors()
	{
		return this.errors;
	}

	@Override
	public QLNode visitForm(QLParser.FormContext ctx)
	{
		String formName = ctx.Identifier().getText();

		List<FormElement> formElements = new ArrayList<>();

		for (QLParser.FormElementContext contextualFormElement : ctx.formElement()) 
		{
			FormElement formElement = (FormElement) contextualFormElement.accept(this);
			formElements.add(formElement);
		}

		Form form = new Form(formName, formElements);

		QBaseHelper.addSourceCodePosition(form, ctx);

		return form; 
	}

	@Override 
	public QLNode visitComputedQuestion(QLParser.ComputedQuestionContext ctx) 
	{ 
		IdentifierLiteral identifier = new IdentifierLiteral(ctx.Identifier().getText());
		QBaseHelper.addSourceCodePosition(identifier, ctx);
		
		TextLiteral questionText = new TextLiteral(QBaseHelper.removeSurroundingQuotes(ctx.Text().getText()));
		QBaseHelper.addSourceCodePosition(questionText, ctx);

		String type = ctx.type.getText().toUpperCase();

		QBaseQuestionType returnType = null;

		try 
		{
			returnType = QBaseQuestionType.valueOf(type);
		} 
		catch(Exception ex) 
		{
			errors.add(new EnumRecognitionError(type, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine()));
		}

		Expression expression = (Expression)ctx.expression().accept(this);

		FormQuestion question = new ComputedQuestion(identifier, questionText, returnType, expression);

		QBaseHelper.addSourceCodePosition(question, ctx);

		return question;
	}

	@Override 
	public QLNode visitBooleanQuestion(QLParser.BooleanQuestionContext ctx) 
	{ 
		IdentifierLiteral identifier = new IdentifierLiteral(ctx.Identifier().getText());
		QBaseHelper.addSourceCodePosition(identifier, ctx);
		
		TextLiteral questionText = new TextLiteral(QBaseHelper.removeSurroundingQuotes(ctx.Text().getText()));
		QBaseHelper.addSourceCodePosition(questionText, ctx);

		FormQuestion question = new InputQuestion(identifier, questionText, QBaseQuestionType.BOOLEAN);

		QBaseHelper.addSourceCodePosition(question, ctx);

		return question;
	}

	@Override 
	public QLNode visitNumberQuestion(QLParser.NumberQuestionContext ctx) 
	{ 
		IdentifierLiteral identifier = new IdentifierLiteral(ctx.Identifier().getText());
		QBaseHelper.addSourceCodePosition(identifier, ctx);
		
		TextLiteral questionText = new TextLiteral(QBaseHelper.removeSurroundingQuotes(ctx.Text().getText()));
		QBaseHelper.addSourceCodePosition(questionText, ctx);

		FormQuestion question = new InputQuestion(identifier, questionText, QBaseQuestionType.NUMBER);

		QBaseHelper.addSourceCodePosition(question, ctx);

		return question;
	}

	@Override 
	public QLNode visitTextQuestion(QLParser.TextQuestionContext ctx) 
	{ 
		IdentifierLiteral identifier = new IdentifierLiteral(ctx.Identifier().getText());
		QBaseHelper.addSourceCodePosition(identifier, ctx);
		
		TextLiteral questionText = new TextLiteral(QBaseHelper.removeSurroundingQuotes(ctx.Text().getText()));
		QBaseHelper.addSourceCodePosition(questionText, ctx);

		FormQuestion question = new InputQuestion(identifier, questionText, QBaseQuestionType.TEXT);

		QBaseHelper.addSourceCodePosition(question, ctx);

		return question;
	}

	@Override
	public QLNode visitConditionalBlock(QLParser.ConditionalBlockContext ctx)
	{
		IfThenBlock ifThenBlock = (IfThenBlock)ctx.ifThenBlock().accept(this);

		List<ElseIfThenBlock> elseIfThenBlocks = new ArrayList<ElseIfThenBlock>();

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

		QBaseHelper.addSourceCodePosition(conditionalBlock, ctx);

		return conditionalBlock;
	}

	@Override
	public QLNode visitIfThenBlock(QLParser.IfThenBlockContext ctx)
	{
		Expression logicalExpression = (Expression) ctx.expression().accept(this);

		List<FormElement> formElements = new ArrayList<FormElement>();

		for (QLParser.FormElementContext contextualFormElement : ctx.formElement()) 
		{
			FormElement formElement = (FormElement) contextualFormElement.accept(this);
			formElements.add(formElement);
		}

		IfThenBlock ifThenBlock =  new IfThenBlock(logicalExpression, formElements);

		QBaseHelper.addSourceCodePosition(ifThenBlock, ctx);

		return ifThenBlock;
	}

	@Override
	public QLNode visitElseIfThenBlock(QLParser.ElseIfThenBlockContext ctx)
	{
		Expression expression = (Expression) ctx.expression().accept(this);

		List<FormElement> formElements = new ArrayList<FormElement>();

		for (QLParser.FormElementContext contextualFormElement : ctx.formElement()) 
		{
			FormElement formElement = (FormElement) contextualFormElement.accept(this);
			formElements.add(formElement);
		}

		ElseIfThenBlock elseIfThenBlock = new ElseIfThenBlock(expression, formElements);

		QBaseHelper.addSourceCodePosition(elseIfThenBlock, ctx);

		return elseIfThenBlock;
	}

	@Override 
	public QLNode visitElseThenBlock(QLParser.ElseThenBlockContext ctx)
	{
		List<FormElement> formElements = new ArrayList<FormElement>();

		for (QLParser.FormElementContext contextualFormElement : ctx.formElement()) 
		{
			FormElement formElement = (FormElement) contextualFormElement.accept(this);
			formElements.add(formElement);
		}

		ElseThenBlock elseThenBlock = new ElseThenBlock(formElements);

		QBaseHelper.addSourceCodePosition(elseThenBlock, ctx);

		return elseThenBlock;
	}

	@Override 
	public QLNode visitOrExpression(QLParser.OrExpressionContext ctx) 
	{ 
		Expression leftHandExpression = (Expression) ctx.expression(0).accept(this);
		Expression rightHandExpression = (Expression) ctx.expression(1).accept(this);

		OrExpression expression = new OrExpression(leftHandExpression, rightHandExpression); 

		QBaseHelper.addSourceCodePosition(expression, ctx);

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

			QBaseHelper.addSourceCodePosition(expression, ctx);

			return expression;
		}

		if (ctx.MultiplyOperator().getText().equals("/"))
		{
			DivideExpression expression = new DivideExpression(leftHandExpression, rightHandExpression); 

			QBaseHelper.addSourceCodePosition(expression, ctx);

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

		QBaseHelper.addSourceCodePosition(expression, ctx);

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

			QBaseHelper.addSourceCodePosition(expression, ctx);

			return expression;
		}

		if (ctx.ComparisonOperator().getText().equals("<="))
		{
			SmallerThanEqualExpression expression = new SmallerThanEqualExpression(leftHandExpression, rightHandExpression); 

			QBaseHelper.addSourceCodePosition(expression, ctx);

			return expression;
		}

		if (ctx.ComparisonOperator().getText().equals(">"))
		{
			GreaterThanExpression expression = new GreaterThanExpression(leftHandExpression, rightHandExpression); 

			QBaseHelper.addSourceCodePosition(expression, ctx);

			return expression;
		}

		if (ctx.ComparisonOperator().getText().equals(">="))
		{
			GreaterThanEqualExpression expression = new GreaterThanEqualExpression(leftHandExpression, rightHandExpression); 

			QBaseHelper.addSourceCodePosition(expression, ctx);

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

			QBaseHelper.addSourceCodePosition(expression, ctx);

			return expression;
		}

		if (ctx.op.getText().equals("-"))
		{
			SubtractExpression expression = new SubtractExpression(leftHandExpression, rightHandExpression); 

			QBaseHelper.addSourceCodePosition(expression, ctx);

			return expression;
		}

		return null;
	}

	@Override 
	public QLNode visitTextLiteral(QLParser.TextLiteralContext ctx) 
	{ 
		TextLiteral literal = new TextLiteral(QBaseHelper.removeSurroundingQuotes(ctx.Text().getText()));

		QBaseHelper.addSourceCodePosition(literal, ctx);

		return literal;
	}

	@Override 
	public QLNode visitIdentifierLiteral(QLParser.IdentifierLiteralContext ctx)
	{ 		
		IdentifierLiteral identifier = new IdentifierLiteral(ctx.Identifier().getText());

		QBaseHelper.addSourceCodePosition(identifier, ctx);

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

			QBaseHelper.addSourceCodePosition(expression, ctx);

			return expression;
		}

		if (ctx.EqualityOperator().getText().equals("!="))
		{
			UnEqualExpression expression = new UnEqualExpression(leftHandExpression, rightHandExpression); 

			QBaseHelper.addSourceCodePosition(expression, ctx);

			return expression;
		}

		return null;
	}

	@Override 
	public QLNode visitNumberLiteral(QLParser.NumberLiteralContext ctx) 
	{ 
		NumberLiteral literal = new NumberLiteral(ctx.Number().getText());

		QBaseHelper.addSourceCodePosition(literal, ctx);

		return literal;
	}

	@Override 
	public QLNode visitUnaryExpression(QLParser.UnaryExpressionContext ctx) 
	{ 
		Expression expression = (Expression) ctx.expression().accept(this);

		if (ctx.operator.getText().equals("!"))
		{
			NotExpression notExpression = new NotExpression(expression);

			QBaseHelper.addSourceCodePosition(notExpression, ctx);

			return notExpression;
		}

		if (ctx.operator.getText().equals("-"))
		{
			MinusExpression minusExpression = new MinusExpression(expression);

			QBaseHelper.addSourceCodePosition(minusExpression, ctx);

			return minusExpression;
		}

		if (ctx.operator.getText().equals("+"))
		{
			PlusExpression plusExpression = new PlusExpression(expression);

			QBaseHelper.addSourceCodePosition(plusExpression, ctx);

			return plusExpression;
		}

		return null;
	}

	@Override 
	public QLNode visitBooleanLiteral(QLParser.BooleanLiteralContext ctx) 
	{ 
		BooleanLiteral literal = new BooleanLiteral(ctx.Boolean().getText());

		QBaseHelper.addSourceCodePosition(literal, ctx);

		return literal;
	}
}
