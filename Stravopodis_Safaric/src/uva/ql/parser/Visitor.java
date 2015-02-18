package uva.ql.parser;

import org.antlr.v4.runtime.ParserRuleContext;

import uva.ql.ast.ASTNode;
import uva.ql.ast.expressions.BinaryExpressions;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.Operator;
import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.ast.expressions.literals.IntValue;
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
import uva.ql.parser.QLParser.AssignContext;
import uva.ql.parser.QLParser.DeclContext;
import uva.ql.parser.QLParser.ExprContext;
import uva.ql.parser.QLParser.FormContext;
import uva.ql.parser.QLParser.IfStatementContext;
import uva.ql.parser.QLParser.LiteralContext;
import uva.ql.parser.QLParser.PrimitiveTypeContext;
import uva.ql.parser.QLParser.ProgContext;
import uva.ql.parser.QLParser.QuestContext;
import uva.ql.parser.QLParser.QuestionTypeContext;
import uva.ql.parser.QLParser.StatContext;
import uva.ql.parser.QLParser.TypeofContext;
import uva.ql.supporting.Tuple;
import uva.ql.ast.expressions.literals.*;
import uva.ql.ast.question.QuestionDeclaration;
import uva.ql.ast.statements.Assign;

public class Visitor extends QLBaseVisitor<ASTNode> {
	
	
	@Override 
	public ASTNode visitProg(ProgContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override 
	public ASTNode visitForm(FormContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override 
	public ASTNode visitQuest(QuestContext ctx) { 
		// quest 	: 'question' ID typeof primitiveType '{' (expr | quest_decl)* '}' ;
		
		return visitChildren(ctx); 
	}
	
	@Override 
	public ASTNode visitStat(StatContext ctx) { 
		// Statements -> quest, decl, ifStatement, quest_decl, assign
		return visitChildren(ctx); 
	}

	@Override 
	public ASTNode visitDecl(DeclContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override
	public ASTNode visitAssignExpr(QLParser.AssignExprContext ctx) { 
		Tuple<Integer,Integer> codeLines = getCodeLines(ctx);
		return new Assign(new Identifier(ctx.ID().toString(), codeLines), (Expression)visitExpr(ctx.expr()), codeLines);
	}

	@Override 
	public ASTNode visitAssignStr(QLParser.AssignStrContext ctx) { 
		Tuple<Integer,Integer> codeLines = getCodeLines(ctx);
		return new Assign(new Identifier(ctx.ID().toString(), codeLines), ctx.STRING().getText(), codeLines);
	}
	
	@Override 
	public ASTNode visitExpr(ExprContext ctx) { 
		Tuple<Integer,Integer> codeLines = getCodeLines(ctx);
		
		if (ctx.op != null){
			Operator operator = Operator.findOperator(ctx.op.getText().toString());
			if (ctx.y == null){
				System.out.println("Parant");
			}
			switch(operator){
				case ADD: return new Addition((Expression)visitExpr(ctx.x),(Expression)visitExpr(ctx.y), codeLines);
				case SUB: return new Substraction((Expression)visitExpr(ctx.x),(Expression)visitExpr(ctx.y), codeLines); 
				case MUL: return new Multiplication((Expression)visitExpr(ctx.x),(Expression)visitExpr(ctx.y), codeLines);
				case DIV: return new Division((Expression)visitExpr(ctx.x),(Expression)visitExpr(ctx.y), codeLines);
				case EXP:  return new Exponentiation((Expression)visitExpr(ctx.x),(Expression)visitExpr(ctx.y), codeLines);
				case OR:   return new Or((Expression)visitExpr(ctx.x),(Expression)visitExpr(ctx.y), codeLines);
				case AND:  return new And((Expression)visitExpr(ctx.x),(Expression)visitExpr(ctx.y), codeLines);
				case LESS: return new Less((Expression)visitExpr(ctx.x),(Expression)visitExpr(ctx.y), codeLines);
				case LESS_EQ:  return new Less_Eq((Expression)visitExpr(ctx.x),(Expression)visitExpr(ctx.y), codeLines);
				case GREATER:  return new Greater((Expression)visitExpr(ctx.x),(Expression)visitExpr(ctx.y), codeLines);
				case GREATER_EQ:  return new Greater_Eq((Expression)visitExpr(ctx.x),(Expression)visitExpr(ctx.y), codeLines);
				case EQUAL:  return new Equal((Expression)visitExpr(ctx.x),(Expression)visitExpr(ctx.y), codeLines);
				case NOT_EQUAL:  return new NotEqual((Expression)visitExpr(ctx.x),(Expression)visitExpr(ctx.y), codeLines);
			}
		}
		else
			return visitLiteral(ctx.lit);
		
		return visitChildren(ctx);
	}
	
	@Override 
	public ASTNode visitIfStatement(IfStatementContext ctx) { 
		
		
		
		return visitChildren(ctx); 
	}
	
	@Override 
	public ASTNode visitLiteral(LiteralContext ctx) {
		Tuple<Integer,Integer> codeLines = getCodeLines(ctx);
		
		if (ctx.BooleanLiteral() != null) return new BooleanValue(Boolean.valueOf(ctx.getText()),codeLines);
		else if (ctx.INT() != null) return new IntValue(Integer.valueOf(ctx.getText()), codeLines);
		else if (ctx.FLOAT() != null) return new FloatValue(Float.valueOf(ctx.getText()), codeLines);
		else if (ctx.CURRENCY() != null) return new CurrencyValue(Float.valueOf(ctx.getText()), codeLines);
		else if (ctx.ID() != null) return new Identifier(ctx.getText(), codeLines);
		
		return visitChildren(ctx); 
	}
	
	@Override 
	public ASTNode visitPrimitiveType(PrimitiveTypeContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override 
	public ASTNode visitTypeof(TypeofContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override 
	public ASTNode visitQuestionType(QuestionTypeContext ctx) { 
		return visitChildren(ctx); 
	}
	
	// Visitor functions
	private Tuple<Integer, Integer> getCodeLines(ParserRuleContext ctx){
		return new Tuple<Integer, Integer>(ctx.start.getLine(),ctx.stop.getLine());
	}
	
}
