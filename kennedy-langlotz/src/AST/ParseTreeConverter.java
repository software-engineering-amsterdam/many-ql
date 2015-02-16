package AST;
import AST.KLQNodes.QuestionNode;
import AST.KLQNodes.QuestionnaireNode;
import org.antlr.v4.runtime.misc.NotNull;
import parser.*;

/**
 * Created by juriaan on 16-2-15.
 */
public class ParseTreeConverter extends KLQBaseVisitor<Node>{
    private QuestionnaireNode ast = new QuestionnaireNode();

    @Override
    public Node visitQuestion(KLQParser.QuestionContext ctx) {
        QuestionNode question = new QuestionNode(ctx.id.getText(), ctx.type.getText(), ctx.text.getText(), true);
        ast.getChildren().add(question);
        return question;
    }

    public QuestionnaireNode getAst() {
        return ast;
    }
}
