package org.fugazi.ql.ast;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.fugazi.ql.ast.expression.Expression;
import org.fugazi.ql.ast.expression.comparison.*;
import org.fugazi.ql.ast.expression.literal.BOOL;
import org.fugazi.ql.ast.expression.logical.And;
import org.fugazi.ql.ast.expression.logical.Logical;
import org.fugazi.ql.ast.expression.numerical.*;
import org.fugazi.ql.ast.expression.unary.Negative;
import org.fugazi.ql.ast.expression.unary.Unary;
import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.ast.expression.literal.ID;
import org.fugazi.ql.ast.expression.literal.INT;
import org.fugazi.ql.ast.expression.literal.STRING;
import org.fugazi.ql.ast.expression.logical.Or;
import org.fugazi.ql.ast.expression.unary.Not;
import org.fugazi.ql.ast.expression.unary.Positive;
import org.fugazi.ql.ast.statement.ComputedQuestion;
import org.fugazi.ql.ast.statement.IfStatement;
import org.fugazi.ql.ast.statement.Question;
import org.fugazi.ql.ast.statement.Statement;
import org.fugazi.ql.ast.type.*;
import org.fugazi.ql.parser.QLBaseVisitor;
import org.fugazi.ql.parser.QLParser;

import java.util.ArrayList;
import java.util.List;

public class FugaziQLVisitor extends QLBaseVisitor<AbstractASTNode> {

    private String removeStringQuotes(String _str) {
        return _str.replaceAll("^\"|\"$", "");
    }

    private int getLineNumber(ParserRuleContext ctx) {
        return ctx.getStart().getLine();
    }

    /**
     * =======================
     * form
     * =======================
     */
    
    @Override
    public Form visitForm(@NotNull QLParser.FormContext ctx) {
        String formName = ctx.ID().getText();
        List<Statement> formStatements = new ArrayList<>();

        for (QLParser.StatementContext statement : ctx.statement()) {
            Statement stat = (Statement) statement.accept(this);
            formStatements.add(stat);
        }

        Form form = new Form(formName, formStatements);
        form.setLineNumber(this.getLineNumber(ctx));
        return form;
    }

    /**
     * =======================
     * Statements
     * =======================
     */
    
    @Override
    public IfStatement visitIfStatement(@NotNull QLParser.IfStatementContext ctx) {
        Expression condition = (Expression) ctx.expression().accept(this);
        List<Statement> statements = new ArrayList<>();

        for (QLParser.StatementContext statement : ctx.statement()) {
            Statement stat = (Statement) statement.accept(this);
            statements.add(stat);
        }

        IfStatement ifStatement = new IfStatement(condition, statements);
        ifStatement.setLineNumber( this.getLineNumber(ctx));
        return ifStatement;
    }

    @Override
    public Question visitSimpleQuestion(@NotNull QLParser.SimpleQuestionContext ctx) {
        Type type = (Type) ctx.type().accept(this);
        
        ID identifier = new ID(ctx.ID().getText());
        identifier.setLineNumber(this.getLineNumber(ctx));

        STRING grammarLabel = new STRING(ctx.STRING().getText());
        grammarLabel.setLineNumber(this.getLineNumber(ctx));
        String label = removeStringQuotes(grammarLabel.toString());
        
        Question question = new Question(type, label, identifier);
        question.setLineNumber(this.getLineNumber(ctx));
        return question;
    }

    @Override
    public ComputedQuestion visitComputedQuestion(@NotNull QLParser.ComputedQuestionContext ctx)  {
        Type type = (Type) ctx.type().accept(this);

        ID identifier = new ID(ctx.ID().getText());
        identifier.setLineNumber(this.getLineNumber(ctx));

        STRING grammarLabel = new STRING(ctx.STRING().getText());
        grammarLabel.setLineNumber(this.getLineNumber(ctx));
        String label = removeStringQuotes(grammarLabel.toString());

        Expression expression = (Expression) ctx.expression().accept(this);

        ComputedQuestion question = new ComputedQuestion(type, label, identifier, expression);
        question.setLineNumber(this.getLineNumber(ctx));
        return question;
    }

    /** 
     * =======================
     * Types 
     * =======================
     */
    
    @Override 
    public BoolType visitBoolType(@NotNull QLParser.BoolTypeContext ctx) {
        BoolType type = new BoolType();
        type.setLineNumber(this.getLineNumber(ctx));
        return type;
    }

    @Override 
    public IntType visitIntType(@NotNull QLParser.IntTypeContext ctx) {
        IntType type = new IntType();
        type.setLineNumber(this.getLineNumber(ctx));
        return type;
    }

    @Override 
    public StringType visitStringType(@NotNull QLParser.StringTypeContext ctx) {
        StringType type = new StringType();
        type.setLineNumber(this.getLineNumber(ctx));
        return type;
    }

    /**
     * =======================
     * Expressions
     * =======================
     */
    @Override
    public Expression visitParenthesisExpression(@NotNull QLParser.ParenthesisExpressionContext ctx) {
        return (Expression) ctx.expression().accept(this);
    }

