package uva.sc.ql.parser;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

import uva.sc.core.INode;
import uva.sc.core.types.Type;
import uva.sc.core.types.String;
import uva.sc.core.types.Boolean;
import uva.sc.core.types.Number;
import uva.sc.ql.ast.IQLExpressionNode;
import uva.sc.ql.atom.BooleanAtom;
import uva.sc.ql.atom.ID;
import uva.sc.ql.atom.NumberAtom;
import uva.sc.ql.atom.StringAtom;
import uva.sc.ql.expression.Expression;
import uva.sc.ql.expression.binaryExpressions.*;
import uva.sc.ql.expression.unaryExpressions.*;
import uva.sc.ql.form.Form;
import uva.sc.ql.statements.IfStatement;
import uva.sc.ql.statements.Question;
import uva.sc.ql.statements.Statement;

public class ASTGeneratorVisitor extends QLGrammarBaseVisitor<INode> {

    /* ========================== Parsing blocks ============================ */

    public Form visitForm(@NotNull QLGrammarParser.FormContext ctx) {
	List<Statement> statementList = new ArrayList<Statement>();
	for (int i = 0; i < ctx.sts.size(); i++)
	    statementList.add((Statement) visitStat(ctx.sts.get(i)));
	return new Form(new ID(ctx.ID().getText()), statementList);
    }

    public Question visitQuestion(@NotNull QLGrammarParser.QuestionContext ctx) {
	java.lang.String label = ctx.STRING().getText();
	ID id = new ID(ctx.ID().getText());
	Type type = (Type) (this.visit(ctx.type()));
	if (ctx.expr() != null) {
	    Expression expression = (Expression) this.visit(ctx.expr());
	    return new Question(label, id, type, expression);
	} else {
	    return new Question(label, id, type);
	}
    }

    public IfStatement visitIf_stat(@NotNull QLGrammarParser.If_statContext ctx) {
	Expression expr = (Expression) this.visit(ctx.expr());
	List<Question> questionList = new ArrayList<Question>();
	for (int i = 0; i < ctx.qs.size(); i++)
	    questionList.add((Question) visitQuestion(ctx.qs.get(i)));
	return new IfStatement(expr, questionList);
    }

    /* ============================== Types ================================= */

    public Boolean visitTypeBoolean(QLGrammarParser.TypeBooleanContext ctx) {
	return new Boolean();
    }

    public Number visitTypeNumber(QLGrammarParser.TypeNumberContext ctx) {
	return new Number();
    }

    public String visitTypeString(QLGrammarParser.TypeStringContext ctx) {
	return new String();
    }

    /* ============================ Literals ================================ */

    public IQLExpressionNode visitString(@NotNull QLGrammarParser.StringContext ctx) {
	java.lang.String str = ctx.getText();
	str = str.substring(1, str.length() - 1).replace("\"\"", "\"");
	return new StringAtom(str);
    }

    public IQLExpressionNode visitNumber(@NotNull QLGrammarParser.NumberContext ctx) {
	IQLExpressionNode result = null;
	// if (ctx.getText().contains("."))
	result = new NumberAtom(Double.valueOf(ctx.getText()));
	// else
	// result = new NumberAtom(ctx.getText());
	return result;
    }

    public IQLExpressionNode visitBoolean(QLGrammarParser.BooleanContext ctx) {
	return new BooleanAtom(java.lang.Boolean.valueOf(ctx.getText()));
    }

    /* ======================== Expressions ================================= */

    public Minus visitUnaryMinus(@NotNull QLGrammarParser.UnaryMinusContext ctx) {
	return new Minus((Expression) this.visit(ctx.expr()));
    }

    public Not visitNot(@NotNull QLGrammarParser.NotContext ctx) {
	return new Not((Expression) this.visit(ctx.expr()));
    }

    public IQLExpressionNode visitMultiplication(
	    @NotNull QLGrammarParser.MultiplicationContext ctx) {
	IQLExpressionNode result = null;
	Expression firstOperand = (Expression) this.visit(ctx.expr(0));
	Expression secondOperand = (Expression) this.visit(ctx.expr(1));
	switch (ctx.op.getType()) {
	case QLGrammarParser.MULT:
	    result = new Multiplication(firstOperand, secondOperand);
	    break;
	case QLGrammarParser.DIV:
	    result = new Division(firstOperand, secondOperand);
	    break;
	case QLGrammarParser.MOD:
	    result = new Modulus(firstOperand, secondOperand);
	    break;
	}
	return result;
    }

    public IQLExpressionNode visitAdditive(@NotNull QLGrammarParser.AdditiveContext ctx) {
	Expression result = null;
	Expression firstOperand = (Expression) this.visit(ctx.expr(0));
	Expression secondOperand = (Expression) this.visit(ctx.expr(1));
	switch (ctx.op.getType()) {
	case QLGrammarParser.ADD:
	    result = new Addition(firstOperand, secondOperand);
	    break;
	case QLGrammarParser.SUB:
	    result = new Substraction(firstOperand, secondOperand);
	    break;
	}
	return result;
    }

    public IQLExpressionNode visitRelational(
	    @NotNull QLGrammarParser.RelationalContext ctx) {
	IQLExpressionNode result = null;
	Expression firstOperand = (Expression) this.visit(ctx.expr(0));
	Expression secondOperand = (Expression) this.visit(ctx.expr(1));
	switch (ctx.op.getType()) {
	case QLGrammarParser.LTE:
	    result = new LesserThanEquals(firstOperand, secondOperand);
	    break;
	case QLGrammarParser.GTE:
	    result = new GreaterThanEquals(firstOperand, secondOperand);
	    break;
	case QLGrammarParser.LT:
	    result = new LesserThan(firstOperand, secondOperand);
	    break;
	case QLGrammarParser.GT:
	    result = new GreaterThan(firstOperand, secondOperand);
	    break;
	}
	return result;
    }

    public IQLExpressionNode visitEquality(@NotNull QLGrammarParser.EqualityContext ctx) {
	IQLExpressionNode result = null;
	Expression firstOperand = (Expression) this.visit(ctx.expr(0));
	Expression secondOperand = (Expression) this.visit(ctx.expr(1));
	switch (ctx.op.getType()) {
	case QLGrammarParser.EQ:
	    result = new Equals(firstOperand, secondOperand);
	    break;
	case QLGrammarParser.NEQ:
	    result = new NotEquals(firstOperand, secondOperand);
	    break;
	}
	return result;
    }

    public And visitAnd(@NotNull QLGrammarParser.AndContext ctx) {
	Expression firstExpression = (Expression) this.visit(ctx.expr(0));
	Expression secondExpression = (Expression) this.visit(ctx.expr(1));
	return new And(firstExpression, secondExpression);
    }

    public Or visitOr(@NotNull QLGrammarParser.OrContext ctx) {
	Expression firstExpression = (Expression) this.visit(ctx.expr(0));
	Expression secondExpression = (Expression) this.visit(ctx.expr(1));
	return new Or(firstExpression, secondExpression);
    }

    public INode visitParenthesis(
	    @NotNull QLGrammarParser.ParenthesisContext ctx) {
	return this.visit(ctx.expr());
    }

    public ID visitId(@NotNull QLGrammarParser.IdContext ctx) {
	return new ID(ctx.ID().getText());
    }
}
