package org.fugazi.ast;

import org.antlr.v4.runtime.misc.NotNull;
import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.expression.comparison.*;
import org.fugazi.ast.expression.logical.And;
import org.fugazi.ast.expression.logical.Logical;
import org.fugazi.ast.expression.logical.Or;
import org.fugazi.ast.expression.numerical.*;
import org.fugazi.ast.expression.unary.Negative;
import org.fugazi.ast.expression.unary.Not;
import org.fugazi.ast.expression.unary.Positive;
import org.fugazi.ast.expression.unary.Unary;
import org.fugazi.ast.form.Form;
import org.fugazi.ast.expression.literal.ID;
import org.fugazi.ast.expression.literal.NUMBER;
import org.fugazi.ast.expression.literal.STRING;
import org.fugazi.ast.statement.ComputedQuestion;
import org.fugazi.ast.statement.IfStatement;
import org.fugazi.ast.statement.Question;
import org.fugazi.ast.statement.Statement;
import org.fugazi.ast.type.*;
import org.fugazi.parser.QLBaseVisitor;
import org.fugazi.parser.QLParser;

import java.util.ArrayList;

public class FugaziQLVisitor extends QLBaseVisitor<AbstractASTNode> {

    /**
     * =======================
     * form
     * =======================
     */
    
    @Override
    public Form visitForm(@NotNull QLParser.FormContext ctx) {
        
        // Get form's name.
        String formName = ctx.ID().getText();

        // Get the body statements.
        ArrayList<Statement> formStatements = new ArrayList<Statement>();

        for (QLParser.StatementContext statement : ctx.statement()) {
            Statement stat = (Statement) statement.accept(this);    // Accept the QL Visitor of the statement
            formStatements.add(stat);
        }

        // Create the form.
        Form form = new Form(formName, formStatements);
        System.out.println("FORM: " + form.getName());

        return form;
    }

    /**
     * =======================
     * Statements
     * =======================
     */
    
    @Override
    public IfStatement visitIfStatement(@NotNull QLParser.IfStatementContext ctx) {
        
        // Get the condition.
        Expression condition = (Expression) ctx.expression().accept(this);
        
        // Get the body statements.
        ArrayList<Statement> statements = new ArrayList<Statement>();

        // Add the statements.
        for (QLParser.StatementContext statement : ctx.statement()) {
            Statement stat = (Statement) statement.accept(this);    // Accept the QL Visitor of the statement
            statements.add(stat);
        }

        // Create an if statement
        IfStatement ifStatement = new IfStatement(condition, statements);
        System.out.println("CONDITION: " + ctx.expression().getText());

        return ifStatement;
    }

    @Override
    public Question visitNoAssignmentQuestion(@NotNull QLParser.NoAssignmentQuestionContext ctx) {
        
        Type type = (Type) ctx.type().accept(this); 

        ID identifier = new ID(ctx.ID().getText());

        // TODO: Which is better?
        // Literal? : STRING label = new STRING(ctx.STRING().getText());
        STRING grammarLabel = new STRING(ctx.STRING().getText());
        String label = grammarLabel.toString();

        Question question = new Question(type, label, identifier);
        System.out.println("LABEL: " + label + " ID: " + identifier + " ");

        return question;
    }

    @Override
    public ComputedQuestion visitAssignmentQuestion(@NotNull QLParser.AssignmentQuestionContext ctx) {
        
        Type type = (Type) ctx.type().accept(this);

        ID identifier = new ID(ctx.ID().getText());

        STRING grammarLabel = new STRING(ctx.STRING().getText());
        String label = grammarLabel.toString();

        Expression expression = (Expression) ctx.expression().accept(this);

        ComputedQuestion question = new ComputedQuestion(type, label, identifier, expression);
        System.out.println("LABEL: " + label + " ID: " + identifier + " ");
        
        return question;
    }

    /** 
     * =======================
     * Types 
     * =======================
     */
    
    @Override 
    public BoolType visitBoolType(@NotNull QLParser.BoolTypeContext ctx) {
        System.out.print("TYPE: " + "Bool ");
        return new BoolType();
    }

    @Override public IntType visitIntType(@NotNull QLParser.IntTypeContext ctx) {
        System.out.print("TYPE: " + "Int ");
        return new IntType();
    }

    @Override 
    public StringType visitStringType(@NotNull QLParser.StringTypeContext ctx) { 
        System.out.print("TYPE: " + "String ");
        return new StringType();
    }

    /**
     * =======================
     * Expressions
     * =======================
     */
    @Override
    public Expression visitParenthesisExpression(@NotNull QLParser.ParenthesisExpressionContext ctx) {
        System.out.print("PARENTHESIS: " + ctx.expression().getText() + " ");
    return (Expression) ctx.expression().accept(this);
    }

