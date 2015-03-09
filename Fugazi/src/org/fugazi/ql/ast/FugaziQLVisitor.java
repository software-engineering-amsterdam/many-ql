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
import org.fugazi.ql.ast.type.BoolType;
import org.fugazi.ql.ast.type.IntType;
import org.fugazi.ql.ast.type.StringType;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.ql.parser.QLBaseVisitor;
import org.fugazi.ql.parser.QLParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FugaziQLVisitor extends QLBaseVisitor<AbstractASTNode> {

    private final Map<String, Type> identifiers = new HashMap<>();

    private void addIdentifier(String _name, Type _type) {
        identifiers.put(_name, _type);
    }

    private Type getIdentifier(String _name) {
        return identifiers.containsKey(_name) ? identifiers.get(_name) : null;
    }
    
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

        return new Form(formName, formStatements, this.getLineNumber(ctx));
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

        return new IfStatement(condition, statements, this.getLineNumber(ctx));
    }

    @Override
    public Question visitNoAssignmentQuestion(@NotNull QLParser.NoAssignmentQuestionContext ctx) {
        Type type = (Type) ctx.type().accept(this);
        ID identifier = new ID(ctx.ID().getText(), type, this.getLineNumber(ctx));
        this.addIdentifier(identifier.getName(), type);

        STRING grammarLabel = new STRING(ctx.STRING().getText(), this.getLineNumber(ctx));
        String label = removeStringQuotes(grammarLabel.toString());

        return new Question(type, label, identifier, this.getLineNumber(ctx));
    }

    @Override
    public ComputedQuestion visitAssignmentQuestion(@NotNull QLParser.AssignmentQuestionContext ctx) {
        Type type = (Type) ctx.type().accept(this);
        ID identifier = new ID(ctx.ID().getText(), type, this.getLineNumber(ctx));
        this.addIdentifier(identifier.getName(), type);

        STRING grammarLabel = new STRING(ctx.STRING().getText(), this.getLineNumber(ctx));
        String label = removeStringQuotes(grammarLabel.toString());

        Expression expression = (Expression) ctx.expression().accept(this);

        return new ComputedQuestion(type, label, identifier, expression, this.getLineNumber(ctx));
    }

    /** 
     * =======================
     * Types 
     * =======================
     */
    
    @Override 
    public BoolType visitBoolType(@NotNull QLParser.BoolTypeContext ctx) {
        return new BoolType(this.getLineNumber(ctx));
    }

    @Override public IntType visitIntType(@NotNull QLParser.IntTypeContext ctx) {
        return new IntType(this.getLineNumber(ctx));
    }

    @Override 
    public StringType visitStringType(@NotNull QLParser.StringTypeContext ctx) {
        return new StringType(this.getLineNumber(ctx));
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

        if (ctx.op.getText().equals("!"))
            return new Not(expr, this.getLineNumber(ctx));

        if (ctx.op.getText().equals("-"))
            return new Negative(expr, this.getLineNumber(ctx));

        if (ctx.op.getText().equals("+"))
            return new Positive(expr, this.getLineNumber(ctx));
        
        return null;
    }
    
    @Override
    public Numerical visitMulDivExpression(@NotNull QLParser.MulDivExpressionContext ctx) {
        Expression leftExpr = (Expression) ctx.expression(0).accept(this);
        Expression rightExpr = (Expression) ctx.expression(1).accept(this);

        if (ctx.op.getText().equals("*"))
            return new Mul(leftExpr, rightExpr, this.getLineNumber(ctx));

        if (ctx.op.getText().equals("/"))
            return new Div(leftExpr, rightExpr, this.getLineNumber(ctx));

        return null;
    }

    @Override
    public Numerical visitAddSubExpression(@NotNull QLParser.AddSubExpressionContext ctx) {
        Expression leftExpr = (Expression) ctx.expression().get(0).accept(this);
        Expression rightExpr = (Expression) ctx.expression().get(1).accept(this);

        if (ctx.op.getText().equals("+"))
            return new Add(leftExpr, rightExpr, this.getLineNumber(ctx));

        if (ctx.op.getText().equals("-"))
            return new Sub(leftExpr, rightExpr, this.getLineNumber(ctx));

        return null;
    }

    @Override
    public Logical visitLogicalOrExpression(@NotNull QLParser.LogicalOrExpressionContext ctx) {
        Expression leftExpr = (Expression) ctx.expression().get(0).accept(this);
        Expression rightExpr = (Expression) ctx.expression().get(1).accept(this);
        
        return new Or(leftExpr, rightExpr, this.getLineNumber(ctx));
    }
    
    @Override
    public Logical visitLogicalAndExpression(@NotNull QLParser.LogicalAndExpressionContext ctx) {
        Expression leftExpr = (Expression) ctx.expression().get(0).accept(this);
        Expression rightExpr = (Expression) ctx.expression().get(1).accept(this);

        return new And(leftExpr, rightExpr, this.getLineNumber(ctx));
    }
    
    @Override
    public Comparison visitComparisonExpression(@NotNull QLParser.ComparisonExpressionContext ctx) {
        Expression leftExpr = (Expression) ctx.expression().get(0).accept(this);
        Expression rightExpr = (Expression) ctx.expression().get(1).accept(this);

        if (ctx.op.getText().equals(">"))
            return new Greater(leftExpr, rightExpr, this.getLineNumber(ctx));

        if (ctx.op.getText().equals(">="))
            return new GE(leftExpr, rightExpr, this.getLineNumber(ctx));

        if (ctx.op.getText().equals("<"))
            return new Less(leftExpr, rightExpr, this.getLineNumber(ctx));

        if (ctx.op.getText().equals("<="))
            return new LE(leftExpr, rightExpr, this.getLineNumber(ctx));

        if (ctx.op.getText().equals("=="))
            return new EQ(leftExpr, rightExpr, this.getLineNumber(ctx));

        if (ctx.op.getText().equals("!="))
            return new NotEq(leftExpr, rightExpr, this.getLineNumber(ctx));

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
        return new INT(value, this.getLineNumber(ctx));
    }

    @Override
    public BOOL visitBoolExpression(@NotNull QLParser.BoolExpressionContext ctx) {
        Boolean value = Boolean.parseBoolean(ctx.BOOL().getText());
        return new BOOL(value, this.getLineNumber(ctx));
    }
    
    @Override
    public ID visitIdentifierExpression(@NotNull QLParser.IdentifierExpressionContext ctx) {
        String name = ctx.ID().getText();
        Type type = this.getIdentifier(name);
        return new ID(name, type, this.getLineNumber(ctx));
    }

    @Override
    public STRING visitStringExpression(@NotNull QLParser.StringExpressionContext ctx) {
        String value = ctx.STRING().getText();
        return new STRING(value, this.getLineNumber(ctx));
    }
}