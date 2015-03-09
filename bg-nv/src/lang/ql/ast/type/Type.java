package lang.ql.ast.type;

import lang.ql.ast.AstNode;

/**
 * Created by bore on 17/02/15.
 */
public abstract class Type extends AstNode
{
    private String title;

    public Type(String s)
    {
        this.title = s;
    }

    public String getTitle()
    {
        return this.title;
    }

    public boolean isUndef()
    {
        return false;
    }

    public boolean isArithmetic() { return false; }

    public boolean isBool() { return false; }

    public boolean isString() { return false; }

    public Type promoteTo(Type t)
    {
        return this;
    }

    protected Type promoteInt(IntType t)
    {
        return t;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o instanceof Type)
        {
            return this.title.equals(((Type)o).title);
        }

        return false;
    }

    @Override
    public int hashCode()
    {
        return this.title.hashCode();
    }

    public abstract <T> T accept(TypeVisitor<T> visitor);
}
