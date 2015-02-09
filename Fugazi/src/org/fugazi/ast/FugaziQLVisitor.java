package org.fugazi.ast;

import org.antlr.v4.runtime.misc.NotNull;
import org.fugazi.parser.QLBaseVisitor;
import org.fugazi.parser.QLParser;

// TODO
public class FugaziQLVisitor extends QLBaseVisitor<Integer> {

    @Override
    public Integer visitForm(@NotNull QLParser.FormContext ctx) {
        
        System.out.print("Form name: " + ctx.ID());
        return 0;
    }

    @Override
    public Integer visitStat(@NotNull QLParser.StatContext ctx) {
        return 0;
    }

    @Override
    public Integer visitIf_statement(@NotNull QLParser.If_statementContext ctx) {
        return 0;
    }

    @Override
    public Integer visitQuestionDecl(@NotNull QLParser.QuestionDeclContext ctx) {
        return 0;
    }

    @Override
    public Integer visitType(@NotNull QLParser.TypeContext ctx) {
        return 0;
    }

    @Override
    public Integer visitExpression(@NotNull QLParser.ExpressionContext ctx) {
        return 0;
    }

    @Override
    public Integer visitLogical_expression(@NotNull QLParser.Logical_expressionContext ctx) {
        return 0;
    }
}
