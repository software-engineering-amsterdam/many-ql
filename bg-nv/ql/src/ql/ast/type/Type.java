package ql.ast.type;

import ql.ast.AstNode;

/**
 * Created by bore on 17/02/15.
 */
public abstract class Type extends AstNode
{
    public abstract String getTitle();

    public boolean isUndef()
    {
        return false;
    }

    public boolean isNumerical() { return false; }

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
            return this.getTitle().equals(((Type) o).getTitle());
        }

        return false;
    }

    @Override
    public int hashCode()
    {
        return this.getTitle().hashCode();
    }

    public abstract <T> T accept(TypeVisitor<T> visitor);
}
