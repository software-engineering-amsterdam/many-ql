package com.klq.ast;
import com.klq.ast.impl.*;
import com.klq.ast.impl.expr.*;
import org.antlr.v4.runtime.misc.NotNull;
import parser.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Created by juriaan on 16-2-15.
 */
public class ParseTreeConverter extends KLQBaseVisitor<ANode>{
    private QuestionnaireNode ast = new QuestionnaireNode();

    @Override
    public ANode visitUncondQuestion(@NotNull KLQParser.UncondQuestionContext ctx) {
        QuestionNode questionNode;

        if(ctx.answerSet() == null){
            questionNode = new QuestionNode(ctx.id.getText(), ctx.type.getText(), ctx.text.getText());
        }
        else {
            ANode child = visit(ctx.answerSet());
            questionNode = new ComputedQuestionNode(ctx.id.getText(), ctx.type.getText(), ctx.text.getText(), child);
        }

        ast.getChildren().add(questionNode);
        return questionNode;
    }

    @Override
    public ANode visitDate(KLQParser.DateContext ctx) {
        String dateString = ctx.Date().getText();
        DateTimeFormatter formatter;

        //TODO Move this logic to a better location
        if(dateString.contains(".")){
            formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH);
        }
        else if(dateString.contains("/")){
            formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
        }
        else{
            formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
        }

        DateNode dateNode = new DateNode(LocalDate.parse(dateString, formatter));
        return dateNode;
    }

    @Override
    public ANode visitNumber(KLQParser.NumberContext ctx) {
        NumberNode numberNode = new NumberNode(Double.valueOf(ctx.Number().getText()));
        return numberNode;
    }

    @Override
    public ANode visitString(KLQParser.StringContext ctx) {
        StringNode stringNode = new StringNode(ctx.String().getText());
        return stringNode;
    }

    @Override
    public ANode visitAddSub(KLQParser.AddSubContext ctx) {
        ANode leftChild = visit(ctx.expr(0));
        ANode rightChild = visit(ctx.expr(1));
        ANode node;

        if(ctx.operator.getType() == KLQParser.ADD) {
            node = new AddNode(leftChild, rightChild);
        }
        else{
            node = new SubtractNode(leftChild, rightChild);
        }
        return node;
    }

    @Override
    public ANode visitMulDiv(KLQParser.MulDivContext ctx) {
        ANode leftChild = visit(ctx.expr(0));
        ANode rightChild = visit(ctx.expr(1));
        ANode node;

        if(ctx.operator.getType() == KLQParser.MUL) {
            node = new MultiplyNode(leftChild, rightChild);
        }
        else{
            node = new DivideNode(leftChild, rightChild);
        }
        return node;
    }

    @Override
    public ANode visitParens(KLQParser.ParensContext ctx) {
        return visit(ctx.expr());
    }

    public QuestionnaireNode getAst() {
        return ast;
    }
}