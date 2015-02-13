package lang.ql.ast.statement;

import lang.ql.ast.expression.Expression;
import lang.ql.ast.visitor.Visitor;

/**
 * Created by bore on 09/02/15.
 */
public class Question extends Statement
{
    private String id;
    private QuestionType questionType;
    private String text;
    private Expression expression;

    public Question(String id, QuestionType questionType, String text, Expression expression)
    {
        this.id = id;
        this.questionType = questionType;
        this.text = text;
        this.expression = expression;
    }

    public String getId()
    {
        return this.id;
    }

    public QuestionType getQuestionType()
    {
        return this.questionType;
    }

    public void visit(Visitor visitor) { visitor.visit(this); }
}
