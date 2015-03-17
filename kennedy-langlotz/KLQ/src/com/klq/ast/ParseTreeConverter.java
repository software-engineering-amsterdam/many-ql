package com.klq.ast;

import com.klq.ast.impl.ANode;
import com.klq.ast.impl.Location;
import com.klq.ast.impl.Type;
import com.klq.ast.impl.stmt.*;
import com.klq.ast.impl.expr.AExpression;
import com.klq.ast.impl.expr.ExpressionUtil;
import com.klq.ast.impl.expr.bool.*;
import com.klq.ast.impl.expr.literal.DateNode;
import com.klq.ast.impl.expr.literal.IdentifierNode;
import com.klq.ast.impl.expr.literal.NumberNode;
import com.klq.ast.impl.expr.literal.StringNode;
import com.klq.ast.impl.expr.math.AddNode;
import com.klq.ast.impl.expr.math.DivideNode;
import com.klq.ast.impl.expr.math.MultiplyNode;
import com.klq.ast.impl.expr.math.SubtractNode;
import com.klq.ast.impl.value.DateValue;
import com.klq.parser.KLQBaseVisitor;
import com.klq.parser.KLQParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by juriaan on 16-2-15.
 */
public class ParseTreeConverter extends KLQBaseVisitor<ANode> {
    private File file;

    public ParseTreeConverter(File file) {
        this.file = file;
    }

    /*==================================================================================================================
        Statements
        ==================================================================================================================*/
    @Override
    public ANode visitQuestionnaire(KLQParser.QuestionnaireContext ctx) {
        QuestionnaireNode ast = new QuestionnaireNode(formatLocation(ctx));

        for(KLQParser.QuestionContext question : ctx.question()){
            ast.getChildren().add((AStatementNode) visit(question));
        }
        return ast;
    }

    @Override
    public ANode visitUncondQuestion(KLQParser.UncondQuestionContext ctx) {
        QuestionNode questionNode;
        IdentifierNode id = new IdentifierNode(ctx.id.getText());

        if(ctx.expr() == null){
            questionNode = new QuestionNode(id, ctx.type.getText(), stripQuotes(ctx.text.getText()), formatLocation(ctx));
        } else {
            AExpression computedAnswer = (AExpression) visit(ctx.expr());
            questionNode = new ComputedQuestionNode(id, ctx.type.getText(), stripQuotes(ctx.text.getText()), computedAnswer, formatLocation(ctx));
        }
        return questionNode;
    }

    @Override
    public ANode visitCondQuestion(KLQParser.CondQuestionContext ctx) {
        AExpression condition = (AExpression) visit(ctx.expr());
        ArrayList<AStatementNode> body = new ArrayList<AStatementNode>();

        for(KLQParser.QuestionContext question : ctx.question()){
            body.add((AStatementNode) visit(question));
        }

        return new ConditionalNode(condition, body, formatLocation(ctx));
    }

    /*==================================================================================================================
        Primitives
    ==================================================================================================================*/
    @Override
    public ANode visitDate(KLQParser.DateContext ctx) {
        String dateString = ctx.Date().getText();

        DateValue date = (DateValue) ExpressionUtil.createTerminalFromString(Type.DATE, dateString);

        DateNode dateNode = new DateNode(date.getValue(), formatLocation(ctx));
        return dateNode;
    }

    @Override
    public ANode visitNumber(KLQParser.NumberContext ctx) {
        BigDecimal value = new BigDecimal(Double.valueOf(ctx.Number().getText()));
        NumberNode numberNode = new NumberNode(value, formatLocation(ctx));
        return numberNode;
    }

    @Override
    public ANode visitString(KLQParser.StringContext ctx) {
        StringNode stringNode = new StringNode(stripQuotes(ctx.String().getText()), formatLocation(ctx));
        return stringNode;
    }

    /*==================================================================================================================
    Expressions
    ==================================================================================================================*/
    @Override
    public ANode visitId(KLQParser.IdContext ctx) {
        return new IdentifierNode(ctx.QuestionId().getText(), formatLocation(ctx));
    }

    @Override
    public ANode visitAddSub(KLQParser.AddSubContext ctx) {
        AExpression leftChild = (AExpression)(visit(ctx.expr(0)));
        AExpression rightChild = (AExpression)(visit(ctx.expr(1)));
        ANode node;

        if(ctx.operator.getType() == KLQParser.ADD) {
            node = new AddNode(leftChild, rightChild, formatLocation(ctx));
        }
        else{
            node = new SubtractNode(leftChild, rightChild, formatLocation(ctx));
        }
        return node;
    }

    @Override
    public ANode visitMulDiv(KLQParser.MulDivContext ctx) {
        AExpression leftChild = (AExpression)(visit(ctx.expr(0)));
        AExpression rightChild = (AExpression)(visit(ctx.expr(1)));
        ANode node;

        if(ctx.operator.getType() == KLQParser.MUL) {
            node = new MultiplyNode(leftChild, rightChild, formatLocation(ctx));
        }
        else{
            node = new DivideNode(leftChild, rightChild, formatLocation(ctx));
        }
        return node;
    }

    @Override
    public ANode visitComparators(KLQParser.ComparatorsContext ctx) {
        AExpression leftChild = (AExpression)(visit(ctx.expr(0)));
        AExpression rightChild = (AExpression)(visit(ctx.expr(1)));

        switch(ctx.operator.getType()){
            case KLQParser.GT: return new GreaterThanNode(leftChild, rightChild, formatLocation(ctx));
            case KLQParser.GE: return new GreaterEqualsNode(leftChild, rightChild, formatLocation(ctx));
            case KLQParser.LT: return new LessThanNode(leftChild, rightChild, formatLocation(ctx));
            case KLQParser.LE: return new LessEqualsNode(leftChild, rightChild, formatLocation(ctx));
            case KLQParser.EQ: return new EqualsNode(leftChild, rightChild, formatLocation(ctx));
            case KLQParser.NEQ: return new NotEqualsNode(leftChild, rightChild, formatLocation(ctx));
            default: return null;
        }
    }

    @Override
    public ANode visitOr(KLQParser.OrContext ctx) {
        AExpression leftChild = (AExpression)(visit(ctx.expr(0)));
        AExpression rightChild = (AExpression)(visit(ctx.expr(1)));

        return new OrNode(leftChild, rightChild, formatLocation(ctx));
    }

    @Override
    public ANode visitAnd(KLQParser.AndContext ctx) {
        AExpression leftChild = (AExpression)(visit(ctx.expr(0)));
        AExpression rightChild = (AExpression)(visit(ctx.expr(1)));

        return new AndNode(leftChild, rightChild, formatLocation(ctx));
    }

    @Override
    public ANode visitParens(KLQParser.ParensContext ctx) {
        return visit(ctx.expr());
    }

    private String stripQuotes(String s) {
        if ( s==null || s.charAt(0)!='"' ) return s;
        return s.substring(1, s.length() - 1);
    }

    private Location formatLocation(ParserRuleContext ctx){
        Token tokenStart = ctx.getStart();
        Token tokenEnd = ctx.getStop();

        return new Location(file.getName(),
            tokenStart.getStartIndex(),
            tokenStart.getStopIndex() - tokenStart.getStartIndex(),
            tokenStart.getLine(),
            tokenStart.getCharPositionInLine(),
            tokenEnd.getLine(),
            tokenEnd.getCharPositionInLine());
    }
}