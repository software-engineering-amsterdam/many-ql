package org.fugazi.ast;

import org.antlr.v4.runtime.misc.NotNull;
import org.fugazi.ast.ASTNode.ASTNode;
import org.fugazi.parser.QLBaseVisitor;
import org.fugazi.parser.QLParser;
import org.fugazi.ast.Form.Form;

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

        System.out.println("Creating form: " + ctx.ID());
        visitChildren(ctx);

        Form form = new Form(ctx.ID().toString());
        System.out.print(form.getName());
        return form;
    }
//
//    @Override
//    public Integer visitStatement(@NotNull QLParser.StatementContext ctx) {
//        System.out.println("Statement: " + ctx);
//        return visitChildren(ctx);
//    }
//
//    @Override
//    public Integer visitIfStatement(@NotNull QLParser.IfStatementContext ctx) {
//        System.out.println("If Statement: " + ctx);
//        return visitChildren(ctx);
//    }
//
//    @Override
//    public Integer visitQuestionDeclaration(@NotNull QLParser.QuestionDeclarationContext ctx) {
//        System.out.println("Question declaration: " + ctx);
//        return visitChildren(ctx);
//    }
//
//    @Override
//    public Integer visitType(@NotNull QLParser.TypeContext ctx) {
//        System.out.println("Type: " + ctx);
//        return visitChildren(ctx);
//    }

}
