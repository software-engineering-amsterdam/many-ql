package lang.ql.ast.type;

/**
 * Created by bore on 17/02/15.
 */
public class DecType extends Type
{
    public DecType()
    {
        super("decimal");
    }

    @Override
    public Type promoteInt(IntType t)
    {
        return this;
    }

    @Override
    public <T> T accept(TypeVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
