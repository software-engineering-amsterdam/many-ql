package org.fugazi.ast;

import org.antlr.v4.runtime.misc.NotNull;
import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.expression.comparison.*;
import org.fugazi.ast.expression.literal.BOOL;
import org.fugazi.ast.expression.literal.ID;
import org.fugazi.ast.expression.literal.INT;
import org.fugazi.ast.expression.literal.STRING;
import org.fugazi.ast.expression.logical.And;
import org.fugazi.ast.expression.logical.Logical;
import org.fugazi.ast.expression.logical.Or;
import org.fugazi.ast.expression.numerical.*;
import org.fugazi.ast.expression.unary.Negative;
import org.fugazi.ast.expression.unary.Not;
import org.fugazi.ast.expression.unary.Positive;
import org.fugazi.ast.expression.unary.Unary;
import org.fugazi.ast.form.Form;
import org.fugazi.ast.statement.ComputedQuestion;
import org.fugazi.ast.statement.IfStatement;
import org.fugazi.ast.statement.Question;
import org.fugazi.ast.statement.Statement;
import org.fugazi.ast.type.BoolType;
import org.fugazi.ast.type.IntType;
import org.fugazi.ast.type.StringType;
import org.fugazi.ast.type.Type;
import org.fugazi.parser.QLBaseVisitor;
import org.fugazi.parser.QLParser;

import java.util.ArrayList;
import java.util.HashMap;

public class FugaziQLVisitor extends QLBaseVisitor<AbstractASTNode> {

    private final HashMap<String, Type> identifiers = new HashMap<String, Type>();

    private void addIdentifier(String _name, Type _type) {
        identifiers.put(_name, _type);
    }

    private Type getIdentifier(String _name) {
        return identifiers.containsKey(_name) ? identifiers.get(_name) : null;
    }
    
    private String removeStringQuotes(String _str) {
        return _str.replaceAll("^\"|\"$", "");
    }

    /**
     * =======================
     * form
     * =======================
     */
    
    @Override
    public Form visitForm(@NotNull QLParser.FormContext ctx) {
        String formName = ctx.ID().getText();
        ArrayList<Statement> formStatements = new ArrayList<Statement>();

        for (QLParser.StatementContext statement : ctx.statement()) {
            Statement stat = (Statement) statement.accept(this);
            formStatements.add(stat);
        }

        return new Form(formName, formStatements);
    }

    /**
     * =======================
     * Statements
     * =======================
     */
    
    @Override
    public IfStatement visitIfStatement(@NotNull QLParser.IfStatementContext ctx) {
        Expression condition = (Expression) ctx.expression().accept(this);
        ArrayList<Statement> statements = new ArrayList<Statement>();

        for (QLParser.StatementContext statement : ctx.statement()) {
            Statement stat = (Statement) statement.accept(this);
            statements.add(stat);
        }

        return new IfStatement(condition, statements);
    }

    @Override
    public Question visitNoAssignmentQuestion(@NotNull QLParser.NoAssignmentQuestionContext ctx) {
        Type type = (Type) ctx.type().accept(this);
        ID identifier = new ID(ctx.ID().getText(), type);
        this.addIdentifier(identifier.getName(), type);

        STRING grammarLabel = new STRING(ctx.STRING().getText());
        String label = removeStringQuotes(grammarLabel.toString());

        return new Question(type, label, identifier);
    }

    @Override
    public ComputedQuestion visitAssignmentQuestion(@NotNull QLParser.AssignmentQuestionContext ctx) {
        Type type = (Type) ctx.type().accept(this);
        ID identifier = new ID(ctx.ID().getText(), type);
        this.addIdentifier(identifier.getName(), type);

        STRING grammarLabel = new STRING(ctx.STRING().getText());
        String label = removeStringQuotes(grammarLabel.toString());

        Expression expression = (Expression) ctx.expression().accept(this);

        return new ComputedQuestion(type, label, identifier, expression);
    }

    /** 
     * =======================
     * Types 
     * =======================
     */
    
    @Override 
    public BoolType visitBoolType(@NotNull QLParser.BoolTypeContext ctx) {
        return new BoolType();
    }

    @Override public IntType visitIntType(@NotNull QLParser.IntTypeContext ctx) {
        return new IntType();
    }

    @Override 
    public StringType visitStringType(@NotNull QLParser.StringTypeContext ctx) { 
        return new StringType();
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
            return new Not(expr);

        if (ctx.op.getText().equals("-"))
            return new Negative(expr);

        if (ctx.op.getText().equals("+"))
            return new Positive(expr);
        
        return null;
    }
    
    @Override
    public Numerical visitMulDivExpression(@NotNull QLParser.MulDivExpressionContext ctx) {
        Expression leftExpr = (Expression) ctx.expression(0).accept(this);
        Expression rightExpr = (Expression) ctx.expression(1).accept(this);

        if (ctx.op.getText().equals("*"))
            return new Mul(leftExpr, rightExpr);

        if (ctx.op.getText().equals("/"))
            return new Div(leftExpr, rightExpr);

        return null;
    }

    @Override
    public Numerical visitAddSubExpression(@NotNull QLParser.AddSubExpressionContext ctx) {
        Expression leftExpr = (Expression) ctx.expression().get(0).accept(this);
        Expression rightExpr = (Expression) ctx.expression().get(1).accept(this);

        if (ctx.op.getText().equals("+"))
            return new Add(leftExpr, rightExpr);

        if (ctx.op.getText().equals("-"))
            return new Sub(leftExpr, rightExpr);

        return null;
    }

    @Override
    public Logical visitLogicalOrExpression(@NotNull QLParser.LogicalOrExpressionContext ctx) {
        Expression leftExpr = (Expression) ctx.expression().get(0).accept(this);
        Expression rightExpr = (Expression) ctx.expression().get(1).accept(this);
        
        return new Or(leftExpr, rightExpr);
    }
    
    @Override
    public Logical visitLogicalAndExpression(@NotNull QLParser.LogicalAndExpressionContext ctx) {
        Expression leftExpr = (Expression) ctx.expression().get(0).accept(this);
        Expression rightExpr = (Expression) ctx.expression().get(1).accept(this);

        return new And(leftExpr, rightExpr);
    }
    
    @Override
    public Comparison visitComparisonExpression(@NotNull QLParser.ComparisonExpressionContext ctx) {
        Expression leftExpr = (Expression) ctx.expression().get(0).accept(this);
        Expression rightExpr = (Expression) ctx.expression().get(1).accept(this);

        if (ctx.op.getText().equals(">"))
            return new Greater(leftExpr, rightExpr);

        if (ctx.op.getText().equals(">="))
            return new GE(leftExpr, rightExpr);

        if (ctx.op.getText().equals("<"))
            return new Less(leftExpr, rightExpr);

        if (ctx.op.getText().equals("<="))
            return new LE(leftExpr, rightExpr);

        if (ctx.op.getText().equals("=="))
            return new EQ(leftExpr, rightExpr);

        if (ctx.op.getText().equals("!="))
            return new NotEq(leftExpr, rightExpr);

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
        return new INT(value);
    }

    @Override
    public BOOL visitBooleanExpression(@NotNull QLParser.BooleanExpressionContext ctx) {
        Boolean value = Boolean.parseBoolean(ctx.BOOLEAN().getText());
        return new BOOL(value);
    }
    
    @Override
    public ID visitIdentifierExpression(@NotNull QLParser.IdentifierExpressionContext ctx) {
        String name = ctx.ID().getText();
        Type type = this.getIdentifier(name);
        return new ID(name, type);
    }
}
