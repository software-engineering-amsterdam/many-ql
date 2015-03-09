package lang.ql.ast.type;

/**
 * Created by bore on 17/02/15.
 */
public class StrType extends Type
{
    public StrType()
    {
        super("string");
    }

    @Override
    public boolean isString()
    {
        return true;
    }

    @Override
    public <T> T accept(TypeVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