    @Override 
    public Unary visitUnaryExpression(@NotNull QLParser.UnaryExpressionContext ctx) {
        Expression expr = (Expression) ctx.expression().accept(this);

        if (ctx.op.getText().equals("!")) {
            Not expression = new Not(expr);
            expression.setLineNumber(this.getLineNumber(ctx));
            return expression;
        }

        if (ctx.op.getText().equals("-")) {
            Negative expression = new Negative(expr);
            expression.setLineNumber(this.getLineNumber(ctx));
            return expression;
        }
        
        if (ctx.op.getText().equals("+")) {
            Positive expression = new Positive(expr);
            expression.setLineNumber(this.getLineNumber(ctx));
            return expression;
        }
        
        return null;
    }
    
    @Override
    public Numerical visitMulDivExpression(@NotNull QLParser.MulDivExpressionContext ctx) {
        Expression leftExpr = (Expression) ctx.expression(0).accept(this);
        Expression rightExpr = (Expression) ctx.expression(1).accept(this);

        if (ctx.op.getText().equals("*")) {
            Mul expression = new Mul(leftExpr, rightExpr);
            expression.setLineNumber(this.getLineNumber(ctx));
            return expression;
        }

        if (ctx.op.getText().equals("/")) {
            Div expression = new Div(leftExpr, rightExpr);
            expression.setLineNumber(this.getLineNumber(ctx));
            return expression;
        }

        return null;
    }

    @Override
    public Numerical visitAddSubExpression(@NotNull QLParser.AddSubExpressionContext ctx) {
        Expression leftExpr = (Expression) ctx.expression().get(0).accept(this);
        Expression rightExpr = (Expression) ctx.expression().get(1).accept(this);

        if (ctx.op.getText().equals("+")) {
            Add expression = new Add(leftExpr, rightExpr);
            expression.setLineNumber(this.getLineNumber(ctx));
            return expression;
        }

        if (ctx.op.getText().equals("-")) {
            Sub expression = new Sub(leftExpr, rightExpr);
            expression.setLineNumber(this.getLineNumber(ctx));
            return expression;
        }

        return null;
    }

    @Override
    public Logical visitLogicalOrExpression(@NotNull QLParser.LogicalOrExpressionContext ctx) {
        Expression leftExpr = (Expression) ctx.expression().get(0).accept(this);
        Expression rightExpr = (Expression) ctx.expression().get(1).accept(this);

        Or expression = new Or(leftExpr, rightExpr);
        expression.setLineNumber(this.getLineNumber(ctx));
        return expression;
    }
    
    @Override
    public Logical visitLogicalAndExpression(@NotNull QLParser.LogicalAndExpressionContext ctx) {
        Expression leftExpr = (Expression) ctx.expression().get(0).accept(this);
        Expression rightExpr = (Expression) ctx.expression().get(1).accept(this);

        And expression = new And(leftExpr, rightExpr);
        expression.setLineNumber(this.getLineNumber(ctx));
        return expression;
    }
    
    @Override
    public Comparison visitComparisonExpression(@NotNull QLParser.ComparisonExpressionContext ctx) {
        Expression leftExpr = (Expression) ctx.expression().get(0).accept(this);
        Expression rightExpr = (Expression) ctx.expression().get(1).accept(this);

        if (ctx.op.getText().equals(">")) {
            Greater expression = new Greater(leftExpr, rightExpr);
            expression.setLineNumber(this.getLineNumber(ctx));
            return expression;
        }

        if (ctx.op.getText().equals(">=")) {
            GE expression = new GE(leftExpr, rightExpr);
            expression.setLineNumber(this.getLineNumber(ctx));
            return expression;
        }

        if (ctx.op.getText().equals("<")) {
            Less expression = new Less(leftExpr, rightExpr);
            expression.setLineNumber(this.getLineNumber(ctx));
            return expression;
        }

        if (ctx.op.getText().equals("<=")) {
            LE expression = new LE(leftExpr, rightExpr);
            expression.setLineNumber(this.getLineNumber(ctx));
            return expression;
        }

        if (ctx.op.getText().equals("==")) {
            EQ expression = new EQ(leftExpr, rightExpr);
            expression.setLineNumber(this.getLineNumber(ctx));
            return expression;
        }

        if (ctx.op.getText().equals("!=")) {
            NotEq expression = new NotEq(leftExpr, rightExpr);
            expression.setLineNumber(this.getLineNumber(ctx));
            return expression;
        }

        return null;
    }

    /**
     * =======================
     * literals
     * =======================
     */
    @Override
    public INT visitIntExpression(@NotNull QLParser.IntExpressionContext ctx) {
        int value = Integer.parseInt(ctx.INT().getText());
        INT expression = new INT(value);
        expression.setLineNumber(this.getLineNumber(ctx));
        return expression;
    }

    @Override
    public BOOL visitBoolExpression(@NotNull QLParser.BoolExpressionContext ctx) {
        Boolean value = Boolean.parseBoolean(ctx.BOOL().getText());
        BOOL expression = new BOOL(value);
        expression.setLineNumber(this.getLineNumber(ctx));
        return expression;
    }
    
    @Override
    public ID visitIdentifierExpression(@NotNull QLParser.IdentifierExpressionContext ctx) {
        String name = ctx.ID().getText();
        ID identifier = new ID(name);
        identifier.setLineNumber(this.getLineNumber(ctx));
        return identifier;
    }

    @Override
    public STRING visitStringExpression(@NotNull QLParser.StringExpressionContext ctx) {
        String value = ctx.STRING().getText();
        STRING expression = new STRING(value);
        expression.setLineNumber(this.getLineNumber(ctx));
        return expression;
    }
}