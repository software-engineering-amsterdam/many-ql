package org.fugazi.ast;

import org.antlr.v4.runtime.misc.NotNull;
import org.fugazi.ast.ASTNode.ASTNode;
import org.fugazi.ast.Expression.GEExpression;
import org.fugazi.ast.Expression.LogicalExpression;
import org.fugazi.ast.Expression.Expression;
import org.fugazi.ast.Literals.ID;
import org.fugazi.ast.Literals.STRING;
import org.fugazi.ast.Statement.IfStatement;
import org.fugazi.ast.Statement.QuestionStatement;
import org.fugazi.ast.Statement.ComputedQuestionStatement;
import org.fugazi.ast.Statement.Statement;
import org.fugazi.ast.Type.Type;
import org.fugazi.parser.QLBaseVisitor;
import org.fugazi.parser.QLParser;
import org.fugazi.ast.Form.Form;

import java.util.ArrayList;

// TODO

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
 */

public class FugaziQLVisitor extends QLBaseVisitor<ASTNode> {

    @Override
    public Form visitForm(@NotNull QLParser.FormContext ctx) {
        //TODO
        
        // Get form's name.
        String formName = ctx.ID().getText();

        ArrayList<Statement> formStatements = new ArrayList<Statement>();

        for (QLParser.StatementContext statement : ctx.statement()) {
            Statement stat = (Statement) statement.accept(this);    // Accept the QL Visitor of the statement
            formStatements.add(stat);
        }

        // Create the form.
        Form form = new Form(formName, formStatements);
        System.out.println(form.getName());

        return form;
    }

    @Override
    public IfStatement visitIfStatement(@NotNull QLParser.IfStatementContext ctx) {
        //TODO
        
        // Get the condition
        LogicalExpression condition = (LogicalExpression) ctx.logicalExpression().accept(this); // TODO Accept the QL Visitor of the logicalExpression
        
        // Get the statements
        ArrayList<Statement> statements = new ArrayList<Statement>();

        for (QLParser.IfStatementContext statement : ctx.ifStatement()) {
            Statement stat = (Statement) statement.accept(this);    // Accept the QL Visitor of the statement
            statements.add(stat);
        }

        // Create an if Statement
        IfStatement ifStatement = new IfStatement(condition, statements);

//        for (Statement statement : ifStatement.getStatements()) {
//            System.out.println(statement.toString());
//        }

        return ifStatement;
    }

    @Override
    public QuestionStatement visitNoAssignmentQuestion(@NotNull QLParser.NoAssignmentQuestionContext ctx) {
        
        Type type = (Type) ctx.type().accept(this);

        ID identifier = new ID(ctx.ID().getText());

        //STRING label = new STRING(ctx.STRING().getText());
        String label = ctx.STRING().getText().toString();

        QuestionStatement question = new QuestionStatement(type, label, identifier);
        System.out.println(label);

        return question;
    }

    @Override
    public ComputedQuestionStatement visitAssignmentQuestion(@NotNull QLParser.AssignmentQuestionContext ctx) {
        //TODO

        Type type = (Type) ctx.type().accept(this);

        ID identifier = new ID(ctx.ID().getText());

        //STRING label = new STRING(ctx.STRING().getText());
        String label = ctx.STRING().getText().toString();

        Expression expression = (Expression) ctx.numericalExpression().accept(this); // TODO Accept the QL Visitor of the numericalExpression
        
        ComputedQuestionStatement question = new ComputedQuestionStatement(type, label, identifier, expression);
        System.out.println(label);
        
        return question;
    }

    @Override 
    public LogicalExpression visitLogicalExpression(@NotNull QLParser.LogicalExpressionContext ctx) {
        // TODO
        return null;
    }
}
