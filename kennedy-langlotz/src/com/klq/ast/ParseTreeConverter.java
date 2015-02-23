package com.klq.ast;
import com.klq.ast.impl.*;
import com.klq.ast.impl.expr.*;
import com.klq.ast.impl.expr.comp.GreaterThanNode;
import com.klq.ast.impl.expr.math.AddNode;
import com.klq.ast.impl.expr.math.MultiplyNode;
import com.klq.ast.impl.expr.math.NumberNode;
import com.klq.ast.impl.expr.math.SubtractNode;
import org.antlr.v4.runtime.misc.NotNull;
import parser.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by juriaan on 16-2-15.
 */
public class ParseTreeConverter extends KLQBaseVisitor<ANode>{
    /*==================================================================================================================
    Statements
     ==================================================================================================================*/

    @Override
    public ANode visitQuestionnaire(KLQParser.QuestionnaireContext ctx) {
        QuestionnaireNode ast = new QuestionnaireNode();

        for(KLQParser.QuestionContext question : ctx.question()){
            ast.getChildren().add(visit(question));
        }
        return ast;
    }

    @Override
    public ANode visitUncondQuestion(KLQParser.UncondQuestionContext ctx) {
        QuestionNode questionNode;

        if(ctx.answerOptions() == null){
            questionNode = new QuestionNode(ctx.id.getText(), ctx.type.getText(), ctx.text.getText());
        }
        else {
            ANode child = visit(ctx.answerOptions());
            questionNode = new ComputedQuestionNode(ctx.id.getText(), ctx.type.getText(), ctx.text.getText(), child);
        }
        return questionNode;
    }

    @Override
    public ANode visitCondQuestion(KLQParser.CondQuestionContext ctx) {
        ANode condition = visit(ctx.expr());
        ArrayList<ANode> body = new ArrayList<ANode>();

        for(KLQParser.QuestionContext question : ctx.question()){
            body.add(visit(question));
        }

        return new ConditionalNode(condition, body);
    }

    /*==================================================================================================================
        Primitives
         ==================================================================================================================*/
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

    /*==================================================================================================================
    Expressions
     ==================================================================================================================*/
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
    public ANode visitComparators(@NotNull KLQParser.ComparatorsContext ctx) {
        ANode leftChild = visit(ctx.expr(0));
        ANode rightChild = visit(ctx.expr(1));
        ANode node;

        if(ctx.operator.getType() == KLQParser.GT) {
            node = new GreaterThanNode(leftChild, rightChild);
        }
        else{
            node = new GreaterThanNode(leftChild, rightChild);
        }
        return node;
    }

    @Override
    public ANode visitParens(KLQParser.ParensContext ctx) {
        return visit(ctx.expr());
    }
}