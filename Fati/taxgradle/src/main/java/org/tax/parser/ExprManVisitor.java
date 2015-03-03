package org.tax.parser;

import java.util.Map;

import org.tax.datatypes.QLBoolean;
import org.tax.datatypes.QLDecimal;
import org.tax.datatypes.QLNumber;
import org.tax.datatypes.QLType;
import org.tax.expression.BooleanBinOpExpr;
import org.tax.expression.BooleanCompExpr;
import org.tax.expression.BooleanUniOpExpr;
import org.tax.expression.BooleanValueExpr;
import org.tax.expression.DecimalValueExpr;
import org.tax.expression.Expression;
import org.tax.expression.IntValueExpr;
import org.tax.expression.MoneyValueExpr;
import org.tax.expression.NumberOptExpr;
import org.tax.exprgen.ExprBaseVisitor;
import org.tax.exprgen.ExprParser;

public class ExprManVisitor extends ExprBaseVisitor<Expression<? extends QLType>> {
	
	Map<String, Variable> memory;
//	Class<? extends Expression<? extends FormType>> clazz;
	String className;

	public ExprManVisitor(Map<String, Variable> memory, String className) {
		super();
		this.memory = memory;
		this.className = className;
	}

	@Override public Expression<? extends QLNumber<? extends Number>> visitINTLiteral(ExprParser.INTLiteralContext ctx) { 
		System.out.println(ctx.getText());
		if (className.equals("money")) 
			return new MoneyValueExpr(Double.valueOf(ctx.getText()));
		if (className.equals("decimal"))
			return new DecimalValueExpr(Double.valueOf(ctx.getText()));
		if (className.equals("integer"))
            return new IntValueExpr(Integer.valueOf(ctx.getText()));
		return null;
	}

	@Override public Expression<? extends QLDecimal> visitDECIMALLiteral(ExprParser.DECIMALLiteralContext ctx) {
		if (className.equals("decimal"))
			return new DecimalValueExpr(Double.valueOf(ctx.getText()));
		if (className.equals("money")) 
			return new MoneyValueExpr(Double.valueOf(ctx.getText()));
		return null;
	}
	

	@Override public Expression<? extends QLType> visitVarLiteral(ExprParser.VarLiteralContext ctx) { 
		String type = memory.get(ctx.getText()).type;
		String value = memory.get(ctx.getText()).value;
		System.out.println("and here is the type from variable" + type + " : " + value);
		if (type.equals("integer"))
			return new IntValueExpr(Integer.valueOf(value));
		else if (type.equals("boolean"))
			return new BooleanValueExpr(Boolean.valueOf(value));
		else if(type.equals("money")) 
			return new MoneyValueExpr(Double.valueOf(value));
		return null;
	}

	@Override public Expression<QLBoolean> visitBOOLLiteral(ExprParser.BOOLLiteralContext ctx) { 
		return new BooleanValueExpr(Boolean.valueOf(ctx.getText())); 
	}

	@Override public Expression<QLBoolean> visitANDExpr(ExprParser.ANDExprContext ctx) { 
		@SuppressWarnings("unchecked")
		Expression<QLBoolean> left = (Expression<QLBoolean>) visit(ctx.expression(0));
		@SuppressWarnings("unchecked")
		Expression<QLBoolean> right = (Expression<QLBoolean>)(visit(ctx.expression(1)));

		return new BooleanBinOpExpr(left, right, ctx.op.getText());
	}

	@Override public Expression<QLBoolean> visitORExpr(ExprParser.ORExprContext ctx) { 
		@SuppressWarnings("unchecked")
		Expression<QLBoolean> left = (Expression<QLBoolean>) visit(ctx.expression(0));
		@SuppressWarnings("unchecked")
		Expression<QLBoolean> right = (Expression<QLBoolean>)(visit(ctx.expression(1)));

		return new BooleanBinOpExpr(left, right, ctx.op.getText());
	}
	
	@Override public Expression<? extends QLNumber<? extends Number>> visitADDSUBExpr(ExprParser.ADDSUBExprContext ctx) { 
		@SuppressWarnings("unchecked")
		Expression<QLNumber<? extends Number>> left = (Expression<QLNumber<? extends Number>>)(visit(ctx.expression(0)));
		
		@SuppressWarnings("unchecked")
		Expression<QLNumber<? extends Number>> right = (Expression<QLNumber<? extends Number>>)(visit(ctx.expression(1)));
		return new NumberOptExpr(left, right, ctx.op.getText());
	}
	
	@SuppressWarnings("rawtypes")
	@Override public Expression visitPARExpr(ExprParser.PARExprContext ctx) { 
		return visit(ctx.expression());
	}
	

	@Override public Expression<QLBoolean> visitBANGExpr(ExprParser.BANGExprContext ctx) { 
		@SuppressWarnings("unchecked")
		Expression<QLBoolean> operand = (Expression<QLBoolean>)(visit(ctx.expression()));

		return new BooleanUniOpExpr(operand, ctx.op.getText());
	}
	
	
	@Override public Expression<QLBoolean> visitCOMPExpr(ExprParser.COMPExprContext ctx) { 
		@SuppressWarnings("unchecked")
		Expression<QLNumber<Number>> left = (Expression<QLNumber<Number>>)(visit(ctx.expression(0)));
		@SuppressWarnings("unchecked")
		Expression<QLNumber<Number>> right = (Expression<QLNumber<Number>>)(visit(ctx.expression(1)));

		return new BooleanCompExpr(left, right, ctx.op.getText());
	}
	
//	@Override public Expression<TInteger> visitMULDIVExpr(ExprParser.MULDIVExprContext ctx) { 
//		System.out.println("MULDIVVVV");
//		@SuppressWarnings("unchecked")
//		Expression<TInteger> left = (Expression<TInteger>)(visit(ctx.expression(0)));
//		@SuppressWarnings("unchecked")
//		Expression<TInteger> right = (Expression<TInteger>)(visit(ctx.expression(1)));
//		return new IntOpExpr(left, right, ctx.op.getText());
//	}
	
	@Override public Expression<? extends QLNumber<? extends Number>> visitMULDIVExpr(ExprParser.MULDIVExprContext ctx) { 
		@SuppressWarnings("unchecked")
		Expression<QLNumber<? extends Number>> left = (Expression<QLNumber<? extends Number>>)(visit(ctx.expression(0)));
		
		@SuppressWarnings("unchecked")
		Expression<QLNumber<? extends Number>> right = (Expression<QLNumber<? extends Number>>)(visit(ctx.expression(1)));
		return new NumberOptExpr(left, right, ctx.op.getText());
	}
}