    @Override 
    public Unary visitUnaryExpression(@NotNull QLParser.UnaryExpressionContext ctx) {
        System.out.print("OP: " + ctx.op.getText() + " ");
        
        // Get the expression
        Expression expr = (Expression) ctx.expression().accept(this);

        // Check the operator. 
        if (ctx.op.getText().equals("!"))
            return new Not(expr);
        else if (ctx.op.getText().equals("-"))
            return new Negative(expr);
        else if (ctx.op.getText().equals("+"))
            return new Positive(expr);
        
        return null;
    }
    
    @Override
    public Numerical visitMulDivExpression(@NotNull QLParser.MulDivExpressionContext ctx) {
        System.out.print("OP: " + ctx.op.getText() + " ");

        // Get the expressions
        Expression leftExpr = (Expression) ctx.expression(0).accept(this);
        Expression rightExpr = (Expression) ctx.expression(1).accept(this);

        // Check the operator.
        if (ctx.op.getText().equals("*"))                        // *
            return new Mul(leftExpr, rightExpr);
        else if (ctx.op.getText().equals("/"))                   // /
            return new Div(leftExpr, rightExpr);

        return null;
    }

    @Override
    public Numerical visitAddSubExpression(@NotNull QLParser.AddSubExpressionContext ctx) {
        System.out.print("OP: " + ctx.op.getText() + " ");

        // Get the expressions
        Expression leftExpr = (Expression) ctx.expression().get(0).accept(this);
        Expression rightExpr = (Expression) ctx.expression().get(1).accept(this);

        // Check the operator.
        if (ctx.op.getText().equals("+"))                        // +
            return new Add(leftExpr, rightExpr);
        else if (ctx.op.getText().equals("-"))                  // -
            return new Sub(leftExpr, rightExpr);

        return null;
    }

    @Override
    public Logical visitLogicalOrExpression(@NotNull QLParser.LogicalOrExpressionContext ctx) {
        System.out.print("OP: || ");
        
        // Get the expressions
        Expression leftExpr = (Expression) ctx.expression().get(0).accept(this);
        Expression rightExpr = (Expression) ctx.expression().get(1).accept(this);
        
        return new Or(leftExpr, rightExpr);
    }
    
    @Override
    public Logical visitLogicalAndExpression(@NotNull QLParser.LogicalAndExpressionContext ctx) {
        System.out.print("OP: && ");

        // Get the expressions
        Expression leftExpr = (Expression) ctx.expression().get(0).accept(this);
        Expression rightExpr = (Expression) ctx.expression().get(1).accept(this);

        return new And(leftExpr, rightExpr);
    }
    
    @Override
    public Comparison visitComparisonExpression(@NotNull QLParser.ComparisonExpressionContext ctx) {
        System.out.print("OP: " + ctx.op.getText() + " ");

        // Get the expressions
        Expression leftExpr = (Expression) ctx.expression().get(0).accept(this);
        Expression rightExpr = (Expression) ctx.expression().get(1).accept(this);

        // Check the operator.
        if (ctx.op.getText().equals(">"))                            // >
            return new Greater(leftExpr, rightExpr);
        else if (ctx.op.getText().equals(">="))                      // >=
            return new GE(leftExpr, rightExpr);
        else if (ctx.op.getText().equals("<"))                       // <
            return new Less(leftExpr, rightExpr);
        else if (ctx.op.getText().equals("<="))                      // <=
            return new LE(leftExpr, rightExpr);
        else if (ctx.op.getText().equals("=="))                      // ==
            return new EQ(leftExpr, rightExpr);
        else if (ctx.op.getText().equals("!="))                      // !=
            return new NotEq(leftExpr, rightExpr);

        return null;
    }

    /**
     * =======================
     * literals
     * =======================
     */
    @Override
    public NUMBER visitIntExpression(@NotNull QLParser.IntExpressionContext ctx) {
        System.out.print(" " + ctx.INT().getText() + " ");
        return (NUMBER) ctx.INT().accept(this); // Accept the QL Visitor of the INT
    }

    @Override
    public BoolType visitBooleanExpression(@NotNull QLParser.BooleanExpressionContext ctx) {
        System.out.print(" " + ctx.BOOLEAN().getText() + " ");
        return (BoolType) ctx.BOOLEAN().accept(this); // Accept the QL Visitor of the BOOLEAN
    }
    
    @Override
    public ID visitIdentifierExpression(@NotNull QLParser.IdentifierExpressionContext ctx) {
        System.out.print(" " + ctx.ID().getText() + " ");
        return (ID) ctx.ID().accept(this); // Accept the QL Visitor of the ID
    }
}
