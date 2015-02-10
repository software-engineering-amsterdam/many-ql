package lang.ql.ast.statement;

import lang.ql.ast.AstNode;
import lang.ql.ast.expression.Expression;

import java.util.List;

/**
 * Created by bore on 09/02/15.
 */
public class Question extends Statement
{
    public String id;
    public QuestionType questionType;
    public String text;
    public Expression expression;

    public Question(String id, QuestionType questionType, String text, Expression expression) {
        this.id = id;
        this.questionType = questionType;
        this.text = text;
        this.expression = expression;
    }

}
