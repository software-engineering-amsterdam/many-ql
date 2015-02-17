package AST;
import AST.KLQNodes.*;
import org.antlr.v4.runtime.misc.NotNull;
import parser.*;

/**
 * Created by juriaan on 16-2-15.
 */
public class ParseTreeConverter extends KLQBaseVisitor<Node>{
    private Questionnaire ast = new Questionnaire();

    @Override
    public Node visitUncondQuestion(@NotNull KLQParser.UncondQuestionContext ctx) {
        Question question = new Question(ctx.id.getText(), ctx.type.getText(), ctx.text.getText());
        ast.getChildren().add(question);
        visit(ctx.answerSet());
        return question;
    }

//    @Override
//    public Node visitExpr(KLQParser.ExprContext ctx) {
//        System.out.println("been here");
//        if(ctx.St    != null) {
//            System.out.println(ctx.String().getText());
//        }
//        else if(ctx.Number() != null){
//            System.out.println(ctx.Number().getText());
//        }
//
//        return super.visitExpr(ctx);
//    }


    @Override
    public Node visitDate(KLQParser.DateContext ctx) {
        System.out.println(ctx.Date().getText());
        return super.visitDate(ctx);
    }

    @Override
    public Node visitNumber(KLQParser.NumberContext ctx) {
        System.out.println(ctx.Number().getText());
        return super.visitNumber(ctx);
    }

    @Override
    public Node visitMulDiv(KLQParser.MulDivContext ctx) {
        System.out.println("yolo");
        return super.visitMulDiv(ctx);
    }

    public Questionnaire getAst() {
        return ast;
    }
}