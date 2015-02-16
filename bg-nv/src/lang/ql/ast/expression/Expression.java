package lang.ql.ast.expression;

import lang.ql.ast.AstNode;
import lang.ql.ast.statement.QuestionType;
import lang.ql.ast.visitor.Visitor;

/**
 * Created by bore on 09/02/15.
 */
public abstract class Expression extends AstNode
{
    private QuestionType type;

    public QuestionType getType()
    {
        return this.type;
    }

    public void setType(QuestionType type)
    {
        this.type = type;
    }

    public void visit(Visitor visitor)
    {
        visitor.visit(this);
    }
}
