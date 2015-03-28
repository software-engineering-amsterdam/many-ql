package uva.ql.parser;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import uva.ql.ast.Node;
import uva.ql.ast.CodeLines;
import uva.ql.ast.Form;
import uva.ql.ast.Prog;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.Operator;
import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.ast.expressions.literals.IntLiteral;
import uva.ql.ast.expressions.logic.And;
import uva.ql.ast.expressions.logic.Equal;
import uva.ql.ast.expressions.logic.Greater;
import uva.ql.ast.expressions.logic.Greater_Eq;
import uva.ql.ast.expressions.logic.Less;
import uva.ql.ast.expressions.logic.Less_Eq;
import uva.ql.ast.expressions.logic.NotEqual;
import uva.ql.ast.expressions.logic.Or;
import uva.ql.ast.expressions.math.Addition;
import uva.ql.ast.expressions.math.Division;
import uva.ql.ast.expressions.math.Exponentiation;
import uva.ql.ast.expressions.math.Multiplication;
import uva.ql.ast.expressions.math.Substraction;
import uva.ql.parser.QLParser.FormContext;
import uva.ql.parser.QLParser.ProgContext;
import uva.ql.parser.QLParser.StatContext;
import uva.ql.ast.expressions.literals.*;
import uva.ql.ast.statements.Assign;
import uva.ql.ast.statements.IfStatement;
import uva.ql.ast.statements.Question;
import uva.ql.ast.statements.Statement;
import uva.ql.ast.type.*;

import java.util.*;

public class QLMainVisitor extends QLBaseVisitor<Node> {
	
	@Override 
	public Node visitProg(ProgContext ctx) { 
		CodeLines codeLines = getCodeLines(ctx);
		return new Prog(visitForm(ctx.form()), codeLines);
	}
	
	@Override 
	public Form visitForm(FormContext ctx) { 
		CodeLines codeLines = getCodeLines(ctx);
		return new Form(this.visitIdentifier(ctx.Identifier(), codeLines), this.getStatementList(ctx.stms), codeLines);
	}
	
	public Statement visitStat(StatContext ctx) { 	
		return (Statement)ctx.accept(this); 
	}

	@Override 
	public Assign visitCtxAssign(QLParser.CtxAssignContext ctx) { 
		return (Assign)ctx.assign().accept(this);
	}
	
	@Override 
	public IfStatement visitCtxIfStatement(QLParser.CtxIfStatementContext ctx) { 
		return this.visitIfStatement(ctx.ifStatement()); 
	}
	
	@Override 
	public IfStatement visitIfStatement(QLParser.IfStatementContext ctx) { 
		return new IfStatement((Expression)ctx.expr().accept(this), this.getStatementList(ctx.stms), this.getCodeLines(ctx));
	}
	
	@Override 
	public Question visitCtxQuestion(QLParser.CtxQuestionContext ctx) { 
		return (Question)ctx.quest().accept(this); 
	}
	
	@Override 
	public Question visitSimpleQuestion(QLParser.SimpleQuestionContext ctx) { 
		CodeLines codeLines = this.getCodeLines(ctx);
		
		Identifier identifier = this.visitIdentifier(ctx.Identifier(), codeLines);
		Type type = (Type)ctx.primitiveType().accept(this);
		StringLiteral text = this.visitStringLiteral(ctx.STRING(), codeLines);
		
		return new Question(type, identifier, text, codeLines);    
	}
	
	@Override 
	public Question visitComputedQuestion(QLParser.ComputedQuestionContext ctx) { 
		CodeLines codeLines = this.getCodeLines(ctx);
		
		Identifier identifier = this.visitIdentifier(ctx.Identifier(), codeLines);
		Type type = (Type)ctx.primitiveType().accept(this);
		StringLiteral text = this.visitStringLiteral(ctx.STRING(), codeLines);
		Assign assign = this.visitAssign(ctx.assign());
		
		return new Question(type, identifier, text, assign.getAssignExpression(), this.getCodeLines(ctx));
	}
	
	@Override 
	public Assign visitAssign(QLParser.AssignContext ctx) { 
		CodeLines codeLines = this.getCodeLines(ctx);
		Expression expression = (Expression)ctx.expr().accept(this);
		
		return new Assign(this.visitIdentifier(ctx.Identifier(), codeLines), expression, codeLines);
	}
	
	@Override 
	public Expression visitParenthesis(QLParser.ParenthesisContext ctx) { 
		return (Expression)ctx.expr().accept(this); 
	}
	
	@Override 
	public Expression visitLessEqualGreaterEqual(QLParser.LessEqualGreaterEqualContext ctx) { 
		CodeLines codeLines = this.getCodeLines(ctx);
		Operator operator = Operator.findOperator(ctx.op.getText());
		
		if (operator == Operator.LESS){
			 return new Less((Expression)ctx.x.accept(this), (Expression)ctx.y.accept(this), codeLines);
		}
		else if (operator == Operator.LESS_EQ){
			return new Less_Eq((Expression)ctx.x.accept(this), (Expression)ctx.y.accept(this), codeLines);
		}
		else if (operator == Operator.GREATER){
			return new Greater((Expression)ctx.x.accept(this), (Expression)ctx.y.accept(this), codeLines);
		}
		else if (operator == Operator.GREATER_EQ){
			return new Greater_Eq((Expression)ctx.x.accept(this), (Expression)ctx.y.accept(this), codeLines);
		}
		
		return null;
	}
	
