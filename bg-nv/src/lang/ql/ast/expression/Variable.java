package lang.ql.ast.expression;

import lang.ql.semantics.Visitor;

/**
 * Created by bore on 09/02/15.
 */
public class Variable extends Expression
{
    private String id;

    public Variable(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return this.id;
    }

    public void accept(Visitor visitor) { visitor.visit(this); }
}
