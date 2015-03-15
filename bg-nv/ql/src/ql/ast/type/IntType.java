package ql.ast.type;

/**
 * Created by bore on 17/02/15.
 */
public class IntType extends Type
{
    @Override
    public boolean isNumerical()
    {
        return true;
    }

    @Override
    public Type promoteTo(Type t)
    {
        return t.promoteInt(this);
    }

    @Override
    public String getTitle()
    {
        return "integer";
    }

    @Override
    public <T> T accept(TypeVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
