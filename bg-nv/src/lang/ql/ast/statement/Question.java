package lang.ql.ast.statement;

import lang.ql.ast.AstNode;
import lang.ql.ast.expression.Expression;

import java.util.List;

/**
 * Created by bore on 09/02/15.
 */
public class Question extends Statement
{
    private String id;
    private QuestionType type;
    private String text;
    private Expression expression;

    public Question(String id, QuestionType type, String questionText, Expression expression)
    {
        this.id = id;
        this.type = type;
        this.text = questionText;
        this.expression = expression;
    }
}
