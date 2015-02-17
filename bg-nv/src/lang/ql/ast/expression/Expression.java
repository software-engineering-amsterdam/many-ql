package lang.ql.ast.expression;

import lang.ql.ast.AstNode;
import lang.ql.ast.statement.QuestionType;
import lang.ql.semantics.Visitor;

/**
 * Created by bore on 09/02/15.
 */
public abstract class Expression extends AstNode
{
    public void accept(Visitor visitor)
    {
        visitor.visit(this);
    }
}
