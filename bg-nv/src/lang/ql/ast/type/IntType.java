package lang.ql.ast.type;

/**
 * Created by bore on 17/02/15.
 */
public class IntType extends Type
{
    public IntType()
    {
        super("integer");
    }

    @Override
    public boolean isArithmetic()
    {
        return true;
    }

    @Override
    public Type promoteTo(Type t)
    {
        return t.promoteInt(this);
    }

    @Override
    public <T> T accept(TypeVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