	@Override 
	public Expression visitMulDiv(QLParser.MulDivContext ctx) { 
		CodeLines codeLines = this.getCodeLines(ctx);
		Operator operator = Operator.findOperator(ctx.op.getText());
		
		if (operator == Operator.MUL){
			 return new Multiplication((Expression)ctx.x.accept(this), (Expression)ctx.y.accept(this), codeLines);
		}
		else if (operator == Operator.DIV){
			return new Division((Expression)ctx.x.accept(this), (Expression)ctx.y.accept(this), codeLines);
		}
		
		return null;
	}
	
	@Override 
	public Expression visitAddSub(QLParser.AddSubContext ctx) { 
		CodeLines codeLines = this.getCodeLines(ctx);
		Operator operator = Operator.findOperator(ctx.op.getText());
		
		if (operator == Operator.ADD){
			 return new Addition((Expression)ctx.x.accept(this), (Expression)ctx.y.accept(this), codeLines);
		}
		else if (operator == Operator.SUB){
			return new Substraction((Expression)ctx.x.accept(this), (Expression)ctx.y.accept(this), codeLines);
		}
		
		return null;
	}
	
	@Override 
	public Or visitLogOr(QLParser.LogOrContext ctx) { 
		return new Or((Expression)ctx.x.accept(this), (Expression)ctx.y.accept(this), this.getCodeLines(ctx));
	}
	
	@Override 
	public Expression visitExprLiteral(QLParser.ExprLiteralContext ctx) { 
		return (Literal)ctx.literal().accept(this); 
	}
	
	@Override 
	public Exponentiation visitExponentiation(QLParser.ExponentiationContext ctx) { 
		return new Exponentiation((Expression)ctx.x.accept(this), (Expression)ctx.y.accept(this), this.getCodeLines(ctx));
	}
	
	@Override 
	public Expression visitEqualNot(QLParser.EqualNotContext ctx) { 
		CodeLines codeLines = this.getCodeLines(ctx);
		Operator operator = Operator.findOperator(ctx.op.getText());
		
		if (operator == Operator.EQUAL){
			 return new Equal((Expression)ctx.x.accept(this), (Expression)ctx.y.accept(this), codeLines);
		}
		else if (operator == Operator.NOT_EQUAL){
			return new NotEqual((Expression)ctx.x.accept(this), (Expression)ctx.y.accept(this), codeLines);
		}
		
		return null;
	}
	
	@Override 
	public And visitLogAnd(QLParser.LogAndContext ctx) { 
		return new And((Expression)ctx.x.accept(this), (Expression)ctx.y.accept(this), this.getCodeLines(ctx));
	}
	
	public Identifier visitIdentifier(TerminalNode identifier, CodeLines codeLines){
		return new Identifier(identifier.getText(), codeLines);
	}
	
	@Override 
	public Identifier visitCtxIdentifier(QLParser.CtxIdentifierContext ctx) { 
		return this.visitIdentifier(ctx.Identifier(), this.getCodeLines(ctx));
	}
	
	@Override 
	public BooleanLiteral visitCtxBooleanLiteral(QLParser.CtxBooleanLiteralContext ctx) { 
		return new BooleanLiteral(Boolean.valueOf(ctx.getText()), this.getCodeLines(ctx));
	}
	
	@Override 
	public IntLiteral visitCtxIntLiteral(QLParser.CtxIntLiteralContext ctx) { 
		return new IntLiteral(Integer.valueOf(ctx.getText()), this.getCodeLines(ctx)); 
	}
	
	public StringLiteral visitStringLiteral(TerminalNode STRING, CodeLines codeLines){
		return new StringLiteral(STRING.getText(), codeLines);
	}
	
	@Override 
	public MoneyLiteral visitCtxMoneyLiteral(QLParser.CtxMoneyLiteralContext ctx) { 
		return new MoneyLiteral(Integer.valueOf(ctx.getText()), this.getCodeLines(ctx)); 
	}
	
	public Type visitPrimitiveType(QLParser.PrimitiveTypeContext ctx){
		return (Type)ctx.accept(this);
	}
	
	@Override 
	public TypeBoolean visitBooleanPrimitive(QLParser.BooleanPrimitiveContext ctx) { 
		return new TypeBoolean(this.getCodeLines(ctx)); 
	}
	
	@Override 
	public TypeMoney visitMoneyPrimitive(QLParser.MoneyPrimitiveContext ctx) { 
		return new TypeMoney(this.getCodeLines(ctx)); 
	}
	
	@Override 
	public TypeString visitStringPrimitive(QLParser.StringPrimitiveContext ctx) { 
		return new TypeString(this.getCodeLines(ctx)); 
	}
	
	@Override 
	public TypeInteger visitIntPrimitive(QLParser.IntPrimitiveContext ctx) { 
		return new TypeInteger(this.getCodeLines(ctx)); 
	}
	
	private CodeLines getCodeLines(ParserRuleContext ctx){
		return new CodeLines(ctx.start.getLine(),ctx.stop.getLine());
	}
	
	private List<Statement> getStatementList(List<StatContext> stms){
		List<Statement> statement = new ArrayList<Statement>();
		
		for(StatContext s : stms)
			statement.add((Statement)visitStat(s));
		
		return statement;
	}
}