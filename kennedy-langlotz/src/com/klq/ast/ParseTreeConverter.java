package com.klq.ast;
import com.klq.ast.impl.*;
import com.klq.ast.impl.NumberNode;
import org.antlr.v4.runtime.misc.NotNull;
import parser.*;

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
            questionNode = new ComputedQuestionNodeNode(ctx.id.getText(), ctx.type.getText(), ctx.text.getText());
            questionNode.getChildren().add(child);
        }

        ast.getChildren().add(questionNode);
        return questionNode;
    }

//    @Override
//    public Node visitDate(KLQParser.DateContext ctx) {
//        System.out.println(ctx.Date().getText());
//        return super.visitDate(ctx);
//    }

    @Override
    public ANode visitNumber(KLQParser.NumberContext ctx) {
        NumberNode numberNode = new NumberNode(Double.valueOf(ctx.Number().getText()));
        return numberNode;
    }

//    @Override
//    public Node visitMulDiv(KLQParser.MulDivContext ctx) {
//        return super.visitMulDiv(ctx);
//    }

    public QuestionnaireNode getAst() {
        return ast;
    }
}