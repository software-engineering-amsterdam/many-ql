package lang.ql.ast.type;

/**
 * Created by bore on 17/02/15.
 */
public class DecType extends Type
{
    @Override
    public boolean isNumerical()
    {
        return true;
    }

    @Override
    public Type promoteInt(IntType t)
    {
        return this;
    }

    @Override
    public String getTitle()
    {
        return "decimal";
    }

    @Override
    public <T> T accept(TypeVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
