package lang.ql.ast.statement;

import lang.ql.ast.AstNode;
import lang.ql.ast.expression.Expression;
import lang.ql.ast.visitor.Visitor;

import java.util.ArrayList;
import java.util.Collections;

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

    public void visit(Visitor visitor) { visitor.visit(this); }

    public void print(Visitor visitor) { visitor.visit(this); }

    public Iterable<? extends AstNode> getChildren()
    {
        return Collections.emptyList();
    }
}
