package AST;
import AST.KLQNodes.*;
import AST.KLQNodes.Number;
import org.antlr.v4.runtime.misc.NotNull;
import parser.*;

/**
 * Created by juriaan on 16-2-15.
 */
public class ParseTreeConverter extends KLQBaseVisitor<Node>{
    private Questionnaire ast = new Questionnaire();

    @Override
    public Node visitUncondQuestion(@NotNull KLQParser.UncondQuestionContext ctx) {
        Question question;

        if(ctx.answerSet() == null){
            question = new Question(ctx.id.getText(), ctx.type.getText(), ctx.text.getText());
        }
        else {
            Node child = visit(ctx.answerSet());
            question = new ComputedQuestion(ctx.id.getText(), ctx.type.getText(), ctx.text.getText());
            question.getChildren().add(child);
        }

        ast.getChildren().add(question);
        return question;
    }

//    @Override
//    public Node visitDate(KLQParser.DateContext ctx) {
//        System.out.println(ctx.Date().getText());
//        return super.visitDate(ctx);
//    }

    @Override
    public Node visitNumber(KLQParser.NumberContext ctx) {
        Number number = new Number(Double.valueOf(ctx.Number().getText()));
        return number;
    }

//    @Override
//    public Node visitMulDiv(KLQParser.MulDivContext ctx) {
//        return super.visitMulDiv(ctx);
//    }

    public Questionnaire getAst() {
        return ast;
    }
}