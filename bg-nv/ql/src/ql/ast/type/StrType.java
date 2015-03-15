package ql.ast.type;

/**
 * Created by bore on 17/02/15.
 */
public class StrType extends Type
{
    @Override
    public boolean isString()
    {
        return true;
    }

    @Override
    public String getTitle()
    {
        return "string";
    }

    @Override
    public <T> T accept(TypeVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
