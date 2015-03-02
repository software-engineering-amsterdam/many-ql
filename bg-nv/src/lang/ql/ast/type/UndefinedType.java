package lang.ql.ast.type;

/**
 * Created by bore on 23/02/15.
 */
public class UndefinedType extends Type
{
    public UndefinedType()
    {
        super("undefined");
    }

    public boolean isUndef()
    {
        return true;
    }

    @Override
    public <T> T accept(TypeVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
