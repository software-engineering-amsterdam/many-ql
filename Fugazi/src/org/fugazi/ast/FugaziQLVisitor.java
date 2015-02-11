package org.fugazi.ast;

import org.antlr.v4.runtime.misc.NotNull;
import org.fugazi.ast.ASTNode.ASTNode;
import org.fugazi.ast.Expression.*;
import org.fugazi.ast.Literals.ID;
import org.fugazi.ast.Literals.NUMBER;
import org.fugazi.ast.Literals.STRING;
import org.fugazi.ast.Statement.IfStatement;
import org.fugazi.ast.Statement.QuestionStatement;
import org.fugazi.ast.Statement.ComputedQuestionStatement;
import org.fugazi.ast.Statement.Statement;
import org.fugazi.ast.Type.BoolType;
import org.fugazi.ast.Type.IntType;
import org.fugazi.ast.Type.MoneyType;
import org.fugazi.ast.Type.Type;
import org.fugazi.parser.QLBaseVisitor;
import org.fugazi.parser.QLParser;
import org.fugazi.ast.Form.Form;

import java.util.ArrayList;

/*
reference to undefined questions
duplicate question declarations with different types
conditions that are not of the type boolean
operands of invalid type to operators
cyclic dependencies between questions
duplicate labels (warning)
*/

/*
WHY VISITOR?
1. Each visit can return an AST node.
2. Build our ASt.
*/

public class FugaziQLVisitor extends QLBaseVisitor<ASTNode> {

    /**
     * =======================
     * Form
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
        System.out.print("FORM: " + form.getName());

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
        Expression condition = (Expression) ctx.expression().accept(this); // TODO Accept the QL Visitor of the expressions
        
        // Get the body statements.
        ArrayList<Statement> statements = new ArrayList<Statement>();

        // Add the inner if statements.
        for (QLParser.IfStatementContext statement : ctx.ifStatement()) {
            Statement stat = (Statement) statement.accept(this);    // Accept the QL Visitor of the ifStatement
            statements.add(stat);
        }

        // Add the inner question declarations.
        for (QLParser.QuestionDeclarationContext statement : ctx.questionDeclaration()) {
            Statement stat = (Statement) statement.accept(this);    // Accept the QL Visitor of the statement
            statements.add(stat);
        }

        // Create an if Statement
        IfStatement ifStatement = new IfStatement(condition, statements);
        System.out.println("CONDITION: " + ctx.expression().getText());

        return ifStatement;
    }

    @Override
    public QuestionStatement visitNoAssignmentQuestion(@NotNull QLParser.NoAssignmentQuestionContext ctx) {
        
        Type type = (Type) ctx.type().accept(this); 

        ID identifier = new ID(ctx.ID().getText());

        // TODO: Literal? : STRING label = new STRING(ctx.STRING().getText());
        //STRING label = new STRING(ctx.STRING().getText());
        String label = ctx.STRING().getText().toString();

        QuestionStatement question = new QuestionStatement(type, label, identifier);
        System.out.println("LABEL: " + label + " ");

        return question;
    }

    @Override
    public ComputedQuestionStatement visitAssignmentQuestion(@NotNull QLParser.AssignmentQuestionContext ctx) {
        
        Type type = (Type) ctx.type().accept(this);

        ID identifier = new ID(ctx.ID().getText());

        // TODO: Literal? : STRING label = new STRING(ctx.STRING().getText());
        String label = ctx.STRING().getText();

        Expression expression = (Expression) ctx.expression().accept(this); // TODO Accept the QL Visitor of the expressions
        
        ComputedQuestionStatement question = new ComputedQuestionStatement(type, label, identifier, expression);
        System.out.println("LABEL: " + label + " ");
        
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

    @Override public MoneyType visitMoneyType(@NotNull QLParser.MoneyTypeContext ctx) {
        System.out.print("TYPE: " + "Money ");
        return new MoneyType();
    }

    @Override public IntType visitIntType(@NotNull QLParser.IntTypeContext ctx) {
        System.out.print("TYPE: " + "Int ");
        return new IntType();
    }

    /**
     * =======================
     * Expressions
     * =======================
     */
    // TODO: Think of this.
    //@Override 
    // public T visitParenthesisExpression(@NotNull QLParser.ParenthesisExpressionContext ctx) { 
    // return visitChildren(ctx); 
    // }

