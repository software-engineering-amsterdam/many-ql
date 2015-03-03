package uva.ql.parser;

import org.antlr.v4.runtime.ParserRuleContext;

import uva.ql.ast.ASTNode;
import uva.ql.ast.CodeLines;
import uva.ql.ast.Form;
import uva.ql.ast.Prog;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.Operator;
import uva.ql.ast.expressions.Type;
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
import uva.ql.parser.QLParser.ExprContext;
import uva.ql.parser.QLParser.FormContext;
import uva.ql.parser.QLParser.IfStatementContext;
import uva.ql.parser.QLParser.PrimitiveTypeContext;
import uva.ql.parser.QLParser.ProgContext;
import uva.ql.parser.QLParser.QuestContext;
import uva.ql.parser.QLParser.StatContext;
import uva.ql.ast.expressions.literals.*;
import uva.ql.ast.question.Question;
import uva.ql.ast.statements.Assign;
import uva.ql.ast.statements.IfStatement;
import uva.ql.ast.statements.Statement;

import java.util.*;

public class QLMainVisitor extends QLBaseVisitor<ASTNode> {
	
	public static List<StatContext> stats = new ArrayList<StatContext>();
	
	@Override 
	public ASTNode visitProg(ProgContext ctx) { 
		CodeLines codeLines = getCodeLines(ctx);
		return new Prog(visitForm(ctx.form()), codeLines);
	}
	
	@Override 
	public Form visitForm(FormContext ctx) { 
		CodeLines codeLines = getCodeLines(ctx);
		return new Form(returnIdentifier(ctx.Identifier().getText(), codeLines), this.getStatementList(ctx.stms), codeLines);
	}
	
	@Override 
	public Question visitQuest(QuestContext ctx) { 
		CodeLines codeLines = getCodeLines(ctx);
		return new 	Question(returnIdentifier(ctx.Identifier().getText(), codeLines), 
					this.visitPrimitiveType(ctx.primitiveType()), this.getStatementList(ctx.stms), codeLines);
	}
	
	public Statement visitStat(StatContext ctx) { 	
		return (Statement)ctx.accept(this); 
	}
	
	@Override 
	public Expression visitCtxExpression(QLParser.CtxExpressionContext ctx) { 
		return this.visitExpr(ctx.expr());
	}

	@Override 
	public Question visitCtxQuestion(QLParser.CtxQuestionContext ctx) { 
		return this.visitQuest(ctx.quest()); 
	}

	@Override 
	public IfStatement visitCtxIfStatement(QLParser.CtxIfStatementContext ctx) { 
		return this.visitIfStatement(ctx.ifStatement()); 
	}

	@Override 
	public Assign visitCtxAssign(QLParser.CtxAssignContext ctx) { 
		return (Assign)ctx.assign().accept(this);
	}
	

	@Override
	public Assign visitAssignExpr(QLParser.AssignExprContext ctx) { 
		CodeLines codeLines = getCodeLines(ctx);
		return new Assign(returnIdentifier(ctx.Identifier().getText(), codeLines), visitExpr(ctx.expr()), codeLines);
	}

	@Override 
	public ASTNode visitAssignStr(QLParser.AssignStrContext ctx) { 
		CodeLines codeLines = getCodeLines(ctx);
		return new Assign(returnIdentifier(ctx.Identifier().getText(), codeLines), new StringLiteral(ctx.STRING().getText(), codeLines), codeLines);
	}
	
	@Override 
	public Expression visitExpr(ExprContext ctx) { 
		CodeLines codeLines = getCodeLines(ctx);
		
		if (ctx.op != null){
			Operator operator = Operator.findOperator(ctx.op.getText().toString());
			
			switch(operator){
				case ADD: 		return new Addition((Expression)visitExpr(ctx.x),(Expression)visitExpr(ctx.y), codeLines);
				case SUB: 		return new Substraction((Expression)visitExpr(ctx.x),(Expression)visitExpr(ctx.y), codeLines); 
				case MUL: 		return new Multiplication((Expression)visitExpr(ctx.x),(Expression)visitExpr(ctx.y), codeLines);
				case DIV: 		return new Division((Expression)visitExpr(ctx.x),(Expression)visitExpr(ctx.y), codeLines);
				case EXP:  		return new Exponentiation((Expression)visitExpr(ctx.x),(Expression)visitExpr(ctx.y), codeLines);
				case OR:   		return new Or((Expression)visitExpr(ctx.x),(Expression)visitExpr(ctx.y), codeLines);
				case AND:  		return new And((Expression)visitExpr(ctx.x),(Expression)visitExpr(ctx.y), codeLines);
				case LESS: 		return new Less((Expression)visitExpr(ctx.x),(Expression)visitExpr(ctx.y), codeLines);
				case LESS_EQ:  	return new Less_Eq((Expression)visitExpr(ctx.x),(Expression)visitExpr(ctx.y), codeLines);
				case GREATER:  	return new Greater((Expression)visitExpr(ctx.x),(Expression)visitExpr(ctx.y), codeLines);
				case GREATER_EQ:return new Greater_Eq((Expression)visitExpr(ctx.x),(Expression)visitExpr(ctx.y), codeLines);
				case EQUAL:  	return new Equal((Expression)visitExpr(ctx.x),(Expression)visitExpr(ctx.y), codeLines);
				case NOT_EQUAL: return new NotEqual((Expression)visitExpr(ctx.x),(Expression)visitExpr(ctx.y), codeLines);
			}
		}
		else if (ctx.y == null && ctx.x != null){
			return visitExpr(ctx.x);
		}
		
		return (Literal)ctx.literal().accept(this);
	}
	
	@Override 
	public IfStatement visitIfStatement(IfStatementContext ctx) {
		CodeLines codeLines = getCodeLines(ctx);
		return new IfStatement(visitExpr(ctx.expr()), this.getStatementList(ctx.stms), codeLines);
	}
	
	@Override 
	public BooleanLiteral visitCtxBooleanLiteral(QLParser.CtxBooleanLiteralContext ctx) { 
		CodeLines codeLines = getCodeLines(ctx);
		return new BooleanLiteral(Boolean.valueOf(ctx.getText()), codeLines);
	}

	@Override 
	public IntLiteral visitCtxIntLiteral(QLParser.CtxIntLiteralContext ctx) { 
		CodeLines codeLines = getCodeLines(ctx);
		return new IntLiteral(Integer.valueOf(ctx.getText().replaceAll(".*\\(|\\).*", "")), codeLines);
	}

	@Override 
	public MoneyLiteral visitCtxMoneyLiteral(QLParser.CtxMoneyLiteralContext ctx) { 
		CodeLines codeLines = getCodeLines(ctx);
		return new MoneyLiteral(Integer.valueOf(ctx.getText().replaceAll(".*\\(|\\).*", "")), codeLines);
	}

	@Override 
	public Identifier visitCtxIdentifier(QLParser.CtxIdentifierContext ctx) { 
		CodeLines codeLines = getCodeLines(ctx);
		return this.returnIdentifier(ctx.getText(), codeLines);
	}
	private Identifier returnIdentifier(String ctxGetText, CodeLines codeLines){
		return new Identifier(ctxGetText, codeLines); 
	}
	
	@Override 
	public Type visitPrimitiveType(PrimitiveTypeContext ctx) { 
		CodeLines codeLines = getCodeLines(ctx);
		return new Type(ctx.getText(), codeLines);
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