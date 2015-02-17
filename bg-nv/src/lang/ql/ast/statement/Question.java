package lang.ql.ast.statement;

import lang.ql.semantics.Visitor;

/**
 * Created by bore on 09/02/15.
 */
public class Question extends Statement
{
    private String id;
    private QuestionType questionType;
    private String text;

    public Question(String id, QuestionType questionType, String text)
    {
        this.id = id;
        this.questionType = questionType;
        this.text = text;
    }

    public String getId()
    {
        return this.id;
    }

    public QuestionType getQuestionType()
    {
        return this.questionType;
    }

    public String getText()
    {
        return this.text;
    }

    public void accept(Visitor visitor)
    {
        visitor.visit(this);
    }
}