    @Override 
    public SingleExpression visitSingleExpression(@NotNull QLParser.SingleExpressionContext ctx) {
        System.out.print("OP: " + ctx.op.getText() + " ");
        
        // Get the expression
        Expression expr = (Expression) ctx.expression().accept(this);

        // TODO: make this beautiful
        // Check the operator. 
        if (ctx.op.getText() == "!")
            return new NotExpression(expr);
        
        return null;
    }
    
    @Override
    public NumericalExpression visitMulDivExpression(@NotNull QLParser.MulDivExpressionContext ctx) {
        System.out.print("OP: " + ctx.op.getText() + " ");

        // Get the expressions
        Expression leftExpr = (Expression) ctx.expression(0).accept(this);
        Expression rightExpr = (Expression) ctx.expression(1).accept(this);

        // TODO: make this beautiful
        // Check the operator.
        if (ctx.op.getText() == "*")                        // *
            return new MulExpression(leftExpr, rightExpr);
        else if (ctx.op.getText() == "/")                   // /
            return new DivExpression(leftExpr, rightExpr);

        return null;
    }

    @Override
    public NumericalExpression visitAddSubExpression(@NotNull QLParser.AddSubExpressionContext ctx) {
        System.out.print("OP: " + ctx.op.getText() + " ");

        // Get the expressions
        Expression leftExpr = (Expression) ctx.expression().get(0).accept(this);
        Expression rightExpr = (Expression) ctx.expression().get(1).accept(this);

        // TODO: make this beautiful
        // Check the operator.
        if (ctx.op.getText() == "+")                        // +
            return new AddExpression(leftExpr, rightExpr);
        else if (ctx.op.getText() == "-")                   // -
            return new SubExpression(leftExpr, rightExpr);

        return null;
    }

    @Override
    public LogicalExpression visitLogicalOrExpression(@NotNull QLParser.LogicalOrExpressionContext ctx) {
        System.out.print("OP: || ");
        
        // Get the expressions
        Expression leftExpr = (Expression) ctx.expression().get(0).accept(this);
        Expression rightExpr = (Expression) ctx.expression().get(1).accept(this);
        
        return new OrExpression(leftExpr, rightExpr);
    }
    
    @Override
    public LogicalExpression visitLogicalAndExpression(@NotNull QLParser.LogicalAndExpressionContext ctx) {
        System.out.print("OP: && ");

        // Get the expressions
        Expression leftExpr = (Expression) ctx.expression().get(0).accept(this);
        Expression rightExpr = (Expression) ctx.expression().get(1).accept(this);

        return new AndExpression(leftExpr, rightExpr);
    }
    
    @Override
    public ComparisonExpression visitComparisonExpression(@NotNull QLParser.ComparisonExpressionContext ctx) {
        System.out.print("OP: " + ctx.op.getText() + " ");

        // Get the expressions
        Expression leftExpr = (Expression) ctx.expression().get(0).accept(this);
        Expression rightExpr = (Expression) ctx.expression().get(1).accept(this);

        // TODO: make this beautiful
        // Check the operator.
        if (ctx.op.getText() == ">")                            // >
            return new GreaterExpression(leftExpr, rightExpr);
        else if (ctx.op.getText() == ">=")                      // >=
            return new GEExpression(leftExpr, rightExpr);
        else if (ctx.op.getText() == "<")                       // <
            return new LessExpression(leftExpr, rightExpr);
        else if (ctx.op.getText() == "<=")                      // <=
            return new LEExpression(leftExpr, rightExpr);
        else if (ctx.op.getText() == "==")                      // ==
            return new EQExpression(leftExpr, rightExpr);
        else if (ctx.op.getText() == "!=")                      // !=
            return new NotEqExpression(leftExpr, rightExpr);

        return null;
    }

    /**
     * =======================
     * Literals
     * =======================
     */
    @Override
    public NUMBER visitNumberExpression(@NotNull QLParser.NumberExpressionContext ctx) {
        // TODO: is that right?
        return (NUMBER) ctx.NUMBER().accept(this); // Accept the QL Visitor of the NUMBER
    }

    @Override
    public BoolType visitBooleanExpression(@NotNull QLParser.BooleanExpressionContext ctx) {
        // TODO: is that right?
        return (BoolType) ctx.BOOLEAN().accept(this); // Accept the QL Visitor of the BOOLEAN
    }
    
    @Override
    public ID visitIdentifierExpression(@NotNull QLParser.IdentifierExpressionContext ctx) {
        // TODO: is that right?
        return (ID) ctx.ID().accept(this); // Accept the QL Visitor of the ID
    }

    
}
